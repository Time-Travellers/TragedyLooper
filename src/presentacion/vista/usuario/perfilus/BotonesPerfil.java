package presentacion.vista.usuario.perfilus;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class BotonesPerfil extends JPanel{

	private static final long serialVersionUID = 1408142039736866807L;
	
	public interface PerfilBotonesListener{
		public void cambiarPass();
		public void modifDatos();
		public void listaAmigos();
	}

	public BotonesPerfil(PerfilBotonesListener list){
		FlowLayout layout = new FlowLayout();
		layout.setHgap(60);
		this.setLayout(layout);
		this.setVisible(true);
		initialize(list);
	}
	
	private void initialize(PerfilBotonesListener list) {
		addButton("Lista de amigos", "Ver lista de amigos",
				(e) -> list.listaAmigos());
		addButton("Cambiar password", "Cambiar la contraseña",
				(e) -> list.cambiarPass());
		addButton("Modificar datos", "Modificar los datos de tu perfil",
				(e) -> list.modifDatos());
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
