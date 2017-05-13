package presentacion.vista.usuario;

import javax.swing.JFrame;
import javax.swing.JPanel;

import presentacion.vista.usuario.GuionesPropuestosUI;

public class Relojes extends JPanel{
	private PanelBotInfoIcono panel;
	public Relojes(int n){
		this.panel=new PanelBotInfoIcono(n, "", null, null);
		this.add(panel);
	}
	
	public static void main(String args[]){
		JFrame ventana=new JFrame("prueba");
		ventana.setSize(800,600);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setContentPane(new Relojes(10));
		ventana.setVisible(true);
	}
}
