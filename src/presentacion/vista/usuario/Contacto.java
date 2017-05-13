package presentacion.vista.usuario;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Contacto extends JPanel {
	JLabel titulo;
	JButton sugerencias;
	JButton proponerguion;
	
	public Contacto(){
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		this.titulo=new JLabel("Contacto con Administradores");
		this.sugerencias=new JButton("Sugerencias");
		this.proponerguion=new JButton("Proponer Guion");
		this.add(titulo);
		this.add(new JLabel(" "));
		this.add(sugerencias);
		this.add(new JLabel(" "));
		this.add(proponerguion);
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.setSize(300, 300);
	}


	public static void main(String args[]){
		JFrame ventana=new JFrame("prueba");
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setSize(800, 600);
		ventana.setContentPane(new Contacto());
		ventana.setVisible(true);
		ventana.repaint();
	}
	
}
