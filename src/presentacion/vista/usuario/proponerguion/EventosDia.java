package presentacion.vista.usuario.proponerguion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class EventosDia extends JPanel {
	
	
	
	private JLabel nombre;
	private JComboBox selectordeincidentes;
	/**
	 * detallar incidente sirve para que si se vuelve a seleccionar noincidentes, se borren el resto de ComboBox.
	 */
	private JPanel detallarincidente;
	private JComboBox<Object> selectordeculpable;
	public Incidentes getValorSeleccionado(){
		return  (Incidentes) selectordeincidentes.getSelectedItem();
	}
	
	/**
	 * Pensar si seria mejor crear un combobox para todos los dias y no tener que inicializarlo para cada uno.
	 * @param lista
	 */
	private void inicializarSelectorDeIncidente(Object[] lista){
		for(int ctrl=0;ctrl<lista.length;ctrl++){
			selectordeincidentes.addItem(lista[ctrl]);
		}
	}
	
	private void inicializarSelectorDeCulpable(Object[]lista){
		for(int ctrl=0;ctrl<lista.length;ctrl++){
			selectordeculpable.addItem(lista[ctrl]);
		}
	}
	
	public EventosDia(int n, Object[] listadeincidentes, Object[] listadeculpables){
		EventosDia aux=this;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		JPanel contenedor=new JPanel();
		this.nombre=new JLabel("Dia "+n);
		this.selectordeincidentes=new JComboBox();
		this.selectordeculpable=new JComboBox();
		detallarincidente=new JPanel();
		detallarincidente.add(this.selectordeculpable);
		contenedor.add(nombre);
		contenedor.add(selectordeincidentes);
		inicializarSelectorDeIncidente(listadeincidentes);
		inicializarSelectorDeCulpable(listadeculpables);
		selectordeincidentes.setSelectedItem(Incidentes.No_Incidentes);
		selectordeincidentes.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(selectordeincidentes.getSelectedItem()==Incidentes.No_Incidentes){
					detallarincidente.setVisible(false);
					aux.revalidate();
					aux.repaint();
				}
				else{
					detallarincidente.setVisible(true);
					//revalidate es para que se reactualice la composicion del panel.
					aux.revalidate();
					aux.repaint();
				}
			}
		});
		this.add(contenedor);
		detallarincidente.setVisible(false);
		detallarincidente.add(selectordeculpable);
		this.add(detallarincidente);
	}
	
	public static void main(String args[]){
		JFrame ventana=new JFrame("prueba");
		ventana.setSize(800,600);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setContentPane(new EventosDia(1,Incidentes.values(), Personajes.values()));
		ventana.setVisible(true);
	}
}
