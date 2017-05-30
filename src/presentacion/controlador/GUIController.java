package presentacion.controlador;

import java.awt.Dialog.ModalityType;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.logging.Logger;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

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
import presentacion.controlador.perfil.PerfilEvent;
import presentacion.controlador.perfil.PerfilListener;
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
import presentacion.vista.usuario.perfilus.CambiarPassUI;
import presentacion.vista.usuario.perfilus.CambiarPassUI.CambiarPassUIListener;
import presentacion.vista.usuario.perfilus.ModificarDatosUI;
import presentacion.vista.usuario.perfilus.ModificarDatosUI.ModifDatosListener;
import presentacion.vista.usuario.perfilus.PerfilUsuario;
import presentacion.vista.usuario.principalus.MostrarAyuda;
import presentacion.vista.usuario.principalus.PrincipalUsuarioUI;
import presentacion.vista.usuario.proponerguion.SugerenciaGuion;
import presentacion.vista.usuario.proponerguion.SugerenciaGuion.GuionListener;
import presentacion.vista.usuario.registro.RegistroUI;
import presentacion.vista.usuario.registro.RegistroUI.RegistroUIListener;

public class GUIController implements IniSesionListener, PrinciUsuarioListener, PrinciAdministradorListener,
		ComprarRelojListener, PerfilListener {

	private enum TipoVentana {
		IniSesion, PrinUsuario, PrinAdmin, Perfil
	}

	private JFrame ventana;
	private GUIModelo modelo;
	private Gestor gestor;
	private TipoVentana tipo;

	public GUIController(JFrame ventana, Gestor gestor) {
		this.ventana = ventana;
		this.gestor = gestor;
		this.modelo = new GUIModelo();
		this.tipo = TipoVentana.IniSesion;
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
				if (usuario.isAdmin()) {
					tipo = TipoVentana.PrinAdmin;
				} else {
					tipo = TipoVentana.PrinUsuario;
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
					} else {
						JOptionPane.showMessageDialog(new JFrame(), result, "Error", JOptionPane.WARNING_MESSAGE);
					}
				}

			});
			fRegistro.setSize(600, 600);
			fRegistro.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			fRegistro.setContentPane(registro);
			fRegistro.pack();
			fRegistro.setVisible(true);
		}
		reiniciarGUI();
	}

	@Override
	public void notificarPrinciUsuario(PrinciUsuarioEvent e) {
		switch (e.getPrinciUsuarioType()) {
		case "Salir": {
			tipo = TipoVentana.IniSesion;

		}
			break;
		case "comprarNivel": {
			Jugador jugador = (Jugador) modelo.getUsuario();
			if (jugador.getNivel() != Tienda.NIVEL) {
				Tienda tienda = new SA_Marketing().iniciarTienda(gestor);
				InfoNivel nivel = tienda.getPaquetesNivel().get(jugador.getNivel());
				JDialog dCompra = new JDialog(ventana, "Compra nivel", ModalityType.DOCUMENT_MODAL);

				ComprarNivelUI compraNivel = new ComprarNivelUI(nivel);
				compraNivel.setNivelListener(new ComprarNivelUIListener() {

					@Override
					public void confirmar() {
						if (new SA_Marketing().comprarNivel(gestor, jugador, nivel))
							JOptionPane.showMessageDialog(null, "¡Compra realizada con exito!", "Compra nivel",
									JOptionPane.INFORMATION_MESSAGE);
						else
							JOptionPane.showMessageDialog(null, "No tienes suficientes relojes", "Compra nivel",
									JOptionPane.ERROR_MESSAGE);
						dCompra.dispose();
					}

					@Override
					public void salir() {
						dCompra.dispose();
					}

				});

				dCompra.setPreferredSize(new Dimension(600, 400));
				dCompra.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dCompra.setContentPane(compraNivel);
				dCompra.pack();
				dCompra.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(null, "Lo sentimos, no hay mas niveles disponibles", "Compra nivel",
						JOptionPane.ERROR_MESSAGE);
			}
		}
			break;

		case "proponerGuion": {
			JDialog dGuion = new JDialog(ventana, "Proponer Guion", ModalityType.DOCUMENT_MODAL);
			SugerenciaGuion proponerGuion = new SugerenciaGuion();
			proponerGuion.setGListener(new GuionListener() {
				@Override
				public void recibirGuion() {
					InfoGuion guion = proponerGuion.getGuionCompleto();
					new SA_Juego().proponerGuion(gestor, guion);
					JOptionPane.showMessageDialog(new JFrame(), "Guion enviado correctamente", "Exito",
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
			dGuion.pack();
			dGuion.setVisible(true);
		}
			break;

		case "miPerfil": {
			tipo = TipoVentana.Perfil;
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
			JDialog jc = new JDialog(ventana, "Tienda de relojes", ModalityType.DOCUMENT_MODAL);
			Jugador jugador = (Jugador) modelo.getUsuario();
			ComprarRelojUI a = new ComprarRelojUI(jugador.getAnuncios() > 0, Tienda.PAQUETESRELOJ, jc);
			a.addComprarRelojListener(this);
			jc.setSize(600, 600);
			jc.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			jc.setContentPane(a);
			jc.pack();
			jc.setVisible(true);
		}
			break;

		case "Ayuda": {
			MostrarAyuda.mostrarAyuda();
		}
			break;

		}
		reiniciarGUI();

	}

	@Override
	public void notificarComprarReloj(ComprarRelojEvent e) {
		switch (e.getComprarRelojType()) {
		case "Comprar": {
			JOptionPane optionPane = new JOptionPane("Quieres comprar este paquete de relojes?",
					JOptionPane.WARNING_MESSAGE);
			optionPane.setOptionType(JOptionPane.YES_NO_OPTION);
			JDialog dialog = optionPane.createDialog("Compra relojes");
			dialog.setAlwaysOnTop(true);
			dialog.setVisible(true);
			if ((int) optionPane.getValue() == JOptionPane.YES_OPTION) {
				Logger.getLogger("log").info("Relojes comprados");
				new SA_Marketing().comprarRelojes(gestor, (Jugador) modelo.getUsuario(), false,
						e.getInfo().getNumReloj());
			} else
				Logger.getLogger("log").info("Error al comprar relojes");
		}
			break;
		case "VerAnuncio": {
			JDialog dialog = new JDialog();
			dialog.setTitle("Anuncio");
			dialog.setPreferredSize(new Dimension(400, 300));
			dialog.pack();
			dialog.setVisible(true);
			new SA_Marketing().comprarRelojes(gestor, (Jugador) modelo.getUsuario(), true, 1);
		}
			break;
		}
		reiniciarGUI();
	}

	@Override
	public void notificarPrinciAdministradorListener(PrinciAdministradorEvent e) {
		switch (e.getPrinciAdministradorType()) {
		case "Salir": {
			// vuelve a IniciarSesionUI
			tipo = TipoVentana.IniSesion;
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
			JDialog reportados = new JDialog();
			reportados.setSize(600, 508);
			reportados.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			reportados.setContentPane(listaReportados);
			reportados.pack();
			reportados.setVisible(true);
		}
			break;
		case "Mensajes": {
		}
			break;
		case "GuionesPropuestos": {
			ArrayList<InfoGuion> lista = (new SA_GameMastering()).sacarGuiones(gestor);
			String[][] devolver = new String[lista.size()][2];
			for (int i = 0; i < lista.size(); i++) {
				devolver[i][0] = lista.get(i).getCreador();
				devolver[i][1] = lista.get(i).getTitulo();
			}
			JDialog propuestos = new JDialog(ventana, "Guiones Propuestos", ModalityType.DOCUMENT_MODAL);
			ListaPropuestosUI listaPropuestos = new ListaPropuestosUI(devolver);
			propuestos.setSize(600, 508);
			propuestos.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			propuestos.setContentPane(listaPropuestos);
			propuestos.pack();
			propuestos.setVisible(true);
		}
			break;
		}
		reiniciarGUI();

	}

	@Override
	public void notificarPerfilListener(PerfilEvent e) {
		switch (e.getPerfilType()) {
		case "Salir": {
			tipo = TipoVentana.PrinUsuario;
		}
			break;
		case "CambiarPass": {
			JDialog jc = new JDialog(ventana, "Cambiar contraseña", ModalityType.DOCUMENT_MODAL);
			Jugador jugador = (Jugador) modelo.getUsuario();
			CambiarPassUI a = new CambiarPassUI();
			a.setListener(new CambiarPassUIListener() {
				@Override
				public void cambiarPulsado() {
					if (a.coinciden()) {
						Jugador jugador = (Jugador) modelo.getUsuario();
						if (new SA_Usuario().cambiarPass(gestor, jugador, a.getOld(), a.getPass1())) {
							JOptionPane.showMessageDialog(new JFrame(), "Contraseña cambiada correctamente", "Exito",
									JOptionPane.INFORMATION_MESSAGE);
							jc.dispose();
						} else {
							JOptionPane.showMessageDialog(new JFrame(), "Contraseña antigua incorrecta", "Error",
									JOptionPane.ERROR_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(new JFrame(), "Las contraseñas no coinciden", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				}

				@Override
				public void cancelarPulsado() {
					jc.dispose();
				}
			});
			jc.setSize(600, 600);
			jc.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			jc.setContentPane(a);
			jc.pack();
			jc.setVisible(true);
		}
			break;
		case "CambiarDatos": {
			JDialog jc = new JDialog(ventana, "Modificar Datos", ModalityType.DOCUMENT_MODAL);
			Jugador jugador = (Jugador) modelo.getUsuario();
			ModificarDatosUI a = new ModificarDatosUI(jugador);
			a.setModificarDatosListener(new ModifDatosListener() {
				@Override
				public void cambiarPulsado() {
					if (a.todoCorrecto()) {
						Jugador jugador = (Jugador) modelo.getUsuario();
						new SA_Usuario().modifDatos(gestor, jugador, a.getEmail(), Integer.parseInt(a.getEdad()),
								a.getPais());
						JOptionPane.showMessageDialog(new JFrame(), "Datos modificados correctamente", "Exito",
								JOptionPane.INFORMATION_MESSAGE);
						jc.dispose();
					}
				}

				@Override
				public void cancelarPulsado() {
					jc.dispose();
				}
			});
			jc.setSize(600, 600);
			jc.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			jc.setContentPane(a);
			jc.pack();
			jc.setVisible(true);
		}
			break;
		}
		reiniciarGUI();
	}

	public void reiniciarGUI() {
		ventana.getContentPane().removeAll();
		switch (tipo) {
		case IniSesion:
			IniciarSesionUI iniSesion = new IniciarSesionUI();
			iniSesion.addIniSesionListener(this);
			ventana.add(iniSesion);
			iniSesion.updateUI();
			break;
		case PrinUsuario:
			PrincipalUsuarioUI prinUsuario = new PrincipalUsuarioUI((Jugador) modelo.getUsuario());
			prinUsuario.addPrinciUsuarioListener(this);
			ventana.add(prinUsuario);
			prinUsuario.updateUI();
			break;
		case PrinAdmin:
			InicioAdminUI prinAdmin = new InicioAdminUI(modelo.getUsuario().getId(), 1, 2, 3);
			prinAdmin.addPrinciAdministradorListener(this);
			ventana.add(prinAdmin);
			prinAdmin.updateUI();
			break;
		case Perfil:
			PerfilUsuario perfil = new PerfilUsuario((Jugador) modelo.getUsuario());
			perfil.addPerfilListener(this);
			ventana.getContentPane().removeAll();
			ventana.add(perfil);
			perfil.updateUI();

			break;
		}
	}
}