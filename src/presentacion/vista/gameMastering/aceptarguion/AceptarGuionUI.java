package presentacion.vista.gameMastering.aceptarguion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import presentacion.modelo.juego.InfoGuion;
import presentacion.modelo.marketing.Tienda;

public class AceptarGuionUI extends JPanel{

	private static final long serialVersionUID = 3891324742744513990L;
	
	private AceptarGuionListener list;
	private JComboBox<Integer> niveles;
	
	public interface AceptarGuionListener {
		void aceptar(); 
		void rechazar();
		void salir();
	}
	
	public void setAGListener(AceptarGuionListener listener){
		this.list = listener;
	}
	
	public AceptarGuionUI(InfoGuion guion){
		
		JPanel todo = new JPanel();
		
		todo.setLayout(new BoxLayout(todo,BoxLayout.Y_AXIS));
		this.setPreferredSize(new Dimension(900,600));

		
		todo.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		  
		JLabel title = new JLabel("Guion propuesto por " + guion.getCreador().getId());
		title.setFont(new Font("",0,30));
		title.setAlignmentX(CENTER_ALIGNMENT);
		title.setMaximumSize(new Dimension(800,100));
		
		JPanel south = new JPanel();
		
		//panel superior para titulo, trama, bucles y subtrama
		PanelSup north = new PanelSup(guion);		
		
		//panel central para las incidencias y los personajes
		PanelCentral center = new PanelCentral(guion);
		
		//panel inferior para los botones
		south.setLayout(new BoxLayout(south,BoxLayout.X_AXIS));
		south.setPreferredSize(new Dimension(800,50));
		south.setBorder(new EmptyBorder(0,20,0,20));
		
		//combobox para seleccionar dificultad
		Integer[] valores = new Integer[Tienda.NIVEL];
		for(int i=0;i<Tienda.NIVEL;++i) valores[i] = i;
		
		niveles = new JComboBox<Integer>(valores);
		niveles.setMaximumSize(new Dimension(100,20));
		
		JLabel nivel = new JLabel("Nivel: ");
		JButton aceptar = new JButton("Aceptar"),
				rechazar = new JButton("Rechazar"),
				cancelar = new JButton("Cancelar");
		
		aceptar.setPreferredSize(new Dimension(100,30));
		rechazar.setPreferredSize(new Dimension(100,30));
		cancelar.setPreferredSize(new Dimension(100,30));
		
		aceptar.setBackground(new Color(150,200,150));
		rechazar.setBackground(new Color(250,70,50));
		cancelar.setBackground(new Color(250,70,50));
		
		aceptar.addActionListener((e)->{list.aceptar();});
		rechazar.addActionListener((e)->{list.rechazar();});
		cancelar.addActionListener((e)->{list.salir();});
		
		south.add(nivel);
		south.add(niveles);
		south.add(Box.createRigidArea(new Dimension(50,0)));
		south.add(aceptar);
		south.add(Box.createRigidArea(new Dimension(10,0)));
		south.add(rechazar);
		south.add(Box.createRigidArea(new Dimension(10,0)));
		south.add(cancelar);
		
		todo.add(title);
		todo.add(Box.createRigidArea(new Dimension(0,10)));
		todo.add(north);
		todo.add(Box.createVerticalGlue());
		todo.add(center);
		todo.add(Box.createVerticalGlue());
		todo.add(south);

		JPanel scroller = new JPanel();
		scroller.setLayout(new BorderLayout());
		scroller.add(new JScrollPane(todo));
		this.setLayout(new BorderLayout());
		this.add(scroller, BorderLayout.CENTER);
		
		todo.setBorder(new EmptyBorder(20, 20, 20, 20));
		
		this.setVisible(true);
	}
	
	public int getNivel(){
		return (int) niveles.getSelectedItem();
	}
}
