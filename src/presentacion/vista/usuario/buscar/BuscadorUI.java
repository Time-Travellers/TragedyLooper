package presentacion.vista.usuario.buscar;

import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BuscadorUI extends JPanel {

	public interface BuscadorUIListener {
		public void buscarPulsado(String usuario);
		public void agregarPulsado(String usuario);
		public void reportarPulsado(String usuario);
	}
	
	private BuscadorUIListener bl;
	private JTextField nombre;
	private JButton botonBuscar;
	private JLabel resultado;
	private JButton botonAgregar;
	private JButton botonReportar;

	
	public BuscadorUI(BuscadorUIListener bListener) {
		this.bl = bListener;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		initGUI();
		this.setVisible(true);
	}
	
	private void initGUI() {
		JPanel panelAux = new JPanel();
		panelAux.add(new JLabel("Introduce el usuario a buscar: "));
		this.nombre = new JTextField(20);
		panelAux.add(this.nombre);
		this.botonBuscar = new JButton("Buscar");
		this.botonBuscar.addActionListener((e) -> bl.buscarPulsado(this.getUsuarioABuscar()));
		this.botonBuscar.addActionListener((e) -> {
			String s = this.getUsuarioABuscar();
			this.setResultado(s);
			habilitarBotones(true);
		}); //Quitar
		panelAux.add(this.botonBuscar);
		this.add(panelAux);
		JPanel panelAux2 = new JPanel();
		JLabel aux = new JLabel("Resultado: ");
		panelAux2.add(aux);
		this.resultado = new JLabel("___");
		this.resultado.setFont(new Font("", 15, 15));
		panelAux2.add(resultado);
		this.botonAgregar = new JButton("Agregar");
		this.botonAgregar.addActionListener((e) -> bl.agregarPulsado(this.getUsuarioABuscar()));
		panelAux2.add(botonAgregar);
		this.botonReportar = new JButton("Reportar");
		this.botonReportar.addActionListener((e) -> bl.reportarPulsado(this.getUsuarioABuscar()));
		panelAux2.add(botonReportar);
		habilitarBotones(false);
		this.add(panelAux2);
	}
	
	public String getUsuarioABuscar() {
		return this.nombre.getText();
	}
	
	public void habilitarBotones(boolean b) {
		if(b) {
			this.botonAgregar.setEnabled(true);
			this.botonReportar.setEnabled(true);
		} else {
			this.botonAgregar.setEnabled(false);
			this.botonReportar.setEnabled(false);
		}
		this.repaint();
	}
	
	public void setResultado(String s) {
		this.resultado.setText(s);
		this.repaint();
	}
	
	//Main para probar el buscador:
	public static void main(String... args) {
		JFrame frame = new JFrame("Prueba de BuscadorUI");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400,300);
		BuscadorUI busc = new BuscadorUI(new BuscadorUIListener() {

			@Override
			public void buscarPulsado(String usuario) {
				System.out.println("Has buscado a " + usuario);
				//Si se encuentra, ok.
				//Si no, deshabilitar botones con el metodo publico proporcionado.
			}

			@Override
			public void agregarPulsado(String usuario) {
				System.out.println("Quieres agregar a " + usuario);
			}

			@Override
			public void reportarPulsado(String usuario) {
				System.out.println("Quieres reportar a " + usuario);
			}
			
		});
		frame.setContentPane(busc);
		frame.setVisible(true);
	}

}
