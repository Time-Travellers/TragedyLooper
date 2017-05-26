package presentacion.vista.usuario.inicioadmin;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
/**
 * Simplemente para reciclar codigo
 * @author jfiwj
 *
 */
public class PanelUtil extends JPanel{
	public PanelUtil(String nombre, int numero){
		String no="";
		FlowLayout lay=new FlowLayout();
		//lay.setHgap(150);
		lay.setAlignment(FlowLayout.CENTER);
		this.setLayout(lay);
		
		this.add(new JLabel(nombre));
		this.add(new JLabel("              "));
		this.add(new JLabel(no+numero+" pendientes"));
		this.setPreferredSize(new Dimension(400,50));
		this.setMinimumSize(new Dimension(400,50));
		this.setMaximumSize(new Dimension(400,50));
		this.setBackground(new Color(100,190,250));
	}
	public static void main(String args[]){
		JFrame ventana=new JFrame("prueba");
		ventana.setLayout(new GridBagLayout());
		ventana.setSize(800,600);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setContentPane(new PanelUtil("HolaMundo", 100));
		ventana.setVisible(true);
	}
}
