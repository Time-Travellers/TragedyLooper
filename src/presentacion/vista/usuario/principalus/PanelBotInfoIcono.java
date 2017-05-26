package presentacion.vista.usuario.principalus;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class PanelBotInfoIcono extends JPanel{
	private JButton boton;
	private JLabel info;
	private JLabel icono;
	
	public PanelBotInfoIcono(int n, String nombre, Icon icono1, Icon icono2, ActionListener list){
		boton = new JButton(icono1);
		boton.addActionListener(list);
		boton.setIcon(new ImageIcon("src/resources/add.png"));
		info = new JLabel(nombre+n);
		info.setFont(new Font("", 20,20));
		this.icono = new JLabel(icono2);
		this.add(boton);
		this.add(info);
		this.add(this.icono);
		this.setPreferredSize(new Dimension(200,200));
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}
	
	public static void main(String args[]){
		SwingUtilities.invokeLater(() -> {
			JFrame ventana=new JFrame("prueba");
			ventana.setSize(800,600);
			ventana.setContentPane(new PanelBotInfoIcono(2,"a", null, null, null));
			ventana.setVisible(true);
		});
	}
	
}
