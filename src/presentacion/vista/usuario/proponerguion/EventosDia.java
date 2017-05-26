package presentacion.vista.usuario.proponerguion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import presentacion.modelo.juego.Incidente;
import presentacion.modelo.juego.Incidente.Incidentes;
import presentacion.modelo.juego.InfoPersonaje.Personaje;

public class EventosDia extends JPanel {
	
	
	public Incidente incidente;
	private JLabel nombre;
	private JComboBox selectorIncidente;
	/**
	 * detallar incidente sirve para que si se vuelve a seleccionar noincidentes, se borren el resto de ComboBox.
	 */
	private JPanel detallarIncidente;
	private JComboBox<Object> selectorCulpable;
	public Incidentes getValorSeleccionado(){
		return  (Incidentes) selectorIncidente.getSelectedItem();
	}
	
	/**
	 * Pensar si seria mejor crear un combobox para todos los dias y no tener que inicializarlo para cada uno.
	 * @param lista
	 */
	private void inicializarSelectorDeIncidente(Object[] lista){
		for(int ctrl=0;ctrl<lista.length;ctrl++){
			selectorIncidente.addItem(lista[ctrl]);
		}
	}
	
	private void inicializarselectorCulpable(Object[]lista){
		for(int ctrl=0;ctrl<lista.length;ctrl++){
			selectorCulpable.addItem(lista[ctrl]);
		}
	}
	
	public EventosDia(int n, Object[] listadeincidentes, Object[] listadeculpables){
		EventosDia aux=this;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		JPanel contenedor=new JPanel();
		this.nombre=new JLabel("Dia "+n);
		this.selectorIncidente=new JComboBox();
		this.selectorCulpable=new JComboBox();
		detallarIncidente=new JPanel();
		detallarIncidente.add(this.selectorCulpable);
		contenedor.add(nombre);
		contenedor.add(selectorIncidente);
		inicializarSelectorDeIncidente(listadeincidentes);
		inicializarselectorCulpable(listadeculpables);
		selectorIncidente.setSelectedItem(Incidentes.No_Incidentes);
		selectorIncidente.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(selectorIncidente.getSelectedItem()==Incidentes.No_Incidentes){
					detallarIncidente.setVisible(false);
					aux.revalidate();
					aux.repaint();
				}
				else{
					detallarIncidente.setVisible(true);
					//revalidate es para que se reactualice la composicion del panel.
					aux.revalidate();
					aux.repaint();
				}
			}
		});
		this.add(contenedor);
		detallarIncidente.setVisible(false);
		detallarIncidente.add(selectorCulpable);
		this.add(detallarIncidente);
	}
	
	public static void main(String args[]){
		JFrame ventana=new JFrame("prueba");
		ventana.setSize(800,600);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setContentPane(new EventosDia(1,Incidentes.values(), Personaje.values()));
		ventana.setVisible(true);
	}
}
