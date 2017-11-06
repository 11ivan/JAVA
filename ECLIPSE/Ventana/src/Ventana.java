import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
 
public class Ventana {
 
    public Ventana (String titulo){
        JFrame ventanaM = new JFrame(titulo);  
        Dimension d = new Dimension();//objeto para obtener el tamaño de la pantalla
        ImageIcon im = new ImageIcon("src/calculadoragui/ventana.jpg");    
        
        
        //finaliza el programa cuando se da click en la X 
        ventanaM.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //configurando tamaño de la ventana     
        ventanaM.setSize(290, 150);
        
        //configurando visualización de la ventana     
        ventanaM.setVisible(true);
        
        //añadiendo un icono a la ventana, obtenemos la imagen del objeto imageicon
        ventanaM.setIconImage(im.getImage());
                
        //para configurar si se redimensiona la ventana
        ventanaM.setResizable(true);
        
        //para ubicar inicialmente donde se muestra la ventana (x, y)
        ventanaM.setLocation((int) ((d.getWidth()/2)+290), 50);
    }   
    
    
    
}
