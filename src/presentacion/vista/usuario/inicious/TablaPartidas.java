package presentacion.vista.usuario.inicious;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class TablaPartidas extends JPanel {

	private static final long serialVersionUID = -2319246681700202276L;

	final static String[] COL_NAMES = { "ID", "Tiempo espera", "Turno", "MasterMind" };

	private JTable table;

	public TablaPartidas() {
		this.setVisible(true);
		this.setPreferredSize(new Dimension(500, 300));
		initialize();
	}

	private void initialize() {

		String[][] datos = {};
		table = new JTable(datos, COL_NAMES);
		table.setVisible(true);
		Border borde = BorderFactory.createLineBorder(Color.black, 1);
		table.setFillsViewportHeight(true);
		JScrollPane pane = new JScrollPane(table);
		pane.setPreferredSize(new Dimension(700, 250));
		this.add(pane);
		this.setBorder(
				BorderFactory.createTitledBorder(borde, "Partidas en curso:", TitledBorder.LEFT, TitledBorder.TOP));
		table.getTableHeader().setReorderingAllowed(false);
	}

	public void eraseData() {
		String[][] datos = {};
		table = new JTable(datos, COL_NAMES);
	}
}
