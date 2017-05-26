package presentacion.vista.marketing.comprarreloj;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BotonesReloj extends JPanel{
	
	private static final long serialVersionUID = 2867316408569435159L;
	
	
	public BotonesReloj(ArrayList<InfoReloj> paquetes, ActionListener a) {
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		this.setSize(800, 600);
		this.setVisible(true);
		addButtons(paquetes,a);

	}
	
	private void addButtons(ArrayList<InfoReloj> paquetes, ActionListener a) {
		int rojo=250,verde = 230, azul = 80;
		for(int i=0;i<paquetes.size();++i){
			Color color = new Color(rojo,verde,azul);
			JButton button = new JButton(paquetes.get(i).toString());
			button.setPreferredSize(new Dimension (this.getWidth() - 50,30));
			button.setVisible(true);
			button.setAlignmentX(CENTER_ALIGNMENT);
			button.setBackground(color);
			button.addActionListener(a);
			this.add(button);
			this.add(Box.createRigidArea(new Dimension(0,10)));
			verde -=15;
			azul -= 10;
		}
	}

	
//	//Main para probar este panel de botones:
//	public static void main(String[] args) {
//		SwingUtilities.invokeLater(() -> 
//		{
//			JFrame testFrame = new JFrame("Probando el panel de botones 2");
//			testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//			testFrame.setSize(new Dimension(800, 600));
//			testFrame.setVisible(true);
//			
//			ArrayList<InfoReloj> paquetesReloj = new ArrayList<InfoReloj>();
//			paquetesReloj.add(new InfoReloj("Paquete Basico", 20, 9.99));
//			paquetesReloj.add(new InfoReloj("Paquete Intermedio", 50, 19.99));
//			paquetesReloj.add(new InfoReloj("Paquete Avanzado",100, 34.99));
//			paquetesReloj.add(new InfoReloj("Paquete Experto",250, 79.99));	
//			paquetesReloj.add(new InfoReloj("Paquete Viajero del Tiempo",500, 149.99));	
//			paquetesReloj.add(new InfoReloj("¡Oferta por tiempo limitado!",25, 9.99));	
//			
//			//BotonesReloj botones = new BotonesReloj (paquetesReloj);
//			//testFrame.add(botones);
//		});
//	}
}
