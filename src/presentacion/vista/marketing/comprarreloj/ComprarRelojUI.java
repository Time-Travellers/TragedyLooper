package presentacion.vista.marketing.comprarreloj;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Dialog.ModalityType;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import presentacion.controlador.ComprarRelojEvent;
import presentacion.controlador.ComprarRelojEvent.ComprarRelojType;

public class ComprarRelojUI extends JDialog{
	
	private static final long serialVersionUID = 3764237795715936211L;

	public interface ComprarRelojListener{
		void notificarComprarReloj(ComprarRelojEvent e);
	}
	
	private JButton verAnuncio;
	private BotonesReloj botones;
	private JButton cancelar;
	private ArrayList<ComprarRelojListener> listeners;
	
	public ComprarRelojUI(JFrame jc, ArrayList<InfoReloj> paquetes /*, GUIController controller*/){
		super(jc, "Tienda de relojes", ModalityType.DOCUMENT_MODAL);

		JPanel container = new JPanel();
		container.setLayout(new BoxLayout(container,BoxLayout.Y_AXIS));
		
		//listeners.add(controller);
		
		//botones de comprar reloj con dinero
		ActionListener comprar = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < listeners.size(); ++i)
					listeners.get(i).notificarComprarReloj(new ComprarRelojEvent(ComprarRelojType.Comprar));
			}
		};
		
		botones = new BotonesReloj(paquetes,comprar);
		
		//boton de comprar reloj viendo anuncios
		verAnuncio = new JButton("1 reloj (Ver anuncio)");
		verAnuncio.setPreferredSize(new Dimension (botones.getWidth() - 50,30));
		verAnuncio.setVisible(true);
		verAnuncio.setBackground(new Color(250,250,100));
		verAnuncio.setAlignmentX(CENTER_ALIGNMENT);
		verAnuncio.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < listeners.size(); ++i)
					listeners.get(i).notificarComprarReloj(new ComprarRelojEvent(ComprarRelojType.VerAnuncio));
			}
		});
		
		//boton cancelar
		cancelar = new JButton("Cancelar");
		cancelar.setBackground(new Color(250,50,50));
		cancelar.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		cancelar.setAlignmentX(RIGHT_ALIGNMENT);
		
		JPanel south = new JPanel();
		south.setLayout(new FlowLayout(FlowLayout.RIGHT));
		south.add(cancelar);
		
		container.add(verAnuncio);
		container.add(Box.createRigidArea(new Dimension(0,10)));
		container.add(botones);
		container.add(Box.createRigidArea(new Dimension(0,20)));
		container.add(south,BorderLayout.SOUTH);
		container.setBorder(new EmptyBorder(20, 20, 20, 20));
		this.add(container);
		
		this.setAlwaysOnTop(true);
		this.pack();
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	//	this.getContentPane().setBackground(new Color(150,150,150));
		this.setVisible(true);
	}
	
	public static void main(String args[]){

		ArrayList<InfoReloj> paquetesReloj = new ArrayList<InfoReloj>();
		paquetesReloj.add(new InfoReloj("Paquete Basico", 20, 9.99));
		paquetesReloj.add(new InfoReloj("Paquete Intermedio", 50, 19.99));
		paquetesReloj.add(new InfoReloj("Paquete Avanzado",100, 34.99));
		paquetesReloj.add(new InfoReloj("Paquete Experto",250, 79.99));	
		paquetesReloj.add(new InfoReloj("Paquete Viajero del Tiempo",500, 149.99));	
		paquetesReloj.add(new InfoReloj("¡Oferta por tiempo limitado!",25, 9.99));	
		
		ComprarRelojUI a =new ComprarRelojUI(null,paquetesReloj);
		a.setSize(800,600);
	}
}
