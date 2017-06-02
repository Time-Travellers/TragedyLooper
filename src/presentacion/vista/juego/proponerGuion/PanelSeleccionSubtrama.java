package presentacion.vista.juego.proponerGuion;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import presentacion.modelo.juego.InfoGuion.Subtrama;

public class PanelSeleccionSubtrama extends JPanel {

	private static final long serialVersionUID = 2102358638852149560L;
	private JComboBox<Subtrama> opciones;
	private JLabel nombre;

	public int sacarOpcion() {
		return opciones.getSelectedIndex();
	}

	public PanelSeleccionSubtrama() {
		this.nombre = new JLabel("Subtrama");
		this.opciones = new JComboBox<Subtrama>(Subtrama.values());
		this.opciones.setEditable(false);
		this.add(this.nombre);
		this.add(this.opciones);
	}

	public Subtrama getSubtrama() {
		return (Subtrama) opciones.getSelectedItem();
	}

}
