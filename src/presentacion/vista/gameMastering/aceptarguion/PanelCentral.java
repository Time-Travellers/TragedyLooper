package presentacion.vista.gameMastering.aceptarguion;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import presentacion.modelo.juego.Incidente;
import presentacion.modelo.juego.InfoPersonaje;
import presentacion.modelo.juego.Incidente.EnumIncidentes;
import presentacion.modelo.juego.InfoGuion;

public class PanelCentral extends JPanel {
	private static final long serialVersionUID = 5077521269328789003L;

	public PanelCentral(InfoGuion guion) {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setPreferredSize(new Dimension(800, 300)); // es lo que vale
		this.setAlignmentX(CENTER_ALIGNMENT);
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		JPanel dias = new JPanel(), personajes = new JPanel();
		JLabel dia = new JLabel("Dias: " + guion.getNumDias()), personaje = new JLabel("Personajes:");
	
		// gridlayout para los labels
		JPanel thisTitle = new JPanel(new GridLayout(0, 2));
		thisTitle.setPreferredSize(new Dimension(800, 40));
		thisTitle.add(dia);
		thisTitle.add(personaje);

		// crear panel de dias
		dias.setLayout(new BoxLayout(dias, BoxLayout.Y_AXIS));
		dias.setMaximumSize(new Dimension(300, 100));
		dias.setBorder(new EmptyBorder(10,10,10,10));
		for (int i = 0; i < guion.getIncidentes().size(); ++i) {
			Incidente inc = guion.getIncidentes().get(i);
			JLabel d = new JLabel("Dia " + (i + 1) + ": " + inc.getIncidente().toString());
			dias.add(d);
			// hay programado un incidente
			if (!inc.getIncidente().equals(EnumIncidentes.No_Incidentes)) {
				JLabel c = new JLabel("	Culpable: " + inc.getCulpable().toString());
				dias.add(c);
			}
		}

		// crear panel de personajes
		personajes.setLayout(new BoxLayout(personajes, BoxLayout.Y_AXIS));
		personajes.setMaximumSize(new Dimension(300, 100));
		personajes.setBorder(new EmptyBorder(10,10,10,10));
		for (int i = 0; i < guion.getInfoPersonajes().size(); ++i) {
			InfoPersonaje pers = guion.getInfoPersonajes().get(i);
			JLabel p = new JLabel(
					"P" + (i + 1) + ": " + pers.getNombre().toString() + "   " + pers.getRol().toString());
			personajes.add(p);
		}
		
		// meter en scrollpane
		JScrollPane scrollDias = new JScrollPane(dias), scrollPers = new JScrollPane(personajes);
		// gridlayout para los scrollpanes
		JPanel thisBody = new JPanel(new GridLayout(0, 2));
		thisBody.setPreferredSize(new Dimension(800, 300));
		thisBody.add(scrollDias);
		thisBody.add(scrollPers);

		this.add(thisTitle);
		this.add(thisBody);
	}

}
