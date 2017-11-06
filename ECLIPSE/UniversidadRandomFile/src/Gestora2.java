	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	//import java.io.FileOutputStream;
	//import java.io.FileReader;
	import java.io.FileWriter;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.io.ObjectInputStream;
	//import java.io.ObjectOutputStream;
	import java.io.RandomAccessFile;
	import java.util.ArrayList;
	//import java.util.Arrays;
	import java.util.Collections;
	import java.util.Comparator;
	import java.util.Date;
	//import java.util.Scanner;
	import java.io.BufferedReader;
	//import java.io.BufferedWriter;
	import java.io.EOFException;

public class Gestora2 {
		
		//private String archivo;
		//private static int puntero;
		
		/*public Gestora2(){
			archivo="archivoProfesores.dat";
			//puntero=this.leePuntero();	
		}*/
		
		
		/*public int leePuntero(){
			int punt=0;
			File file =new File("puntero.txt");
			FileReader fr=null;
			BufferedReader br=null;
			
			if(file.exists()){
				try {
					fr=new FileReader(file);
					br=new BufferedReader(fr);
				} catch (FileNotFoundException e) {
					System.out.println(e);
				}
				try {
					punt=br.read();
				} catch (NumberFormatException | IOException e) {
					System.out.println(e);
				}finally{
					try {
						br.close();
						fr.close();
					} catch (IOException e) {
						System.out.println(e);
					}
					
				}
			}
			return punt;
		}*/
	
		
		/*public void escribePuntero(){
			File file =new File("puntero.txt");
			FileWriter fw=null;
			BufferedWriter bw=null;
			
			try {	
				fw=new FileWriter(file);
				bw=new BufferedWriter(fw);
				bw.write(this.puntero);
			} catch (FileNotFoundException e) {
				System.out.println(e);
			}catch (IOException e) {
				e.printStackTrace();
			}finally{
				try {
					bw.close();
					fw.close();
				} catch (IOException e) {
					System.out.println(e);
				}
				
			}		
		}*/

	//-------------------------------------------------------------------------------------------
		
		public void pintaMenu(){
			System.out.println("\nElija una opción del menú");
			System.out.println("0 para: Salir");
			System.out.println("1 para: Edad promedio del grupo de Profesores.");
			System.out.println("2 para: Nombre del Profesor más joven del grupo");
			System.out.println("3 para: Nombre del Profesor de más edad");
			System.out.println("4 para: Número de Profesores con edad mayor al promedio");
			System.out.println("5 para: Número de Profesores con edad menor al promedio");
			System.out.println("6 para: Lista archivo de Movimientos");
			System.out.println("7 para: Añadir Profesor");
			System.out.println("8 para: Borrar Profesor");
			System.out.println("9 para: Búsqueda de Profesor");
			System.out.println("10 para: Modificar Profesor");
			System.out.println("11 para: Mostrar lista ordenada por antigüedad");
			System.out.println("12 para: Mostrar lista ordenada por apellido");
			System.out.println("13 para: Actualizar Master");
			System.out.println("14 para: Lista archivo Master");
			System.out.println("15 para: Ordenar archivo Master\n\n");
		}
		
	//-------------------------------------------------------------------------------------------
		
		/* Proposito: Recibe un String, lo parsea a entero y valida que esté entre 0 y 11
		 * Prototipo: boolean validaOpcion(String opcion)
		 * Precondiciones: no hay
		 * Entradas: una cadena
		 * Salidas: un booleano
		 * Postcondiciones: El booleano será verdadero si el entero está entre 0 y 11 y falso sino
		 */
		public boolean validaOpcion(String opcion){
			boolean vale=false;
			int parseo=-1;
			
			try{
				parseo=Integer.parseInt(opcion);
			}catch(NumberFormatException error){
				System.out.println("Se esperaba un numero");
			}
			
			if(parseo>=0 && parseo<=15){
				vale=true;
			}
			
			return vale;
		}
		
	//-------------------------------------------------------------------------------------------

