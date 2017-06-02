package presentacion.vista.usuario.inicious;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelBotInfoIcono extends JPanel {

	private static final long serialVersionUID = -1234269953813842921L;
	private JButton boton;
	private JLabel info;
	private JLabel icono;

	public PanelBotInfoIcono(int n, String nombre, Icon icono2, ActionListener list) {
		boton = new JButton(new ImageIcon(getClass().getClassLoader().getResource("resources/add.png")));
		boton.addActionListener(list);
		info = new JLabel(nombre + n);
		info.setFont(new Font("", 20, 20));
		this.icono = new JLabel(icono2);
		this.add(boton);
		this.add(info);
		this.add(this.icono);
		this.setPreferredSize(new Dimension(200, 150));
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.setBackground(new Color(103, 239, 177));

	}
}
