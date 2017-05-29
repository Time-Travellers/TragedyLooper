package presentacion.vista.marketing.comprarnivel;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Dialog.ModalityType;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import presentacion.modelo.marketing.InfoNivel;
import presentacion.modelo.usuario.Jugador;

public class ComprarNivelUI extends JPanel {
	
	private static final long serialVersionUID = -6931407663483390176L;

	private ComprarNivelUIListener list;
	
	//Interfaz a implementar si se quieren insertar listeners:
	public interface ComprarNivelUIListener {
		void confirmar(); 
		void salir();
	}
	
	public void setNivelListener(ComprarNivelUIListener listener){
		this.list = listener;
	}
	
	public ComprarNivelUI ( InfoNivel nivelSiguiente){
		
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		this.setAlignmentX(CENTER_ALIGNMENT);

		this.setBorder(BorderFactory.createLineBorder(Color.black));
		
		//titulo
		JLabel title = new JLabel("¿Quieres comprar el siguiente nivel por " + nivelSiguiente.getPrecio() + " relojes?");
		title.setFont(new Font("",20,20));
		title.setAlignmentX(CENTER_ALIGNMENT);
		
		//panel para la lista de guiones
		JPanel niveles = new JPanel();
		niveles.setLayout(new BoxLayout(niveles,BoxLayout.Y_AXIS));
		niveles.setBorder(new EmptyBorder(20, 30, 20, 30));
		niveles.setPreferredSize(new Dimension(500,200));
		niveles.setAlignmentX(CENTER_ALIGNMENT);

		//niveles.setBorder(BorderFactory.createLineBorder(Color.black));
		
		JLabel info = new JLabel("Contiene los siguientes guiones:");
		info.setFont(new Font("",15,15));
		info.setAlignmentX(CENTER_ALIGNMENT);
		niveles.add(info);
		niveles.add(Box.createRigidArea(new Dimension(0,30)));		
		
		int rojo = 250,verde = 250, azul =100;
		for(int i=0;i<nivelSiguiente.getGuiones().size();++i){
			JLabel guion = new JLabel(nivelSiguiente.getGuiones().get(i));
			guion.setBackground(new Color(rojo,verde,azul));
			guion.setAlignmentX(CENTER_ALIGNMENT);
			guion.setOpaque(true);
			guion.setBorder(new EmptyBorder(0, 20, 0, 20));
			guion.setMaximumSize(new Dimension(250, 30));
		       
			niveles.add(guion);
			niveles.add(Box.createRigidArea(new Dimension(0,10)));			
			verde -=20;
			azul -= 20;
		}
		
		//panel inferior para los dos botones
		JPanel south = new JPanel();
		south.setLayout(new FlowLayout(FlowLayout.CENTER,20,0));
		
		//boton aceptar
		JButton aceptar = new JButton("Aceptar");
		aceptar.addActionListener((e)-> list.confirmar());
		aceptar.setBackground(new Color(150,200,150));
		
		//boton cancelar
		JButton cancelar = new JButton("Cancelar");
		cancelar.setBackground(new Color(250,70,50));
		cancelar.addActionListener((e)-> list.salir());
		
		south.add(aceptar);
		south.add(cancelar);
		
		this.add(title);
		this.add(Box.createRigidArea(new Dimension(0,10)));
		this.add(niveles);
		this.add(Box.createVerticalGlue());
		this.add(south,BorderLayout.SOUTH);
		
		this.setBorder(new EmptyBorder(20, 20, 20, 20));
		this.setPreferredSize(new Dimension(600, 350));
		this.setVisible(true);
		
		
	}
	
	
	
	public static void main(String[] args){
		InfoNivel nivel = new InfoNivel(3,50,new ArrayList<String>(Arrays.asList("guion1","guion2")));
		ComprarNivelUI ui = new ComprarNivelUI(nivel);
		Jugador jugador = new Jugador("Prueba", "Prueba", false, "Prueba", 0, null, "Prueba");
		JDialog dialog = new JDialog(null, "Prueba", ModalityType.DOCUMENT_MODAL);
		ui.setNivelListener(new ComprarNivelUIListener(){

			@Override
			public void confirmar() {
				if(jugador.comprarNivel(nivel))
					JOptionPane.showConfirmDialog(null, "Compra con exito!","Compra nivel", JOptionPane.PLAIN_MESSAGE, JOptionPane.OK_OPTION);
				else 
					JOptionPane.showConfirmDialog(null, "No tienes suficientes relojes","Compra nivel", JOptionPane.ERROR_MESSAGE, JOptionPane.OK_OPTION);
			}

			@Override
			public void salir() {
				dialog.dispose();
			}
			
		});
		dialog.setSize(700,400);

		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setContentPane(ui);
		dialog.setVisible(true);
		dialog.setAlwaysOnTop(true);
	}
}
