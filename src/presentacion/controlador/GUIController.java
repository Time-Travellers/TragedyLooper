package presentacion.controlador;

import java.awt.Dialog.ModalityType;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.logging.Logger;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import bbdd.Gestor;
import negocio.SA_Juego;
import negocio.SA_Marketing;
import negocio.SA_GameMastering;
import negocio.SA_Usuario;
import presentacion.controlador.comprarreloj.ComprarRelojEvent;
import presentacion.controlador.comprarreloj.ComprarRelojListener;
import presentacion.controlador.iniciarsesion.IniSesionEvent;
import presentacion.controlador.iniciarsesion.IniSesionListener;
import presentacion.controlador.inicioadmin.PrinciAdministradorEvent;
import presentacion.controlador.inicioadmin.PrinciAdministradorListener;
import presentacion.controlador.principalus.PrinciUsuarioEvent;
import presentacion.controlador.principalus.PrinciUsuarioListener;
import presentacion.modelo.GUIModelo;
import presentacion.modelo.gameMastering.Reporte;
import presentacion.modelo.juego.InfoGuion;
import presentacion.modelo.marketing.InfoNivel;
import presentacion.modelo.marketing.Tienda;
import presentacion.modelo.usuario.Jugador;
import presentacion.modelo.usuario.Usuario;
import presentacion.vista.gameMastering.ListaPropuestosUI;
import presentacion.vista.gameMastering.ListaReportadosUI;
import presentacion.vista.marketing.comprarnivel.ComprarNivelUI;
import presentacion.vista.marketing.comprarnivel.ComprarNivelUI.ComprarNivelUIListener;
import presentacion.vista.marketing.comprarreloj.ComprarRelojUI;
import presentacion.vista.usuario.buscar.BuscadorUI;
import presentacion.vista.usuario.buscar.BuscadorUI.BuscadorUIListener;
import presentacion.vista.usuario.iniciarsesion.IniciarSesionUI;
import presentacion.vista.usuario.inicioadmin.InicioAdminUI;
import presentacion.vista.usuario.perfilus.PerfilUsuario;
import presentacion.vista.usuario.principalus.MostrarAyuda;
import presentacion.vista.usuario.principalus.PrincipalUsuarioUI;
import presentacion.vista.usuario.proponerguion.SugerenciaGuion;
import presentacion.vista.usuario.proponerguion.SugerenciaGuion.GuionListener;
import presentacion.vista.usuario.registro.RegistroUI;
import presentacion.vista.usuario.registro.RegistroUI.RegistroUIListener;

