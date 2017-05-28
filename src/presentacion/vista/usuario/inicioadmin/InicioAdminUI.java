package presentacion.vista.usuario.inicioadmin;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import presentacion.controlador.GUIController;
import presentacion.controlador.inicioadmin.PrinciAdministradorEvent;
import presentacion.controlador.inicioadmin.PrinciAdministradorEvent.PrinciAdministradorType;
import presentacion.controlador.inicioadmin.PrinciAdministradorListenable;
import presentacion.controlador.inicioadmin.PrinciAdministradorListener;

/**
 * Pantalla de inicio de administrador
 */
public class InicioAdminUI extends JPanel implements PrinciAdministradorListenable{
	
	private static final long serialVersionUID = 4808370895498535774L;
	
	private ArrayList<PrinciAdministradorListener> listeners;
	/**
	 * este para las pruebas
	 * @param name
	 * @param numMensajes
	 * @param propuestos
	 * @param report
	 */
	
	private void notificar(PrinciAdministradorEvent e){
		for (int i = 0; i < listeners.size(); ++i)
			listeners.get(i).notificarPrinciAdministradorListener(e);
	}
	
//	@Override
//	  protected void paintComponent(Graphics g) {
//
//	    super.paintComponent(g);
//		Image img = null;
//		try {
//			img = ImageIO.read(getClass().getResource("/resources/fondo.png"));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	
//	        g.drawImage(img, 200, 200, null);
//	}
//	
	public InicioAdminUI(String name, int numMensajes, int propuestos, int report, GUIController controller){
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		this.setPreferredSize(new Dimension(800,600));
		listeners = new ArrayList<PrinciAdministradorListener>();
		addPrinciAdministradorListener(controller);
		
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north,BoxLayout.X_AXIS));
		
		JLabel nombre = new JLabel(name);
		nombre.setFont(new Font("",20,40));
		
		JButton volver = new JButton();
		volver.setIcon(new ImageIcon("src/resources/exit.png"));
		volver.setPreferredSize(new Dimension (50,50));
		volver.addActionListener((e)-> notificar(new PrinciAdministradorEvent(PrinciAdministradorType.Salir)));
		volver.setVisible(true);
		
		north.add(nombre);
		north.add(Box.createHorizontalGlue());
		north.add(volver);
		
		this.add(north);

		this.add(Box.createRigidArea(new Dimension(0,20)));
		
		this.add(new PanelGrande("Mensajes:", 
				new ImageIcon("src/resources/message.png"),
				report, new ActionListener(){
					public void actionPerformed(ActionEvent arg0) {
						notificar(new PrinciAdministradorEvent(PrinciAdministradorType.Mensajes));						
					}
		}));
		this.add(Box.createRigidArea(new Dimension(0,10)));
		this.add(new PanelGrande("Usuarios reportados:", 
				new ImageIcon("src/resources/reportar.png"),
				numMensajes, new ActionListener(){
					public void actionPerformed(ActionEvent arg0) {
						notificar(new PrinciAdministradorEvent(PrinciAdministradorType.Reportados));						
					}
		}));
		this.add(Box.createRigidArea(new Dimension(0,10)));
		this.add(new PanelGrande("Guiones propuestos:", 
				new ImageIcon("src/resources/exit-iloveimg-resized.png"),
				propuestos, new ActionListener(){
					public void actionPerformed(ActionEvent arg0) {
						notificar(new PrinciAdministradorEvent(PrinciAdministradorType.GuionesPropuestos));						
					}
		}));
		setOpaque(false);
		this.setBorder(new EmptyBorder(20,30,20,30));
	}
	
	public static void main(String args[]) throws IOException{
		JFrame ventana=new JFrame("prueba");
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setSize(800,650);
		BufferedImage img = ImageIO.read(InicioAdminUI.class.getResource("/resources/fondo.png"));
		ventana.setContentPane(new JLabel(new ImageIcon(img)));
		ventana.setLayout(new FlowLayout());
		ventana.add(new InicioAdminUI("peter", 10 ,1 ,5,new GUIController(null,null,null)));
		ventana.setVisible(true);
	}

	@Override
	public void addPrinciAdministradorListener(PrinciAdministradorListener p) {
		listeners.add(p);
	}
	
}
