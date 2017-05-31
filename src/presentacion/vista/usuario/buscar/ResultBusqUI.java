package presentacion.vista.usuario.buscar;

import javax.swing.JButton;
import javax.swing.JPanel;

import presentacion.modelo.usuario.Jugador;

public class ResultBusqUI extends JPanel {

	private Jugador jugador;
	private ResultListener list;
	
	public interface ResultListener {
		public void agregarPulsado(Jugador jugador);
		public void reportarPulsado(Jugador jugador);
	}
	
	public ResultBusqUI(Jugador jugador, ResultListener list){
		this.jugador = jugador;
		this.list = list;
		initGUI();
	}
	
	private void initGUI() {
		JButton agregar = new JButton("Agregar");
		agregar.addActionListener((e) -> list.agregarPulsado(jugador));
		add(agregar);
		JButton reportar = new JButton("Reportar");
		reportar.addActionListener((e) -> list.reportarPulsado(jugador));
		add(reportar);
		setVisible(true);
	}
}
