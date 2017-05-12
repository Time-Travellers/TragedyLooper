package tragedylooper.view;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

public class Tienda extends JPanel{

	public interface TiendaObserver {
		  //Metodos
	 }
	  
	private Relojes numrelojes;
	private Nivel nivel;
	private TiendaObserver tObserver;  
	
	
 
  
  public Tienda(int r, int n, TiendaObserver to){
  	  JPanel panelmayor=new JPanel();
      panelmayor.setLayout(new BoxLayout(panelmayor, BoxLayout.X_AXIS));
	  this.numrelojes=new Relojes(r);
	  this.nivel=new Nivel(n);
	  panelmayor.add(numrelojes);
	  panelmayor.add(nivel);
	  this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	  this.add(new JLabel("Tienda"));
	  this.add(panelmayor);
  }
  
  public static void main(String args[]){
		JFrame ventana=new JFrame("prueba");
		ventana.setSize(800,600);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setContentPane(new Tienda(10,27,null));
		ventana.setVisible(true);
	}
  
}
