package presentacion.vista.usuario.proponerguion;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Regulador extends JPanel{
	private JSpinner selector;
	private ArrayList<ReguladorListener> Observadores;
	
	public Regulador(String nombre,int n){
		this.selector=new JSpinner(new SpinnerNumberModel(3,0,n,1));
		this.Observadores=new ArrayList();
		selector.addChangeListener(new ChangeListener(){
			@Override
			public void stateChanged(ChangeEvent e) {
				for(int i=0;i<Observadores.size();i++)
					Observadores.get(i).nuevoDia();
			}
		});
		this.add(new JLabel(nombre));
		this.add(selector);
	}
	
	public void addObservador(ReguladorListener dl){
		Observadores.add(dl);
	}
	
	public int getValor(){
		return (int) selector.getValue();
	}
	
	
	public static void main(String args[]){
		JFrame ventana=new JFrame("prueba");
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setContentPane(new Regulador("hola",8));
		ventana.setSize(800,600);
		ventana.setVisible(true);
	}
	
}
