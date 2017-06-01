package presentacion.vista.gameMastering.aceptarguion;

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

public class ListaPropuestosUI extends JPanel{
	
	private static final long serialVersionUID = -2169464744594357032L;

	private final static String Actualizar="actualizar.png";
	private final static String[] COL_NAMES={"Creador", "Titulo", "Fecha"};
	
	private JTable tabla;
	private JScrollPane tablePane;
	private GuionesPropuestosListener list;
	
	public interface GuionesPropuestosListener {
		void actualizar(); 
		void seleccionar(String s);
	}
	
	public void setGPListener(GuionesPropuestosListener listener){
		this.list = listener;
	}
	
	public ListaPropuestosUI(String [][] datos) {
		setVisible(true);
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
		//panel superior para el titulo y los botones
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north,BoxLayout.X_AXIS));
		
		JLabel title = new JLabel("Hay " + datos.length +  " guiones pendientes:");
		title.setFont(new Font("",20,40));
		
		//boton actualizar
		JButton actualizar = new JButton();
		actualizar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("resources/" + Actualizar)));
		actualizar.setPreferredSize(new Dimension (50,50));
		actualizar.addActionListener((e)-> list.actualizar());
		
		north.add(title);
		north.add(Box.createHorizontalGlue());
		north.add(actualizar);
		
		//tabla
		tabla = new JTable(datos, COL_NAMES);
		tabla.setVisible(true);
		tabla.setFillsViewportHeight(true);
		tabla.getTableHeader().setReorderingAllowed(false);
		tabla.getSelectionModel().addListSelectionListener((e)->{
			list.seleccionar((String)tabla.getValueAt(tabla.getSelectedRow(), 1));
		});
		tablePane = new JScrollPane(tabla);
		
		add(north);
		add(Box.createRigidArea(new Dimension(0,10)));
		add(tablePane);
		setBorder(new EmptyBorder(20,20,20,20));
	}

	public void setDatos(String[][] datos){
		
		tabla = new JTable(datos, COL_NAMES);
		tabla.revalidate();
		tabla.repaint();
		tablePane.repaint();
		tablePane.revalidate();
		revalidate();
		repaint();
	}
}

