package presentacion.vista.usuario.perfilus;

import java.awt.Color;
import java.awt.Dimension;

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
		table.setPreferredScrollableViewportSize(new Dimension(600,350));
	}

	public void eraseData() {
		String[][] datos = {};
		table = new JTable(datos, COL_NAMES);
	}
}
