package  presentacion.vista.usuario.inicious;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import presentacion.controlador.iniciousuario.InicioUsuarioEvent;
import presentacion.controlador.iniciousuario.InicioUsuarioListener;
import presentacion.controlador.iniciousuario.InicioUsuarioEvent.PrinciUsuarioType;
/**
 * Panel con tres botones: 
 * "Iniciar nueva partida", "Mi perfil", "Ver ranking".
 */
public class Botones2 extends JPanel {

	private static final long serialVersionUID = -331372996838369812L;
	
	public Botones2(ArrayList<InicioUsuarioListener> listeners) {
		FlowLayout layout = new FlowLayout();
		layout.setHgap(60);
		this.setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
		this.setPreferredSize(new Dimension(800,50));
		this.setVisible(true);
		initialize(listeners);
	}
	
	private void initialize(ArrayList<InicioUsuarioListener> listeners) {
		addButton("Iniciar nueva partida", "Comenzar un nuevo juego",new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < listeners.size(); ++i)
					listeners.get(i).notificarPrinciUsuario(new InicioUsuarioEvent(PrinciUsuarioType.IniciarPartida));
			}
		});

		this.add(Box.createHorizontalGlue());
		addButton("Mi perfil", "Ir al perfil",new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < listeners.size(); ++i)
					listeners.get(i).notificarPrinciUsuario(new InicioUsuarioEvent(PrinciUsuarioType.miPerfil));
			}
		});

		this.add(Box.createHorizontalGlue());
		addButton("Ver ranking", "Ver los mejores jugadores",new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < listeners.size(); ++i)
					listeners.get(i).notificarPrinciUsuario(new InicioUsuarioEvent(PrinciUsuarioType.verRanking));
			}
		});

	}
	
	
	private void addButton(String title, String toolTipText,
			ActionListener listener) {
		JButton button = new JButton(title);
		button.setPreferredSize(new Dimension (150,30));
		button.setBackground(new Color(240, 196, 16));
		button.addActionListener(listener);
		button.setVisible(true);
		this.add(button);
	}

}
