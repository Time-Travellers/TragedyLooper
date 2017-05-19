package  presentacion.vista.usuario;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
/**
 * Panel con cuatro botones: 
 * Buscar, configuración, ayuda y salir.
 */
public class Botones extends JPanel {

	private static final long serialVersionUID = 1875668843425465875L;
	
	private BotonesListener bListener;
	
	final static String searchIcon = "search.png";
	final static String configIcon = "config.png";
	final static String helpIcon = "help.png";
	final static String exitIcon = "exit.png";
	
	public Botones(BotonesListener bl) {
		this.bListener = bl;
		this.setLayout(new FlowLayout());
		this.setVisible(true);
		initialize();
	}
	
	private void initialize() {
		addButton("", searchIcon, "Buscar usuario",
				(e) -> this.bListener.buscarUsuario());
		addButton("", configIcon, "Ajustes",
				(e) -> this.bListener.ajustes());
		addButton("", helpIcon, "Preguntas habituales",
				(e) -> this.bListener.ayuda());
		addButton("", exitIcon, "Salir de la aplicacion",
				(e) -> this.bListener.salir());
	}
	
	
	private void addButton(String title, String fileName, String toolTipText,
			ActionListener listener) {
		JButton button = new JButton(title);
		button.setIcon(new ImageIcon("src/resources/" + fileName));
		button.setPreferredSize(new Dimension (80,80));
		button.addActionListener(listener);
		button.setVisible(true);
		this.add(button);
	}
	
	//Main para probar el panel de los botones:
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> 
		{
			JFrame testFrame = new JFrame("Probando el panel de botones");
			testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			testFrame.setSize(new Dimension(800, 600));
			testFrame.setVisible(true);
			testFrame.getContentPane().setLayout(new FlowLayout());
			Botones botones = new Botones (new BotonesListener() {

				@Override
				public void buscarUsuario() {
					System.out.println("Has pulsado en BUSCAR");
				}

				@Override
				public void ajustes() {
					System.out.println("Has pulsado en CONFIGURACION");
				}

				@Override
				public void ayuda() {
					System.out.println("Has pulsado en AYUDA");
				}

				@Override
				public void salir() {
					System.out.println("Has pulsado en SALIR");
				}
				
			});
			testFrame.add(botones);
		});
	}

}
