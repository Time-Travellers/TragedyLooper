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
import presentacion.modelo.juego.Incidente.EnumIncidentes;
import presentacion.modelo.juego.InfoPersonaje.Personaje;

public class EventosDia extends JPanel {
	
	private JLabel nombre;
	private JComboBox<EnumIncidentes> selectorIncidente;
	/**
	 * detallar incidente sirve para que si se vuelve a seleccionar noincidentes, se borren el resto de ComboBox.
	 */
	private JPanel detallarIncidente;
	private JComboBox<Personaje> selectorCulpable;
	public EnumIncidentes getValorSeleccionado(){
		return  (EnumIncidentes) selectorIncidente.getSelectedItem();
	}
	

	public EventosDia(int n){
		EventosDia aux=this;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		JPanel contenedor=new JPanel();
		this.nombre=new JLabel("Dia "+n);
		selectorIncidente = new JComboBox<EnumIncidentes>(EnumIncidentes.values());
		selectorCulpable = new JComboBox<Personaje>(Personaje.values());
		detallarIncidente=new JPanel();
		detallarIncidente.add(this.selectorCulpable);
		contenedor.add(nombre);
		contenedor.add(selectorIncidente);
		selectorIncidente.setSelectedItem(EnumIncidentes.No_Incidentes);
		selectorIncidente.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(selectorIncidente.getSelectedItem()==EnumIncidentes.No_Incidentes){
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
		ventana.setContentPane(new EventosDia(1));
		ventana.setVisible(true);
	}


	public Incidente getIncidente() {
		if(selectorIncidente.getSelectedItem() != null){
			return new Incidente((EnumIncidentes)selectorIncidente.getSelectedItem(), (Personaje)selectorCulpable.getSelectedItem());
		} else
			return null;
	}
}
