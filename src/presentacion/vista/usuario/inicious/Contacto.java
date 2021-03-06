package presentacion.vista.usuario.inicious;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import presentacion.controlador.iniciousuario.InicioUsuarioEvent;
import presentacion.controlador.iniciousuario.InicioUsuarioListener;
import presentacion.controlador.iniciousuario.InicioUsuarioEvent.PrinciUsuarioType;

/**
 * Clase para el panel de la pantalla principal del usuario de "contacto con
 * administradores".
 *
 */
public class Contacto extends JPanel {

	private static final long serialVersionUID = -7736617416184417895L;

	public Contacto(ArrayList<InicioUsuarioListener> listeners) {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		// titulo del panel
		JLabel titulo = new JLabel("Contacto con Administradores:");
		titulo.setFont(new Font("", Font.BOLD, 20));
		titulo.setAlignmentX(CENTER_ALIGNMENT);

		// boton sugerencias
		JButton sugerencias = new JButton("Sugerencias");
		sugerencias.setBackground(new Color(50, 140, 50));
		sugerencias.setPreferredSize(new Dimension(100, 30));
		sugerencias.setAlignmentX(CENTER_ALIGNMENT);
		sugerencias.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < listeners.size(); ++i)
					listeners.get(i).notificarPrinciUsuario(new InicioUsuarioEvent(PrinciUsuarioType.sugerencias));
			}
		});

		// boton proponerGuion
		JButton proponerGuion = new JButton("Proponer Guion");
		proponerGuion.setBackground(new Color(50, 140, 50));
		proponerGuion.setPreferredSize(new Dimension(100, 30));
		proponerGuion.setAlignmentX(CENTER_ALIGNMENT);
		proponerGuion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < listeners.size(); ++i)
					listeners.get(i).notificarPrinciUsuario(new InicioUsuarioEvent(PrinciUsuarioType.proponerGuion));
			}
		});

		this.add(Box.createRigidArea(new Dimension(0, 10)));
		this.add(titulo);
		this.add(Box.createVerticalGlue());
		this.add(sugerencias);
		this.add(Box.createVerticalGlue());
		this.add(proponerGuion);
		this.add(Box.createRigidArea(new Dimension(0, 10)));
		this.setBackground(new Color(150, 200, 150));
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		this.setPreferredSize(new Dimension(450, 200));
	}
}
