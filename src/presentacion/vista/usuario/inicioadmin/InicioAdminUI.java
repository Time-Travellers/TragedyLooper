package presentacion.vista.usuario.inicioadmin;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import presentacion.controlador.inicioadmin.PrinciAdministradorEvent;
import presentacion.controlador.inicioadmin.PrinciAdministradorListenable;
import presentacion.controlador.inicioadmin.PrinciAdministradorListener;
import presentacion.controlador.inicioadmin.PrinciAdministradorEvent.PrinciAdministradorType;

/**
 * Pantalla de inicio de administrador
 */
public class InicioAdminUI extends JPanel implements PrinciAdministradorListenable{
	
	private static final long serialVersionUID = 4808370895498535774L;
	
	private ArrayList<PrinciAdministradorListener> listeners;
	
	private void notificar(PrinciAdministradorEvent e){
		for (int i = 0; i < listeners.size(); ++i)
			listeners.get(i).notificarPrinciAdministradorListener(e);
	}
	
	public InicioAdminUI(String name, int numMensajes, int propuestos, int report){
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		this.setPreferredSize(new Dimension(800,600));
		listeners = new ArrayList<PrinciAdministradorListener>();
		
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north,BoxLayout.X_AXIS));
		
		JLabel nombre = new JLabel(name);
		nombre.setFont(new Font("",20,40));
		
		JButton volver = new JButton();
		volver.setIcon(new ImageIcon(getClass().getClassLoader().getResource("resources/exit.png")));
		volver.setPreferredSize(new Dimension (50,50));
		volver.addActionListener((e)-> notificar(new PrinciAdministradorEvent(PrinciAdministradorType.Salir)));
		volver.setVisible(true);
		
		north.add(nombre);
		north.add(Box.createHorizontalGlue());
		north.add(volver);
		
		this.add(north);

		this.add(Box.createRigidArea(new Dimension(0,20)));
		
		this.add(new PanelGrande("Mensajes:", 
				new ImageIcon(getClass().getClassLoader().getResource("resources/message.png")),
				report, new ActionListener(){
					public void actionPerformed(ActionEvent arg0) {
						notificar(new PrinciAdministradorEvent(PrinciAdministradorType.Mensajes));						
					}
		}));
		this.add(Box.createRigidArea(new Dimension(0,10)));
		this.add(new PanelGrande("Usuarios reportados:", 
				new ImageIcon(getClass().getClassLoader().getResource("resources/reportar.png")),
				numMensajes, new ActionListener(){
					public void actionPerformed(ActionEvent arg0) {
						notificar(new PrinciAdministradorEvent(PrinciAdministradorType.Reportados));						
					}
		}));
		this.add(Box.createRigidArea(new Dimension(0,10)));
		this.add(new PanelGrande("Guiones propuestos:", 
				new ImageIcon(getClass().getClassLoader().getResource("resources/guion.png")),
				propuestos, new ActionListener(){
					public void actionPerformed(ActionEvent arg0) {
						notificar(new PrinciAdministradorEvent(PrinciAdministradorType.GuionesPropuestos));						
					}
		}));
		setOpaque(false);
		this.setBorder(new EmptyBorder(20,30,20,30));
	}
	

	@Override
	public void addPrinciAdministradorListener(PrinciAdministradorListener p) {
		listeners.add(p);
	}
	
}
