package  presentacion.vista.usuario.principalus;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Tienda extends JPanel{
	  
	private Relojes numrelojes;
	private Nivel nivel;
	private TiendaListener tListener;  
	
 
  
  public Tienda(int r, int n, TiendaListener to){
	  tListener = to;
  	  JPanel panelmayor=new JPanel();
      panelmayor.setLayout(new BoxLayout(panelmayor, BoxLayout.X_AXIS));
	  this.numrelojes=new Relojes(r, new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e) {
			tListener.comprarRelojes();
		}
	  });
	  this.nivel=new Nivel(n, new ActionListener(){
		  @Override
		  public void actionPerformed(ActionEvent e) {
				tListener.comprarNivel();
			}
	  });
	  
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
