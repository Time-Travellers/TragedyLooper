package presentacion.vista.usuario;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 * Clase para el panel de la pantalla principal
 * del usuario de "contacto con administradores".
 *
 */
public class Contacto extends JPanel {
	
	JLabel titulo;
	JButton sugerencias;
	JButton proponerGuion;
	ContactoListener cl;
	
	public interface ContactoListener {
		void sugerenciasPulsado();
		void proponerGuionPulsado();
	}
	
	public Contacto(ContactoListener cListener){
		this.cl = cListener;
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		this.titulo = new JLabel("Contacto con Administradores:");
		this.sugerencias = new JButton("Sugerencias");
		this.sugerencias.addActionListener((e)-> this.cl.sugerenciasPulsado());
		this.proponerGuion = new JButton("Proponer Guion");
		this.proponerGuion.addActionListener((e)->this.cl.proponerGuionPulsado());
		this.add(titulo);
		this.add(new JLabel(" "));
		this.add(sugerencias);
		this.add(new JLabel(" "));
		this.add(proponerGuion);
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		this.setPreferredSize(new Dimension(200,150));
	}

	public static void main(String args[]){
		JFrame ventana = new JFrame("Prueba panel contacto admin");
		ventana.setLayout(new FlowLayout());
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setSize(800, 600);
		ventana.add(new Contacto(new ContactoListener() {

			@Override
			public void sugerenciasPulsado() {
				System.out.println("Pulsado el boton de sugerencias");
			}

			@Override
			public void proponerGuionPulsado() {
				System.out.println("Pulsado el boton de proponer guion");
			}
			
		}));
		ventana.setVisible(true);
	}
	
}
