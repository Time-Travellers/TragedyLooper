package presentacion.vista.gameMastering;

import java.awt.Color;

import javax.swing.BorderFactory;
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
	
	final static String[] COL_NAMES={"Remitente", "Asunto", "Fecha","Ver"};
	
	JTable table;
	
	public ListaReportadosUI(String id) {
		this.setVisible(true);
		initialize();
	}

	private void initialize() {

		String [][] datos = {};
		table = new JTable(datos, COL_NAMES);
		table.setVisible(true);
		Border borde = BorderFactory.createLineBorder(Color.black, 1);
		table.setFillsViewportHeight(true);
		this.add(new JScrollPane(table));
		this.setBorder(BorderFactory.createTitledBorder(
				borde, "Mejores partidas:",
				TitledBorder.LEFT, TitledBorder.TOP));
	}

	public void eraseData() {
		String[][] datos = {};
		table = new JTable(datos, COL_NAMES);
	}
	
	public static void main(String args[]){
		JFrame ventana=new JFrame("prueba");
		ventana.setSize(800,600);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setContentPane(new ListaReportadosUI("zzz"));
		ventana.setVisible(true);
	}
	
}
