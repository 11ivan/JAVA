import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.EOFException;

public class GestoraProgPrinc {
	
	private String archivo;
	
	public GestoraProgPrinc(){
		archivo="archivoProfesores.obj";
	}
	
//-------------------------------------------------------------------------------------------
	
	public void pintaMenu(){
		System.out.println("Elija una opción del menú");
		System.out.println("0 para: Salir");
		System.out.println("1 para: Edad promedio del grupo de profesores.");
		System.out.println("2 para: Nombre del profesor más joven del grupo");
		System.out.println("3 para: Nombre del profesor de más edad");
		System.out.println("4 para: Número de profesores con edad mayor al promedio");
		System.out.println("5 para: Número de profesores con edad menor al promedio");
		System.out.println("6 para: Lista de profesores");
	}
	
//-------------------------------------------------------------------------------------------
		
	public boolean validaOpcion(String opcion){
		boolean vale=false;
		int parseo=-1;
		
		try{
			parseo=Integer.parseInt(opcion);
		}catch(NumberFormatException error){
			System.out.println("Se esperaba un numero");
		}
		
		if(parseo>=0 && parseo<=6){
			vale=true;
		}
		
		return vale;
	}
	
//-------------------------------------------------------------------------------------------
	public double edadPromedio(){
		ArrayList<Persona> personas=null;
		double edadProm=0.0;
		int contadorPersonas=0;
		int acumEdad=0;
		
		personas=cargaArrayPersonas();
		
		for(int i=0;i<personas.size();i++){
			contadorPersonas++;
			acumEdad=acumEdad+personas.get(i).getAge();
		}
		edadProm=acumEdad/contadorPersonas;
		
		return edadProm;
	}
	
	
//-------------------------------------------------------------------------------------------
	
	public ArrayList<Persona> cargaArrayPersonas(){
		File file=new File(this.archivo);
		ArrayList<Persona> personas=new ArrayList<Persona>();
		ObjectInputStream ois =null;
		FileInputStream fis=null;
		boolean sigue=true;
		
		try {		
			fis = new FileInputStream(file);
			ois = new ObjectInputStream(fis);
			
			while(sigue){
				Persona p=null;
				try {
					p = (Persona) ois.readObject();
					
					personas.add(p);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}catch(EOFException error){
					sigue=false;
				}

			}

		} catch (FileNotFoundException error) {
			error.printStackTrace();
		} catch (IOException error) {
			error.printStackTrace();
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
		return personas;		
	}
	
	
	
	public void leePersonas(){
		File file=new File(this.archivo);
		ObjectInputStream ois =null;
		FileInputStream fis=null;
		boolean sigue=true;
		
		try {		
			fis = new FileInputStream(file);
			ois = new ObjectInputStream(fis);
			
			while(sigue){
				//Persona p=null;
				try {
					//p = (Persona) ois.readObject();
					System.out.println(ois.readObject());
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}catch(EOFException error){
					sigue=false;
				}
				/*if(sigue){
					System.out.print("Nombre: "+p.getNombre());
					System.out.print("\tApellido: "+p.getApellido());
					System.out.print("\tEdad: "+p.getAge());
					System.out.print("\tSexo: "+p.getSexo());	
					System.out.println(" ");
				}*/
			}

		} catch (FileNotFoundException error) {
			error.printStackTrace();
		} catch (IOException error) {
			error.printStackTrace();
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
	}

	
	
	public void escribePersonas(){
		File file=new File(this.archivo);
		FileOutputStream fos=null;
		ObjectOutputStream oos=null;
		try {
			fos=new FileOutputStream(file,true);			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			oos=new ObjectOutputStream(fos);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			oos.writeObject(new Persona("Pepe", "Castro", new Fecha2(2,3,1990),'H'));
			oos.writeObject(new Persona("Ana", "ToRoja", new Fecha2(12,10,1989),'M'));
			oos.writeObject(new Persona("Juan", "Gonzalez", new Fecha2(26,6,1987),'H'));			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ExcepcionPersona e) {
			e.printStackTrace();
		} catch (ExcepcionFecha e) {
			e.printStackTrace();
		}
		try {
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
}
