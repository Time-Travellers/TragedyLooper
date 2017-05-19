package presentacion.vista.usuario;

import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import presentacion.modelo.usuario.Jugador;

public class PerfilUsuario extends JPanel {
	
	private static final long serialVersionUID = 6979329339992124305L;
	
	TablaTOPPartidas tabla;
	BotonesPerfil botones;

	public PerfilUsuario(Jugador jugador){
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		JPanel panelSup = new JPanel();
		JLabel username = new JLabel(jugador.getId());
		JLabel datos = new JLabel(jugador.verDatos());
		
		username.setFont(new Font("", 30, 30));
		datos.setFont(new Font("", 20,20));
		
		panelSup.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		panelSup.add(username);
		panelSup.add(datos); 
		
		this.tabla=new TablaTOPPartidas();
		botones =new BotonesPerfil();
		this.add(panelSup);
		this.add(tabla);
		this.add(botones);
	}

	public static void main(String args[]){
		JFrame ventana=new JFrame("Tragedy Looper");
		ventana.setSize(800,800);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setContentPane(new PerfilUsuario());
		ventana.setVisible(true);
	}
}
