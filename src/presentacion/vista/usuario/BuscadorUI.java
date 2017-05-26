package presentacion.vista.usuario;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class BuscadorUI extends JPanel {

	public interface BuscadorUIListener {
		public void buscarPulsado();
	}
	
	final static String[] COL_NAMES =  {"Usuario", "Agregar", "Reportar"};
	
	private BuscadorUIListener bl;
	private JTextField nombre;
	private JButton boton;
	private JTable tabla;
	private Object[][] datos;
	
	public BuscadorUI(BuscadorUIListener bListener) {
		this.bl = bListener;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		initGUI();
		this.setVisible(true);
	}
	
	private void initGUI() {
		JPanel panelAux = new JPanel();
		panelAux.add(new JLabel("Introduce el usuario a buscar: "));
		this.nombre = new JTextField(20);
		panelAux.add(this.nombre);
		this.boton = new JButton("Buscar");
		panelAux.add(this.boton);
		this.add(panelAux);
		
		
		this.datos = new Object[4][4];
		tabla = new JTable(datos, COL_NAMES);
		tabla.setVisible(true);
		Border borde = BorderFactory.createLineBorder(Color.black, 1);
		tabla.setFillsViewportHeight(true);
		this.add(new JScrollPane(tabla));
		this.setBorder(BorderFactory.createTitledBorder(
				borde, "Usuarios:",
				TitledBorder.LEFT, TitledBorder.TOP));
	}
	
	public String getUsuarioABuscar() {
		return this.nombre.getText();
	}
	
	public void insertarUsuarioATabla(String username) {
		this.datos[0][0] = username;
		this.datos[0][1] = new JButton();
		this.datos[0][2] = new JButton();
	}
	
	//Main para probar el buscador:
	public static void main(String[] args) {
		JFrame frame = new JFrame("Prueba de BuscadorUI");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800,600);
		BuscadorUI busc = new BuscadorUI(null);
		busc.insertarUsuarioATabla("Hola");
		frame.setContentPane(busc);
		frame.setVisible(true);
	}

}
