package tragedylooper.view;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class JugadorUI extends JFrame {

	public JugadorUI() {
		super("Tragedy Looper");
		inicializarGUI();
	}
	public void inicializarGUI() {
		this.setSize(800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new JugadorUI());
	}

}
