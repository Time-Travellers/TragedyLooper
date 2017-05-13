package tragedylooper.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelBotInfoIcono extends JPanel{
	private JButton boton;
	private JLabel info;
	private JLabel icono;
	
	public PanelBotInfoIcono(int n, String nombre, Icon icono1, Icon icono2){
		boton=new JButton(icono1);
		info=new JLabel(nombre+n);
		this.icono=new JLabel(icono2);
		this.add(boton);
		this.add(info);
		this.add(this.icono);
		this.setSize(500,100);
		this.setPreferredSize(new Dimension(200,100));
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}
	
	public static void main(String args[]){
		JFrame ventana=new JFrame("prueba");
		ventana.setSize(800,600);
		ventana.setContentPane(new PanelBotInfoIcono(2,"a", null, null));
		ventana.setVisible(true);
	}
	
}
