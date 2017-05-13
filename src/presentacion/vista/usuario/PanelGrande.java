package presentacion.vista.usuario;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Simplemente para reciclar codigo
 * @author jfiwj
 *
 */
public class PanelGrande extends JPanel{
	PanelUtil nombre;
	JButton boton;
	/**
	 * Pongo name en ingles porque ya he usado nombre
	 * @param name
	 * @param n
	 */
	
	public PanelGrande(String name, int n){
		BoxLayout lay=new BoxLayout(this,BoxLayout.Y_AXIS);
		this.setLayout(lay);
		this.nombre=new PanelUtil(name, n);
		this.boton=new JButton("Revisar");
		this.add(nombre);
		this.add(boton);
		this.setSize(500,300);
		this.setPreferredSize(new Dimension(500,300));
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.setBackground(nombre.getBackground());
	}
	
	public void setListener(ActionListener listener){
		this.boton.addActionListener(listener);
	}
	
	public static void main(String args[]){
		JFrame ventana=new JFrame("prueba");
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setSize(800, 600);
		ventana.setContentPane(new PanelGrande("Usuarios Reportados", 6));
		ventana.setVisible(true);
		ventana.repaint();
	}
}
