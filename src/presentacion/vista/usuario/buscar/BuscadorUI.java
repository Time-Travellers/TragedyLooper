package presentacion.vista.usuario.buscar;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class BuscadorUI extends JPanel{

	private static final long serialVersionUID = -8214433700582040511L;

	public interface BuscList{
		public void buscarPulsado(String busq);
	}
	
	private BuscList list;
	private JTextField nombre;
	private JButton botonBuscar;

	public BuscadorUI() {
		initGUI();
	}

	public void setList(BuscList list) {
		this.list = list;
	}

	private void initGUI() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		JPanel panelAux = new JPanel();
		panelAux.add(new JLabel("Introduce el usuario a buscar: "));
		this.nombre = new JTextField(20);
		panelAux.add(this.nombre);
		this.botonBuscar = new JButton("Buscar");
		this.botonBuscar.addActionListener((e) -> list.buscarPulsado(nombre.getText()));
		this.botonBuscar.setBackground(new Color(246, 251, 51));
		panelAux.add(this.botonBuscar);
		
		JPanel scroller = new JPanel();
		scroller.setLayout(new BorderLayout());
		scroller.add(new JScrollPane(panelAux));
		this.setLayout(new BorderLayout());
		this.add(scroller, BorderLayout.CENTER);
		this.setVisible(true);
	}
}
