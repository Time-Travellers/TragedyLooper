package presentacion.vista.usuario;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ComprarNivelUI extends JPanel {
	
	//Interfaz a implementar si se quieren insertar listeners:
	public interface ComprarNivelUIListener {
		void comprarPulsado(int nivel); //nivel del 1 al 4 elegido
		void salir();
	}
	
	private int nivel;
	private ComprarNivelUIListener list;
	
	public ComprarNivelUI (ComprarNivelUIListener list){
		this.list = list;
		iniciarGUI(this);
	}
	
	void iniciarGUI(JPanel panel){
		JButton nivel1 =  new JButton("Comprar - Nivel 1");
		nivel1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				list.comprarPulsado(1);
			}
		});
		JButton nivel2 =  new JButton("Comprar - Nivel 2");
		nivel2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				list.comprarPulsado(2);
			}
		});
		JButton nivel3 =  new JButton("Comprar - Nivel 3");
		nivel3.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				list.comprarPulsado(3);
			}
		});
		JButton nivel4 =  new JButton("Comprar - Nivel 4");
		nivel4.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				list.comprarPulsado(4);
			}
		});
		
		JButton salir =  new JButton("Salir");
		nivel4.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				list.salir();
			}
		});
		
		
		
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.add(Box.createRigidArea(new Dimension(25,25)));
		panel.add(new JLabel("Compra de niveles"));
		panel.add(Box.createRigidArea(new Dimension(25,30)));
		panel.add(nivel1);
		panel.add(Box.createRigidArea(new Dimension(25,10)));
		panel.add(nivel2);
		panel.add(Box.createRigidArea(new Dimension(25,10)));
		panel.add(nivel3);
		panel.add(Box.createRigidArea(new Dimension(25,10)));
		panel.add(nivel4);
		panel.add(Box.createRigidArea(new Dimension(25,30)));
		panel.add(salir);

	}
	
	
	
	public static void main(String[] args){
		JFrame frame = new JFrame("test");
		frame.setSize(250, 350);
		frame.setContentPane(new ComprarNivelUI(null));
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}
}
