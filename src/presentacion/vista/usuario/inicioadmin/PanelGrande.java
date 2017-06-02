package presentacion.vista.usuario.inicioadmin;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * Panel de cada bicho de administrador
 *
 */
public class PanelGrande extends JPanel {

	private static final long serialVersionUID = -1100069362055485490L;

	public PanelGrande(String name, ImageIcon icon, int n, ActionListener a) {

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JPanel info = new PanelUtil(name, icon, n);
		JButton button = new JButton("Revisar");
		button.setMaximumSize(new Dimension(200, 50));
		button.setBackground(new Color(50, 140, 50));
		button.addActionListener(a);
		button.setAlignmentX(CENTER_ALIGNMENT);

		this.setPreferredSize(new Dimension(600, 200));
		this.add(info);
		this.add(Box.createVerticalGlue());
		this.add(button);
		this.setBorder(new EmptyBorder(20, 20, 20, 20));

		this.setBackground(info.getBackground());
	}

}
