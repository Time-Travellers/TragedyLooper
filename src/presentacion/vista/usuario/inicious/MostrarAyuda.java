package presentacion.vista.usuario.inicious;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MostrarAyuda {
	public static void mostrarAyuda() {
		JOptionPane.showMessageDialog(new JFrame(),
				"Esta es una version para ordenador del juego de mesa\n"
						+ " Tragedy Looper. En el, tres jugadores (llamados Protagonistas)\n"
						+ " se enfrentan contra un cerebro (el MasterMind) para evitar que tenga lugar\n"
						+ " la tragedia. Los Protagonistas deben evitar que el MasterMind logre alcanzar\n"
						+ " las condiciones de victoria determinadas por el guion que se esta jugando y \n"
						+ "que estan relacionadas con los personajes que se encuentran en el tablero.",
				"Ayuda", JOptionPane.PLAIN_MESSAGE);
	}
}
