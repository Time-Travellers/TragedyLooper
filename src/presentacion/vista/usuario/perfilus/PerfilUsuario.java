package presentacion.vista.usuario.perfilus;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import presentacion.modelo.usuario.Jugador;
import presentacion.modelo.usuario.Paises;

public class PerfilUsuario extends JPanel {
	
	private static final long serialVersionUID = 6979329339992124305L;
	
	TablaTOPPartidas tabla;
	BotonesPerfil botones;

	public PerfilUsuario(Jugador jugador){
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		JPanel panelSup = new JPanel();
		JLabel username = new JLabel(jugador.getId());
		username.setBorder(BorderFactory.createLineBorder(Color.black));
		JLabel datos = new JLabel(jugador.verDatos());
		datos.setBorder(BorderFactory.createLineBorder(Color.black));
		datos.setSize(800, 200);
		username.setFont(new Font("", 30, 30));
		datos.setFont(new Font("", 20,20));
		
		panelSup.add(username);
		panelSup.add(datos); 
	//	panelSup.setBounds(0, 0, 800, 300);
		panelSup.setAlignmentY(Component.LEFT_ALIGNMENT);
		panelSup.setMaximumSize(new Dimension(800, 800));
		panelSup.setBorder(BorderFactory.createLineBorder(Color.black));
		this.tabla=new TablaTOPPartidas();
		botones =new BotonesPerfil();
		this.add(panelSup);
		this.add(tabla);
		this.add(botones);
		this.setAlignmentY(Component.LEFT_ALIGNMENT);
	}

	public static void main(String args[]){
		JFrame ventana=new JFrame("Tragedy Looper");
		ventana.setSize(800,800);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setContentPane(new PerfilUsuario(new Jugador("blue","asdf", false, "cris", 12, Paises.Alemania, "kk")));
		ventana.setVisible(true);
	}
}
