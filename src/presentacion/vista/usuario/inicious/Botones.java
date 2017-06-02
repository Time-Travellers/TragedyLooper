package presentacion.vista.usuario.inicious;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import presentacion.controlador.iniciousuario.InicioUsuarioEvent;
import presentacion.controlador.iniciousuario.InicioUsuarioListener;
import presentacion.controlador.iniciousuario.InicioUsuarioEvent.PrinciUsuarioType;

/**
 * Panel con cuatro botones: Buscar, configuracion, ayuda y salir.
 */
public class Botones extends JPanel {

	private static final long serialVersionUID = 1875668843425465875L;

	final static String searchIcon = "search.png";
	final static String configIcon = "setting.png";
	final static String helpIcon = "help.png";
	final static String exitIcon = "exit.png";

	public Botones(ArrayList<InicioUsuarioListener> listeners) {
		this.setLayout(new FlowLayout(FlowLayout.RIGHT));
		this.setVisible(true);

		initialize(listeners);
	}

	private void initialize(ArrayList<InicioUsuarioListener> listeners) {
		addButton("", searchIcon, "Buscar usuario", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < listeners.size(); ++i)
					listeners.get(i).notificarPrinciUsuario(new InicioUsuarioEvent(PrinciUsuarioType.BuscarUsuario));
			}
		});
		addButton("", configIcon, "Ajustes", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < listeners.size(); ++i)
					listeners.get(i).notificarPrinciUsuario(new InicioUsuarioEvent(PrinciUsuarioType.Ajustes));
			}
		});
		addButton("", helpIcon, "Preguntas habituales", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < listeners.size(); ++i)
					listeners.get(i).notificarPrinciUsuario(new InicioUsuarioEvent(PrinciUsuarioType.Ayuda));
			}
		});
		addButton("", exitIcon, "Salir de la aplicacion", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < listeners.size(); ++i)
					listeners.get(i).notificarPrinciUsuario(new InicioUsuarioEvent(PrinciUsuarioType.Salir));
			}
		});
	}

	private void addButton(String title, String fileName, String toolTipText, ActionListener listener) {
		JButton button = new JButton(title);
		button.setIcon(new ImageIcon(getClass().getClassLoader().getResource("resources/" + fileName)));
		button.setPreferredSize(new Dimension(60, 60));
		button.addActionListener(listener);
		button.setVisible(true);
		this.add(button);
	}
}
