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
	private String busq;
	private ArrayList<ResultBusqUI> resultados;

	public BuscadorUI() {
		this.busq = null;
		this.resultados = new ArrayList<ResultBusqUI>();
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
		if (busq != null) {
			JScrollPane panelAux2 = new JScrollPane();
			JLabel aux = new JLabel("Resultados de la búsqueda de " + busq);
			panelAux2.add(aux);
			for (ResultBusqUI a : resultados) {
				panelAux2.add(a);
				a.setVisible(true);
			}
			if (resultados.size() == 0)
				panelAux2.add(new JLabel("No se han encontrado resultados"));
			panelAux2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			panelAux2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
			this.add(panelAux2);
		}
		this.setVisible(true);
	}
	
	public void actualizar() {
		initGUI();
	}

	public void setResultados(ArrayList<ResultBusqUI> resultados) {
		this.resultados = resultados;
	}
	
	public void setBusq(String busq) {
		this.busq = busq;
	}
}
