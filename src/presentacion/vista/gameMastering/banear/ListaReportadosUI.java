package presentacion.vista.gameMastering.banear;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

public class ListaReportadosUI extends JPanel {
	
	private static final long serialVersionUID = -8961549082439847327L;
	private final static String Actualizar="actualizar.png";
	private final static String[] COL_NAMES={"Remitente", "Reportado", "Fecha"};
	
	private JTable table;
	private JScrollPane tablePane;	
	private ReportadosListener list;
	
	public interface ReportadosListener {
		void actualizar(); 
		void seleccionar(String s);
		void salir();
	}
	
	public void setReportadosListener(ReportadosListener listener){
		this.list = listener;
	}
	
	public ListaReportadosUI(String [][] datos) {
		
		JPanel todo = new JPanel();
		
		todo.setLayout(new BoxLayout(todo,BoxLayout.Y_AXIS));
		
		//panel superior para el titulo y los botones
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north,BoxLayout.X_AXIS));
				
		JLabel title = new JLabel("Hay " + datos.length +  " reportados pendientes:");
		title.setFont(new Font("",20,40));
				

		JButton actualizar = new JButton();
		actualizar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("resources/" + Actualizar)));
		actualizar.setPreferredSize(new Dimension (50,50));
		actualizar.addActionListener((e)-> list.actualizar());
		
		north.add(title);
		north.add(Box.createHorizontalGlue());
		north.add(actualizar);
		
		table = new JTable(datos, COL_NAMES);
		table.setVisible(true);
		table.getTableHeader().setReorderingAllowed(false);
		table.setFillsViewportHeight(true);
		table.getSelectionModel().addListSelectionListener((e)->{
			list.seleccionar((String)table.getValueAt(table.getSelectedRow(), 1));
		});
		tablePane = new JScrollPane(table);
		
		todo.add(north);
		todo.add(Box.createRigidArea(new Dimension(0,10)));
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
		table = new JTable(datos, COL_NAMES);
		table.revalidate();
		table.repaint();
		tablePane.repaint();
		tablePane.revalidate();
		revalidate();
		repaint();
	}
	
}
