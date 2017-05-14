package presentacion.vista.usuario;

import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class PrincipalUsuarioUI extends JPanel {
	
	Botones botonera1;
	Botones2 botonera2;
	Tienda paneltienda;
	TablaPartidas tabla;
	Contacto panelcontacto;
	
	public PrincipalUsuarioUI(int r, int n){
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		JPanel panelSup = new JPanel();
		JLabel username = new JLabel("Nombre Usuario");
		username.setFont(new Font("", 30, 30));
		panelSup.add(username);
		this.botonera1 = new Botones(null);
		panelSup.add(this.botonera1);
		this.botonera2=new Botones2(null);
		this.paneltienda=new Tienda(r, n, null);
		this.tabla=new TablaPartidas();
		this.panelcontacto=new Contacto(null);
		this.add(panelSup);
		this.add(new JLabel(" "));
		this.add(tabla);
		this.add(new JLabel(" "));
		this.add(botonera2);
		this.add(new JLabel(" "));
		JPanel paneldeabajo=new JPanel();
		paneldeabajo.add(paneltienda);
		paneldeabajo.add(panelcontacto);
		this.add(paneldeabajo);
	}
	
	public static void main(String args[]){
		JFrame ventana=new JFrame("Tragedy Looper");
		ventana.setSize(800,800);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setContentPane(new PrincipalUsuarioUI(10,27));
		ventana.setVisible(true);
	}
}
