package  presentacion.vista.usuario.inicious;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import presentacion.controlador.principalus.PrinciUsuarioEvent;
import presentacion.controlador.principalus.PrinciUsuarioListener;
import presentacion.controlador.principalus.PrinciUsuarioEvent.PrinciUsuarioType;
/**
 * Panel con tres botones: 
 * "Iniciar nueva partida", "Mi perfil", "Ver ranking".
 */
public class Botones2 extends JPanel {

	private static final long serialVersionUID = -331372996838369812L;
	
	public Botones2(ArrayList<PrinciUsuarioListener> listeners) {
		FlowLayout layout = new FlowLayout();
		layout.setHgap(60);
		this.setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
		this.setPreferredSize(new Dimension(800,50));
		this.setVisible(true);
		initialize(listeners);
	}
	
	private void initialize(ArrayList<PrinciUsuarioListener> listeners) {
		addButton("Iniciar nueva partida", "Comenzar un nuevo juego",new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < listeners.size(); ++i)
					listeners.get(i).notificarPrinciUsuario(new PrinciUsuarioEvent(PrinciUsuarioType.IniciarPartida));
			}
		});

		this.add(Box.createHorizontalGlue());
		addButton("Mi perfil", "Ir al perfil",new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < listeners.size(); ++i)
					listeners.get(i).notificarPrinciUsuario(new PrinciUsuarioEvent(PrinciUsuarioType.miPerfil));
			}
		});

		this.add(Box.createHorizontalGlue());
		addButton("Ver ranking", "Ver los mejores jugadores",new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < listeners.size(); ++i)
					listeners.get(i).notificarPrinciUsuario(new PrinciUsuarioEvent(PrinciUsuarioType.verRanking));
			}
		});

	}
	
	
	private void addButton(String title, String toolTipText,
			ActionListener listener) {
		JButton button = new JButton(title);
		button.setPreferredSize(new Dimension (150,30));
		button.addActionListener(listener);
		button.setVisible(true);
		this.add(button);
	}

}
