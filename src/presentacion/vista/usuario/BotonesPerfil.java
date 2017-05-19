package presentacion.vista.usuario;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class BotonesPerfil extends JPanel{

	private static final long serialVersionUID = 1408142039736866807L;


	public BotonesPerfil(){
		FlowLayout layout = new FlowLayout();
		layout.setHgap(60);
		this.setLayout(layout);
		this.setVisible(true);
		initialize();
	}
	
	private void initialize() {
		addButton("Lista de amigos", "Ver lista de amigos",
				null);
		addButton("Cambiar password", "Cambiar la contrase(letra que viene despues de la n)a",
				null);
		addButton("Modificar datos", "Modificar los datos de tu perfil",
				null);
	}
	
	
	private void addButton(String title, String toolTipText,
			ActionListener listener) {
		JButton button = new JButton(title);
		button.setPreferredSize(new Dimension (150,30));
		button.addActionListener(listener);
		button.setVisible(true);
		this.add(button);
	}
}
