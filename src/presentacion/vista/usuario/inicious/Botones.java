package  presentacion.vista.usuario.inicious;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import presentacion.controlador.principalus.PrinciUsuarioEvent;
import presentacion.controlador.principalus.PrinciUsuarioListener;
import presentacion.controlador.principalus.PrinciUsuarioEvent.PrinciUsuarioType;
/**
 * Panel con cuatro botones: 
 * Buscar, configuracion, ayuda y salir.
 */
public class Botones extends JPanel {

	private static final long serialVersionUID = 1875668843425465875L;
	
	final static String searchIcon = "search.png";
	final static String configIcon = "setting.png";
	final static String helpIcon = "help.png";
	final static String exitIcon = "exit.png";
	
	public Botones(ArrayList<PrinciUsuarioListener> listeners) {
		this.setLayout(new FlowLayout(FlowLayout.RIGHT));
		this.setVisible(true);

		initialize(listeners);
	}
	
	private void initialize(ArrayList<PrinciUsuarioListener> listeners) {
		addButton("", searchIcon, "Buscar usuario",
			new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < listeners.size(); ++i)
					listeners.get(i).notificarPrinciUsuario(new PrinciUsuarioEvent(PrinciUsuarioType.BuscarUsuario));
			}
		});
		addButton("", configIcon, "Ajustes",new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < listeners.size(); ++i)
					listeners.get(i).notificarPrinciUsuario(new PrinciUsuarioEvent(PrinciUsuarioType.Ajustes));
			}
		});
		addButton("", helpIcon, "Preguntas habituales",new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < listeners.size(); ++i)
					listeners.get(i).notificarPrinciUsuario(new PrinciUsuarioEvent(PrinciUsuarioType.Ayuda));
			}
		});
		addButton("", exitIcon, "Salir de la aplicacion",new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < listeners.size(); ++i)
					listeners.get(i).notificarPrinciUsuario(new PrinciUsuarioEvent(PrinciUsuarioType.Salir));
			}
		});
	}
	
	
	private void addButton(String title, String fileName, String toolTipText,
			ActionListener listener) {
		JButton button = new JButton(title);
		button.setIcon( new ImageIcon(getClass().getClassLoader().getResource("resources/"+fileName)));
		button.setPreferredSize(new Dimension (60,60));
		button.addActionListener(listener);
		button.setVisible(true);
		this.add(button);
	}
}
