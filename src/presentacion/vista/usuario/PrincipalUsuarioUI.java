package presentacion.vista.usuario;

import java.awt.Font;
import java.util.ArrayList;
import java.util.logging.Logger;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import presentacion.controlador.PrinciUsuarioEvent;
import presentacion.controlador.PrinciUsuarioEvent.PrinciUsuarioType;
import presentacion.controlador.PrinciUsuarioListenable;
import presentacion.controlador.PrinciUsuarioListener;
import presentacion.modelo.usuario.Jugador;

public class PrincipalUsuarioUI extends JPanel implements PrinciUsuarioListenable{
	
	private static final long serialVersionUID = 7527554039049217535L;
	
	Botones botonera1;
	Botones2 botonera2;
	Tienda paneltienda;
	TablaPartidas tabla;
	Contacto panelcontacto;
	ArrayList<PrinciUsuarioListener> listeners;
	
	private void notificar(PrinciUsuarioEvent e){
		Logger.getLogger("log").info("Notificado PrinciUsuarioEvent de tipo " + e.getPrinciUsuarioType());
		for (int i = 0; i < listeners.size(); ++i)
			listeners.get(i).notificarPrinciUsuario(e);
	}
	
	public PrincipalUsuarioUI(Jugador j){
		listeners = new ArrayList<PrinciUsuarioListener>();
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		JPanel panelSup = new JPanel();
		JLabel username = new JLabel(j.getDatos().getNombre());
		username.setFont(new Font("", 30, 30));
		panelSup.add(username);
		this.botonera1 = new Botones(new BotonesListener(){
			@Override
			public void buscarUsuario() {
				notificar(new PrinciUsuarioEvent(PrinciUsuarioType.BuscarUsuario));
			}
			@Override
			public void ajustes() {
				notificar(new PrinciUsuarioEvent(PrinciUsuarioType.Ajustes));
			}
			@Override
			public void ayuda() {
				notificar(new PrinciUsuarioEvent(PrinciUsuarioType.Ayuda));
			}
			@Override
			public void salir() {
				notificar(new PrinciUsuarioEvent(PrinciUsuarioType.Salir));
			}
		});
		panelSup.add(this.botonera1);
		this.botonera2=new Botones2(new Botones2Listener(){
			@Override
			public void iniciarPartida() {
				notificar(new PrinciUsuarioEvent(PrinciUsuarioType.IniciarPartida));
			}
			@Override
			public void miPerfil() {
				notificar(new PrinciUsuarioEvent(PrinciUsuarioType.Ajustes));
			}

			@Override
			public void verRanking() {
				notificar(new PrinciUsuarioEvent(PrinciUsuarioType.verRanking));
			}
		});
		this.paneltienda=new Tienda(j.getReloj(), j.getNivel(), new TiendaListener(){
			@Override
			public void comprarRelojes() {
				notificar(new PrinciUsuarioEvent(PrinciUsuarioType.comprarRelojes));
			}
			@Override
			public void comprarNivel() {
				notificar(new PrinciUsuarioEvent(PrinciUsuarioType.comprarNivel));
			}
		});
		
		this.tabla=new TablaPartidas();
		this.panelcontacto=new Contacto(new ContactoListener(){
			@Override
			public void sugerencias() {
				notificar(new PrinciUsuarioEvent(PrinciUsuarioType.sugerencias));
				
			}
			@Override
			public void proponerGuion() {
				notificar(new PrinciUsuarioEvent(PrinciUsuarioType.proponerGuion));
			}
		});
		
		this.add(panelSup);
		this.add(new JLabel(" "));
		this.add(tabla);
		this.add(new JLabel(" "));
		this.add(botonera2);
		this.add(new JLabel(" "));
		JPanel paneldeabajo=new JPanel();
		paneldeabajo.add(paneltienda);
		paneldeabajo.add(panelcontacto);
		this.add(paneldeabajo);
	}
	

	@Override
	public void addPrinciUsuarioListener(PrinciUsuarioListener list) {
		this.listeners.add(list);
	}
	
	public static void main(String args[]){
		JFrame ventana=new JFrame("Tragedy Looper");
		ventana.setSize(1024, 768);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setContentPane(new PrincipalUsuarioUI(new Jugador("Prueba", "Prueba", false, "Prueba", 0, null, "Prueba")));
		ventana.setVisible(true);
	}

}
