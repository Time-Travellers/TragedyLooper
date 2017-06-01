package presentacion.vista.juego.proponerGuion;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import presentacion.modelo.juego.Incidente;

public class PanelDias extends JPanel implements ReguladorListener{
	
	private static final long serialVersionUID = 7852788062256253992L;
	private static final int MAX_DIAS=8;
	private Regulador numdias;
	private JScrollPane deslizador;
	private JPanel contenedor;
	ArrayList<EventosDia> listaDias;
	
	private void inicializarlistaDias(){
		for(int ctrl=0;ctrl<MAX_DIAS;ctrl++){
			listaDias.add(new EventosDia(ctrl+1));
			listaDias.get(ctrl).setVisible(ctrl<numdias.getValor());
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
		for(int ctrl=0;ctrl<listaDias.size();ctrl++){
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
			listaDias.get(ctrl).setVisible(ctrl<numdias.getValor());
		}
		this.revalidate();
		this.repaint();
	}
	
	public ArrayList<Incidente> getIncidentes() {
		ArrayList<Incidente> incidentes = new ArrayList<Incidente>();
		for(int i = 0; i < numdias.getValor();++i){
			incidentes.add(listaDias.get(i).getIncidente());
		}
		return incidentes;
	}
	
	public int getNumDias(){
		return numdias.getValor();
	}
	
}