		/* Proposito: Calcula la edad media de un grupo de ProfesorImples almacenados en un archivo binario
		 * Prototipo: double edadPromedio()
		 * Precondiciones: No hay
		 * Entradas: Usamos el atributo de la clase (archivo)
		 * Salidas: Un real
		 * Postcondiciones: El real será la edad promedio del grupo de ProfesorImples
		 * Restricciones: El archivo debe existir y contener algún ProfesorImpl
		 */
		public double edadPromedio(){
			double edadProm=0.0;
			int contadorPersonas=0;
			int acumEdad=0;
			File file=new File("profesoresMOV.dat");
			ObjectInputStream ois =null;
			FileInputStream fis=null;
			//boolean sigue=true;
			ProfesorImpl p=null;
			
			if(file.exists()){//Si el archivo existe y contiene algún ProfesorImpl
				try {		
					fis = new FileInputStream(file);
					ois = new ObjectInputStream(fis){@Override protected void readStreamHeader(){}};//Sobreescribiremos el metodo readStreamHeader (por defecto falla)

					p = (ProfesorImpl) ois.readObject(); //Lectura anticipada
					while(p!=null){
						acumEdad=acumEdad+p.getAge();
						contadorPersonas++;				
						p = (ProfesorImpl) ois.readObject();
					}
				} catch (ClassNotFoundException error) {
				} catch (EOFException error) {	
				} catch (IOException error) {
					System.out.println(error);
				}finally{
					try {
						if(ois!=null){
							ois.close();
						}
						if(fis!=null){
							fis.close();
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				
				}
				edadProm=acumEdad/contadorPersonas;
			}
			this.RegistroLog("edadPromedio");
			return edadProm;
		}

		

	//-------------------------------------------------------------------------------------------

		/*//INTERFAZ ProfesorImplJoven
		 * Cabecera: public void ProfesorImplJoven()
		 * Comentario: Dice cual es el ProfesorImpl más joven de todos
		 * Prec: Nada
		 * Entrada: Nada
		 * Salida: Nada
		 * Post: Muestra en pantalla el nombre y la edad del ProfesorImpl más joven del grupo
		 * Restricciones: El archivo debe existir y contener algún ProfesorImpl
		 */	
		public void ProfesorJoven(){
			ProfesorImpl p=null;
			ProfesorImpl pjoven=null;	
			File f=new File("profesoresMOV.dat");
			FileInputStream fis=null;
			ObjectInputStream ois=null;
			
			if(f.exists()){
				try{				
					fis=new FileInputStream(f);
					ois=new ObjectInputStream(fis){@Override protected void readStreamHeader(){}};
					
					p=(ProfesorImpl) ois.readObject();
					pjoven=p;
					while(p!=null){
						if(pjoven.getAge()>p.getAge()){
							pjoven=p;
						}
						p=(ProfesorImpl) ois.readObject();
					}
					
				}catch(ClassNotFoundException e){
				}catch(EOFException e){ 
				}catch(IOException e){
					System.out.println(e);
				}finally{
					try{
					ois.close();
					fis.close();
					}catch(IOException e){
						System.out.println(e);
					}
				}		
				System.out.println("El ProfesorImpl mas joven es "+pjoven.getNombre()+" con "+pjoven.getAge()+" años.");
			}else{
				System.out.println("El archivo debe existir y contener algún ProfesorImpl");
			}
			this.RegistroLog("ProfesorImplJoven");
		}
		
	//-------------------------------------------------------------------------------------------	
		/*//INTERFAZ ProfesorImplMayor
		 * Cabecera: public void ProfesorImplMayor()
		 * Comentario: Dice cual es el ProfesorImpl más viejo de todos
		 * Prec: Nada
		 * Entrada: Nada
		 * Salida: Nada
		 * Post: Muestra en pantalla el nombre y la edad del ProfesorImpl más viejo del grupo
		 * Restricciones: El archivo debe existir y contener algún ProfesorImpl
		 */	
		public void ProfesorMayor(){
			ProfesorImpl p=null;
			ProfesorImpl pmayor=null;		
			File f=new File("profesoresMOV.dat");
			FileInputStream fis=null;
			ObjectInputStream ois=null;
			
			if(f.exists()){
				try{
					fis=new FileInputStream(f);
					ois=new ObjectInputStream(fis){@Override protected void readStreamHeader(){}};
					
					p=(ProfesorImpl) ois.readObject();
					pmayor=p;
					while(p!=null){
						if(pmayor.getAge()<p.getAge()){
							pmayor=p;
						}
						p=(ProfesorImpl) ois.readObject();
					}
					
				}catch(ClassNotFoundException e){
				}catch(EOFException e){ 
				}catch(IOException e){
					System.out.println(e);
				}finally{
					try{
					ois.close();
					fis.close();
					}catch(IOException e){
						System.out.println(e);
					}
				}		
				System.out.println("El ProfesorImpl mas viejo es "+pmayor.getNombre()+" con "+pmayor.getAge()+" anios.");
			}else{
				System.out.println("El fichero debe existir y contener ProfesorImples");	
			}
			this.RegistroLog("ProfesorImplMayor");
		}
		
	//-------------------------------------------------------------------------------------------	
		/*//INTERFAZ MenorAMedia
		 * Cabecera: public void MenorAMedia()
		 * Comentario: Muestra una lista con los ProfesorImples cuya edad es menor a la media.
		 * Prec: Nada
		 * Entrada: Nada
		 * Salida: Nada
		 * Post: Muestra en pantalla un listado con nombre y edad de ProfesorImples menor a la media.
		 * Restricciones: El archivo debe existir y contener algún ProfesorImpl
		 */	
		public void MenorAMedia(){
			//ProfesorImpl[] ProfesorImples;
			File f=new File("profesoresMOV.dat");
			FileInputStream fis=null;
			ObjectInputStream ois=null;
			ProfesorImpl p=null;
			double edadMedia;
			edadMedia=MediaEdadProfesores();
			
			if(f.exists()){
				try{
					fis=new FileInputStream(f);
					ois=new ObjectInputStream(fis){@Override protected void readStreamHeader(){}};
					
					System.out.println("La edad media del ProfesorImplado actual es: "+edadMedia);
					
					p=(ProfesorImpl) ois.readObject();
					while(p!=null){
						if(p.getAge()<edadMedia){
							System.out.println("ProfesorImpl: "+p.getNombre()+"   \tEdad: "+p.getAge());
						}
						p=(ProfesorImpl) ois.readObject();
					}
				}catch(ClassNotFoundException e){
				}catch(EOFException e){
				}catch(IOException e){
					System.out.println(e);
				}finally{
					try{
					ois.close();
					fis.close();
					}catch(IOException e){
						System.out.println(e);
					}
				}
			}else{
				System.out.println("El fichero debe existir y contener ProfesorImples");	
			}
			this.RegistroLog("MenorAMedia");
		}
		
	//-------------------------------------------------------------------------------------------	
		/*//INTERFAZ MayorAMedia
		 * Cabecera: public void MayorAMedia()
		 * Comentario: Muestra una lista con los ProfesorImples cuya edad es mayor a la media.
		 * Prec: Nada
		 * Entrada: Nada
		 * Salida: Nada
		 * Post: Muestra en pantalla un listado con nombre y edad de ProfesorImples mayor a la media.
		 * Restricciones: El archivo debe existir y contener algún ProfesorImpl
		 */
		public void MayorAMedia(){
			//ProfesorImpl[] ProfesorImples;
			File f=new File("profesoresMOV.dat");
			FileInputStream fis=null;
			ObjectInputStream ois=null;
			ProfesorImpl p=null;
			double edadMedia;
			edadMedia=MediaEdadProfesores();
			
			if(f.exists()){
				try{
					fis=new FileInputStream(f);
					ois=new ObjectInputStream(fis){@Override protected void readStreamHeader(){}};
					
					System.out.println("La edad media del ProfesorImplado actual es: "+edadMedia);
					
					p=(ProfesorImpl) ois.readObject();
					while(p!=null){
						if(p.getAge()>edadMedia){
							System.out.println("Profesor: "+p.getNombre()+"   \tEdad: "+p.getAge());
						}
						p=(ProfesorImpl) ois.readObject();
					}
				}catch(ClassNotFoundException e){
				}catch(EOFException e){
				}catch(IOException e){
					System.out.println(e);
				}finally{
					try{
					ois.close();
					fis.close();
					}catch(IOException e){
						System.out.println(e);
					}
				}
			}else{
				System.out.println("El fichero debe existir y contener Profesores");	
			}
			this.RegistroLog("MayorAMedia");
		}	
		
	//-------------------------------------------------------------------------------------------------------------------------------	
		/*//INTERFAZ MediaEdadProfesorImples
		 * Cabecera: public void MediaEdadProfesorImples() throws ClassNotFoundException
		 * Comentario: Calcula la edad media de todos los ProfesorImples
		 * Prec: Nada
		 * Entrada: Nada
		 * Salida: double
		 * Post: Devuelve asociado al nombre la edad media del grupo de ProfesorImples.
		 * Restricciones: El archivo debe existir y contener algún ProfesorImpl
		 */	
		public double MediaEdadProfesores(){
			double mediaEdad=-1;
			int nProfesores=0;
			ProfesorImpl p = null;
			File f=new File("profesoresMOV.dat");
			FileInputStream fis=null;
			ObjectInputStream ois=null;
			
			if(f.exists()){
				mediaEdad=0;
				try{	
					fis=new FileInputStream(f);
					ois=new ObjectInputStream(fis){@Override protected void readStreamHeader(){}};
					
					p = (ProfesorImpl) ois.readObject();
					while(p != null) { //Vamos acumulando las edades y contando la cantidad total de ProfesorImples, para realizar el calculo.
						mediaEdad=mediaEdad+p.getAge();
						nProfesores++;
						p = (ProfesorImpl) ois.readObject();
					}
						
				}catch(ClassNotFoundException e){
		        }catch(EOFException e){ 
		        }catch(IOException e){
		        	System.out.println(e);
		        }finally{
		        	try{
		    			ois.close();
		    			fis.close();
		    		}catch(IOException e){
		    			System.out.println(e);
		    		}
		        }
				
				//Calculamos la Media
				mediaEdad=mediaEdad/nProfesores;
				mediaEdad=Math.floor(mediaEdad*100)/100;//Reducimos el numero de decimales.
			}
			this.RegistroLog("MediaEdadProfesores");
			return mediaEdad;
		}

		
	//-------------------------------------------------------------------------------------------
		/* Proposito: Carga un ArrayList con todos los Profesores que hay en el archivo binario
		 * Prototipo: ArrayList<ProfesorImpl> cargaArrayProfesores()
		 * Precondiciones: No hay
		 * Entradas: Se usará el atributo de la clase 
		 * Salidas: 
		 * Postcondiciones: 
		 */	
		public ArrayList<ProfesorImpl> cargaArrayProfesores(){
			File file=new File("profesoresMOV.dat");
			ArrayList<ProfesorImpl> profesores=new ArrayList<ProfesorImpl>();
			RandomAccessFile raf=null;
			ProfesorImpl p=null;
			String[] campos=new String[10];
			int Nprofesores;
			
			if(file.exists()){
				try {		
					raf=new RandomAccessFile(file, "r");
					Nprofesores=(int)file.length()/109;
				
					for(int i=0;i<Nprofesores;i++){
						campos=raf.readLine().split(",");
						campos[0]=campos[0].substring(2, 19);
						
						try{
							p=new ProfesorImpl(campos[0], campos[1], new Fecha2(campos[2], campos[3], campos[4]), campos[5],
										   campos[6].substring(0, 8), campos[7], new Fecha2(campos[8], campos[9], campos[10]));
						}catch(ExcepcionPersona | ExcepcionProfesor | ExcepcionFecha e){
							System.out.println(e);
						}
						profesores.add(p);
					}			
				} catch (IOException error) {
					System.out.println(error);
				}finally{
					try {
						if(raf!=null){
							raf.close();
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}	
			}//fin si
			return profesores;		
		}
		
//-------------------------------------------------------------------------------------------			
		//LEE PROFESORES DEL ARCHIVO DE MOVIMIENTOS
		public void leeProfesores(){
			File file=new File("profesoresMOV.dat");
			RandomAccessFile raf=null;			
			ProfesorImpl p=null;
			//Fecha2 fecha=null;
			String[] campos=new String[10];
			int cont=1;
			long Nprofesores=0;
			
			if(file.exists()){
				System.out.print("   Nombre\t\t   Apellido\t\t\t   Edad\t    Sexo      DNI          Materia\t\tAntigüedad\n");
				try {		
					raf=new RandomAccessFile(file,"rw");
					Nprofesores=file.length()/109;//Me da el numero de profesores que tengo en el archivo
					//System.out.println(Nprofesores);
					for(int i=0;i<Nprofesores;i++){
						System.out.println(" _____________________________________________________________________________\n");
						campos=raf.readLine().split(",");
						campos[0]=campos[0].substring(2, 19);
						/*for(int i=0;i<campos.length;i++){
							System.out.println(campos[i]+".");
						}*/
						try {
							p=new ProfesorImpl(campos[0], campos[1], new Fecha2(campos[2], campos[3], campos[4]), campos[5], 
											   campos[6].substring(0, 8), campos[7], new Fecha2(campos[8], campos[9], campos[10]));
															
							if(!campos[0].contains("*")){
								System.out.println(cont+": "+p.getNombre()+".   "+p.getApellido()+".      "+p.getAge()+".     "+p.getSexo()+".    "+p.getDNI()+".    "+p.getMateria()+"."+p.getAntiwedad());
								cont++;
							}
						} catch (NumberFormatException | ExcepcionProfesor | ExcepcionPersona | ExcepcionFecha e) {
							System.out.println(e);
						}			
					}//fin para	
				} catch (IOException error) {
					System.out.println(error);
				}finally{
					try {
						if(raf!=null){
							raf.close();
						}
					} catch (IOException e) {
						System.out.println(e);
					}	
				}
			}else{
				System.out.println("El fichero no existe");
			}
			this.RegistroLog("leerProfesores");
		}
	
//-------------------------------------------------------------------------------------------			
		//LEE PROFESORES DEL MASTER
		public void leeProfesoresMaster(){
			File file=new File("profesoresMOV.dat");
			RandomAccessFile raf=null;			
			ProfesorImpl p=null;
			//Fecha2 fecha=null;
			String[] campos=new String[10];
			int cont=1;
			long Nprofesores=0;
			
			if(file.exists()){
				System.out.print("   Nombre\t\t   Apellido\t\t\t   Edad\t    Sexo      DNI          Materia\t\tAntigüedad\n");
				try {		
					raf=new RandomAccessFile(file,"rw");
					Nprofesores=file.length()/109;//Me da el numero de profesores que tengo en el archivo
					//System.out.println(Nprofesores);
					for(int i=0;i<Nprofesores;i++){
						System.out.println(" _____________________________________________________________________________\n");
						campos=raf.readLine().split(",");
						campos[0]=campos[0].substring(2, 19);
						/*for(int i=0;i<campos.length;i++){
							System.out.println(campos[i]+".");
						}*/
						try {
							p=new ProfesorImpl(campos[0], campos[1], new Fecha2(campos[2], campos[3], campos[4]), campos[5], 
											   campos[6].substring(0, 8), campos[7], new Fecha2(campos[8], campos[9], campos[10]));
															
							if(!campos[0].contains("*")){
								System.out.println(cont+": "+p.getNombre()+".   "+p.getApellido()+".      "+p.getAge()+".     "+p.getSexo()+".    "+p.getDNI()+".    "+p.getMateria()+"."+p.getAntiwedad());
								cont++;
							}
						} catch (NumberFormatException | ExcepcionProfesor | ExcepcionPersona | ExcepcionFecha e) {
							System.out.println(e);
						}			
					}//fin para	
				} catch (IOException error) {
					System.out.println(error);
				}finally{
					try {
						if(raf!=null){
							raf.close();
						}
					} catch (IOException e) {
						System.out.println(e);
					}	
				}
			}else{
				System.out.println("El fichero no existe");
			}
			this.RegistroLog("leerProfesores");
		}
	
	//-------------------------------------------------------------------------------------------
		/* Proposito: Inserta un Profesor en un archivo binario
		 * Prototipo: void addProfesor(ProfesorImpl profesor)
		 * Precondiciones: Todos los atributos del Profesor deben ser válidos
		 * Entradas: Un Profesor
		 * Salidas: no hay
		 * Postcondiciones: El profesor ha sido añadido al fichero
		 */		
		public void addProfesor(ProfesorImpl pofesor){
			File file=new File("profesoresMOV.dat");
			RandomAccessFile raf=null;			
			//Abrimos el fichero
			try {	
				raf=new RandomAccessFile(file,"rw");

				if(!file.exists()){
					raf.writeUTF(pofesor.toString());	
				}else{
					raf.seek(file.length());
					raf.writeUTF(pofesor.toString());	
				}			
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}catch (IOException e) {
				e.printStackTrace();
			}finally{
				try {
					if(raf!=null){
					raf.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}	
			}		
			this.RegistroLog("addProfesor");
		}
//-------------------------------------------------------------------------------------------
	/* Proposito: Inserta un Profesor en un archivo binario
	 * Prototipo: void addProfesor(ProfesorImpl profesor, int posicion)
	 * Precondiciones: Todos los atributos del Profesor deben ser válidos
	 * Entradas: Un Profesor y un entero
	 * Salidas: no hay
	 * Postcondiciones: El profesor ha sido añadido al fichero
	 */		
	public void addProfesor(ProfesorImpl profesor, int posicion){
		File file=new File("profesoresMOV.dat");
		RandomAccessFile raf=null;			
		
		//Abrimos el fichero
		try {	
			raf=new RandomAccessFile(file,"rw");

			if(!file.exists()){
				raf.writeUTF(profesor.toString());	
			}else{
				raf.seek(109*posicion);
				raf.writeUTF(profesor.toString());	
			}		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				if(raf!=null){
				raf.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}	
		}		
		this.RegistroLog("addProfesor");
	}
		
		/////////////////////////////----PARA PRUEBAS----//////////////////////////////
		public void addProfesores(){
			File file=new File("profesoresMOV.dat");
			RandomAccessFile raf=null;	
			ProfesorImpl ProfesorImpl1 =null;
			ProfesorImpl ProfesorImpl2 =null;
			ProfesorImpl ProfesorImpl3 =null;
			ProfesorImpl ProfesorImpl4 =null;
			ProfesorImpl ProfesorImpl5 =null;
			ProfesorImpl ProfesorImpl6 =null;

			try {
				 ProfesorImpl1 = new ProfesorImpl("Manuel","Gonzalez", new Fecha2("1","02","01"), "H", "12345677", "Programacion", new Fecha2("1","02","01"));
				 ProfesorImpl2=new ProfesorImpl("Pepe","Castro", new Fecha2("1","02","01"), "M", "12345678", "Programacion", new Fecha2("1","02","01"));
				 ProfesorImpl3=new ProfesorImpl("*OMG","WTF", new Fecha2("1","02","01"), "H", "12345676", "Programacion", new Fecha2("1","02","01"));
				 ProfesorImpl4 = new ProfesorImpl("Manuel","Gonzalez", new Fecha2("1","02","01"), "H", "12345677", "Programacion", new Fecha2("1","02","01"));
				 ProfesorImpl5=new ProfesorImpl("*Pepe","Castro", new Fecha2("1","02","01"), "M", "12345578", "Programacion", new Fecha2("1","02","01"));
				 ProfesorImpl6=new ProfesorImpl("OMG","WTF", new Fecha2("1","02","01"), "H", "12345676", "Programacion", new Fecha2("1","02","01"));

			} catch (ExcepcionProfesor | ExcepcionPersona | ExcepcionFecha e1) {
				e1.printStackTrace();
			}
			//Abrimos el fichero
			try {
					raf=new RandomAccessFile(file,"rw");
					System.out.println(raf.getFilePointer());
					raf.writeUTF(ProfesorImpl1.toString());	
					System.out.println(raf.getFilePointer());
					raf.writeUTF(ProfesorImpl2.toString());	
					System.out.println(raf.getFilePointer());
					raf.writeUTF(ProfesorImpl3.toString());	
					System.out.println(raf.getFilePointer());
					System.out.println(raf.getFilePointer());
					raf.writeUTF(ProfesorImpl4.toString());	
					System.out.println(raf.getFilePointer());
					raf.writeUTF(ProfesorImpl5.toString());	
					System.out.println(raf.getFilePointer());
					raf.writeUTF(ProfesorImpl6.toString());	
					System.out.println(raf.getFilePointer());

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}catch (IOException e) {
				e.printStackTrace();
			}finally{
				try {
					if(raf!=null){
					raf.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}	
			}		
		}

//-----------------------------------------------------------------------------------------------
		//rellenaConBlanco
		/* Proposito: Recibe una cadena y un entero, rellenará la cadena con espacios blancos hasta la posicion indicada
		 * Prototipo: String rellenaConBlanco(String cadena, int pos)
		 * Precondiciones: no hay
		 * Entradas: una cadenas
		 * Salidas: 
		 * Postcondiciones: 
		 * Restricciones: 
		 */
		protected String rellenaConBlanco(String cadena, int pos){
			String cadRellena=cadena;
			do{
				cadRellena=cadRellena+" ";
			}while(cadRellena.length()<pos);
			return cadRellena;
		}
		

		
//-------------------------------------------------------------------------------------------
		/* Proposito: Modificar el nombre de un profesor almacenado en un archivo binario
		 * Prototipo: void modProfesorNombre(String nombre, int posicion)
		 * Precondiciones: Todos los atributos del ProfesorImpl deben ser válidos
		 * Entradas: Un ProfesorImpl
		 * Salidas: Un booleano 
		 * Postcondiciones: El booleano será verdadero si el ProfesorImpl se ha insertado con éxito y falso sino 
		 * Restricciones: El ProfesorImpl no debe existir en la lista para introducirlo, su edad debe ser mayor que 25(nacido en el 91) y menor que 65 (nacido en el 57)
		 */		
		/*public void modProfesorNombre(String nombre, int posicion){
			File file=new File("profesoresMOV.dat");
			RandomAccessFile raf=null;	
			
			//Abrimos el fichero
			try {
				
				raf=new RandomAccessFile(file,"rw");
				raf.seek((posicion*109));
				
				if(nombre.length()>20){
					nombre=nombre.substring(0, 19);
				}else{
					nombre=this.rellenaConBlanco(nombre, 20);
				}
				raf.writeUTF(nombre);	

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}catch (IOException e) {
				e.printStackTrace();
			}finally{
				try {
					if(raf!=null){
					raf.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}	
			}		
			this.RegistroLog("modProfesorImpl");
		}*/
				
//-------------------------------------------------------------------------------------------
		/* Proposito: Modificar algun campo de un profesor almacenado en un archivo binario
		 * Prototipo: void modProfesor(String campo, int posicionProfesor, int posicionCampo)
		 * Precondiciones: El nombre solo debe contener letras
		 * Entradas: Un ProfesorImpl
		 * Salidas: Un booleano 
		 * Postcondiciones: El booleano será verdadero si el ProfesorImpl se ha insertado con éxito y falso sino 
		 */		
		public void modProfesor(String campo, int posicionProfesor, int posicionCampo){
			File file=new File("profesoresMOV.dat");
			RandomAccessFile raf=null;	
			String[] campos=new String[10];
			Profesor p=null;
			String[] fecharec=null;
			//String cadena;
			
			//Abrimos el fichero
			if(file.exists()){
				try {			
					raf=new RandomAccessFile(file,"rw");
					raf.seek((posicionProfesor*109));//POSICIONAMOS EL CURSOR EN EL PROFESOR
					campos=raf.readLine().split(",");//RECUPERAMOS TODOS LOS CAMPOS DEL PROFESOR
					
					switch(posicionCampo){
						case 1:	//Modifica Nombre
								if(campo.length()>20){//campo 0 
									campo=campo.substring(0, 19);
								}else{
									campo=this.rellenaConBlanco(campo, 20);
								}
								raf.seek(raf.getFilePointer()-109);
								raf.writeUTF(campo);	
						break;			
						
						case 2:	//Modifica Apellido
								/*if(campo.length()>25){
									campo=campo.substring(0, 24);
								}else{
									campo=this.rellenaConBlanco(campo, 24);
								}*/
								//raf.skipBytes(-109);
								raf.seek(raf.getFilePointer()-109);
								campos[0]=campos[0].substring(2, 19);//QUITAR PORQUERIA
								campos[1]=campo;//CAMBIAMOS EL APELLIDO
								try {//RECONSTRUIMOS UN PROFESOR CON EL NUEVO DATO
									p=new ProfesorImpl(campos[0], campos[1], new Fecha2(campos[2], campos[3], campos[4]), campos[5], 
													   campos[6].substring(0, 8), campos[7], new Fecha2(campos[8], campos[9], campos[10]));
								} catch (NumberFormatException | ExcepcionProfesor | ExcepcionPersona | ExcepcionFecha e) {
									System.out.println(e);
								}			
								//cadena=p.toString();
								raf.writeUTF(p.toString());//ESCRIBIMOS LA CADENA	
						break;
							
						case 3:	//Modificar Fecha Nacimiento*
								raf.seek(raf.getFilePointer()-109);
								fecharec=new String[3];
								fecharec=campo.split(",");//ASI TENEMOS DIA; MES; AÑO POR SEPARADO
								campos[0]=campos[0].substring(2, 19);//QUITAR PORQUERIA
								try {//RECONSTRUIMOS UN PROFESOR CON EL NUEVO DATO
									p=new ProfesorImpl(campos[0], campos[1], new Fecha2(fecharec[0], fecharec[1], fecharec[2]), campos[5], 
													   campos[6].substring(0, 8), campos[7], new Fecha2(campos[8], campos[9], campos[10]));
								} catch (NumberFormatException | ExcepcionProfesor | ExcepcionPersona | ExcepcionFecha e) {
									System.out.println(e);
								}			
								raf.writeUTF(p.toString());									
						break;
						
						case 4:	//Modificar Sexo*
								raf.seek(raf.getFilePointer()-109);
								campos[0]=campos[0].substring(2, 19);//QUITAR PORQUERIA
								campos[5]=campo;
								try {//RECONSTRUIMOS UN PROFESOR CON EL NUEVO DATO
									p=new ProfesorImpl(campos[0], campos[1], new Fecha2(campos[2], campos[3], campos[4]), campos[5], 
													   campos[6].substring(0, 8), campos[7], new Fecha2(campos[8], campos[9], campos[10]));
								} catch (NumberFormatException | ExcepcionProfesor | ExcepcionPersona | ExcepcionFecha e) {
									System.out.println(e);
								}			
								raf.writeUTF(p.toString());
						break;
							
						case 5:	//Modificar DNI*
								raf.seek(raf.getFilePointer()-109);
								campos[0]=campos[0].substring(2, 19);
								campos[6]=campo;
								try {//RECONSTRUIMOS UN PROFESOR CON EL NUEVO DATO
									p=new ProfesorImpl(campos[0], campos[1], new Fecha2(campos[2], campos[3], campos[4]), campos[5], 
													   campos[6], campos[7], new Fecha2(campos[8], campos[9], campos[10]));
								} catch (NumberFormatException | ExcepcionProfesor | ExcepcionPersona | ExcepcionFecha e) {
									System.out.println(e);
								}			
								raf.writeUTF(p.toString());										
						break;
							
						case 6:	//Modificar Materia*
								raf.seek(raf.getFilePointer()-109);
								campos[0]=campos[0].substring(2, 19);
								campos[7]=campo;
								try {//RECONSTRUIMOS UN PROFESOR CON EL NUEVO DATO
									p=new ProfesorImpl(campos[0], campos[1], new Fecha2(campos[2], campos[3], campos[4]), campos[5], 
													   campos[6].substring(0, 8), campos[7], new Fecha2(campos[8], campos[9], campos[10]));
								} catch (NumberFormatException | ExcepcionProfesor | ExcepcionPersona | ExcepcionFecha e) {
									System.out.println(e);
								}			
								raf.writeUTF(p.toString());
						break;							
							
						case 7:	//Modificar Fecha Contratacion*
								raf.seek(raf.getFilePointer()-109);
								campos[0]=campos[0].substring(2, 19);
								fecharec=new String[3];
								fecharec=campo.split(",");
								try {//RECONSTRUIMOS UN PROFESOR CON EL NUEVO DATO
									p=new ProfesorImpl(campos[0], campos[1], new Fecha2(campos[2], campos[3], campos[4]), campos[5], 
													   campos[6].substring(0, 8), campos[7], new Fecha2(fecharec[0], fecharec[1], fecharec[2]));
								} catch (ExcepcionProfesor | ExcepcionPersona | ExcepcionFecha e) {
									System.out.println(e);
								}			
								raf.writeUTF(p.toString());						
						break;
					}//fin segun
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}catch (IOException e) {
					e.printStackTrace();
				}finally{
					try {
						if(raf!=null){
							raf.close();
						}
					} catch (IOException e) {
						e.printStackTrace();
					}	
				}
			}//fin si
			this.RegistroLog("modProfesorImpl");
		}
		
		
//-------------------------------------------------------------------------------------------
		/* Proposito: Marca un Profesor en un archivo binario
		 * Prototipo: void marcaProfesor(int posicion)
		 * Precondiciones: La posicion del profesor será válida
		 * Entradas: Un entero que será la posicion del Profesor a marcar
		 * Salidas: No hay
		 * Postcondiciones: El profesor ha sido marcado
		 */		
		public void marcaProfesorChungo(int posicion){//cuando escribe un profesor completo elimina los dos primeros caracteres de la linea siguiente
			File file=new File("profesoresMOV.dat");		  //modificando el acceso al profesor siguiente al que he modificado por completo
			RandomAccessFile raf=null;
			//ProfesorImpl p=null;	
			String[] campos=new String[10];
			if(file.exists()){//Si el archivo existe 	

				try {					
					raf=new RandomAccessFile(file,"rw");			
					raf.seek(109*posicion);
					campos=raf.readLine().split(",");
					campos[0]=campos[0].substring(2, 19);	
					
					/*for(int i=0;i<campos.length;i++){
						System.out.println(campos[i]+".");
					}*/
					
					raf.seek((raf.getFilePointer()-109));
					raf.writeUTF("*"+campos[0]);

				}catch (IOException e) {
					System.out.println(e);
				}finally{
					try{
						raf.close();
					}catch(IOException e){		
						e.printStackTrace();
					}		
				}
			}//fi si
			this.RegistroLog("dropProfesorImpl");		
		}
		
	
//-------------------------------------------------------------------------------------------
	/* Proposito: Muestra un menu de opciones para el filtrado de búsqueda de un ProfesorImpl en un archivo binario
	 * 			  Las opciones de filtrado son : - Nombre y apellido
	 * 											 - Materia
	 * 											 - Sexo
	 * 											 - DNI
	 * Prototipo: void pintaMenuBusqueda()
	 * Precondiciones: no hay
	 * Entradas: no hay
	 * Salidas: no hay
	 * Postcondiciones: Se pinta en pantalla un menu de filtrado 
	 * Restricciones: El archivo debe existir y contener al menos un ProfesorImpl
	 */				
	public void pintaMenuMod(){System.out.println("\nElija el campo a modificar");
			System.out.println("0 para: Salir.");
			System.out.println("1 para: Modificar Nombre.");
			System.out.println("2 para: Modificar Apellido.");
			System.out.println("3 para: Modificar Fecha Nacimiento");
			System.out.println("4 para: Modificar Sexo");
			System.out.println("5 para: Modificar DNI");
			System.out.println("6 para: Modificar Materia");
			System.out.println("7 para: Modificar Fecha Contratacion");
	
	}
	
//-------------------------------------------------------------------------------------------
	
	/* Proposito: Recibe un String, lo parsea a entero y valida que esté entre 0 y 4
	 * Prototipo: boolean validaOpcionBusqueda(String opcion)
	 * Precondiciones: no hay
	 * Entradas: una cadena
	 * Salidas: un booleano
	 * Postcondiciones: El booleano será verdadero si el entero está entre 0 y 4 y falso sino
	 */
	public boolean validaOpcionMod(String opcion){
		boolean vale=false;
		int parseo=-1;
		
		try{
			parseo=Integer.parseInt(opcion);
		}catch(NumberFormatException error){
			System.out.println("Se esperaba un numero");
			 vale=false;
		}
		
		if(parseo>=0 && parseo<=7){
			vale=true;
		}		
		return vale;
	}
	
	
///////BUSQUEDA		
//-------------------------------------------------------------------------------------------
	
		/* Proposito: Recibe un String que será el DNI del profesor a buscar
		 * Prototipo: int posicionProfesor(String dni)
		 * Precondiciones: 
		 * Entradas: una cadena
		 * Salidas: un entero asociado al nombre
		 * Postcondiciones: El entero será la posición del profesor buscado, -1 en el caso de no encontrarlo
		 */
		public int posicionProfesor(String dni){
			int posicion=-1;
			File file=new File("profesoresMOV.dat");
			RandomAccessFile raf=null;
			long Nprofesores=0;
			String[] campos=new String[10];
			String dnirec=" ";
			boolean encontrado=false;
			
			if(file.exists()){			
				try{
					raf=new RandomAccessFile(file, "r");		
					Nprofesores=file.length()/109;
					
					for(int i=0;i<Nprofesores && !encontrado;i++){
						//raf.seek(i*62);//byte 62 para posicionarse en el primer dni
						campos=raf.readLine().split(",");
						dnirec=campos[6];
						//System.out.println(dnirec);
						if(dni.equalsIgnoreCase(dnirec)){
							posicion=i;//-1 porque es la posicion real en el archivo
							encontrado=true;
						}
					}//fin para					
				}catch(IOException e){
					System.out.println(e);
				}finally{
					try {
						if(raf!=null){
							raf.close();
						}
					} catch (IOException e) {
						System.out.println(e);
					}
				}
			}else{
				System.out.println("El archivo de profesores no existe");
			}
			System.out.println(posicion);
			return posicion;
		}
	
	
		
//-------------------------------------------------------------------------------------------
		/* Proposito: Muestra un menu de opciones para el filtrado de búsqueda de un ProfesorImpl en un archivo binario
		 * 			  Las opciones de filtrado son : - Nombre y apellido
		 * 											 - Materia
		 * 											 - Sexo
		 * 											 - DNI
		 * Prototipo: void pintaMenuBusqueda()
		 * Precondiciones: no hay
		 * Entradas: no hay
		 * Salidas: no hay
		 * Postcondiciones: Se pinta en pantalla un menu de filtrado 
		 * Restricciones: El archivo debe existir y contener al menos un ProfesorImpl
		 */				
	public void pintaMenuBusqueda(){
		File file=new File("profesoresMOV.dat");
		if(file.exists()){
			System.out.println("\nElija el filtro de búsqueda");
			System.out.println("0 para: Salir");
			System.out.println("1 para: Filtrar por nombre y apellido.");
			System.out.println("2 para: Filtrar por materia");
			System.out.println("3 para: Filtrar por sexo");
			System.out.println("4 para: Filtrar por DNI");
		}else{
			System.out.println("El archivo debe existir y contener algún ProfesorImpl");
		}
	}
	
//-------------------------------------------------------------------------------------------
	
	/* Proposito: Recibe un String, lo parsea a entero y valida que esté entre 0 y 4
	 * Prototipo: boolean validaOpcionBusqueda(String opcion)
	 * Precondiciones: no hay
	 * Entradas: una cadena
	 * Salidas: un booleano
	 * Postcondiciones: El booleano será verdadero si el entero está entre 0 y 4 y falso sino
	 */
	public boolean validaOpcionBusqueda(String opcion){
		boolean vale=false;
		int parseo=-1;
		
		try{
			parseo=Integer.parseInt(opcion);
		}catch(NumberFormatException error){
			System.out.println("Se esperaba un numero");
		}
		
		if(parseo>=0 && parseo<=4){
			vale=true;
		}		
		return vale;
	}
	
	
//---------------------------------------------------------------------------------------------------------------	
	//ValidaMateria
	/* Proposito: Dada una materia como cadena valida que sea programacion, base de datos o entornos de desarrollo
	 * Prototipo: boolean validaMateria(String materia) 
	 * Precondiciones: No hay
	 * Entradas: Una cadena
	 * Salidas: Un booleano
	 * Postcondiciones: EL booleano será verdadero si la cadena coincide con programacion, base de datos o entornos de desarrollo y falso sino
	 */
	public boolean validaMateria(String materia){
		boolean vale=false;
		
		if(materia.toLowerCase().equals("programacion") || materia.toLowerCase().equals("base de datos") || materia.toLowerCase().equals("entornos de desarrollo")){
			vale=true;
		}
		return vale;
	}
	
//---------------------------------------------------------------------------------------------------------------	
	//validaSexo
	/* Proposito: Dado un sexo como cadena valida que sea "s" o "m"
	 * Prototipo: boolean validaSexo(String sexo)
	 * Precondiciones: No hay
	 * Entradas: Una cadena
	 * Salidas: Un booleano
	 * Postcondiciones: El booleano será verdadero si la cadena es "s" o "n" y falso si no
	 */
	public boolean validaSexo(String sexo){
		boolean vale=false;
		if(sexo.toLowerCase().equals("m") || sexo.toLowerCase().equals("h")){
			vale=true;
		}	
		return vale;
	}
	
//---------------------------------------------------------------------------------------------------------------
	//validaDNI
	/* Proposito: Dado un dni como cadena (sin la letra), valida que sean 8 dígitos numéricos
	 * Prototipo: boolean validaDNI(String dni) 
	 * Precondiciones: No hay
	 * Entradas: Una cadena
	 * Salidas: Un booleano
	 * Postcondiciones: El booleano será verdadero si la cadena contiene 8 dígitos numéricos y falso si no
	 */
	public boolean validaDNI(String dni){
		boolean vale=true;
		
		if(dni.length()!=8){
			vale=false;
		}else if(vale){
			for(int contador=0; contador<=7 && vale; contador++){
				if(Character.isDigit(dni.charAt(contador))==false){
					vale=false;			 
				}									
			}
		}		
		return vale;
	}
	
//---------------------------------------------------------------------------------------------------------------
	//ProfesorDNIExists
	/* Proposito: Dado un dni como cadena completo comprueba que existe un ProfesorImpl con el mismo
	 * Prototipo: boolean ProfesorImplDniExists(String dni)
	 * Precondiciones: No hay
	 * Entradas: Una cadena
	 * Salidas: Un booleano
	 * Postcondiciones: El booleano será verdadero si hay un ProfesorImpl con el mismo dni
	 * Restricciones: El archivo debe existir y contener algun ProfesorImpl
	 * 				  El dni debe tener 8 digitos numéricos y una letra
	 */
	/*public boolean ProfesorDniExists(String dni){
		boolean existe=false;
		File file=new File("profesoresMOV.dat");
		FileInputStream fis=null;
		ObjectInputStream ois=null;
		ProfesorImpl p=null;
		
		if(file.exists()){	//si el archivo existe y contiene algun ProfesorImpl	
			if(dni.matches("[0-9]{8}[a-zA-Z]{1}") ){//si el dni tiene 8 digitos numéricos y una letra
				try {//validaDNI(dni) && Character.isAlphabetic(dni.charAt(8)) && 
					fis=new FileInputStream(file);
					ois=new ObjectInputStream(fis){@Override protected void readStreamHeader(){}};
					Character.toUpperCase(dni.charAt(8));//Pasamos a mayúscula la letra del dni
					p=(ProfesorImpl)ois.readObject();	
					while(p!=null){
						if(p.getDNI().equals(dni)){
							existe=true;
						}
						p=(ProfesorImpl)ois.readObject();	
					}					
				} catch (ClassNotFoundException e) {					
				}catch(EOFException e){	
				}catch(IOException e){				
					System.out.println(e);
				}finally{
					try{
						if(fis!=null){
							fis.close();
						}
						if(ois!=null){
							ois.close();
						}
					}catch(IOException e){
						e.printStackTrace();
					}
				}
			}//fin si
		}//fin si
		this.RegistroLog("ProfesorImplDniExists");
		return existe;
	}*/
	
//----------------------------------------------------------------------------------------------------------------
	
	/* Proposito: Dado un nombre y apellido busca los ProfesorImples con los mismos y los pinta en pantalla
	 * Prototipo: void buscaProfesorImples(String nombre, String apellido)
	 * Precondiciones: no hay
	 * Entradas: dos cadenas
	 * Salidas: no hay
	 * Postcondiciones: Se pintará en pantalla los ProfesorImples con ese nombre y apellido 
	 * Restricciones: EL fichero debe existir
	 */
	public void buscaProfesores(String nombre, String apellido){
		File file=new File("profesoresMOV.dat");
		RandomAccessFile raf=null;
		int contador=0;
		ProfesorImpl p=null;
		String[] campos=new String[10];
		int Nprofesores;
		
		if(file.exists()){			
			try{
				raf=new RandomAccessFile(file,"r");					
				Nprofesores=(int)file.length()/109;
				
				for(int i=0;i<Nprofesores;i++){
					campos=raf.readLine().split(",");
					campos[0]=campos[0].substring(2, 19);
					try{
						p=new ProfesorImpl(campos[0], campos[1], new Fecha2(campos[2], campos[3], campos[4]), campos[5],
										   campos[6].substring(0, 8), campos[7], new Fecha2(campos[8], campos[9], campos[10]) );
					}catch(ExcepcionProfesor | ExcepcionPersona | ExcepcionFecha e){
						System.out.println(e);
					}
					
					if(p.getNombre().replaceAll(" ", "").equalsIgnoreCase(nombre.replaceAll(" ", "")) && p.getApellido().replaceAll(" ", "").equalsIgnoreCase(apellido.replaceAll(" ", "")) ){
						if(contador==0){
							System.out.print("   Nombre\t\t   Apellido\t\t\t   Edad\t    Sexo      DNI          Materia\t\tAntigüedad\n");
						}
						System.out.println(contador+": "+p.getNombre()+".   "+p.getApellido()+".      "+p.getAge()+".     "+p.getSexo()+".    "+p.getDNI()+".    "+p.getMateria()+"."+p.getAntiwedad());
						contador++;				
					}
					
				}//fin para				
				System.out.println("\n\t\t\t\t"+contador+" resultados");
			}catch (FileNotFoundException e) {
			}catch(IOException e){
				System.out.println(e);
			}finally{			
				try{
					if(raf!=null){
						raf.close();						
					}
				}catch(IOException e){
					e.printStackTrace();
				}
			}	
		}//fin si
		//this.RegistroLog("buscaProfesores");
	}
	
	
	
//----------------------------------------------------------------------------------------------------------------
	
	/* Proposito: Dada una materia busca los ProfesorImples con la misma y los pinta en pantalla
	 * Prototipo: void buscaProfesorImplesMateria(String materia)
	 * Precondiciones: no hay
	 * Entradas: una cadenas
	 * Salidas: no hay
	 * Postcondiciones: Se pintará en pantalla los ProfesorImples con esa materia
	 * Restricciones: EL fichero debe existir
	 */
	public void buscaProfesoresMateria(String materia){
		File file=new File("profesoresMOV.dat");
		RandomAccessFile raf=null;
		int contador=0;
		ProfesorImpl p=null;
		String[] campos=new String[10];
		int Nprofesores;
		
		if(file.exists()){			
			try{
				raf=new RandomAccessFile(file,"r");					
				Nprofesores=(int)file.length()/109;
				
				for(int i=0;i<Nprofesores;i++){
					campos=raf.readLine().split(",");
					campos[0]=campos[0].substring(2, 19);
					try{
						p=new ProfesorImpl(campos[0], campos[1], new Fecha2(campos[2], campos[3], campos[4]), campos[5],
										   campos[6].substring(0, 8), campos[7], new Fecha2(campos[8], campos[9], campos[10]) );
					}catch(ExcepcionProfesor | ExcepcionPersona | ExcepcionFecha e){
						System.out.println(e);
					}
					
					if(p.getMateria().replaceAll(" ", "").equalsIgnoreCase(materia.replaceAll(" ", ""))){
						if(contador==0){
							System.out.print("   Nombre\t\t   Apellido\t\t\t   Edad\t    Sexo      DNI          Materia\t\tAntigüedad\n");
						}
						System.out.println(contador+": "+p.getNombre()+".   "+p.getApellido()+".      "+p.getAge()+".     "+p.getSexo()+".    "+p.getDNI()+".    "+p.getMateria()+"."+p.getAntiwedad());
						contador++;				
					}
					
				}//fin para				
				System.out.println("\n\t\t\t\t"+contador+" resultados");
			}catch (FileNotFoundException e) {
			}catch(IOException e){
				System.out.println(e);
			}finally{			
				try{
					if(raf!=null){
						raf.close();						
					}
				}catch(IOException e){
					e.printStackTrace();
				}
			}	
		}//fin si
		//this.RegistroLog("buscaProfesorImplesMateria");
	}
	
	
	
//----------------------------------------------------------------------------------------------------------------
	
	/* Proposito: Dado un caracter como sexo del ProfesorImpl/a busca los ProfesorImples del mismo y los pinta en pantalla
	 * Prototipo: void buscaProfesorImples(String sexo)
	 * Precondiciones: no hay
	 * Entradas: una cadenas
	 * Salidas: no hay
	 * Postcondiciones: Se pintará en pantalla los ProfesorImples de ese sexo
	 * Restricciones: EL fichero debe existir
	 */
	public void buscaProfesoresSexo(String sexo){
		File file=new File("profesoresMOV.dat");
		ObjectInputStream ois=null;
		FileInputStream fis=null;
		int contador=0;
		ProfesorImpl p=null;	
		
		if(file.exists()){			
			try{
				fis=new FileInputStream(file);
				ois=new ObjectInputStream(fis){@Override protected void readStreamHeader(){}};						
			
				while(p!=null){								
					if(p.getSexo().toLowerCase().equals(sexo.toLowerCase())){
						
						System.out.println(p.toString());
						contador++;
					}
					p=(ProfesorImpl)ois.readObject();
				}//fin mientras		
				
				System.out.println("\t\t"+contador+" resultados");
				
			}catch (ClassNotFoundException e) {
			}catch(EOFException e){
			}catch(IOException e){
				System.out.println(e);
			}finally{			
				try{
					if(ois!=null){
						ois.close();						
					}
					if(fis!=null){						
						fis.close();
					}
	
				}catch(IOException e){
					e.printStackTrace();
				}
			}
		}//fin si
		this.RegistroLog("buscaProfesorImplesSexo");
	}
	
//----------------------------------------------------------------------------------------------------------------
	
	/* Proposito: Dado un dni busca el ProfesorImpl conel mismo y lo pinta en pantalla
	 * Prototipo: void buscaProfesorImples(String dni)
	 * Precondiciones: no hay
	 * Entradas: una cadenas
	 * Salidas: no hay
	 * Postcondiciones: Se pintará en pantalla los ProfesorImples de ese sexo
	 * Restricciones: EL fichero debe existir
	 */
	public void buscaProfesorDNI(String dni){
		File file=new File("profesoresMOV.dat");
		ObjectInputStream ois=null;
		FileInputStream fis=null;
		ProfesorImpl p=null;	
		int contador=0;
		
		if(file.exists()){			
			try{
				fis=new FileInputStream(file);
				ois=new ObjectInputStream(fis){@Override protected void readStreamHeader(){}};						
				p=(ProfesorImpl)ois.readObject();
				
				while(p!=null){
					if(p.getDNI().equals(dni)){
						//oos.writeObject(p);
						System.out.println(p.toString());
						contador++;
					}
					p=(ProfesorImpl)ois.readObject();
				}//fin mientras		
				System.out.println("\t\t"+contador+" resultados");
			}catch (ClassNotFoundException e) {
			}catch(EOFException e){
			}catch(IOException e){
				e.printStackTrace();
			}finally{				
				try{
					if(ois!=null){
						ois.close();						
					}
					if(fis!=null){						
						fis.close();
					}
				}catch(IOException e){
					e.printStackTrace();
				}
			}	
		}//fin si
		RegistroLog("buscaProfesorImplDNI");
	}	
	
//----------------------------------------------------------------------------------------------------------------
	
	/* Proposito: Pide los datos necesarios para crear un ProfesorImpl
	 * Prototipo: ProfesorImpl creaProfesorImpl()
	 * Precondiciones: no hay
	 * Entradas: - Cadenas: nombre, apellido, DNI, sexo, materia
	 * 			 - Fecha: FechaNacimiento, FechaContratacion; las fechas tienen año, mes y dia como enteros
	 * Salidas: Un ProfesorImpl
	 * Postcondiciones: Se habrá creado un ProfesorImpl
	 */
	public ProfesorImpl creaProfesor(){
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		//String nombre, apellido;
		boolean vale=true;
		ProfesorImpl ProfesorImpl=new ProfesorImpl();
		String dni=" ";
		//Fecha2 fecha=new Fecha2();
		
			//LEER NOMBRE
				System.out.println("\nIntroduzca el nombre");
			do{
				vale=true;
				try {
					ProfesorImpl.setNombre(br.readLine());
				} catch (IOException e) {
					System.out.println(e);
					vale=false;
				}
			}while(!vale);
			
			//LEER APELLIDO
			do{
				vale=true;
				System.out.println("\nIntroduzca el primer apellido");
				try {
					ProfesorImpl.setApellido(br.readLine());
				} catch (IOException e) {										
					System.out.println(e);
				}
			}while(!vale);
			//LEER Y VALIDAR FECHA NACIMIENTO
			do{
				System.out.println("\nIntroduzca la fecha de nacimiento");
				do{
					vale=true;
					System.out.println("\n\tIntroduzca el año");
					try{
						ProfesorImpl.getBirthDate().setYear(br.readLine());
					}catch(ExcepcionFecha error){
						System.out.println(error);
						vale=false;
					}catch (IOException e) {					
						e.printStackTrace();
					}
				}while(!vale);
				
				do{
					vale=true;
					System.out.println("\n\tIntroduzca el mes");
					try{
						ProfesorImpl.getBirthDate().setMonth(br.readLine());
					}catch(ExcepcionFecha error){
						System.out.println(error);
						vale=false;
					}catch (IOException e) {					
						e.printStackTrace();
					}
				}while(!vale);
				
				do{
					vale=true;
					System.out.println("\tIntroduzca el dia");
					try{
						ProfesorImpl.getBirthDate().setDay(br.readLine());
					}catch(ExcepcionFecha error){
						System.out.println(error);
						vale=false;
					}catch (IOException e) {					
						e.printStackTrace();
					}
				}while(!vale);
	
			}while(!ProfesorImpl.getBirthDate().validafecha());
	
			//LEER Y VALIDAR SEXO
			do{
				vale=true;
				System.out.println("\nIntroduzca el sexo: H-M");
				try {
					ProfesorImpl.setSexo(br.readLine());
				} catch (ExcepcionPersona e) {
					System.out.println(e);
					vale=false;
				}catch (IOException e) {
					e.printStackTrace();
				}
			}while(!vale);///
	
			//LEER Y VALIDAR DNI
			do{
				System.out.println("\nIntroduzca el DNI");
				try {
					dni=br.readLine();
				} catch (IOException e) {
					System.out.println(e);
				}
			}while(!validaDNI(dni));	 
			
			try{
				ProfesorImpl.setDNI(dni);
			}catch(ExcepcionPersona error){
				System.out.println(error);
			}
			
			//LEER Y VALIDAR MATERIA
			do{
				vale=true;
				System.out.println("\nIntroduzca la materia");
				try {
					ProfesorImpl.setMateria(br.readLine());
				} catch (ExcepcionProfesor e) {
					System.out.println(e);
					vale=false;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}while(!vale);	
			
			//LEER Y VALIDAR FECHA CONTRATACION
			do{
				System.out.println("\nIntroduzca la fecha de contratación");
				do{
					vale=true;
					System.out.println("\n\tIntroduzca el año");
					try{
						ProfesorImpl.getFechaCont().setYear(br.readLine());
						System.out.println();
					}catch(ExcepcionFecha error){
						System.out.println(error);
						vale=false;
					} catch (IOException e) {					
						e.printStackTrace();
					}
				}while(!vale);
				
				do{
					vale=true;
					System.out.println("\n\tIntroduzca el mes");
					try{
						ProfesorImpl.getFechaCont().setMonth(br.readLine());
					}catch(ExcepcionFecha error){
						System.out.println(error);
						vale=false;
					} catch (IOException e) {					
						e.printStackTrace();
					}
				}while(!vale);
				
				do{
					vale=true;
					System.out.println("\tIntroduzca el dia");
					try{
						ProfesorImpl.getFechaCont().setDay(br.readLine());
					}catch(ExcepcionFecha error){
						System.out.println(error);
						vale=false;
					}catch (IOException e) {					
						e.printStackTrace();
					}
				}while(!vale );
	
			}while(!ProfesorImpl.getFechaCont().validafecha());
		RegistroLog("creaProfesorImpl");
		return ProfesorImpl;
	}
	
//------------------------------------------------------------------------------------------------------------------------------	
	//ordenar
	/* Proposito: Muestra una lista de Profesores ordenada segun el criterio establecido en el comparator recibido
	 * Prototipo: void Ordenar(Comparator<ProfesorImpl> comparator)
	 * Precondiciones: no hay
	 * Entradas: un comparator
	 * Salidas: Pinta en pantalla un listado de ProfesorImples ordenados por el criterio del comparator
	 * Postcondiciones: Pinta en pantalla
	 */
	public void Ordenar(Comparator<ProfesorImpl> comparator){
		//File file=new File("profesoresMOV.dat");
		ArrayList<ProfesorImpl> profesores=new ArrayList<ProfesorImpl>();
		profesores=this.cargaArrayProfesores();
		//T comparator=new ComparatorProfesor();
		
		Collections.sort(profesores, comparator);
		
		for(ProfesorImpl temp:profesores){
			System.out.println(temp.toString());
		}
		//RegistroLog("ordenarPorAntiwedad");
	}
	
	
	//RegistroLog
	/*
	 * Cabecera: public void RegistroLog(String entrada)
	 * Comentario: Crea un registro de todo lo que hace los administradores.
	 * Prec: Nada
	 * Entrada: Nada
	 * Salida: Nada
	 * Post: Crea un fichero de texto y va registrando lo que sucede en el programa.
	 */
	public void RegistroLog(String entrada){
		File f=new File("LogUniversidad.txt");
		FileWriter archivo = null;
		Date d=null;
		
		try{
		//Si el fichero no existe, lo crea nuevo.
		if(f.exists()==false){
			archivo=new FileWriter(f);
		}else{
			archivo=new FileWriter(f, true);
		}				
		d=new Date();	
		archivo.write(String.valueOf(d)+"; "+entrada+"\r\n");
		
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			try{
			archivo.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		
	}	
	
	
//-------------------------------------------------------------------------------------------------------------
	
	/* Proposito: Actualizar fichero de Master volcando desde el de Movimientos los no marcados como borrado y en otro volcaremos los que sí están marcados,
	 * 			  nombra el generado con los marcados como el Borrados si no existiera ya, si hubiera DNI duplicados los escribiriamos en un fichero Errores
	 * Prototipo: void actualizarArchivo()
	 * Precondiciones: no hay
	 * Entradas: No hay
	 * Salidas: No hay
	 * Postcondiciones: Se genera un archivo con los profesores no borrados y otro con los borrados
	 */
		public void actualizarMaster(){
			File filemov=new File("profesoresMOV.dat");
			File filemas=new File("ProfesoresMAST.dat");
			File fileBorrados=new File("ProfesoresDEL.dat");
			File fileError=new File("ProfesoresERROR.dat");
			RandomAccessFile rafMov=null;
			RandomAccessFile rafMaster=null;
			RandomAccessFile rafDel=null;
			RandomAccessFile rafErr=null;
			ProfesorImpl p=null;
			ProfesorImpl p2=null;
			int NprofesoresMov;
			int NprofesoresMast;
			String[] campos=new String[10];
			String[] campos2=new String[10];
			boolean sal=false;
			
			if(filemov.exists()){					
				try{
					rafMov=new RandomAccessFile(filemov,"r");
					rafMaster=new RandomAccessFile(filemas,"rw");
					rafDel=new RandomAccessFile(fileBorrados,"rw");
					rafErr=new RandomAccessFile(fileError,"rw");
					
					//if(fileBorrados.exists()){//Si existe el fichero de Borrados movemos el puntero al final del fichero
						rafDel.seek(fileBorrados.length());
					//}

					NprofesoresMov=(int)rafMov.length()/109;//Número de profesores en el archivo de Movimientos
					
					for(int i=0;i<NprofesoresMov;i++){
						campos=rafMov.readLine().split(",");
						campos[0]=campos[0].substring(2, 19);
						//Recontruimos el profesor del fichero de Movimientos
						try{
							p=new ProfesorImpl(campos[0], campos[1], new Fecha2(campos[2], campos[3], campos[4]), campos[5],
												campos[6].substring(0,8), campos[7], new Fecha2(campos[8], campos[9], campos[10]));
						}catch(ExcepcionPersona | ExcepcionProfesor| ExcepcionFecha e){
							System.out.println(e);
						}																				
						if(campos[0].contains("*")){//Si está marcado lo pasamos al fichero de Borrados
							rafDel.writeUTF(p.toString());
						}else{//Sino pasamo a ver si se repite el DNI con alguno de los profesores que hay en el Master							
							
							NprofesoresMast=(int)filemas.length()/109;//Número de profesores en el archivo Master
							
							for(int i2=0;i2<NprofesoresMast && !sal;i2++){
								campos2=rafMaster.readLine().split(",");
								campos2[0]=campos2[0].substring(2, 19);
								//Recontruimos el profesor del fichero Master
								try{
									p2=new ProfesorImpl(campos2[0], campos2[1], new Fecha2(campos2[2], campos2[3], campos2[4]), campos2[5],
														campos2[6].substring(0,8), campos2[7], new Fecha2(campos2[8], campos2[9], campos2[10]));
								}catch(ExcepcionPersona | ExcepcionProfesor| ExcepcionFecha e){
									System.out.println(e);
								}																				

								if(p.getDNI().equalsIgnoreCase(p2.getDNI())){//Registro de Movimiento con Registro en Maestro
									sal=true;
								}
							}//fin para						
							
							if(sal){//El DNI está repetido y pasamos el Profesor al fichero de Errores
									rafErr.seek(fileError.length());
									rafErr.writeUTF(p.toString());
							}else{//Si no cambió el estado de la variable sal es por que no está repetido el dni, así que pasamos a escribir en el fichero Master
								rafMaster.seek(filemas.length());//Movemos el puntero del Master al final
								rafMaster.writeUTF(p.toString());															
							}
							sal=false;
							rafMaster.seek(0);//Movemos el puntero del Master al principio para la próxima iteración
						}//fin si sino
					}//fin para
					
				}catch(IOException e){
					System.out.println(e);
				}finally{
					try{
						if(rafMov!=null){
							rafMov.close();
						}
						if(rafMaster!=null){
							rafMaster.close();
						}
						if(rafDel!=null){
							rafDel.close();
						}
					}catch(IOException e){
						System.out.println(e);
					}
				}		
			}else{
				System.out.println("No hay nada que actualizar");
			}//
			//filemov.deleteOnExit();
			
		}	
		
//----------------------------------------------------------------------------------------------------------------------------------------------------------------	
		
		/* Proposito: Ordena el fichero Master
		 * 
		 * 
		 * Prototipo: 
		 * Precondiciones: 
		 * Entradas: No hay
		 * Salidas: No hay
		 * Postcondiciones: 
		 */

		

}
