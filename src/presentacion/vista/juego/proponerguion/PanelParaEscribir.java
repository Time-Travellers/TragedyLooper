package presentacion.vista.juego.proponerguion;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelParaEscribir extends JPanel{
	
	private static final long serialVersionUID = 1L;

	private JTextField texto;
	private JLabel nombre;
	
	public String getTexto(){
		return texto.getText();
	}
	
	public PanelParaEscribir(int n, String nombre){
		this.nombre=new JLabel(nombre);
		this.texto=new JTextField(n);
		texto.setSize(20, 20);
		this.add(this.nombre);
		this.add(this.texto);
	}
}