public class GUIController implements IniSesionListener, PrinciUsuarioListener,
		PrinciAdministradorListener, ComprarRelojListener {

	private JFrame ventana;
	private GUIModelo modelo;
	private static Gestor gestor;

	public GUIController(JFrame ventana) {
		this.ventana = ventana;
		this.modelo = new GUIModelo();
	}

	public static void setGestor(Gestor g) {
		GUIController.gestor = g;
	}

	public void closeGestor() {
		gestor.close();
	}

	@Override
	public void notificarIniSesion(IniSesionEvent e) {
		if (e.getIniSesionType() == "IniciarSesion") {
			Usuario usuario = new SA_Usuario().iniciarSesion(gestor,
					e.getUsuario(), e.getContrasena());
			if (usuario != null) {
				modelo.setUsuario(usuario);
				ventana.getContentPane().removeAll();
				if (usuario.isAdmin()) {
					InicioAdminUI content = new InicioAdminUI(usuario.getId(),
							1, 2, 3, this);
					ventana.add(content);
					content.updateUI();
				} else {
					PrincipalUsuarioUI content = new PrincipalUsuarioUI(
							(Jugador) usuario);
					content.addPrinciUsuarioListener(this);
					ventana.add(content);
					content.updateUI();
				}

			} else {
				JOptionPane.showMessageDialog(new JFrame(),
						"Usuario o password incorrectos", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		} else {
			JDialog fRegistro = new JDialog(ventana, "Registrarse",
					ModalityType.DOCUMENT_MODAL);
			RegistroUI registro = new RegistroUI();
			registro.setRListener(new RegistroUIListener() {

				@Override
				public void registrarsePulsado() {
					String result = registro.todoCorrecto();
					if (result == null) {
						Usuario usuario = registro.getUsuarioCompleto();
						boolean OK = new SA_Usuario().agregarUsuario(gestor,
								usuario);
						if (OK) {
							JOptionPane.showMessageDialog(new JFrame(),
									"Usuario creado correctamente", "Exito",
									JOptionPane.INFORMATION_MESSAGE);
							fRegistro.dispose();
						} else
							JOptionPane.showMessageDialog(new JFrame(),
									"Nombre de usuario repetido", "Error",
									JOptionPane.ERROR_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(new JFrame(), result,
								"Error", JOptionPane.WARNING_MESSAGE);
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
		switch (e.getPrinciUsuarioType()) {
		case "Salir": {
			// vuelve a IniciarSesionUI
			IniciarSesionUI content = new IniciarSesionUI(this);
			ventana.getContentPane().removeAll();
			ventana.add(content);
			content.updateUI();

		}
			break;
		case "comprarNivel": {
			if (e.getJugador().getNivel() != Tienda.NIVEL) {
				Tienda tienda = new SA_Marketing().iniciarTienda(gestor);
				InfoNivel nivel = tienda.getPaquetesNivel().get(
						e.getJugador().getNivel());
				JDialog dCompra = new JDialog(ventana, "Compra nivel",
						ModalityType.DOCUMENT_MODAL);

				ComprarNivelUI compraNivel = new ComprarNivelUI(nivel);
				compraNivel.setNivelListener(new ComprarNivelUIListener() {

					@Override
					public void confirmar() {
						if (e.getJugador().comprarNivel(nivel))
							JOptionPane.showConfirmDialog(null,
									"Compra con exito!", "Compra nivel",
									JOptionPane.PLAIN_MESSAGE,
									JOptionPane.OK_OPTION);
						else
							JOptionPane.showConfirmDialog(null,
									"No tienes suficientes relojes",
									"Compra nivel", JOptionPane.ERROR_MESSAGE,
									JOptionPane.OK_OPTION);

					}

					@Override
					public void salir() {
						dCompra.dispose();
					}

				});

				dCompra.setSize(800, 600);
				dCompra.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dCompra.setContentPane(compraNivel);
				dCompra.setVisible(true);
				dCompra.setAlwaysOnTop(true);
			} else {
				JOptionPane.showConfirmDialog(null,
						"Lo sentimos, no hay mas niveles disponibles",
						"Compra nivel", JOptionPane.ERROR_MESSAGE,
						JOptionPane.OK_OPTION);
			}
		}
			break;

		case "proponerGuion": {
			JDialog dGuion = new JDialog(ventana, "Proponer Guion",
					ModalityType.DOCUMENT_MODAL);
			SugerenciaGuion proponerGuion = new SugerenciaGuion();
			proponerGuion.setGListener(new GuionListener() {
				@Override
				public void recibirGuion() {
					InfoGuion guion = proponerGuion.getGuionCompleto();
					new SA_Juego().proponerGuion(gestor, guion);
					JOptionPane.showMessageDialog(new JFrame(),
							"Guion enviado correctamente", "Exito",
							JOptionPane.INFORMATION_MESSAGE);
					dGuion.dispose();
				}
				@Override
				public void salir() {
					dGuion.dispose();
				}
				@Override
				public String idRegistrado() {
					return modelo.getIdUsuario();
				}

			});
			dGuion.setSize(800, 600);
			dGuion.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dGuion.setContentPane(proponerGuion);
			dGuion.setVisible(true);
			dGuion.setAlwaysOnTop(true);

		}
			break;

		case "miPerfil": {
			PerfilUsuario content = new PerfilUsuario(e.getJugador());
			ventana.getContentPane().removeAll();
			ventana.add(content);
			content.updateUI();

		}
			break;

		case "BuscarUsuario": {
			BuscadorUI content = new BuscadorUI(new BuscadorUIListener() {
				@Override
				public void buscarPulsado(String usuario) {
					// TODO Auto-generated method stub
				}

				@Override
				public void agregarPulsado(String usuario) {
					// TODO Auto-generated method stub
				}

				@Override
				public void reportarPulsado(String usuario) {
					// TODO Auto-generated method stub
				}
			});
			JFrame Buscador = new JFrame();
			Buscador.setSize(250, 350);
			Buscador.setVisible(true);
			Buscador.setContentPane(content);
		}
			break;

		case "comprarRelojes": {
			// prueba
			ComprarRelojUI a = new ComprarRelojUI(true, ventana,
					Tienda.PAQUETESRELOJ, e.getJugador());
			a.addComprarRelojListener(this);
			a.setSize(800, 600);

		}
			break;

		case "Ayuda": {
			MostrarAyuda.mostrarAyuda();
		}
			break;

		}
	}

	@Override
	public void notificarComprarReloj(ComprarRelojEvent e) {
		switch (e.getComprarRelojType()) {
		case "Comprar": {
			// JOptionPane.showConfirmDialog (null, "Quieres comprar este
			// nivel?","Warning",JOptionPane.YES_NO_OPTION);
			JOptionPane optionPane = new JOptionPane(
					"Quieres comprar este paquete de relojes?",
					JOptionPane.WARNING_MESSAGE);
			optionPane.setOptionType(JOptionPane.YES_NO_OPTION);
			JDialog dialog = optionPane.createDialog("Compra relojes");
			dialog.setAlwaysOnTop(true);
			dialog.setVisible(true);
			if ((int) optionPane.getValue() == JOptionPane.YES_OPTION) {
				Logger.getLogger("log").info("success");
				e.getJugador().comprarRelojes(false, e.getInfo().getNumReloj());
			} else
				Logger.getLogger("log").info("fail");
			// JDialog compra = new JDialog(ventana, "Confirmacion compra",
			// ModalityType.DOCUMENT_MODAL);
			//
			// compra.setSize(500,200);
			// dGuion.setVisible(true);
			// dGuion.setAlwaysOnTop(true);
		}
			break;
		case "VerAnuncio": {
			JDialog dialog = new JDialog();
			dialog.setTitle("Anuncio");
			dialog.setPreferredSize(new Dimension(400, 300));
			dialog.setAlwaysOnTop(true);
			dialog.setVisible(true);
			e.getJugador().comprarRelojes(true, 1);
		}
			break;

		}

	}

	@Override
	public void notificarPrinciAdministradorListener(PrinciAdministradorEvent e) {
		switch (e.getPrinciAdministradorType()) {
		case "Salir": {
			// vuelve a IniciarSesionUI
			IniciarSesionUI content = new IniciarSesionUI(this);
			ventana.getContentPane().removeAll();
			ventana.add(content);
			content.updateUI();

		}
			break;
		case "Reportados": {
			ArrayList<Reporte> lista = (new SA_GameMastering()).sacarReportados(gestor);
			String[][] devolver = new String[lista.size()][3];
			for (int i = 0; i < lista.size(); i++) {
				devolver[i][0] = lista.get(i).getReportador().getId();
				devolver[i][1] = lista.get(i).getReportado().getId();
				devolver[i][2] = lista.get(i).getFecha().toString();
			}
			ListaReportadosUI listaReportados = new ListaReportadosUI(devolver);
			JDialog reportados=new JDialog();
			reportados.setSize(600, 508);
			reportados.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			reportados.setContentPane(listaReportados);
			reportados.setVisible(true);
			reportados.setAlwaysOnTop(true);
		}break;
		case "Mensajes": {
		}
			break;
		case "GuionesPropuestos":{
				ArrayList<InfoGuion>lista=(new SA_GameMastering()).sacarGuiones(gestor);
				String [][] devolver=new String[lista.size()][2];
				for(int i=0;i<lista.size();i++){
					devolver[i][0]=lista.get(i).getCreador();
					devolver[i][1]=lista.get(i).getTitulo();
				}
				JDialog propuestos=new JDialog(ventana, "Guiones Propuestos", ModalityType.DOCUMENT_MODAL);
				ListaPropuestosUI listaPropuestos=new ListaPropuestosUI(devolver);
				propuestos.setSize(600, 508);
				propuestos.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				propuestos.setContentPane(listaPropuestos);
				propuestos.setVisible(true);
				propuestos.setAlwaysOnTop(true);
			}break;
		}
	}

}