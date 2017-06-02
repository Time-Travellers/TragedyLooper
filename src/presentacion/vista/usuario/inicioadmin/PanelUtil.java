package presentacion.vista.usuario.inicioadmin;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * Panel que contiene la informacion
 */
public class PanelUtil extends JPanel {

	private static final long serialVersionUID = -1352536952648345486L;

	public PanelUtil(String nombre, ImageIcon icon, int numero) {

		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

		JLabel labelIz = new JLabel(nombre, icon, JLabel.CENTER);
		labelIz.setMaximumSize(new Dimension(200, 50));
		labelIz.setFont(new Font("", 0, 18));
		JLabel labelDr = new JLabel(numero + " pendientes");
		labelDr.setMaximumSize(new Dimension(200, 50));
		labelDr.setFont(new Font("", 0, 20));

		this.add(labelIz);
		this.add(Box.createHorizontalGlue());
		this.add(labelDr);
		this.setMaximumSize(new Dimension(600, 80));
		this.setBorder(new EmptyBorder(0, 10, 0, 10));
		this.setBackground(new Color(150, 200, 150));
	}
}
