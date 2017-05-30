package presentacion.vista.gameMastering.aceptarguion;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import presentacion.modelo.juego.Incidente;
import presentacion.modelo.juego.Incidente.EnumIncidentes;
import presentacion.modelo.juego.InfoGuion;
import presentacion.modelo.juego.InfoGuion.Subtrama;
import presentacion.modelo.juego.InfoGuion.Trama;
import presentacion.modelo.juego.InfoPersonaje;
import presentacion.modelo.juego.InfoPersonaje.Personaje;
import presentacion.modelo.juego.InfoPersonaje.Rol;
import presentacion.modelo.marketing.Tienda;
import presentacion.modelo.usuario.Jugador;

public class AceptarGuionUI extends JPanel{

	private static final long serialVersionUID = 3891324742744513990L;
	
//	private AceptarGuionListener listener;
//	
//	public interface AceptarGuionListener(){
//		public void Aceptar();
//		public void Rechazar();
//		public void Salir();
//	}
//	
//	public void setAGListener(AceptarGuionListener listener){
//		this.listener = listener;
//	}
	
	public AceptarGuionUI(InfoGuion guion){
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		this.setPreferredSize(new Dimension(800,600));

		
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		  
		JLabel title = new JLabel("Guion propuesto por " + guion.getCreador().getId());
		title.setFont(new Font("",0,30));
		title.setAlignmentX(CENTER_ALIGNMENT);
		title.setMaximumSize(new Dimension(800,100));
		
		JPanel south = new JPanel();
		
		//panel superior para titulo, trama, bucles y subtrama
		PanelSup north = new PanelSup(guion);		
		
		//panel central para las incidencias y los personajes
		PanelCentral center = new PanelCentral(guion);
		
		//panel inferior para los botones
		south.setLayout(new BoxLayout(south,BoxLayout.X_AXIS));
		south.setPreferredSize(new Dimension(800,50));
	//	south.setAlignmentX(CENTER_ALIGNMENT);
		south.setBorder(new EmptyBorder(0,20,0,20));
		
		//combobox para seleccionar dificultad
		ArrayList<Integer> valores = new ArrayList<Integer>();
		for(int i=0;i<Tienda.NIVEL;++i) valores.add(i);
		@SuppressWarnings({ "rawtypes", "unchecked" })
		JComboBox niveles = new JComboBox(valores.toArray());
		niveles.setMaximumSize(new Dimension(100,20));
		
		JLabel nivel = new JLabel("Nivel: ");
		JButton aceptar = new JButton("Aceptar"),
				rechazar = new JButton("Rechazar"),
				cancelar = new JButton("Cancelar");
		
		aceptar.setPreferredSize(new Dimension(100,30));
		rechazar.setPreferredSize(new Dimension(100,30));
		cancelar.setPreferredSize(new Dimension(100,30));
		
		aceptar.setBackground(new Color(150,200,150));
		rechazar.setBackground(new Color(250,70,50));
		cancelar.setBackground(new Color(250,70,50));
//Anadir los listeners!
		
		south.add(nivel);
		south.add(niveles);
		south.add(Box.createRigidArea(new Dimension(50,0)));
		south.add(aceptar);
		south.add(Box.createRigidArea(new Dimension(10,0)));
		south.add(rechazar);
		south.add(Box.createRigidArea(new Dimension(10,0)));
		south.add(cancelar);
		
		this.add(title);
		this.add(Box.createRigidArea(new Dimension(0,10)));
		this.add(north);
		this.add(Box.createVerticalGlue());
		this.add(center);
		this.add(Box.createVerticalGlue());
		this.add(south);

		this.setBorder(new EmptyBorder(20, 20, 20, 20));
	}
	
	public static void main(String args[]){
		JFrame ventana=new JFrame("prueba");
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setLayout(new FlowLayout());
		ventana.setSize(800,600);
		InfoGuion guion = new InfoGuion( new Jugador("Prueba", "Prueba", false, "Prueba", 0, null, "Prueba"),
				"title", Trama.Luz_del_vengador, Subtrama.Amor_prohibido,
				3,5, new ArrayList<InfoPersonaje>(Arrays.asList(new InfoPersonaje(Personaje.Empresario,Rol.Amante))),
						new ArrayList<Incidente>(Arrays.asList( new Incidente(EnumIncidentes.Asesinato, Personaje.Empresario))));
		ventana.setContentPane(new AceptarGuionUI(guion));
		ventana.setVisible(true);
	}

}
