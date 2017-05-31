package presentacion.vista.usuario.buscar;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import presentacion.modelo.usuario.Jugador;

public class ResultBusqUI extends JPanel {

	private static final long serialVersionUID = -7339691583175238212L;

	private ArrayList<Jugador> jugadores;
	private ResultListener list;

	public interface ResultListener {
		public void agregarPulsado(Jugador jugador);
		public void reportarPulsado(Jugador jugador);
	}

	public ResultBusqUI(ArrayList<Jugador> jugadores, ResultListener list) {
		this.jugadores = jugadores;
		this.list = list;
		initGUI();
	}

	private void initGUI() {
		this.setLayout(new BorderLayout());
		JLabel aux = new JLabel("Resultados de la búsqueda: ");
		this.add(aux, BorderLayout.NORTH);
		JPanel res = new JPanel();
		res.setLayout(new BoxLayout(res, BoxLayout.Y_AXIS));
		res.add(Box.createRigidArea(new Dimension(10, 10)));
		for (Jugador j : jugadores) {
			JPanel jug = new JPanel();
			JLabel nombre = new JLabel(j.getId());
			jug.add(nombre);
			JButton agregar = new JButton("Agregar");
			agregar.addActionListener((e) -> list.agregarPulsado(j));
			jug.add(agregar);
			JButton reportar = new JButton("Reportar");
			reportar.addActionListener((e) -> list.reportarPulsado(j));
			jug.add(reportar);
			jug.setVisible(true);
			res.add(jug);
		}
		if(jugadores.size() == 0)
			res.add(new JLabel("Sin resultados"));
		this.add(new JScrollPane(res), BorderLayout.CENTER);
		this.setVisible(true);
	}
}
