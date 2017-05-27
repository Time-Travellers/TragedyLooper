package presentacion.controlador;

import java.awt.Dialog.ModalityType;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


import bbdd.Gestor;
import negocio.SA_Juego;
import negocio.SA_GameMastering;
import negocio.SA_Usuario;
import presentacion.modelo.GUIModelo;
import presentacion.modelo.gameMastering.Reporte;
import presentacion.modelo.juego.InfoGuion;
import presentacion.modelo.usuario.Jugador;
import presentacion.modelo.usuario.Usuario;
import presentacion.vista.gameMastering.ListaReportadosUI;
import presentacion.vista.marketing.comprarnivel.ComprarNivelUI;
import presentacion.vista.marketing.comprarnivel.ComprarNivelUI.ComprarNivelUIListener;
import presentacion.vista.marketing.comprarreloj.ComprarRelojUI;
import presentacion.vista.marketing.comprarreloj.InfoReloj;
import presentacion.vista.usuario.buscar.BuscadorUI;
import presentacion.vista.usuario.buscar.BuscadorUI.BuscadorUIListener;
import presentacion.vista.usuario.iniciarsesion.IniciarSesionUI;
import presentacion.vista.usuario.inicioadmin.InicioAdminUI;
import presentacion.vista.usuario.perfilus.PerfilUsuario;
import presentacion.vista.usuario.principalus.PrincipalUsuarioUI;
import presentacion.vista.usuario.proponerguion.SugerenciaGuion;
import presentacion.vista.usuario.proponerguion.SugerenciaGuion.GuionListener;
import presentacion.vista.usuario.registro.RegistroUI;
import presentacion.vista.usuario.registro.RegistroUI.RegistroUIListener;

public class GUIController implements IniSesionListener, PrinciUsuarioListener, PrinciAdministradorListener {

	private JFrame ventana;
	private GUIModelo modelo;
	private Gestor gestor;

	public GUIController(JFrame ventana, GUIModelo modelo, Gestor gestor) {
		this.ventana = ventana;
		this.modelo = modelo;
		this.gestor = gestor;
	}
	
	
	public void closeGestor() {
		gestor.close();
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
			JDialog fRegistro = new JDialog(ventana, "Registrarse", ModalityType.DOCUMENT_MODAL);
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
		
//		case "proponerGuion":{
//			JDialog dGuion = new JDialog(ventana, "Proponer Guion", ModalityType.DOCUMENT_MODAL);
//			SugerenciaGuion proponerGuion = new SugerenciaGuion();
//			proponerGuion.setGListener(new GuionListener(){
//				@Override
//				public void recibirGuion() {
//					InfoGuion guion = proponerGuion.getGuionCompleto();
//					new SA_Juego().proponerGuion(gestor, guion);
//						JOptionPane.showMessageDialog(new JFrame(), "Guion enviado correctamente", "Exito",
//								JOptionPane.INFORMATION_MESSAGE);
//						dGuion.dispose();
//				}
//				@Override
//				public void salir(){
//					dGuion.dispose();
//				}
//				
//			});
//			dGuion.setSize(800, 600);
//			dGuion.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dGuion.setContentPane(proponerGuion);
//			dGuion.setVisible(true);
//			dGuion.setAlwaysOnTop(true);
//			
//		}break;
		
		case "miPerfil":{
			PerfilUsuario content = new PerfilUsuario(e.getJugador());
			ventana.getContentPane().removeAll();
			ventana.add(content);
			content.updateUI();
			
		}break;
		
//		case "BuscarUsuario":{
//			BuscadorUI content = new BuscadorUI(new BuscadorUIListener(){
//				@Override
//				public void buscarPulsado(String usuario) {
//					// TODO Auto-generated method stub
//				}
//				@Override
//				public void agregarPulsado(String usuario) {
//					// TODO Auto-generated method stub
//				}
//				@Override
//				public void reportarPulsado(String usuario) {
//					// TODO Auto-generated method stub	
//				}
//			});
//			JFrame Buscador = new JFrame();
//			Buscador.setSize(250, 350);
//			Buscador.setVisible(true);
//			Buscador.setContentPane(content);
//		}break;
		
		case "comprarRelojes":{
			//prueba
			ArrayList<InfoReloj> paquetesReloj = new ArrayList<InfoReloj>();
			paquetesReloj.add(new InfoReloj("Paquete Basico", 20, 9.99));
			paquetesReloj.add(new InfoReloj("Paquete Intermedio", 50, 19.99));
			paquetesReloj.add(new InfoReloj("Paquete Avanzado",100, 34.99));
			paquetesReloj.add(new InfoReloj("Paquete Experto",250, 79.99));	
			paquetesReloj.add(new InfoReloj("Paquete Viajero del Tiempo",500, 149.99));	
			paquetesReloj.add(new InfoReloj("¡Oferta por tiempo limitado!",25, 9.99));	
			
			ComprarRelojUI a =new ComprarRelojUI(null,paquetesReloj);
			a.setSize(800,600);
			
		}break;
		
		}
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
		}
	}
}