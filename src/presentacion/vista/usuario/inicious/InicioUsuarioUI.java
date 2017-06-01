package presentacion.vista.usuario.inicious;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import presentacion.controlador.iniciousuario.InicioUsuarioListenable;
import presentacion.controlador.iniciousuario.InicioUsuarioListener;
import presentacion.modelo.usuario.Jugador;

public class InicioUsuarioUI extends JPanel implements InicioUsuarioListenable{
	
	private static final long serialVersionUID = 7527554039049217535L;
	
	private Tienda paneltienda;
	private TablaPartidas tabla;
	private Contacto panelcontacto;
	private ArrayList<InicioUsuarioListener> listeners;
	private Jugador j;

	public InicioUsuarioUI(Jugador j){
		listeners = new ArrayList<InicioUsuarioListener>();
		this.j = j;
		initGUI();
	}
	
	public void initGUI() {
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
		
		this.paneltienda=new Tienda(j,listeners);
		
		this.tabla=new TablaPartidas();
		this.panelcontacto=new Contacto(listeners);

		JPanel paneldeabajo=new JPanel();
		paneldeabajo.setLayout(new FlowLayout(FlowLayout.CENTER,20,0));
		paneldeabajo.add(paneltienda);
		//paneldeabajo.add(Box.createRigidArea(new Dimension(10,0)));
		paneldeabajo.add(panelcontacto);
		
		JPanel todo = new JPanel();
		todo.setLayout(new BoxLayout(todo, BoxLayout.Y_AXIS));
		todo.add(panelSup);
		todo.add(tabla);
		todo.add(new Botones2(listeners));
		todo.add(paneldeabajo);
		
		todo.setBorder(new EmptyBorder(20, 20, 20, 20));

		JPanel scroller = new JPanel();
		scroller.setLayout(new BorderLayout());
		scroller.add(new JScrollPane(todo));
		this.setLayout(new BorderLayout());
		this.add(scroller);
		this.setVisible(true);
		
		
	}

	@Override
	public void addPrinciUsuarioListener(InicioUsuarioListener list) {
		this.listeners.add(list);
	}

}
