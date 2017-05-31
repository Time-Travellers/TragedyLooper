package presentacion.vista.usuario.inicious;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import presentacion.controlador.principalus.PrinciUsuarioEvent;
import presentacion.controlador.principalus.PrinciUsuarioListener;
import presentacion.controlador.principalus.PrinciUsuarioEvent.PrinciUsuarioType;


/**
 * Clase para el panel de la pantalla principal
 * del usuario de "contacto con administradores".
 *
 */
public class Contacto extends JPanel {
	
	private static final long serialVersionUID = -7736617416184417895L;
	
	public Contacto(ArrayList<PrinciUsuarioListener> listeners){
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
		//titulo del panel
		JLabel titulo = new JLabel("Contacto con Administradores:");
		titulo.setFont(new Font("",Font.BOLD,20));
		titulo.setAlignmentX(CENTER_ALIGNMENT);
		
		//boton sugerencias
		JButton sugerencias = new JButton("Sugerencias");
		sugerencias.setPreferredSize(new Dimension(100, 30));
		sugerencias.setAlignmentX(CENTER_ALIGNMENT);
		sugerencias.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < listeners.size(); ++i)
					listeners.get(i).notificarPrinciUsuario(new PrinciUsuarioEvent(PrinciUsuarioType.sugerencias));
			}
		});
		
		//boton proponerGuion
		JButton proponerGuion = new JButton("Proponer Guion");
		proponerGuion.setPreferredSize(new Dimension(100, 30));
		proponerGuion.setAlignmentX(CENTER_ALIGNMENT);
		proponerGuion.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < listeners.size(); ++i)
					listeners.get(i).notificarPrinciUsuario(new PrinciUsuarioEvent(PrinciUsuarioType.proponerGuion));
			}
		});
		
		this.add(Box.createRigidArea(new Dimension(0,10)));
		this.add(titulo);
		this.add(Box.createVerticalGlue());
		this.add(sugerencias);
		this.add(Box.createVerticalGlue());
		this.add(proponerGuion);
		this.add(Box.createRigidArea(new Dimension(0,10)));
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		this.setPreferredSize(new Dimension(450,200));
	}

	public static void main(String args[]){
		JFrame ventana = new JFrame("Prueba panel contacto admin");
		ventana.setLayout(new FlowLayout());
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setSize(800, 600);
		ventana.add(new Contacto(null));
		ventana.setVisible(true);
	}
	
}
