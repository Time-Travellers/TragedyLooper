package presentacion.vista.juego.proponerguion;

import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import presentacion.modelo.juego.InfoGuion.Subtrama;

public class PanelSeleccionSubtrama extends JPanel{
	private JComboBox<Subtrama> opciones;
	private JLabel nombre;
	
	/**
	 * Ojo devuelve la posicion que se ha seleccionado, no el enumerado
	 * @return
	 */
	
	public int sacarOpcion(){
		return opciones.getSelectedIndex();
	}
	
	
	public PanelSeleccionSubtrama(){
		this.nombre=new JLabel("Subtrama");
		this.opciones=new JComboBox<Subtrama>(Subtrama.values());
		this.opciones.setEditable(false);
		this.add(this.nombre);
		this.add(this.opciones);
	}
	
	public static void main(String args[]){
		JFrame prueba=new JFrame("prueba");
		prueba.setContentPane(new PanelSeleccionSubtrama());
		prueba.setSize(800, 600);
		prueba.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		prueba.setVisible(true);
	}


	public Subtrama getSubtrama() {
		return (Subtrama)opciones.getSelectedItem();
	}
	

}
