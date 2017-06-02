package presentacion.vista.usuario.inicioadmin;

import java.awt.BorderLayout;
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
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import presentacion.controlador.inicioadmin.InicioAdministradorEvent;
import presentacion.controlador.inicioadmin.InicioAdministradorListenable;
import presentacion.controlador.inicioadmin.InicioAdministradorListener;
import presentacion.controlador.inicioadmin.InicioAdministradorEvent.PrinciAdministradorType;

/**
 * Pantalla de inicio de administrador
 */
public class InicioAdminUI extends JPanel implements InicioAdministradorListenable{
	
	private static final long serialVersionUID = 4808370895498535774L;
	
	private ArrayList<InicioAdministradorListener> listeners;
	
	private void notificar(InicioAdministradorEvent e){
		for (int i = 0; i < listeners.size(); ++i)
			listeners.get(i).notificarPrinciAdministradorListener(e);
	}
	
	public InicioAdminUI(String name, int numMensajes, int propuestos, int report){
		JPanel todo = new JPanel();
		todo.setLayout(new BoxLayout(todo,BoxLayout.Y_AXIS));
		todo.setPreferredSize(new Dimension(800,600));
		listeners = new ArrayList<InicioAdministradorListener>();
		
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north,BoxLayout.X_AXIS));
		
		JLabel nombre = new JLabel(name);
		nombre.setFont(new Font("",20,40));
		
		JButton volver = new JButton();
		volver.setIcon(new ImageIcon(getClass().getClassLoader().getResource("resources/exit.png")));
		volver.setPreferredSize(new Dimension (50,50));
		volver.addActionListener((e)-> notificar(new InicioAdministradorEvent(PrinciAdministradorType.Salir)));
		volver.setVisible(true);
		
		north.add(nombre);
		north.add(Box.createHorizontalGlue());
		north.add(volver);
		
		todo.add(north);

		todo.add(Box.createRigidArea(new Dimension(0,20)));
		
		todo.add(new PanelGrande("Mensajes:", 
				new ImageIcon(getClass().getClassLoader().getResource("resources/message.png")),
				numMensajes, new ActionListener(){
					public void actionPerformed(ActionEvent arg0) {
						notificar(new InicioAdministradorEvent(PrinciAdministradorType.Mensajes));						
					}
		}));
		todo.add(Box.createRigidArea(new Dimension(0,10)));
		todo.add(new PanelGrande("Usuarios reportados:", 
				new ImageIcon(getClass().getClassLoader().getResource("resources/reportar.png")),
				report, new ActionListener(){
					public void actionPerformed(ActionEvent arg0) {
						notificar(new InicioAdministradorEvent(PrinciAdministradorType.Reportados));						
					}
		}));
		todo.add(Box.createRigidArea(new Dimension(0,10)));
		todo.add(new PanelGrande("Guiones propuestos:", 
				new ImageIcon(getClass().getClassLoader().getResource("resources/guion.png")),
				propuestos, new ActionListener(){
					public void actionPerformed(ActionEvent arg0) {
						notificar(new InicioAdministradorEvent(PrinciAdministradorType.GuionesPropuestos));						
					}
		}));
		
		todo.setOpaque(false);
		
		JPanel scroller = new JPanel();
		scroller.setLayout(new BorderLayout());
		scroller.add(new JScrollPane(todo));
		this.setLayout(new BorderLayout());
		this.add(scroller);
		this.setVisible(true);
		setOpaque(false);
		todo.setBorder(new EmptyBorder(20,30,20,30));
		
	}

	@Override
	public void addPrinciAdministradorListener(InicioAdministradorListener p) {
		listeners.add(p);
	}
	
}
