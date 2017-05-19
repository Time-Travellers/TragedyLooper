package presentacion.vista.usuario.SugerirGuion.EventosDias;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;

public class Dias extends JPanel{
	private JSpinner selector;
	
	public Dias(){
		this.selector=new JSpinner();
		selector.setValue(2);
		this.add(new JLabel("Dias"));
		this.add(selector);
	}
	
	public int getDias(){
		return (int) selector.getValue();
	}
	
	public static void main(String args[]){
		JFrame ventana=new JFrame("prueba");
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setContentPane(new Dias());
		ventana.setSize(800,600);
		ventana.setVisible(true);
	}
	
}
