package presentacion.vista.juego.proponerGuion;

import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Regulador extends JPanel {

	private static final long serialVersionUID = 4515698274157262067L;
	private JSpinner selector;
	private ArrayList<ReguladorListener> Observadores;

	public Regulador(String nombre, int n) {
		this.selector = new JSpinner(new SpinnerNumberModel(1, 1, n, 1));
		this.Observadores = new ArrayList<ReguladorListener>();
		selector.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				for (int i = 0; i < Observadores.size(); i++)
					Observadores.get(i).nuevoDia();
			}
		});
		this.add(new JLabel(nombre));
		this.add(selector);
	}

	public void addObservador(ReguladorListener dl) {
		Observadores.add(dl);
	}

	public int getValor() {
		return (int) selector.getValue();
	}

}
