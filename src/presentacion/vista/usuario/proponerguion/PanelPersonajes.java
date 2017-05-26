package presentacion.vista.usuario.proponerguion;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import presentacion.modelo.juego.InfoPersonaje;
import presentacion.modelo.juego.InfoPersonaje.Personaje;

public class PanelPersonajes extends JPanel implements ReguladorListener{

	private static final int MAX_PERSONAJES=20;
	private Regulador numpersonajes;
	private JScrollPane deslizador;
	private JPanel contenedor;
	ArrayList<DescripcionPersonaje>listaDescripciones;
	


	@Override
	public void nuevoDia() {
		for(int ctrl=0;ctrl<MAX_PERSONAJES;ctrl++){
			listaDescripciones.get(ctrl).setVisible(ctrl<numpersonajes.getValor());
		}
		this.revalidate();
		this.repaint();
	}
	private void inicializarlistaDescripciones(){
		for(int ctrl=0;ctrl<MAX_PERSONAJES;ctrl++){
			listaDescripciones.add(new DescripcionPersonaje(ctrl+1, Personaje.values(), Rol.values()));
			listaDescripciones.get(ctrl).setVisible(ctrl<numpersonajes.getValor());
		}
	}
	
	public PanelPersonajes(){
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.numpersonajes=new Regulador("Personajes", MAX_PERSONAJES);
		this.listaDescripciones=new ArrayList();
		this.contenedor=new JPanel();
		contenedor.setLayout(new BoxLayout(contenedor,BoxLayout.Y_AXIS));
		this.add(numpersonajes);
		inicializarlistaDescripciones();
		numpersonajes.addObservador(this);
		for(int ctrl=0;ctrl<listaDescripciones.size();ctrl++){
			contenedor.add(listaDescripciones.get(ctrl));
		}
		this.deslizador=new JScrollPane(contenedor);
		deslizador.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		this.add(deslizador);
		this.setSize(300, 200);
		this.setPreferredSize(new Dimension(300, 200));
		this.setMaximumSize(new Dimension(300, 200));
		this.setMinimumSize(new Dimension(300, 200));
	}
	
	public static void main(String args[]){
		JFrame ventana=new JFrame("prueba");
		ventana.setContentPane(new PanelPersonajes());
		ventana.pack();
		ventana.setSize(400, 300);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setVisible(true);
	}
	
	
	public ArrayList<InfoPersonaje> getInfoPersonajes() {
		ArrayList<InfoPersonaje> list = new ArrayList<InfoPersonaje>();
		for(int i = 0;i < this.listaDescripciones.size();++i){
			list.add(listaDescripciones.get(i).personaje);
		}
		return list;
	}


}
