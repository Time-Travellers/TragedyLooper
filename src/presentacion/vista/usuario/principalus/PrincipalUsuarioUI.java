package presentacion.vista.usuario.principalus;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bbdd.Gestor;
import presentacion.controlador.GUIController;
import presentacion.controlador.principalus.PrinciUsuarioListenable;
import presentacion.controlador.principalus.PrinciUsuarioListener;
import presentacion.modelo.usuario.Jugador;

public class PrincipalUsuarioUI extends JPanel implements PrinciUsuarioListenable{
	
	private static final long serialVersionUID = 7527554039049217535L;
	
	private Tienda paneltienda;
	private TablaPartidas tabla;
	private Contacto panelcontacto;
	private ArrayList<PrinciUsuarioListener> listeners;
	
//	private void notificar(PrinciUsuarioEvent e){
//		Logger.getLogger("log").info("Notificado PrinciUsuarioEvent de tipo " + e.getPrinciUsuarioType());
//		for (int i = 0; i < listeners.size(); ++i)
//			listeners.get(i).notificarPrinciUsuario(e);
//	}
//	
	public PrincipalUsuarioUI(Jugador j, GUIController controller){
		listeners = new ArrayList<PrinciUsuarioListener>();
		addPrinciUsuarioListener(controller);
		
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		//panel superior
		JPanel panelSup = new JPanel();
		
		//nombre del jugador
		JLabel username = new JLabel(j.getDatos().getNombre());
		username.setFont(new Font("", Font.BOLD, 40));
		panelSup.setLayout(new BoxLayout(panelSup,BoxLayout.X_AXIS));
		panelSup.setPreferredSize(new Dimension(this.getWidth(),100));
		panelSup.add(username);
		//botones ajustes
		Botones botones =new Botones(listeners);
		panelSup.add(botones);

		//panelSup.setBorder(BorderFactory.createLineBorder(Color.black));
		
		this.paneltienda=new Tienda(j,listeners);
		
		this.tabla=new TablaPartidas();
		this.panelcontacto=new Contacto(listeners);

		JPanel paneldeabajo=new JPanel();
		paneldeabajo.setLayout(new FlowLayout(FlowLayout.CENTER,20,0));
		paneldeabajo.add(paneltienda);
		//paneldeabajo.add(Box.createRigidArea(new Dimension(10,0)));
		paneldeabajo.add(panelcontacto);
		
		this.add(panelSup);
		this.add(tabla);
		this.add(new Botones2(listeners));
		this.add(paneldeabajo);

		this.setBorder(new EmptyBorder(20, 20, 20, 20));
	}
	

	@Override
	public void addPrinciUsuarioListener(PrinciUsuarioListener list) {
		this.listeners.add(list);
	}
	
	public static void main(String args[]){
		JFrame ventana=new JFrame("Tragedy Looper");
		ventana.setSize(1024, 768);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GUIController controller = new GUIController(ventana,null,new Gestor());
		ventana.setContentPane(new PrincipalUsuarioUI(new Jugador("Prueba", "Prueba", false, "Prueba", 0, null, "Prueba"),controller));
		ventana.setVisible(true);
	}

}
