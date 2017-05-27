package  presentacion.vista.usuario.principalus;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import presentacion.controlador.principalus.PrinciUsuarioEvent;
import presentacion.controlador.principalus.PrinciUsuarioEvent.PrinciUsuarioType;
import presentacion.controlador.principalus.PrinciUsuarioListener;
import presentacion.modelo.usuario.Jugador;
import presentacion.modelo.usuario.Paises;

public class Tienda extends JPanel{
	  
	private static final long serialVersionUID = -660897330434834732L;
	
	private JLabel tienda;
	private PanelBotInfoIcono relojes;
	private PanelBotInfoIcono nivel;
//	private Relojes numrelojes;
//	private Nivel nivel;
	
 
  
  public Tienda(Jugador jugador, ArrayList<PrinciUsuarioListener> listeners){
	  //tListener = to;
  	  JPanel panelmayor=new JPanel();
      this.setLayout(new BoxLayout(panelmayor, BoxLayout.X_AXIS));

      relojes = new PanelBotInfoIcono(jugador.getReloj(), "Relojes: ", null, (e)->{
				for (int i = 0; i < listeners.size(); ++i)
					listeners.get(i).notificarPrinciUsuario(new PrinciUsuarioEvent(PrinciUsuarioType.comprarRelojes,jugador));
		});
      nivel = new PanelBotInfoIcono(jugador.getNivel(), "Nivel: ", null,(e)->{
				for (int i = 0; i < listeners.size(); ++i)
					listeners.get(i).notificarPrinciUsuario(new PrinciUsuarioEvent(PrinciUsuarioType.comprarNivel,jugador));
		});
//	  this.numrelojes=new Relojes(r, new ActionListener(){
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			tListener.comprarRelojes();
//		}
//	  });
//	  this.nivel=new Nivel(n, new ActionListener(){
//		  @Override
//		  public void actionPerformed(ActionEvent e) {
//				tListener.comprarNivel();
//			}
//	  });
//	  
	  panelmayor.add(relojes);
	  panelmayor.add(nivel);
	  this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	  tienda = new JLabel("Tienda");
	  tienda.setFont(new Font("",Font.BOLD,20));
	  tienda.setAlignmentX(CENTER_ALIGNMENT);
	  this.add(tienda);
	  this.add(Box.createRigidArea(new Dimension(0,10)));
	  this.add(panelmayor);
	  this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
	  this.setPreferredSize(new Dimension(450,200));
  }
  
  public static void main(String args[]){
		JFrame ventana=new JFrame("prueba");
		ventana.setSize(800,600);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setContentPane(new Tienda(new Jugador("blue","asdf", false, "cris", 12, Paises.Alemania, "kk"),null));
		ventana.setVisible(true);
	}
  
}
