package  presentacion.vista.usuario.principalus;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
/**
 * Panel con tres botones: 
 * "Iniciar nueva partida", "Mi perfil", "Ver ranking".
 */
public class Botones2 extends JPanel {

	private static final long serialVersionUID = -331372996838369812L;
	
	private Botones2Listener bListener;
	
	public Botones2(Botones2Listener bl) {
		this.bListener = bl;
		FlowLayout layout = new FlowLayout();
		layout.setHgap(60);
		this.setLayout(layout);
		this.setVisible(true);
		initialize();
	}
	
	private void initialize() {
		addButton("Iniciar nueva partida", "Comenzar un nuevo juego",
				(e) -> this.bListener.iniciarPartida());
		addButton("Mi perfil", "Ir al perfil",
				(e) -> this.bListener.miPerfil());
		addButton("Ver ranking", "Ver los mejores jugadores",
				(e) -> this.bListener.verRanking());
	}
	
	
	private void addButton(String title, String toolTipText,
			ActionListener listener) {
		JButton button = new JButton(title);
		button.setPreferredSize(new Dimension (150,30));
		button.addActionListener(listener);
		button.setVisible(true);
		this.add(button);
	}
	
	//Main para probar este panel de botones:
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> 
		{
			JFrame testFrame = new JFrame("Probando el panel de botones 2");
			testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			testFrame.setSize(new Dimension(800, 600));
			testFrame.setVisible(true);
			testFrame.getContentPane().setLayout(new FlowLayout());
			Botones2 botones = new Botones2 (new Botones2Listener() {

				@Override
				public void iniciarPartida() {
					System.out.println("Solicitado INICIAR NUEVA PARTIDA");
					
				}

				@Override
				public void miPerfil() {
					System.out.println("Solicitado IR AL PERFIL");
					
				}

				@Override
				public void verRanking() {
					System.out.println("Solicitado VER RANKING");
					
				}
				
			});
			testFrame.add(botones);
		});
	}

}
