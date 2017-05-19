package presentacion.vista.usuario.SugerirGuion;

import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelSeleccionSubtrama extends JPanel{
	private JComboBox opciones;
	private JLabel nombre;
	
	/**
	 * Ojo devuelve la posicion que se ha seleccionado, no el enumerado
	 * @return
	 */
	
	public int sacarOpcion(){
		return opciones.getSelectedIndex();
	}
	
	private void InicializarComboBox(SubTramas[] lista){
		for(int i=0;i<lista.length;i++){
			this.opciones.addItem(lista[i]);
		}
	}
	
	public PanelSeleccionSubtrama(){
		this.nombre=new JLabel("Subtrama");
		this.opciones=new JComboBox<Object>();
		this.opciones.setEditable(false);
		InicializarComboBox(SubTramas.values());
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

}
