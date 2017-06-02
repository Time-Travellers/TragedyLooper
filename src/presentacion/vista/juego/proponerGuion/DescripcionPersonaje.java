package presentacion.vista.juego.proponerGuion;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import presentacion.modelo.juego.InfoPersonaje;
import presentacion.modelo.juego.InfoPersonaje.Personaje;
import presentacion.modelo.juego.InfoPersonaje.Rol;

public class DescripcionPersonaje extends JPanel {

	private static final long serialVersionUID = -7679336530768833039L;

	private JLabel nombre;
	private JComboBox<Personaje> selectordepersonajes;
	private JComboBox<Rol> selectorderol;

	public InfoPersonaje getValorSeleccionado() {
		return new InfoPersonaje((Personaje) selectordepersonajes.getSelectedItem(),
				(Rol) selectorderol.getSelectedItem());
	}

	public DescripcionPersonaje(int n) {

		this.nombre = new JLabel("P" + n);
		this.selectordepersonajes = new JComboBox<Personaje>(Personaje.values());
		this.selectorderol = new JComboBox<Rol>(Rol.values());
		this.add(nombre);
		this.add(selectordepersonajes);
		this.add(selectorderol);
	}
}
