package presentacion.vista.usuario.SugerirGuion;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PanelParaEscribir extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTextField texto;
	private JLabel nombre;
	
	public String sacarTexto(){
		return texto.getText();
	}
	
	public PanelParaEscribir(String nombre){
		this.nombre=new JLabel(nombre);
		this.texto=new JTextField(3);
		texto.setSize(20, 20);
		this.add(this.nombre);
		this.add(this.texto);
	}
	
	public static void main(String args[]){
		JFrame prueba=new JFrame("prueba");
		prueba.setContentPane(new PanelParaEscribir("jaja"));
		prueba.setSize(800, 600);
		prueba.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		prueba.setVisible(true);
	}
}
