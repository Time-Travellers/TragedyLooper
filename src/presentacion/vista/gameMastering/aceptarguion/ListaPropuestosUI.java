package presentacion.vista.gameMastering.aceptarguion;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

public class ListaPropuestosUI extends JPanel {

	private static final long serialVersionUID = -2169464744594357032L;

	private final static String[] COL_NAMES = { "Creador", "Titulo", "Fecha" };

	private JTable tabla;
	private JScrollPane tablePane;
	private GuionesPropuestosListener list;

	public interface GuionesPropuestosListener {
		void actualizar();

		void seleccionar(String s);
	}

	public void setGPListener(GuionesPropuestosListener listener) {
		this.list = listener;
	}

	public ListaPropuestosUI(String[][] datos) {

		JPanel todo = new JPanel();

		todo.setLayout(new BoxLayout(todo, BoxLayout.Y_AXIS));

		// panel superior para el titulo y los botones
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.X_AXIS));

		JLabel title = new JLabel("Hay " + datos.length + " guiones pendientes:");
		title.setFont(new Font("", 20, 40));

		north.add(title);
		north.add(Box.createHorizontalGlue());

		// tabla
		tabla = new JTable(datos, COL_NAMES);
		tabla.setVisible(true);
		tabla.setFillsViewportHeight(true);
		tabla.getTableHeader().setReorderingAllowed(false);
		tabla.getSelectionModel().addListSelectionListener((e) -> {
			list.seleccionar((String) tabla.getValueAt(tabla.getSelectedRow(), 1));
		});
		tablePane = new JScrollPane(tabla);

		todo.add(north);
		todo.add(Box.createRigidArea(new Dimension(0, 10)));
		todo.add(tablePane);

		JPanel scroller = new JPanel();
		scroller.setLayout(new BorderLayout());
		scroller.add(new JScrollPane(todo));
		this.setLayout(new BorderLayout());
		this.add(scroller, BorderLayout.CENTER);

		todo.setBorder(new EmptyBorder(20, 20, 20, 20));

		this.setVisible(true);
	}

	public void setDatos(String[][] datos) {

		tabla = new JTable(datos, COL_NAMES);
		tabla.revalidate();
		tabla.repaint();
		tablePane.repaint();
		tablePane.revalidate();
		revalidate();
		repaint();
	}
}
