package presentacion.vista.gameMastering;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import presentacion.modelo.juego.Incidente;
import presentacion.modelo.juego.Incidente.EnumIncidentes;
import presentacion.modelo.juego.InfoGuion;
import presentacion.modelo.juego.InfoGuion.Subtrama;
import presentacion.modelo.juego.InfoGuion.Trama;
import presentacion.modelo.juego.InfoPersonaje;
import presentacion.modelo.juego.InfoPersonaje.Personaje;
import presentacion.modelo.juego.InfoPersonaje.Rol;
import presentacion.vista.usuario.inicioadmin.InicioAdminUI;

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
	
	public AceptarGuionUI(InfoGuion guion, String nombre){
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		this.setPreferredSize(new Dimension(800,600));
		
		JLabel title = new JLabel("Guion propuesto por " + nombre);
		title.setFont(new Font("",0,20));
		
		JPanel north = new JPanel(), center = new JPanel(), south = new JPanel();
		
		//panel superior para titulo, trama, bucles y subtrama
		north.setLayout(new GridLayout(2,2));
		north.setPreferredSize(new Dimension(800,100));
		JLabel titulo = new JLabel("Titulo: " + guion.getTitulo()),
				trama = new JLabel("Trama: " + guion.getTrama().toString()),
				subtrama = new JLabel("Subtrama: " + guion.getSubtrama().toString()),
				bucles = new JLabel("Bucles: " + guion.getNumLoops());
		
		north.add(titulo);
		north.add(bucles);
		north.add(trama);
		north.add(subtrama);
		
		//panel central para las incidencias y los personajes
		center.setLayout(new GridLayout(2,2));
		center.setPreferredSize(new Dimension(800,400));
		JPanel dias = new JPanel(),personajes = new JPanel();
		JLabel dia = new JLabel("Dias: " + guion.getNumDias()),
				personaje = new JLabel("Personajes:");
		
		//crear panel de dias
		dias.setLayout(new BoxLayout(dias,BoxLayout.Y_AXIS));
		dias.setPreferredSize(new Dimension(300,100));
		for(int i=0;i<guion.getIncidentes().size();++i){
			Incidente inc=guion.getIncidentes().get(i);
			JLabel d = new JLabel("Dia " + (i+1) + ": " + inc.getIncidente().toString());
			dias.add(d);
			//hay programado un incidente
			if(!inc.getIncidente().equals(EnumIncidentes.No_Incidentes)){
				JLabel c = new JLabel("	Culpable: " + inc.getCulpable().toString());
				dias.add(c);
			}
		}
		
		//crear panel de personajes
		personajes.setLayout(new BoxLayout(personajes,BoxLayout.Y_AXIS));
		personajes.setPreferredSize(new Dimension(300,100));
		for(int i=0;i<guion.getInfoPersonajes().size();++i){
			InfoPersonaje pers =guion.getInfoPersonajes().get(i);
			JLabel p = new JLabel("P" + (i+1) + ": " + pers.getNombre().toString() + "   " + pers.getRol().toString());
			personajes.add(p);
		}
		//meter en scrollpane
		JScrollPane scrollDias = new JScrollPane(dias), 
				scrollPers = new JScrollPane(personajes);
		
		center.add(dia);
		center.add(personaje);
		center.add(scrollDias);
		center.add(scrollPers);
		
		//panel inferior para los botones
		
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
		ventana.setSize(800,600);
		InfoGuion guion = new InfoGuion("title", Trama.Luz_del_vengador, Subtrama.Amor_prohibido,
				3,5, new ArrayList<InfoPersonaje>(Arrays.asList(new InfoPersonaje(Personaje.empresario,Rol.amante))),
						new ArrayList<Incidente>(Arrays.asList( new Incidente(EnumIncidentes.Asesinato, Personaje.empresario))));
		ventana.setContentPane(new AceptarGuionUI(guion, "Pepe"));
		ventana.setVisible(true);
	}

}
