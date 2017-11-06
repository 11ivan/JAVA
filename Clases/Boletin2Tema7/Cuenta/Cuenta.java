//Cuenta.java


public class Cuenta implements Comparable<Cuenta>, Cloneable {
	
	private double numCuenta;
	private double saldo;
	//private static final double comision=0.001;
	
//---------------------------------------------------------------------------		
	//Constructores
	public Cuenta(){
		numCuenta=0000000000;
		saldo=0.0;
	}
	
	public Cuenta(double numCuenta,double saldo)throws ExcepcionCuenta{
		
		this.numCuenta=numCuenta;
		
		if(saldo<=0){
			throw new ExcepcionCuenta("No puede tener 0 o menos");
		}else{	
			this.saldo=saldo;
			}
	}
	
	public Cuenta(Cuenta cuenta){
		this.numCuenta=cuenta.getNumCuenta();
		this.saldo=cuenta.getSaldo();
	}
	
//---------------------------------------------------------------------------		
	//Consultores
	public double getNumCuenta(){
		return numCuenta;
	}
	
	public double getSaldo(){
		return saldo;
	}
	
//---------------------------------------------------------------------------		
	//Modificadores
	void setSaldo(double saldo)throws ExcepcionCuenta{
		if(saldo<=0){
			throw new ExcepcionCuenta("No puede tener 0 o menos");
		}else{	
			this.saldo=saldo;
			}
	}

//---------------------------------------------------------------------------	
	//compareTo 
	//se devolvera 0 si tienen el mismo saldo, 1 si la cuenta que llega tiene menos saldo y -1 si tiene mas
	public int compareTo(Cuenta cuenta){
		int comparacion=0;
		
		if(this.saldo>cuenta.getSaldo()){
			comparacion=1;
		}else if(this.saldo<cuenta.getSaldo()){
			comparacion=-1;
			}
		return comparacion;
	}

//---------------------------------------------------------------------------	
	//equals
	//Dos cuentas son iguales si tienen el mismo numero y el mismo saldo devuelve true
	@Override
	public boolean equals(Object obj){
		boolean iguales=false;
		
		if(obj!=null && obj instanceof Cuenta){
			Cuenta cuenta=(Cuenta) obj;
			if(this.numCuenta==cuenta.getNumCuenta() && this.saldo==cuenta.getSaldo()){
				iguales=true;
			}
		}
		return iguales;
	}
	
//---------------------------------------------------------------------------	
		//clone
		@Override
		public Cuenta clone(){
			Cuenta copia=null;
			try{
				copia=(Cuenta) super.clone();
				}catch(CloneNotSupportedException error){
					System.out.println("Objeto no clonado");
				}
			return copia;
		}

//---------------------------------------------------------------------------	
	//Funcionalidades
	
	//Transferencia
	public void tranferencia(Cuenta cuenta,double cantidad)throws ExcepcionCuenta{
		if(cantidad<=0){
			throw new ExcepcionCuenta("No puede sacar 0 o menos");
		}else if(cantidad>this.saldo || this.saldo-cantidad<0){
				throw new ExcepcionCuenta("No tiene dinero suficiente");
			}else{
				this.saldo=this.saldo-cantidad;
				cuenta.setSaldo(cuenta.getSaldo()+cantidad);
				System.out.println("Operacion realizada, ahora tiene: "+this.saldo);					
				}
	}
	
	//Retirar saldo
	public double sacaPasta(double cantidad)throws ExcepcionCuenta{
	
		if(cantidad<=0){
			throw new ExcepcionCuenta("No puede sacar 0 o menos");
		}else if(this.saldo-cantidad<0){
				throw new ExcepcionCuenta("No tiene suficiente dinero");
			}else{
				this.saldo=this.saldo-cantidad;
				System.out.println("Operacion realizada, ahora tiene: "+this.saldo);
				}
		
		return cantidad;
	}
	
	//Ingresar saldo
	public void metePasta(double cantidad) throws ExcepcionCuenta{
		if(cantidad<=0){
			throw new ExcepcionCuenta("No puede ingresar 0 o menos");
		}else{
				this.saldo=this.saldo+cantidad;
				System.out.println("Operacion realizada, ahora tiene: "+this.saldo);
			}
	}
	
	
	
	
	
	
}
