package presentacion.vista.gameMastering;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ListaPropuestosUI extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2169464744594357032L;

	private final static String Actualizar="actualizar.png";
	private final static String[] COL_NAMES={"Creador", "Titulo"};
	
	private JTable tabla;
	private String[][]datos;
	private JButton actualizar;
	
	public ListaPropuestosUI(String [][] datos) {
		this.setVisible(true);
		this.datos=datos;
		initialize();
	}

	private void initialize() {
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		this.actualizar=new JButton(new ImageIcon("src/resources/"+ Actualizar));
		this.add(actualizar);
		tabla = new JTable(datos, COL_NAMES);
		tabla.setVisible(true);
		tabla.setFillsViewportHeight(true);
		this.add(new JScrollPane(tabla));
	}

	public void eraseData() {
		String[][] datos = {};
		tabla = new JTable(datos, COL_NAMES);
	}

	public static void main(String args[]){
		JFrame ventana=new JFrame("prueba");
		ventana.setSize(800,600);
		String [][] dat = {};
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setContentPane(new ListaPropuestosUI(dat));
		ventana.setVisible(true);
	}
}

