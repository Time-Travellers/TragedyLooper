package tragedylooper.view;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PrincipalUsuarioUI extends JPanel {
	
	Botones botonera1;
	Botones2 botonera2;
	Tienda paneltienda;
	TablaPartidas tabla;
	Contacto panelcontacto;
	
	public PrincipalUsuarioUI(int r, int n){
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		this.botonera1=new Botones(null);
		this.botonera2=new Botones2(null);
		this.paneltienda=new Tienda(r, n, null);
		this.tabla=new TablaPartidas();
		this.panelcontacto=new Contacto();
		this.add(botonera1);
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
		JFrame ventana=new JFrame("prueba");
		ventana.setSize(800,800);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setContentPane(new PrincipalUsuarioUI(10,27));
		ventana.setVisible(true);
	}
  
	
}
