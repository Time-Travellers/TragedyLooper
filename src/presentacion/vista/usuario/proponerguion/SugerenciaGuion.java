package presentacion.vista.usuario.proponerguion;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import presentacion.modelo.juego.InfoGuion;
import presentacion.modelo.juego.InfoPersonaje;
import presentacion.modelo.usuario.Paises;


public class SugerenciaGuion extends JDialog{
	
	

	final static String SALIR = "salirIcono.png";
	final static String TICK = "tickverde.png";
	private PanelParaEscribir bucles;
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
	}
	
	public void setGListener(GuionListener listener){
		this.gListener = listener;
	}
	
	public SugerenciaGuion(JFrame jc){
		super(jc,ModalityType.DOCUMENT_MODAL);
		SugerenciaGuion aux=this;
		JPanel contenedor=new JPanel();
		contenedor.setLayout(new BoxLayout(contenedor,BoxLayout.Y_AXIS));
		JPanel nivel1=new JPanel();
		JPanel nivel2=new JPanel();
		JPanel nivel3=new JPanel();
		JPanel nivel4=new JPanel();
		this.bucles=new PanelParaEscribir(3,"Bucles");
		this.titulo=new PanelParaEscribir(15,"Titulo");
		this.trama=new PanelSeleccionTrama();
		this.subtrama=new PanelSeleccionSubtrama();
		this.dias=new PanelDias();
		this.personajes=new PanelPersonajes();
		this.aceptar=new JButton(new ImageIcon("src/resources/" + TICK));
		aceptar.addActionListener((e)->this.gListener.recibirGuion());
		this.cancelar=new JButton(new ImageIcon("src/resources/" + SALIR));
		cancelar.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				aux.dispose();
			}
		});
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
		this.pack();
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		this.setAlwaysOnTop(true);
	}
	
	
	public static void main(String[] args) {
		
		SugerenciaGuion a=new SugerenciaGuion(null);
		a.setSize(800,600);
		}

	public InfoGuion getGuionCompleto() {
		// TODO Auto-generated method stub
		return null;
	}

	public PanelParaEscribir getBucles() {
		return bucles;
	}

	public PanelParaEscribir getTitulo() {
		return titulo;
	}

	public PanelSeleccionTrama getTrama() {
		return trama;
	}

	public PanelSeleccionSubtrama getSubtrama() {
		return subtrama;
	}

	public PanelDias getDias() {
		return dias;
	}

	public ArrayList<InfoPersonaje> getPersonajes() {
		return personajes.getInfoPersonajes();
	}

	

	

}
