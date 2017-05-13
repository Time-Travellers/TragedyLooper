package tragedylooper.view;

import javax.swing.JFrame;
import javax.swing.JPanel;

import tragedylooper.view.Admin.GuionesPropuestosUI;

public class Nivel extends JPanel{
	private PanelBotInfoIcono panel;
	public Nivel(int n){
		this.panel=new PanelBotInfoIcono(n, "Nivel", null, null);
		this.add(panel);
	}
	
	public static void main(String args[]){
		JFrame ventana=new JFrame("prueba");
		ventana.setSize(800,600);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setContentPane(new Nivel(10));
		ventana.setVisible(true);
	}
}
