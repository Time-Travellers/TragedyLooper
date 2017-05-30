package presentacion.vista.gameMastering.aceptarguion;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import presentacion.modelo.juego.InfoGuion;

public class PanelSup extends JPanel{
	
	private static final long serialVersionUID = 7991354347470055176L;

	public PanelSup(InfoGuion guion){
		this.setLayout(new GridLayout(2,2));
		this.setPreferredSize(new Dimension(800,50));	//es lo que vale
		this.setAlignmentX(CENTER_ALIGNMENT);
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		JLabel titulo = new JLabel("Titulo: " + guion.getTitulo()),
				trama = new JLabel("Trama: " + guion.getTrama().toString()),
				subtrama = new JLabel("Subtrama: " + guion.getSubtrama().toString()),
				bucles = new JLabel("Bucles: " + guion.getNumLoops());
		
		this.add(titulo);
		this.add(bucles);
		this.add(trama);
		this.add(subtrama);
	}

}
