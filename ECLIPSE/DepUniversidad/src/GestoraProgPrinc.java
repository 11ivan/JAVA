import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.EOFException;

public class GestoraProgPrinc {
	
	private String archivo;
	
	public GestoraProgPrinc(){
		archivo="archivoProfesores.dat";
	}
	
//-------------------------------------------------------------------------------------------
	
	public void pintaMenu(){
		System.out.println("\nElija una opción del menú");
		System.out.println("0 para: Salir");
		System.out.println("1 para: Edad promedio del grupo de profesores.");
		System.out.println("2 para: Nombre del profesor más joven del grupo");
		System.out.println("3 para: Nombre del profesor de más edad");
		System.out.println("4 para: Número de profesores con edad mayor al promedio");
		System.out.println("5 para: Número de profesores con edad menor al promedio");
		System.out.println("6 para: Lista de profesores");
		System.out.println("7 para: Añadir profesor");
		System.out.println("8 para: Borrar profesor");
		System.out.println("9 para: Búsqueda de profesor");
		System.out.println("10 para: Modificar profesor");
		System.out.println("11 para: Mostrar lista ordenada por antigüedad\n\n");

	}
	
//-------------------------------------------------------------------------------------------
	
	/* Proposito: 
	 * Prototipo:
	 * Precondiciones: 
	 * Entradas:
	 * Salidas: 
	 * Postcondiciones: 
	 */
	public boolean validaOpcion(String opcion){
		boolean vale=false;
		int parseo=-1;
		
		try{
			parseo=Integer.parseInt(opcion);
		}catch(NumberFormatException error){
			System.out.println("Se esperaba un numero");
		}
		
		if(parseo>=0 && parseo<=11){
			vale=true;
		}
		
		return vale;
	}
	
//-------------------------------------------------------------------------------------------

