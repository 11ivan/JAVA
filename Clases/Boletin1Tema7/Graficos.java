/**
 * 
 */
//package Graficos;

import java.applet.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
/**
 * @author aortiz
 *	@author Paulo Soarez
 */
public class Graficos  extends Applet implements KeyListener {
	private Rectangle rect;
	
	public void init(){
		this.addKeyListener(this);
		rect=new Rectangle(0,0,50,50);
	}
	
	public void pintar(Graphics g){
		
		setSize(500,500);
		Graphics2D g2=(Graphics2D) g;
		g2.fill(rect);
	}
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==e.VK_UP){
			
			rect.setLocation(rect.x,rect.y+2);
		
		}
		repaint();
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
