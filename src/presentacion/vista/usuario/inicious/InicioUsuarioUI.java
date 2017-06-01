package presentacion.vista.usuario.inicious;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import presentacion.controlador.principalus.InicioUsuarioListenable;
import presentacion.controlador.principalus.InicioUsuarioListener;
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
	public void addPrinciUsuarioListener(InicioUsuarioListener list) {
		this.listeners.add(list);
	}

}
