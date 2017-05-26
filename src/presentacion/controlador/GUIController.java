package presentacion.controlador;

import java.awt.Dialog.ModalityType;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import negocio.SA_GameMastering;
import negocio.SA_Usuario;
import presentacion.modelo.GUIModelo;
import presentacion.modelo.gameMastering.Reporte;
import presentacion.modelo.juego.InfoGuion;
import presentacion.modelo.usuario.Jugador;
import presentacion.modelo.usuario.Usuario;
import presentacion.vista.gameMastering.ListaReportadosUI;
import presentacion.vista.usuario.ComprarNivelUI;
import presentacion.vista.usuario.ComprarNivelUI.ComprarNivelUIListener;
import presentacion.vista.usuario.IniciarSesionUI;
import presentacion.vista.usuario.InicioAdminUI;
import presentacion.vista.usuario.PrincipalUsuarioUI;
import presentacion.vista.usuario.RegistroUI;
import presentacion.vista.usuario.RegistroUI.RegistroUIListener;
import presentacion.vista.usuario.proponerguion.SugerenciaGuion;
import presentacion.vista.usuario.proponerguion.SugerenciaGuion.GuionListener;
import bbdd.Gestor;

public class GUIController implements IniSesionListener, PrinciUsuarioListener, PrinciAdministradorListener {

	private JFrame ventana;
	private GUIModelo modelo;
	private Gestor gestor;

	public GUIController(JFrame ventana, GUIModelo modelo, Gestor gestor) {
		this.ventana = ventana;
		this.modelo = modelo;
		this.gestor = gestor;
	}

	@Override
	public void notificarIniSesion(IniSesionEvent e) {
		if (e.getIniSesionType() == "IniciarSesion") {
			Usuario usuario = new SA_Usuario().iniciarSesion(gestor, e.getUsuario(), e.getContrasena());
			if (usuario != null) {
				modelo.setUsuario(usuario);
				ventana.getContentPane().removeAll();
				if (usuario.isAdmin()) {
					InicioAdminUI content = new InicioAdminUI(usuario.getId(), 1, 2, 3); //TODO Hacer que funcione dado un admin
					ventana.add(content);
					content.updateUI();
				}
				else {
					PrincipalUsuarioUI content = new PrincipalUsuarioUI((Jugador)usuario);
					content.addPrinciUsuarioListener(this);
					ventana.add(content);
					content.updateUI();
				}
				
			} else {
				JOptionPane.showMessageDialog(new JFrame(), "Usuario o password incorrectos", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		} else {
			JDialog fRegistro = new JDialog(ventana, ModalityType.DOCUMENT_MODAL);
			RegistroUI registro = new RegistroUI();
			registro.setRListener(new RegistroUIListener() {

				@Override
				public void registrarsePulsado() {
					String result = registro.todoCorrecto();
					if (result == null) {
						Usuario usuario = registro.getUsuarioCompleto();
						boolean OK = new SA_Usuario().agregarUsuario(gestor, usuario);
						if (OK) {
							JOptionPane.showMessageDialog(new JFrame(), "Usuario creado correctamente", "Exito",
									JOptionPane.INFORMATION_MESSAGE);
							fRegistro.dispose();
						} else
							JOptionPane.showMessageDialog(new JFrame(), "Nombre de usuario repetido", "Error",
									JOptionPane.ERROR_MESSAGE);
					}
					else {
						JOptionPane.showMessageDialog(new JFrame(), result, "Error", JOptionPane.WARNING_MESSAGE);
					}
				}

			});
			fRegistro.setSize(600, 508);
			fRegistro.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			fRegistro.setContentPane(registro);
			fRegistro.setVisible(true);
			fRegistro.setAlwaysOnTop(true);
		}
	}

	
	@Override
	public void notificarPrinciUsuario(PrinciUsuarioEvent e) {
		switch(e.getPrinciUsuarioType()){
		case "Salir":{
			//vuelve a IniciarSesionUI
			IniciarSesionUI content = new IniciarSesionUI(this);
			ventana.getContentPane().removeAll();
			ventana.add(content);
			content.updateUI();
			
		}break;
		case "comprarNivel":{
			JFrame compraDeNivel = new JFrame();
			compraDeNivel.setSize(250, 350);
			compraDeNivel.setVisible(true);
			compraDeNivel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			compraDeNivel.setContentPane(new ComprarNivelUI(new ComprarNivelUIListener(){
				@Override
				public void comprarPulsado(int nivel) {
					//Niveles del 1 al 4, falta almacenarlo de alguna forma
				}
				@Override
				public void salir() {
					compraDeNivel.dispose();
				}
			}));
		}break;
		
		case "proponerGuion":{
			SugerenciaGuion proponerGuion = new SugerenciaGuion(ventana);
			proponerGuion.setGListener(new GuionListener(){

				@Override
				public void recibirGuion() {
					InfoGuion guion = proponerGuion.getGuionCompleto();
				}
			});
		}break;
		
		
		}
	}
	
	public void closeGestor() {
		gestor.close();
	}

	@Override
	public void notificarPrinciAdministradorListener(PrinciAdministradorEvent e) {
		switch(e.getPrinciAdministradorType()){
		case "Salir":{
			//vuelve a IniciarSesionUI
			IniciarSesionUI content = new IniciarSesionUI(this);
			ventana.getContentPane().removeAll();
			ventana.add(content);
			content.updateUI();
			
		}break;
		case "Reportados":{
			ArrayList<Reporte> lista=(new SA_GameMastering().sacarReportados(gestor));
			String[][] devolver=new String[lista.size()][3];
			for(int i=0;i<lista.size();i++){
				//Se podria usar el patron adaptador y no pasar directamente a String.
				devolver[i][0]=lista.get(i).getReportador();
				devolver[i][1]=lista.get(i).getReportado();
				devolver[i][2]=lista.get(i).getFecha();
			}
			ListaReportadosUI listaReportados=new ListaReportadosUI(devolver);
			ventana.getContentPane().removeAll();
			ventana.add(listaReportados);
			listaReportados.updateUI();
		}break;
		
		case "mensajes":{
			ArrayList<GuionesPropuestos> lista=new SA_GameMastering().

				@Override
				public void recibirGuion() {
					InfoGuion guion = proponerGuion.getGuionCompleto();
				}
			});
		}break;
		case "a":{
			
		}
		
		}
	}

}
