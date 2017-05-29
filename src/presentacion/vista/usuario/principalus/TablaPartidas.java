package presentacion.vista.usuario.principalus;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;


public class TablaPartidas extends JPanel {

	private static final long serialVersionUID = -2319246681700202276L;

	final static String[] COL_NAMES = {"ID" , "Tiempo espera", "Turno", "MasterMind"};
	
	private JTable table;
	
	public TablaPartidas() {
		this.setVisible(true);
		this.setPreferredSize(new Dimension(500,300));
		initialize();
	}
	
	private void initialize() {
		
		String [][] datos = {};
		table = new JTable(datos, COL_NAMES);
		table.setVisible(true);
		Border borde = BorderFactory.createLineBorder(Color.black, 1);
		table.setFillsViewportHeight(true);
		JScrollPane pane =new JScrollPane(table);
		pane.setPreferredSize(new Dimension(700,250));
		this.add(pane);
		this.setBorder(BorderFactory.createTitledBorder(
				borde, "Partidas en curso:",
				TitledBorder.LEFT, TitledBorder.TOP));
		table.getTableHeader().setReorderingAllowed(false);
	}
	
	public void eraseData() {
		String[][] datos = {};
		table = new JTable(datos, COL_NAMES);
	}
	
	/* public void eraseGame(Partida partida) {
		Sacar el contenido de la tabla, buscar la partida a eliminar,
		 eliminarla y actualizar los datos de la tabla.
	}*/
	
	/* public void appendGame(Partida partida) {
	 // Insertar partida en un atributo "lista de partidas"?
	 	appendData(partida.getID(), partida.getTEspera(), partida.getTurno(), partida.getMasterMind());
	 }
	 */
	
	/*
	 * public void appendData(String id, String time, String turn, String MM) {
	 * Insertarlo en una nueva fila del array bidimensional de los datos de la tabla. 
	 * }
	 */
	
	/*public setData(Partida[] partida) {
	 * Dentro de un bucle: 
		setData(partida[i].getID(), partida[i].getTEspera(), partida[i].getTurno(), partida[i].getMasterMind());
	}*/
	
	
	
	// Main para probar la tabla de partidas:
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> 
		{
			JFrame testFrame = new JFrame("Probando la tabla de partidas");
			testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			testFrame.setSize(new Dimension(800, 600));
			testFrame.setVisible(true);
			testFrame.getContentPane().setLayout(new FlowLayout());
			TablaPartidas tablaP = new TablaPartidas ();
			testFrame.add(tablaP);
		});

	}

}
