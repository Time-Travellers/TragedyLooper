package presentacion.vista.usuario.buscar;

import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import presentacion.controlador.buscador.BuscadorEvent;
import presentacion.controlador.buscador.BuscadorEvent.BuscadorType;
import presentacion.controlador.buscador.BuscadorListenable;
import presentacion.controlador.buscador.BuscadorListener;

public class BuscadorUI extends JPanel implements BuscadorListenable{

	private static final long serialVersionUID = -8214433700582040511L;

	private ArrayList<BuscadorListener> listeners;
	private JTextField nombre;
	private JButton botonBuscar;

	public BuscadorUI() {
		initGUI();
	}


	private void initGUI() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		JPanel panelAux = new JPanel();
		panelAux.add(new JLabel("Introduce el usuario a buscar: "));
		this.nombre = new JTextField(20);
		panelAux.add(this.nombre);
		this.botonBuscar = new JButton("Buscar");
		this.botonBuscar.addActionListener((e) -> notificar(new BuscadorEvent(BuscadorType.Buscar, nombre.getText())));
		panelAux.add(this.botonBuscar);
		this.add(panelAux);
		this.setVisible(true);
	}

	public void notificar(BuscadorEvent e) {
		for(BuscadorListener l : listeners)
			l.notificarBuscador(e);
	}
	
	@Override
	public void addBuscadorListener(BuscadorListener list) {
		listeners.add(list);
	}
}
