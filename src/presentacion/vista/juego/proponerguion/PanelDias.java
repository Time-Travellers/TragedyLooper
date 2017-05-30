package presentacion.vista.juego.proponerguion;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import presentacion.modelo.juego.Incidente;
import presentacion.modelo.juego.InfoPersonaje.Personaje;

public class PanelDias extends JPanel implements ReguladorListener{
	//sacar fuera esta cte cuando este definida
	private static final int MAX_DIAS=8;
	private Regulador numdias;
	private JScrollPane deslizador;
	private JPanel contenedor;
	ArrayList<EventosDia> listaDias;
	
	private void inicializarlistaDias(){
		for(int ctrl=0;ctrl<MAX_DIAS;ctrl++){
			listaDias.add(new EventosDia(ctrl));
			listaDias.get(ctrl).setVisible(ctrl-1<numdias.getValor());
		}
	}
	
	public PanelDias(){
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.numdias=new Regulador("Dias", MAX_DIAS);
		this.listaDias=new ArrayList<EventosDia>();
		this.contenedor=new JPanel();
		contenedor.setLayout(new BoxLayout(contenedor,BoxLayout.Y_AXIS));
		this.add(numdias);
		inicializarlistaDias();
		numdias.addObservador(this);
		for(int ctrl=1;ctrl<listaDias.size();ctrl++){
			contenedor.add(listaDias.get(ctrl));
		}
		this.deslizador=new JScrollPane(contenedor);
		this.add(deslizador);
		this.setSize(300, 200);
		this.setPreferredSize(new Dimension(300, 200));
		this.setMaximumSize(new Dimension(300, 200));
		this.setMinimumSize(new Dimension(300, 200));
	}
	@Override
	public void nuevoDia() {
		for(int ctrl=0;ctrl<MAX_DIAS;ctrl++){
			listaDias.get(ctrl).setVisible(ctrl-1<numdias.getValor());
		}
		this.revalidate();
		this.repaint();
	}
	
	public static void main(String args[]){
		JFrame ventana=new JFrame("prueba");
		ventana.setContentPane(new PanelDias());
		ventana.pack();
		ventana.setSize(400, 300);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setVisible(true);
	}

	public ArrayList<Incidente> getIncidentes() {
		ArrayList<Incidente> incidentes = new ArrayList<Incidente>();
		for(int i = 0; i < listaDias.size();++i){
			incidentes.add(listaDias.get(i).getIncidente());
		}
		return incidentes;
	}
	
	public int getNumDias(){
		return numdias.getValor();
	}
	
}
