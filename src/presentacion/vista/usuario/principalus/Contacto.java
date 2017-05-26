package presentacion.vista.usuario.principalus;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import presentacion.vista.usuario.proponerguion.SugerenciaGuion;


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
	
	private JFrame getFrame(){
		return (JFrame)this.getRootPane().getParent();
	}
	
	public Contacto(ContactoListener cListener){
		Contacto aux=this;
		this.cl = cListener;
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		this.titulo = new JLabel("Contacto con Administradores:");
		this.sugerencias = new JButton("Sugerencias");
		this.sugerencias.addActionListener((e)-> this.cl.sugerencias());
		this.proponerGuion = new JButton("Proponer Guion");
		this.proponerGuion.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				SugerenciaGuion dialogo=new SugerenciaGuion(aux.getFrame());
			}
		});
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
			public void sugerencias() {
				System.out.println("Pulsado el boton de sugerencias");
			}

			@Override
			public void proponerGuion() {
				System.out.println("Pulsado el boton de proponer guion");
			}
			
		}));
		ventana.setVisible(true);
	}
	
}
