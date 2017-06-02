package presentacion.vista.juego.proponerGuion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import presentacion.modelo.juego.Incidente;
import presentacion.modelo.juego.InfoGuion;
import presentacion.modelo.juego.InfoGuion.Subtrama;
import presentacion.modelo.juego.InfoGuion.Trama;
import presentacion.modelo.juego.InfoPersonaje;
import presentacion.modelo.usuario.Jugador;


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
		public void recibirGuion();
		public void salir();
		public Jugador idRegistrado();
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
		this.aceptar=new JButton("Enviar");
		aceptar.setBackground(new Color(147, 238, 64));
		aceptar.addActionListener((e)->this.gListener.recibirGuion());
		this.cancelar=new JButton("Cancelar");
		cancelar.setBackground(new Color(242, 76, 76));
		cancelar.addActionListener((e)->this.gListener.salir());
		nivel1.add(titulo);
		nivel1.add(new JLabel("Bucles:"));
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
		
		JPanel scroller = new JPanel();
		scroller.setLayout(new BorderLayout());
		scroller.add(new JScrollPane(contenedor));
		this.setLayout(new BorderLayout());
		this.add(scroller, BorderLayout.CENTER);
		this.setVisible(true);
	}


	public InfoGuion getGuionCompleto() {
		return new InfoGuion(gListener.idRegistrado(), getTitulo(), getTrama(), getSubtrama(), getBucles(), getDias(), getPersonajes(), getIncidentes(), new Date());
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
