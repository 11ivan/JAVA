/*
 * Clase Jugador
 * 
 * Propiedades Basicas
 * 
 *     posicionX  : tipo int, consultable y modificable
 *     posicionY  : tipo int, consultable y modificable
 *     direccionX : tipo int, consultable y modificable
 *     direccionY : tipo int, consultable y modificable
 *     vida       : tipo int, consultable y modificable
 *     puntuacion : tipo int, consultable y modificable
 *     vivo       : tipo boolean, consultable y modificable
 *     
 * Propiedades Derivadas
 * 
 * Propiedades Compartidas
 * 
 * Interfaz:
 * 
 *     public int  getPosicionY();
 *     public int  getPosicionX();
 *     public int  getDireccionY();
 *     public int  getDireccionX();
 *     public int  getVida();
 *     public int  getPuntuacion();
 *     public boolean getVivo();
 *     
 *     public void setPosicionY( int posicionX );
 *     public void setPosicionX( int posicionY );
 *     public void setDireccionY( int direccionX );
 *     public void setDireccionX( int direccionX );
 *     public void setVida( int vida );
 *     public void setPuntuacion( int puntuacion );
 *     public void setVivo( boolean vivo );
 *     
 */

public class JugadorPaulo
{
	//ATRIBUTOS
	private int posicionY;
	private int posicionX;
	private int direccionY;
	private int direccionX;
	private int vida;
	private int puntuacion;
	private boolean vivo;
	private BitMap bitMap;
	
	//CONTRUCTORES
	//CONTRUCTOR POR DEFECTO
	public JugadorPaulo()
	{
		posicionY  = 1;
		posicionX  = 1;
		direccionY = 1;
		direccionX = 1;
		vida       = 1;
		puntuacion = 1;
		vivo       = true;
	}
	
	//CONSTRUCTOR SOBRECARGADO
	public JugadorPaulo(int posicionY, int posicionX, int direccionX, int direccionY, int vida, int puntuacion, boolean vivo, BitMap bitMap) throws JugadorException
	{
		this.posicionY  = posicionY;
		this.posicionX  = posicionX;
 		this.direccionX = direccionY;
		this.direccionY = direccionX;
		this.vida       = vida;
		this.puntuacion = puntuacion;
		this.vivo       = vivo;
		this.bitMap     = bitMap;
	}
	
	//CONSTRUCTOR DE COPIA
	public JugadorPaulo(JugadorPaulo jugador)  throws JugadorException
	{
		this.posicionY  = jugador.getPosicionY();
		this.posicionX  = jugador.getPosicionX();
		this.direccionY = jugador.getDireccionY();
		this.direccionX = jugador.getDireccionX();
		this.vida 		= jugador.getVida();
		this.puntuacion = jugador.getPuntuacion();
		this.vivo		= jugador.getVivo();
		this.bitMap     = jugador.getBitMap();
	}
	
	//METODOS CONSULTORES
	public int getPosicionY() 
	{
		return posicionY;
	}
	
	public int getPosicionX() 
	{
		return posicionX;
	}
	
	public int getDireccionY() 
	{
		return direccionY;
	}
	
	public int getDireccionX() 
	{
		return direccionX;
	}
	
	public int getVida() 
	{
		return vida;
	}
	
	public int getPuntuacion() 
	{
		return puntuacion;
	}
	
	public boolean getVivo() 
	{
		return vivo;
	}
	
	public BitMap getBitMap() 
	{
		return bitMap;
	}
	
	//METODOS MODIFICADORES
	public void setPosicionY(int posicionY) 
	{
		this.posicionY = posicionY;
	}
	
	public void setPosicionX(int posicionX) 
	{

		this.posicionX = posicionX;
	}

	public void setDireccionX(int direccionX)
	{
		this.direccionX = direccionX;
	}
	
	public void setDireccionY(int direccionY) 
	{
		this.direccionY = direccionY;
	}
	
	public void setVida(int vida) 
	{
		this.vida = vida;
	}
	
	public void setPuntuacion(int puntuacion)
	{
		this.puntuacion = puntuacion;
	}
	
	public void setVivo(boolean vivo) 
	{
		this.vivo = vivo;
	}
	
	public void setbitMap(BitMap bitMap)
	{
		this.bitMap = bitMap;
	}	
	
	//Movimiento
	public void moverArriba(int numeroPosiciones)
	{
		if ( posicionY - numeroPosiciones > 0 )
		{
			setPosicionY(posicionY -= numeroPosiciones);
		}
	}
	
	public void moverAbajo(int numeroPosiciones) 
	{
		if ( posicionY + numeroPosiciones < Pantalla.ALTO - 2 )
		{
			setPosicionY(posicionY +=  numeroPosiciones);
		}	
	}
	
	
	public void moverIzquierda(int numeroPosiciones)
	{
		if ( posicionX - numeroPosiciones > 0 )
		{
			setPosicionX(posicionX -= numeroPosiciones);
		}
	}
	
	public void moverDerecha(int numeroPosiciones) 
	{
		if ( posicionX + numeroPosiciones < Pantalla.ANCHO - 2 )
		{
			setPosicionX(posicionX += numeroPosiciones);
		}
	}
	
	public void disparar()
	{
		Bala bala = new Bala(posicionY - 5, posicionX, 1, 1, 1, new BitMap(1,1, Pantalla.bitMapBala));
	}
}
