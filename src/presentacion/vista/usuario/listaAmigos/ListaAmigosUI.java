package presentacion.vista.usuario.listaAmigos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import presentacion.modelo.usuario.Jugador;

public class ListaAmigosUI extends JPanel {

	private static final long serialVersionUID = -3261009194733650094L;

	public interface ListaAmigosListener {
		public void borrarPulsado(Jugador jugador);
	}

	private ArrayList<Jugador> amigos;
	private ListaAmigosListener list;

	public ListaAmigosUI(ArrayList<Jugador> amigos) {
		this.amigos = amigos;
		initGUI();
	}

	public void setListaAmigosListener(ListaAmigosListener list) {
		this.list = list;
	}

	private void initGUI() {
		this.setLayout(new BorderLayout());
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		for (Jugador i : amigos) {
			JPanel amigo = new JPanel();
			JLabel nombre = new JLabel(i.getId());
			amigo.add(nombre);
			JButton borrar = new JButton("Borrar");
			borrar.setBackground(new Color(242, 76, 76));
			borrar.addActionListener((e) -> list.borrarPulsado(i));
			amigo.add(borrar);
			panel.add(amigo);
		}
		if (amigos.size() == 0)
			panel.add(new JLabel("Actualmente tienes 0 amigos"));
		this.add(new JScrollPane(panel), BorderLayout.CENTER);
	}

}
