package presentacion.vista.usuario;

import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Nivel extends JPanel{
	
	private PanelBotInfoIcono panel;
	
	public Nivel(int n, ActionListener list){
		this.panel = new PanelBotInfoIcono(n, "Nivel: ", null, null, list);
		this.add(panel);
	}
	
	public static void main(String args[]){
		JFrame ventana=new JFrame("prueba");
		ventana.setSize(800,600);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setContentPane(new Nivel(10,null));
		ventana.setVisible(true);
	}
}