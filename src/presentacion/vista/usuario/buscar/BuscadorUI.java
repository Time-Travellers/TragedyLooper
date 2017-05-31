package presentacion.vista.usuario.buscar;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
		panelAux.add(this.botonBuscar);
		this.add(panelAux);
		this.setVisible(true);
	}
}
