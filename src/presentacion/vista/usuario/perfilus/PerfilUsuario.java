package presentacion.vista.usuario.perfilus;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import presentacion.controlador.perfil.PerfilEvent;
import presentacion.controlador.perfil.PerfilEvent.PerfilType;
import presentacion.controlador.perfil.PerfilListenable;
import presentacion.controlador.perfil.PerfilListener;
import presentacion.modelo.usuario.Jugador;
import presentacion.vista.usuario.perfilus.BotonesPerfil.PerfilBotonesListener;

public class PerfilUsuario extends JPanel implements PerfilListenable {

	private static final long serialVersionUID = 6979329339992124305L;

	TablaTOPPartidas tabla;
	BotonesPerfil botones;
	ArrayList<PerfilListener> list;

	public PerfilUsuario(Jugador jugador) {
		this.list = new ArrayList<PerfilListener>();
		
		JPanel todo = new JPanel();
		
		todo.setLayout(new BoxLayout(todo, BoxLayout.Y_AXIS));
		todo.setAlignmentX(CENTER_ALIGNMENT);

		todo.setBorder(BorderFactory.createLineBorder(Color.black));

		// panel superior para la informacion del usuario
		JPanel panelSup = new JPanel();
		panelSup.setLayout(new BoxLayout(panelSup, BoxLayout.X_AXIS));

		JLabel photo = new JLabel();
		photo.setIcon(new ImageIcon(getClass().getResource("/resources/spy.png")));

		JPanel info = new JPanel();
		info.setLayout(new BoxLayout(info, BoxLayout.Y_AXIS));

		JLabel username = new JLabel(jugador.getId());
		username.setFont(new Font("", 30, 30));
		username.setPreferredSize(new Dimension(800, 50));

		JTextArea datos = new JTextArea(jugador.verDatos());
		datos.setBorder(BorderFactory.createLineBorder(Color.black));
		datos.setOpaque(false);
		datos.setPreferredSize(new Dimension(800, 100));
		datos.setFont(new Font("", 20, 20));
		datos.setEditable(false);

		info.add(username);
		info.add(datos);

		JButton atras = new JButton();
		atras.setIcon(new ImageIcon(getClass().getResource("/resources/exit.png")));
		atras.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				notificarListeners(new PerfilEvent(PerfilType.Salir));
			}

		});

		panelSup.add(photo);
		panelSup.add(info);
		panelSup.setAlignmentY(CENTER_ALIGNMENT);
		panelSup.setPreferredSize(new Dimension(800, 100));
		panelSup.setBorder(BorderFactory.createLineBorder(Color.black));
		panelSup.add(Box.createRigidArea(new Dimension(5, 0)));
		panelSup.add(atras);
		panelSup.add(Box.createRigidArea(new Dimension(5, 0)));

		// tabla de las partidas mejores
		this.tabla = new TablaTOPPartidas();

		tabla.setAlignmentY(CENTER_ALIGNMENT);

		// botones de la parte inferior
		botones = new BotonesPerfil(new PerfilBotonesListener() {

			@Override
			public void cambiarPass() {
				notificarListeners(new PerfilEvent(PerfilType.CambiarPass));
			}

			@Override
			public void modifDatos() {
				notificarListeners(new PerfilEvent(PerfilType.CambiarDatos));
			}

			@Override
			public void listaAmigos() {
				notificarListeners(new PerfilEvent(PerfilType.ListaAmigos));
			}

		});

		botones.setAlignmentY(CENTER_ALIGNMENT);

		todo.add(panelSup);
		todo.add(tabla);
		todo.add(botones);
		todo.setPreferredSize(new Dimension(800, 800));
		
		JPanel scroller = new JPanel();
		scroller.setLayout(new BorderLayout());
		scroller.add(new JScrollPane(todo));
		this.setLayout(new BorderLayout());
		this.add(scroller);
		this.setVisible(true);
	}

	@Override
	public void addPerfilListener(PerfilListener listener) {
		list.add(listener);
	}

	public void notificarListeners(PerfilEvent e) {
		for (PerfilListener l : list) {
			l.notificarPerfilListener(e);
		}
	}
}