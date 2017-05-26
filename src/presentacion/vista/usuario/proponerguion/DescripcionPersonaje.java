package presentacion.vista.usuario.proponerguion;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import presentacion.modelo.juego.InfoPersonaje;
import presentacion.modelo.juego.InfoPersonaje.Personaje;

public class DescripcionPersonaje extends JPanel {
	public InfoPersonaje personaje;
	private JLabel nombre;
	private JComboBox selectordepersonajes;
	private JComboBox selectorderol;
	
	public InfoPersonaje getValorSeleccionado(){
		return new InfoPersonaje((String)selectordepersonajes.getSelectedItem(), (String)selectorderol.getSelectedItem());
	}

	private void inicializarSelectorDePersonajes(Object[] lista){
		for(int ctrl=0;ctrl<lista.length;ctrl++){
			selectordepersonajes.addItem(lista[ctrl]);
		}
	}
	
	private void inicializarSelectorDeRol(Object[] lista){
		for(int ctrl=0;ctrl<lista.length;ctrl++){
			selectorderol.addItem(lista[ctrl]);
		}
	}
	
	public DescripcionPersonaje(int n,Object[] listadepersonajes, Object[] listaderoles){
		
		this.nombre=new JLabel("P"+n);
		this.selectordepersonajes=new JComboBox();
		this.selectorderol=new JComboBox();
		inicializarSelectorDePersonajes(listadepersonajes);
		inicializarSelectorDeRol(listaderoles);
		this.add(nombre);
		this.add(selectordepersonajes);
		this.add(selectorderol);
	}
	
	public static void main(String args[]){
		JFrame ventana=new JFrame("prueba");
		ventana.setSize(800,600);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setContentPane(new DescripcionPersonaje(1,Personaje.values(), Rol.values()));
		ventana.setVisible(true);
	}
}
