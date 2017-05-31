package presentacion.vista.usuario.perfilus;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class TablaTOPPartidas extends JPanel {


	private static final long serialVersionUID = 2471691997972245593L;

	final static String[] COL_NAMES = {"N�" , "ID", "Rol", "Puntuacion", "Fecha"};

	private JTable table;

	public TablaTOPPartidas() {
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





}
