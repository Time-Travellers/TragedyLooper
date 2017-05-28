package presentacion.vista.gameMastering;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class ListaReportadosUI extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8961549082439847327L;
	private final static String Actualizar="actualizar.png";
	private final static String[] COL_NAMES={"Remitente", "Reportado", "Fecha"};
	
	private JTable table;
	private String [][] datos = {};
	private JButton actualizar;
	
	public ListaReportadosUI(String [][] datos) {
		this.setVisible(true);
		this.datos=datos;
		initialize();
	}

	private void initialize() {
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		this.actualizar=new JButton(new ImageIcon(getClass().getClassLoader().getResource("resources/"+ Actualizar)));
		this.add(actualizar);
		table = new JTable(datos, COL_NAMES);
		table.setVisible(true);
		table.setFillsViewportHeight(true);
		this.add(new JScrollPane(table));
	}

	public void eraseData() {
		String[][] datos = {};
		table = new JTable(datos, COL_NAMES);
	}
	
	public static void main(String args[]){
		JFrame ventana=new JFrame("prueba");
		ventana.setSize(800,600);
		String [][] dat = {};
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setContentPane(new ListaReportadosUI(dat));
		ventana.setVisible(true);
	}
	
}
