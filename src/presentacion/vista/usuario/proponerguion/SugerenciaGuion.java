package presentacion.vista.usuario.proponerguion;

import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import presentacion.modelo.juego.Incidente;
import presentacion.modelo.juego.InfoGuion;
import presentacion.modelo.juego.InfoGuion.Subtrama;
import presentacion.modelo.juego.InfoGuion.Trama;
import presentacion.modelo.juego.InfoPersonaje;


public class SugerenciaGuion extends JPanel{
	
	private static final long serialVersionUID = -5984566220916638228L;
	final static String SALIR = "salirIcono.png";
	final static String TICK = "tickverde.png";
	private JSpinner bucles;
	private PanelParaEscribir titulo;
	private PanelSeleccionTrama trama;
	private PanelSeleccionSubtrama subtrama;
	private PanelDias dias;
	private PanelPersonajes personajes;
	private JButton aceptar;
	private JButton cancelar;
	private GuionListener gListener;
	
	public interface GuionListener{
		void recibirGuion();
		void salir();
	}
	
	public void setGListener(GuionListener listener){
		this.gListener = listener;
	}
	
	public SugerenciaGuion(){
		
		JPanel contenedor=new JPanel();
		contenedor.setLayout(new BoxLayout(contenedor,BoxLayout.Y_AXIS));
		JPanel nivel1=new JPanel();
		JPanel nivel2=new JPanel();
		JPanel nivel3=new JPanel();
		JPanel nivel4=new JPanel();

		bucles = new JSpinner(new SpinnerNumberModel(3,1,8,1));
		this.titulo=new PanelParaEscribir(15,"Titulo");
		this.trama=new PanelSeleccionTrama();
		this.subtrama=new PanelSeleccionSubtrama();
		this.dias=new PanelDias();
		this.personajes=new PanelPersonajes();
		this.aceptar=new JButton(new ImageIcon("src/resources/" + TICK));
		aceptar.addActionListener((e)->this.gListener.recibirGuion());
		this.cancelar=new JButton(new ImageIcon("src/resources/" + SALIR));
		cancelar.addActionListener((e)->this.gListener.salir());
		nivel1.add(titulo);
		nivel1.add(bucles);
		nivel2.add(trama);
		nivel2.add(subtrama);
		nivel3.add(dias);
		nivel3.add(personajes);
		nivel4.add(aceptar);
		nivel4.add(cancelar);
		contenedor.add(nivel1);
		contenedor.add(nivel2);
		contenedor.add(nivel3);
		contenedor.add(nivel4);
		this.add(contenedor);
	}
	
	
	/*public static void main(String[] args) {
		SugerenciaGuion a=new SugerenciaGuion(null);
		a.setSize(800,600);
		}*/

	public InfoGuion getGuionCompleto() {
		return new InfoGuion(getTitulo(), getTrama(), getSubtrama(), getBucles(), getDias(), getPersonajes(), getIncidentes());
	}

	private int getDias() {
		return dias.getNumDias();
	}

	public int getBucles() {
		return (Integer) bucles.getValue();
	}

	public String getTitulo() {
		return titulo.getTexto();
	}

	public Trama getTrama() {
		return trama.getTrama();
	}

	public Subtrama getSubtrama() {
		return subtrama.getSubtrama();
	}

	public ArrayList<Incidente> getIncidentes() {
		return dias.getIncidentes();
	}

	public ArrayList<InfoPersonaje> getPersonajes() {
		return personajes.getInfoPersonajes();
	}


	

	

}