	/* Proposito: Calcula la edad media de un grupo de profesores almacenados en un archivo binario
	 * Prototipo: double edadPromedio()
	 * Precondiciones: No hay
	 * Entradas: Usamos el atributo de la clase (archivo)
	 * Salidas: Un real
	 * Postcondiciones: El real será la edad promedio del grupo de profesores
	 * Restricciones: El archivo debe existir y contener algún profesor
	 */
	public double edadPromedio(){
		double edadProm=0.0;
		int contadorPersonas=0;
		int acumEdad=0;
		File file=new File(this.archivo);
		ObjectInputStream ois =null;
		FileInputStream fis=null;
		//boolean sigue=true;
		Profesor p=null;
		
		if(file.exists() && this.cuentaProfesores()>0){//Si el archivo existe y contiene algún profesor
			try {		
				fis = new FileInputStream(file);
				ois = new ObjectInputStream(fis){@Override protected void readStreamHeader(){}};//Sobreescribiremos el metodo readStreamHeader (por defecto falla)

				p = (Profesor) ois.readObject(); //Lectura anticipada
				while(p!=null){
					acumEdad=acumEdad+p.getAge();
					contadorPersonas++;				
					p = (Profesor) ois.readObject();
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

	/*//INTERFAZ ProfesorJoven
	 * Cabecera: public void ProfesorJoven()
	 * Comentario: Dice cual es el profesor más joven de todos
	 * Prec: Nada
	 * Entrada: Nada
	 * Salida: Nada
	 * Post: Muestra en pantalla el nombre y la edad del profesor más joven del grupo
	 * Restricciones: El archivo debe existir y contener algún profesor
	 */	
	public void ProfesorJoven(){
		Profesor p=null;
		Profesor pjoven=null;	
		File f=new File(this.archivo);
		FileInputStream fis=null;
		ObjectInputStream ois=null;
		
		if(f.exists() && this.cuentaProfesores()>0){
			try{				
				fis=new FileInputStream(f);
				ois=new ObjectInputStream(fis){@Override protected void readStreamHeader(){}};
				
				p=(Profesor) ois.readObject();
				pjoven=p;
				while(p!=null){
					if(pjoven.getAge()>p.getAge()){
						pjoven=p;
					}
					p=(Profesor) ois.readObject();
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
			System.out.println("El profesor mas joven es "+pjoven.getNombre()+" con "+pjoven.getAge()+" años.");
		}else{
			System.out.println("El archivo debe existir y contener algún profesor");
		}
		this.RegistroLog("ProfesorJoven");
	}
	
//-------------------------------------------------------------------------------------------	
	/*//INTERFAZ ProfesorMayor
	 * Cabecera: public void ProfesorMayor()
	 * Comentario: Dice cual es el profesor más viejo de todos
	 * Prec: Nada
	 * Entrada: Nada
	 * Salida: Nada
	 * Post: Muestra en pantalla el nombre y la edad del profesor más viejo del grupo
	 * Restricciones: El archivo debe existir y contener algún profesor
	 */	
	public void ProfesorMayor(){
		Profesor p=null;
		Profesor pmayor=null;		
		File f=new File(this.archivo);
		FileInputStream fis=null;
		ObjectInputStream ois=null;
		
		if(f.exists() && this.cuentaProfesores()>0){
			try{
				fis=new FileInputStream(f);
				ois=new ObjectInputStream(fis){@Override protected void readStreamHeader(){}};
				
				p=(Profesor) ois.readObject();
				pmayor=p;
				while(p!=null){
					if(pmayor.getAge()<p.getAge()){
						pmayor=p;
					}
					p=(Profesor) ois.readObject();
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
			System.out.println("El profesor mas viejo es "+pmayor.getNombre()+" con "+pmayor.getAge()+" anios.");
		}else{
			System.out.println("El fichero debe existir y contener profesores");	
		}
		this.RegistroLog("ProfesorMayor");
	}
	
//-------------------------------------------------------------------------------------------	
	/*//INTERFAZ MenorAMedia
	 * Cabecera: public void MenorAMedia()
	 * Comentario: Muestra una lista con los profesores cuya edad es menor a la media.
	 * Prec: Nada
	 * Entrada: Nada
	 * Salida: Nada
	 * Post: Muestra en pantalla un listado con nombre y edad de profesores menor a la media.
	 * Restricciones: El archivo debe existir y contener algún profesor
	 */	
	public void MenorAMedia(){
		//Profesor[] profesores;
		File f=new File(this.archivo);
		FileInputStream fis=null;
		ObjectInputStream ois=null;
		Profesor p=null;
		double edadMedia;
		edadMedia=MediaEdadProfesores();
		
		if(f.exists() && this.cuentaProfesores()>0){
			try{
				fis=new FileInputStream(f);
				ois=new ObjectInputStream(fis){@Override protected void readStreamHeader(){}};
				
				System.out.println("La edad media del profesorado actual es: "+edadMedia);
				
				p=(Profesor) ois.readObject();
				while(p!=null){
					if(p.getAge()<edadMedia){
						System.out.println("Profesor: "+p.getNombre()+"   \tEdad: "+p.getAge());
					}
					p=(Profesor) ois.readObject();
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
			System.out.println("El fichero debe existir y contener profesores");	
		}
		this.RegistroLog("MenorAMedia");
	}
	
//-------------------------------------------------------------------------------------------	
	/*//INTERFAZ MayorAMedia
	 * Cabecera: public void MayorAMedia()
	 * Comentario: Muestra una lista con los profesores cuya edad es mayor a la media.
	 * Prec: Nada
	 * Entrada: Nada
	 * Salida: Nada
	 * Post: Muestra en pantalla un listado con nombre y edad de profesores mayor a la media.
	 * Restricciones: El archivo debe existir y contener algún profesor
	 */
	public void MayorAMedia(){
		//Profesor[] profesores;
		File f=new File(this.archivo);
		FileInputStream fis=null;
		ObjectInputStream ois=null;
		Profesor p=null;
		double edadMedia;
		edadMedia=MediaEdadProfesores();
		
		if(f.exists() && this.cuentaProfesores()>0){
			try{
				fis=new FileInputStream(f);
				ois=new ObjectInputStream(fis){@Override protected void readStreamHeader(){}};
				
				System.out.println("La edad media del profesorado actual es: "+edadMedia);
				
				p=(Profesor) ois.readObject();
				while(p!=null){
					if(p.getAge()>edadMedia){
						System.out.println("Profesor: "+p.getNombre()+"   \tEdad: "+p.getAge());
					}
					p=(Profesor) ois.readObject();
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
			System.out.println("El fichero debe existir y contener profesores");	
		}
		this.RegistroLog("MayorAMedia");
	}	
	
//-------------------------------------------------------------------------------------------------------------------------------	
	/*//INTERFAZ MediaEdadProfesores
	 * Cabecera: public void MediaEdadProfesores() throws ClassNotFoundException
	 * Comentario: Calcula la edad media de todos los profesores
	 * Prec: Nada
	 * Entrada: Nada
	 * Salida: double
	 * Post: Devuelve asociado al nombre la edad media del grupo de profesores.
	 * Restricciones: El archivo debe existir y contener algún profesor
	 */	
	public double MediaEdadProfesores(){
		double mediaEdad=-1;
		int nprofesores=0;
		Profesor p = null;
		File f=new File(this.archivo);
		FileInputStream fis=null;
		ObjectInputStream ois=null;
		
		if(f.exists() && this.cuentaProfesores()>0){
			mediaEdad=0;
			try{	
				fis=new FileInputStream(f);
				ois=new ObjectInputStream(fis){@Override protected void readStreamHeader(){}};
				
				p = (Profesor) ois.readObject();
				while(p != null) { //Vamos acumulando las edades y contando la cantidad total de profesores, para realizar el calculo.
					mediaEdad=mediaEdad+p.getAge();
					nprofesores++;
					p = (Profesor) ois.readObject();
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
			mediaEdad=mediaEdad/nprofesores;
			mediaEdad=Math.floor(mediaEdad*100)/100;//Reducimos el numero de decimales.
		}
		this.RegistroLog("MediaEdadProfesores");
		return mediaEdad;
	}

	
//-------------------------------------------------------------------------------------------
	/* Proposito: Carga un ArrayList con todos los profesores que hay en el archivo binario
	 * Prototipo: ArrayList<Profesor> cargaArrayProfesores()
	 * Precondiciones: No hay
	 * Entradas: Se usará el atributo de la clase 
	 * Salidas: 
	 * Postcondiciones: 
	 * Restricciones: El archivo debe existir y contener algún profesor 
	 */	
	public ArrayList<Profesor> cargaArrayProfesores(){
		File file=new File(this.archivo);
		ArrayList<Profesor> profesores=new ArrayList<Profesor>();
		ObjectInputStream ois =null;
		FileInputStream fis=null;
		Profesor p=null;
		
		try {		
			fis = new FileInputStream(file);
			ois = new ObjectInputStream(fis){@Override protected void readStreamHeader(){}};//Sino sobreescribiremos el metodo readStreamHeader de ObjectInputStream	
																							
			p = (Profesor) ois.readObject();	
			
			while(p!=null){				
				profesores.add(p);
				p = (Profesor) ois.readObject();	
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
		return profesores;		
	}
	
	//-------------------------------------------------------------------------------------------	

		public void leeProfesores(){
			File file=new File(this.archivo);
			ObjectInputStream ois =null;
			FileInputStream fis=null;
			Profesor p=null;
			
			if(file.exists() && this.cuentaProfesores()>0){
				System.out.print("Nombre     Apellido         Edad   Sexo    DNI         Materia       Antigüedad\n");
				try {		
					fis = new FileInputStream(file);
					ois = new ObjectInputStream(fis){@Override protected void readStreamHeader(){}};
						
					p = (Profesor) ois.readObject();

					while(p!=null){
						System.out.println(" _____________________________________________________________________________\n");
						//System.out.println(ois.readObject().toString());				
						//System.out.println("|"+p.toString());
						System.out.println(p.getNombre()+"   "+p.getApellido()+"      "+p.getAge()+"     "+p.getSexo()+"    "+p.getDNI()+"    "+p.getMateria()+"      "+p.getAntiwedad());
						p = (Profesor) ois.readObject();
					}//fin mientras	
				} catch (ClassNotFoundException error) {
				}catch (EOFException error) {
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
			}else{
				System.out.println("El fichero debe existir y contener profesores");
			}
			this.RegistroLog("leerProfesores");
		}
	
//-------------------------------------------------------------------------------------------
	/* Proposito: Inserta un profesor en un archivo binario
	 * Prototipo:
	 * Precondiciones: Todos los atributos del profesor deben ser válidos
	 * Entradas: Un profesor
	 * Salidas: Un booleano 
	 * Postcondiciones: El booleano será verdadero si el profesor se ha insertado con éxito y falso sino 
	 * Restricciones: El profesor no debe existir en la lista para introducirlo, su edad debe ser mayor que 25(nacido en el 91) y menor que 65 (nacido en el 57)
	 */		
	public boolean addProfesor(Profesor profesor){
		File file=new File(this.archivo);
		FileOutputStream fos=null;
		ObjectOutputStream oos=null;
		boolean introducido=false;
		
		//Abrimos el fichero
		try {
			if(file.exists()){
				fos=new FileOutputStream(file,true);
			}else{
				fos=new FileOutputStream(file);//Sino existe lo creamos
			}
			
			oos=new ObjectOutputStream(fos){@Override protected void writeStreamHeader(){}};
			oos.writeObject(profesor);	
			introducido=true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				if(oos!=null){
				oos.close();
				}
				if(fos!=null){
					fos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}	
		}		
		this.RegistroLog("addProfesor");
		return introducido;
	}

	
	
//-------------------------------------------------------------------------------------------
		/* Proposito: Borra un profesor en un archivo binario
		 * Prototipo: boolean dropProfesor(String dni)
		 * Precondiciones: no hay
		 * Entradas: Una cadena que será el dni del profesor a borrar
		 * Salidas: Un booleano 
		 * Postcondiciones: El booleano será verdadero si el profesor se ha borrado con éxito y falso sino 
		 * Restricciones: El archivo debe existir y contener algún profesor
		 */		
	//USANDO ARCHIVO AUXILIAR
		public boolean dropProfesor(String dni){
			boolean borrado=false;
			File file=new File(this.archivo);
			File fileAux=new File("archivoProfesoresAux.dat");
			FileInputStream fis=null;
			ObjectInputStream ois=null;
			FileOutputStream fos=null;
			ObjectOutputStream oos=null;
			Profesor p=null;	
			
			if(file.exists()){//Si el archivo existe y contiene algun profesor 	

					try {					
						//Abrimos el archivo para leer
						fis=new FileInputStream(file);	
						ois=new ObjectInputStream(fis){@Override protected void readStreamHeader(){}};//Si contiene datos usamos ObjectInputStream sobreecribiendo el metodo readStreamHeader()
	
						//Abrimos el fichero para escribir
						fos=new FileOutputStream(fileAux);	
						oos=new ObjectOutputStream(fos){@Override protected void writeStreamHeader(){}};				
						
						p=(Profesor)ois.readObject();
						while(p!=null){						
							if(p.getDNI().equalsIgnoreCase(dni)){	
								borrado=true;
							}else{
								oos.writeObject(p);//Escribimos en el archivo creado todos los profesores excepto el que borramos								
							}	
							p=(Profesor)ois.readObject();
						}//fin mientras
					} catch (ClassNotFoundException e) {
					} catch (EOFException e) {
					}catch (IOException e) {
						System.out.println(e);
					}finally{
						try{
							if(oos!=null){
								oos.close();
							}
							if(fos!=null){
								fos.close();
							}
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
					file.delete();
					fileAux.renameTo(file);				
			}//fi si
			this.RegistroLog("dropProfesor");		
			return borrado;
		}
		
		//USANDO UN ARRAYLIST DE PROFESORES Y SOBREESCRIBIENDO EL ARCHIVO
		/*public boolean dropProfesor(String dni){
			boolean borrado=false;
			File file=new File(this.archivo);
			//FileInputStream fis=null;
			//ObjectInputStream ois=null;
			FileOutputStream fos=null;
			ObjectOutputStream oos=null;
			//boolean sigue=true;
			ArrayList<Profesor> profesores=new ArrayList<Profesor>();
			
			if(file.exists() && file.getTotalSpace()>0){
				try {				
					profesores=cargaArrayProfesores();
					
					for(int i=0;i<profesores.size();i++){
						Profesor p=null;
						p=profesores.get(i);
						
						if(p.getDNI().equals(dni)){
							profesores.remove(i);
							borrado=true;
						}
					}
					
					try {
						fos=new FileOutputStream(file);
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}		
					
					oos=new ObjectOutputStream(fos);

					for(int i=0;i<profesores.size();i++){
						oos.writeObject(profesores.get(i));
					}
				}catch(IOException e){
					e.printStackTrace();
				}
				
				try{
					oos.close();
				}catch(IOException e){		
					e.printStackTrace();
				}
			
			}//fin si
		
			return borrado;
		}*/
	
		
		
//-------------------------------------------------------------------------------------------
		/* Proposito: Muestra un menu de opciones para el filtrado de búsqueda de un profesor en un archivo binario
		 * 			  Las opciones de filtrado son : - Nombre y apellido
		 * 											 - Materia
		 * 											 - Sexo
		 * 											 - DNI
		 * Prototipo: void pintaMenuBusqueda()
		 * Precondiciones: no hay
		 * Entradas: no hay
		 * Salidas: no hay
		 * Postcondiciones: Se pinta en pantalla un menu de filtrado 
		 * Restricciones: El archivo debe existir y contener al menos un profesor
		 */				
	public void pintaMenuBusqueda(){
		File file=new File(this.archivo);
		if(file.exists() && this.cuentaProfesores()>0){
			System.out.println("\nElija el filtro de búsqueda");
			System.out.println("0 para: Salir");
			System.out.println("1 para: Filtrar por nombre y apellido.");
			System.out.println("2 para: Filtrar por materia");
			System.out.println("3 para: Filtrar por sexo");
			System.out.println("4 para: Filtrar por DNI");
		}else{
			System.out.println("El archivo debe existir y contener algún profesor");
		}
	}
	
//-------------------------------------------------------------------------------------------

	/* Proposito: 
	 * Prototipo:
	 * Precondiciones: 
	 * Entradas:
	 * Salidas: 
	 * Postcondiciones: 
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

//----------------------------------------------------------------------------------------------------------------

	/* Proposito: Cuenta los profesores que hay en un archivo binario
	 * Prototipo: int cuentaProfesores()
	 * Precondiciones: no hay
	 * Entradas: no hay
	 * Salidas: un entero
	 * Postcondiciones: El entero será el número de profesores que hay en el archivo
	 * Restricciones: EL fichero debe existir
	 */
	public int cuentaProfesores(){
		File file=new File(this.archivo);
		ObjectInputStream ois =null;
		FileInputStream fis=null;
		int contador=0;
		Profesor p=null;
		if(file.exists()){
			try {		
				fis = new FileInputStream(file);
				ois = new ObjectInputStream(fis){@Override protected void readStreamHeader(){}};	
				p = (Profesor) ois.readObject();
				while(p!=null){						
					contador++;
					p = (Profesor) ois.readObject();
				}
			} catch (ClassNotFoundException e) {				
			}catch(EOFException error){
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
		}//fin si	
		return contador;
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
	//profesorExists
	/* Proposito: Dado un dni como cadena completo comprueba que existe un profesor con el mismo
	 * Prototipo: boolean profesorDniExists(String dni)
	 * Precondiciones: No hay
	 * Entradas: Una cadena
	 * Salidas: Un booleano
	 * Postcondiciones: El booleano será verdadero si hay un profesor con el mismo dni
	 * Restricciones: El archivo debe existir y contener algun profesor
	 * 				  El dni debe tener 8 digitos numéricos y una letra
	 */
	public boolean profesorDniExists(String dni){
		boolean existe=false;
		File file=new File(this.archivo);
		FileInputStream fis=null;
		ObjectInputStream ois=null;
		Profesor p=null;
		
		if(file.exists() && this.cuentaProfesores()>0){	//si el archivo existe y contiene algun profesor	
			if(dni.matches("[0-9]{8}[a-zA-Z]{1}") ){//si el dni tiene 8 digitos numéricos y una letra
				try {//validaDNI(dni) && Character.isAlphabetic(dni.charAt(8)) && 
					fis=new FileInputStream(file);
					ois=new ObjectInputStream(fis){@Override protected void readStreamHeader(){}};
					Character.toUpperCase(dni.charAt(8));//Pasamos a mayúscula la letra del dni
					p=(Profesor)ois.readObject();	
					while(p!=null){
						if(p.getDNI().equals(dni)){
							existe=true;
						}
						p=(Profesor)ois.readObject();	
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
		this.RegistroLog("profesorDniExists");
		return existe;
	}
	
//----------------------------------------------------------------------------------------------------------------

	/* Proposito: Dado un nombre y apellido busca los profesores con los mismos y los pinta en pantalla
	 * Prototipo: void buscaProfesores(String nombre, String apellido)
	 * Precondiciones: no hay
	 * Entradas: dos cadenas
	 * Salidas: no hay
	 * Postcondiciones: Se pintará en pantalla los profesores con ese nombre y apellido 
	 * Restricciones: EL fichero debe existir
	 */
	public void buscaProfesores(String nombre, String apellido){
		File file=new File(this.archivo);
		ObjectInputStream ois=null;
		FileInputStream fis=null;
		Profesor p=null;
		int contador=0;
		
		if(file.exists()){			
			try{
				fis=new FileInputStream(file);
				ois=new ObjectInputStream(fis){@Override protected void readStreamHeader(){}};
									
				p=(Profesor)ois.readObject();
				
				while(p!=null){										
					
					if(p.getNombre().toLowerCase().equals(nombre.toLowerCase()) && p.getApellido().toLowerCase().equals(apellido.toLowerCase())){
						System.out.println(p.toString());
						contador++;
						p=(Profesor)ois.readObject();
					}
				}//fin mientras		
				System.out.println("\t\t"+contador+" resultados");
			} catch (ClassNotFoundException e) {
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
		this.RegistroLog("buscaProfesores");
	}
	
	
	
//----------------------------------------------------------------------------------------------------------------

	/* Proposito: Dada una materia busca los profesores con la misma y los pinta en pantalla
	 * Prototipo: void buscaProfesoresMateria(String materia)
	 * Precondiciones: no hay
	 * Entradas: una cadenas
	 * Salidas: no hay
	 * Postcondiciones: Se pintará en pantalla los profesores con esa materia
	 * Restricciones: EL fichero debe existir
	 */
	public void buscaProfesoresMateria(String materia){
		File file=new File(this.archivo);
		ObjectInputStream ois=null;
		FileInputStream fis=null;
		int contador=0;
		Profesor p=null;
		
		if(file.exists()){			
			try{
				fis=new FileInputStream(file);
				ois=new ObjectInputStream(fis){@Override protected void readStreamHeader(){}};						
			
				p=(Profesor)ois.readObject();
				while(p!=null){					
					
					if(p.getMateria().toLowerCase().equals(materia.toLowerCase())){
						//oos.writeObject(p);
						System.out.println(p.toString());
						contador++;
						p=(Profesor)ois.readObject();
					}
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
		this.RegistroLog("buscaProfesoresMateria");
	}

	
	
//----------------------------------------------------------------------------------------------------------------

	/* Proposito: Dado un caracter como sexo del profesor/a busca los profesores del mismo y los pinta en pantalla
	 * Prototipo: void buscaProfesores(String sexo)
	 * Precondiciones: no hay
	 * Entradas: una cadenas
	 * Salidas: no hay
	 * Postcondiciones: Se pintará en pantalla los profesores de ese sexo
	 * Restricciones: EL fichero debe existir
	 */
	public void buscaProfesoresSexo(String sexo){
		File file=new File(this.archivo);
		ObjectInputStream ois=null;
		FileInputStream fis=null;
		int contador=0;
		Profesor p=null;	
		
		if(file.exists()){			
			try{
				fis=new FileInputStream(file);
				ois=new ObjectInputStream(fis){@Override protected void readStreamHeader(){}};						
			
				while(p!=null){								
					if(p.getSexo().toLowerCase().equals(sexo.toLowerCase())){
						
						System.out.println(p.toString());
						contador++;
					}
					p=(Profesor)ois.readObject();
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
		this.RegistroLog("buscaProfesoresSexo");
	}
	
//----------------------------------------------------------------------------------------------------------------

	/* Proposito: Dado un dni busca el profesor conel mismo y lo pinta en pantalla
	 * Prototipo: void buscaProfesores(String dni)
	 * Precondiciones: no hay
	 * Entradas: una cadenas
	 * Salidas: no hay
	 * Postcondiciones: Se pintará en pantalla los profesores de ese sexo
	 * Restricciones: EL fichero debe existir
	 */
	public void buscaProfesorDNI(String dni){
		File file=new File(this.archivo);
		ObjectInputStream ois=null;
		FileInputStream fis=null;
		Profesor p=null;	
		int contador=0;
		
		if(file.exists()){			
			try{
				fis=new FileInputStream(file);
				ois=new ObjectInputStream(fis){@Override protected void readStreamHeader(){}};						
				p=(Profesor)ois.readObject();
				
				while(p!=null){
					if(p.getDNI().equals(dni)){
						//oos.writeObject(p);
						System.out.println(p.toString());
						contador++;
					}
					p=(Profesor)ois.readObject();
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
		RegistroLog("buscaProfesorDNI");
	}	
	
//----------------------------------------------------------------------------------------------------------------

	/* Proposito: Dado un dni busca el profesor con el mismo y devuelve la posicion
	 * Prototipo: void modificaProfesor(String dni)
	 * Precondiciones: no hay
	 * Entradas: una cadena 
	 * Salidas: no hay
	 * Postcondiciones: Se obtendra la posicion del profesor a modificar
	 * Restricciones: EL fichero debe existir y contener profesores
	 */
	public int posicionProfesor(String dni){
		File file=new File(this.archivo);
		FileInputStream fis=null;
		ObjectInputStream ois=null;
		int posicion=-1, contador=0;	
		Profesor p=null;	
		
		if(file.exists() && this.cuentaProfesores()>0){
			try {
				fis=new FileInputStream(file);
				ois = new ObjectInputStream(fis){@Override protected void readStreamHeader(){}};																											
				p=(Profesor)ois.readObject();
				while(p!=null){										
					contador++;
					if(p.getDNI().equals(dni)){
						posicion=contador;
					}		
					p=(Profesor)ois.readObject();
				}//fin mentras																				
			}catch(ClassNotFoundException e){								
			}catch(EOFException e){								
			} catch (IOException e) {
				System.out.println(e);
			}finally{				
				try {
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
		RegistroLog("posicionProfesor");
		return posicion;
	}
	
	
	
//----------------------------------------------------------------------------------------------------------------

	/* Proposito: Recibe un dni y un Profesor, busca al profesor con el mismo y lo cambia por el profesor recibido
	 * Prototipo: void modificaProfesor(String dni, Profesor profesor)
	 * Precondiciones: no hay
	 * Entradas: una cadena que será el dni del profesor a modificar y un objeto profesor que tendrá los datos ya modificados
	 * Salidas: no hay
	 * Postcondiciones: Se hab
	 * Restricciones: EL fichero debe existir y contener algun profesor			 
	 */
	public void modificaProfesor(String dni, Profesor profesor){
		File fichero=new File(this.archivo);
		File fileAux=new File("ficheroAux.dat");
		FileInputStream fis=null;
		ObjectInputStream ois=null;
		FileOutputStream fos=null;
		ObjectOutputStream oos=null;
		Profesor p=null;	
		
		if(fichero.exists() && cuentaProfesores()>0){
			try {
				fis=new FileInputStream(fichero);	
				ois = new ObjectInputStream(fis){@Override protected void readStreamHeader(){}};
				
				fos=new FileOutputStream(fileAux);
				oos=new ObjectOutputStream(fos){@Override protected void writeStreamHeader(){}};							
				
				p=(Profesor)ois.readObject();	
				
				while(p!=null){																					
					if(p.getDNI().equalsIgnoreCase(dni)){
						oos.writeObject(profesor);
					}else{
						oos.writeObject(p);
					}	
					p=(Profesor)ois.readObject();	
				}																					
			}catch(ClassNotFoundException e){				
			}catch(EOFException e){								
			}catch (IOException e) {
				System.out.println(e);
			}finally{
				try {
					if(oos!=null) {
						oos.close();
					}
					if(fos!=null){					
						fos.close();
					}//fin si	
					if(ois!=null){
						ois.close();					
					}//fin si
					if(fis!=null){					
						fis.close();
					}
				}catch (IOException e) {
					e.printStackTrace();
				}								
			}
			fichero.delete();
			fileAux.renameTo(fichero);
		}//fin si fichero existe y contiene profesores
		RegistroLog("modificaProfesor");
	}
	
	/* Proposito: Pide los datos necesarios para crear un profesor
	 * Prototipo: Profesor creaProfesor()
	 * Precondiciones: no hay
	 * Entradas: - Cadenas: nombre, apellido, DNI, sexo, materia
	 * 			 - Fecha: FechaNacimiento, FechaContratacion; las fechas tienen año, mes y dia como enteros
	 * Salidas: Un Profesor
	 * Postcondiciones: Se habrá creado un profesor
	 */
	public Profesor creaProfesor(){
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		Scanner teclado=new Scanner(System.in);
		boolean vale=true;
		Profesor profesor=new Profesor();
		String dni=" ";
		Fecha2 fecha=new Fecha2();
		
			//LEER NOMBRE
				System.out.println("\nIntroduzca el nombre");
			try {
				profesor.setNombre(br.readLine());
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			//LEER APELLIDO
			System.out.println("\nIntroduzca el primer apellido");
			try {
				profesor.setApellido(br.readLine());
			} catch (IOException e) {										
				e.printStackTrace();
			}
			
			//LEER Y VALIDAR FECHA NACIMIENTO
			do{
				System.out.println("\nIntroduzca la fecha de nacimiento");
				do{
					vale=true;
					System.out.println("\n\tIntroduzca el año");
					try{
					profesor.getBirthDate().setYear(teclado.nextInt());
					}catch(ExcepcionFecha error){
						System.out.println(error);
						vale=false;
					}
				}while(!vale);
				
				do{
					vale=true;
					System.out.println("\n\tIntroduzca el mes");
					try{
					profesor.getBirthDate().setMonth(teclado.nextInt());
					}catch(ExcepcionFecha error){
						System.out.println(error);
						vale=false;
					}
				}while(!vale);
				
				do{
					vale=true;
					System.out.println("\tIntroduzca el dia");
					try{
					profesor.getBirthDate().setDay(teclado.nextInt());
					}catch(ExcepcionFecha error){
						System.out.println(error);
						vale=false;
					}
				}while(!vale);

			}while(!profesor.getBirthDate().validafecha());

			//LEER Y VALIDAR SEXO
			do{
				vale=true;
				System.out.println("\nIntroduzca el sexo: H-M");
				try {
					profesor.setSexo(br.readLine());
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
				profesor.setDNI(dni);
			}catch(ExcepcionPersona error){
				System.out.println(error);
			}
			
			//LEER Y VALIDAR MATERIA
			do{
				vale=true;
				System.out.println("\nIntroduzca la materia");
				try {
					profesor.setMateria(br.readLine());
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
					profesor.getFechaCont().setYear(teclado.nextInt());
					}catch(ExcepcionFecha error){
						System.out.println(error);
						vale=false;
					}
				}while(!vale);
				
				do{
					vale=true;
					System.out.println("\n\tIntroduzca el mes");
					try{
					profesor.getFechaCont().setMonth(teclado.nextInt());
					}catch(ExcepcionFecha error){
						System.out.println(error);
						vale=false;
					}
				}while(!vale);
				
				do{
					vale=true;
					System.out.println("\tIntroduzca el dia");
					try{
					profesor.getFechaCont().setDay(teclado.nextInt());
					}catch(ExcepcionFecha error){
						System.out.println(error);
						vale=false;
					}
				}while(!vale);

			}while(!profesor.getFechaCont().validafecha());
		RegistroLog("creaProfesor");
		return profesor;
	}
	
	
	//ordenarPorAntiwedad
	/* Proposito: Muestra una lista de profesores ordenada por fecha de antigüedad
	 * Prototipo: void ordenarPorAntiwedad()
	 * Precondiciones: El fichero debe existir y contener algún
	 * Entradas: 
	 * Salidas: Pinta en pantalla un listado de profesores ordenados por antiguedad en el centro.
	 * Postcondiciones: Pinta en pantalla
	 */
	public void ordenarPorAntiwedad(){
		File file=new File(this.archivo);
		ArrayList<Profesor> profesores=new ArrayList<Profesor>();
		profesores=this.cargaArrayProfesores();
		ComparatorProfesor comparator=new ComparatorProfesor();
		
		Collections.sort(profesores, comparator);
		
		for(Profesor temp:profesores){
			System.out.println(temp.toString());
		}
		RegistroLog("ordenarPorAntiwedad");
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
			archivo=new FileWriter(f,false);
		}
		
		archivo=new FileWriter(f, true);
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
	
	
	
	
	
}
