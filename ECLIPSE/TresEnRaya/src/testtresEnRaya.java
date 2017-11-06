
public class testtresEnRaya {
	public static void main(String [] args){
		
		tresEnRaya juego=new tresEnRaya();
		
		//juego.montaTablero();
		juego.ponFicha(0, 0, 2);
		juego.ponFicha(1, 0, 2);
		juego.ponFicha(2, 0, 2);
		juego.ponFicha(0, 1, 2);
		juego.ponFicha(1, 1, 2);
		juego.ponFicha(2, 1, 2);
		juego.ponFicha(0, 2, 2);
		juego.ponFicha(1, 2, 2);
		juego.ponFicha(2, 2, 2);

		//juego.quitaFicha(posI, posJ, jug);
		//juego.ponFicha(0, 2, 2);
		//juego.ponFicha(0, 2, 1);
		//juego.quitaFicha(0, 0, 1);
		//juego.quitaFicha(0, 0, 2);
		juego.pintaTablero();
		//System.out.println(juego.compruebaGanador());
		//System.out.println("\nPosiciones libres: "+juego.getPosicionesLibres());
		
		
	}
}
