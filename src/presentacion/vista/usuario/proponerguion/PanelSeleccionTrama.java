package presentacion.vista.usuario.proponerguion;

import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelSeleccionTrama extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private JComboBox opciones;
	private JLabel nombre;
	
	/**
	 * Ojo devuelve la posicion que se ha seleccionado, no el enumerado
	 * @return
	 */
	
	public int sacarOpcion(){
		return opciones.getSelectedIndex();
	}
	
	private void InicializarComboBox(Tramas[] lista){
		for(int i=0;i<lista.length;i++){
			this.opciones.addItem(lista[i]);
		}
	}
	
	public PanelSeleccionTrama(){
		this.nombre=new JLabel("Trama");
		this.opciones=new JComboBox<Object>();
		this.opciones.setEditable(false);
		InicializarComboBox(Tramas.values());
		this.add(this.nombre);
		this.add(this.opciones);
	}
	
	public static void main(String args[]){
		JFrame prueba=new JFrame("prueba");
		prueba.setContentPane(new PanelSeleccionTrama());
		prueba.setSize(800, 600);
		prueba.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		prueba.setVisible(true);
	}
	}
