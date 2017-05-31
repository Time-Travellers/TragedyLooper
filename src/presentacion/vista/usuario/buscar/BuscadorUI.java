package presentacion.vista.usuario.buscar;

import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class BuscadorUI extends JPanel {

	private static final long serialVersionUID = -8214433700582040511L;

	public interface BuscadorUIListener {
		public void buscarPulsado(String usuario);
	}

	private BuscadorUIListener bl;
	private JTextField nombre;
	private JButton botonBuscar;

	public BuscadorUI() {
		initGUI();
	}
	
	public void setListener(BuscadorUIListener bl) {
		this.bl = bl;
	}

	private void initGUI() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		JPanel panelAux = new JPanel();
		panelAux.add(new JLabel("Introduce el usuario a buscar: "));
		this.nombre = new JTextField(20);
		panelAux.add(this.nombre);
		this.botonBuscar = new JButton("Buscar");
		this.botonBuscar.addActionListener((e) -> bl.buscarPulsado(nombre.getText()));
		panelAux.add(this.botonBuscar);
		this.add(panelAux);
		this.setVisible(true);
	}
}
