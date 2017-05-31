package presentacion.controlador;

import java.awt.Dialog.ModalityType;
import java.awt.Dimension;
import java.util.logging.Logger;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import bbdd.Gestor;
import negocio.SA_Juego;
import negocio.SA_Marketing;
import negocio.SA_GameMastering;
import negocio.SA_Usuario;
import presentacion.controlador.buscador.BuscadorEvent;
import presentacion.controlador.buscador.BuscadorListener;
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
import presentacion.modelo.juego.InfoGuion;
import presentacion.modelo.marketing.InfoNivel;
import presentacion.modelo.marketing.Tienda;
import presentacion.modelo.usuario.Jugador;
import presentacion.modelo.usuario.Usuario;
import presentacion.vista.gameMastering.aceptarguion.AceptarGuionUI;
import presentacion.vista.gameMastering.aceptarguion.AceptarGuionUI.AceptarGuionListener;
import presentacion.vista.gameMastering.aceptarguion.ListaPropuestosUI;
import presentacion.vista.gameMastering.aceptarguion.ListaPropuestosUI.GuionesPropuestosListener;
import presentacion.vista.gameMastering.banear.ListaReportadosUI;
import presentacion.vista.gameMastering.banear.ListaReportadosUI.ReportadosListener;
import presentacion.vista.juego.proponerguion.SugerenciaGuion;
import presentacion.vista.juego.proponerguion.SugerenciaGuion.GuionListener;
import presentacion.vista.marketing.comprarnivel.ComprarNivelUI;
import presentacion.vista.marketing.comprarnivel.ComprarNivelUI.ComprarNivelUIListener;
import presentacion.vista.marketing.comprarreloj.ComprarRelojUI;
import presentacion.vista.usuario.buscar.BuscadorUI;
import presentacion.vista.usuario.iniciarsesion.IniciarSesionUI;
import presentacion.vista.usuario.inicioadmin.InicioAdminUI;
import presentacion.vista.usuario.inicious.MostrarAyuda;
import presentacion.vista.usuario.inicious.InicioUsuarioUI;
import presentacion.vista.usuario.perfilus.CambiarPassUI;
import presentacion.vista.usuario.perfilus.CambiarPassUI.CambiarPassUIListener;
import presentacion.vista.usuario.perfilus.ModificarDatosUI;
import presentacion.vista.usuario.perfilus.ModificarDatosUI.ModifDatosListener;
import presentacion.vista.usuario.perfilus.PerfilUsuario;
import presentacion.vista.usuario.registro.RegistroUI;
import presentacion.vista.usuario.registro.RegistroUI.RegistroUIListener;

public class GUIController implements IniSesionListener, PrinciUsuarioListener, PrinciAdministradorListener,
		ComprarRelojListener, PerfilListener, BuscadorListener {

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
							JOptionPane.showMessageDialog(null, "�Compra realizada con exito!", "Compra nivel",
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
					if (!guion.getTitulo().equals("")) {
						if (new SA_Juego().proponerGuion(gestor, guion)) {
							JOptionPane.showMessageDialog(new JFrame(), "Guion enviado correctamente", "Exito",
									JOptionPane.INFORMATION_MESSAGE);
							dGuion.dispose();
						} else {
							JOptionPane.showMessageDialog(new JFrame(), "Ya existe un guion con ese titulo", "Error",
									JOptionPane.ERROR_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(new JFrame(), "El guion debe tener titulo", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}

				@Override
				public void salir() {
					dGuion.dispose();
				}

				@Override
				public Jugador idRegistrado() {
					return (Jugador) modelo.getUsuario();
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
			JDialog dBuscar = new JDialog(ventana, "Buscador", ModalityType.DOCUMENT_MODAL);
			BuscadorUI buscador = new BuscadorUI();
			buscador.addBuscadorListener(this);
			
			dBuscar.setSize(800, 600);
			dBuscar.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dBuscar.setContentPane(buscador);
			dBuscar.pack();
			dBuscar.setVisible(true);
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
			String[][] reporte = (new SA_GameMastering()).datosReportados(gestor);
			JDialog reportados = new JDialog(ventana, "Guiones Propuestos", ModalityType.DOCUMENT_MODAL);
			
			ListaReportadosUI listaReportados = new ListaReportadosUI(reporte);
			listaReportados.setReportadosListener(new ReportadosListener(){

				@Override
				public void actualizar() {
					listaReportados.setDatos((new SA_GameMastering()).datosReportados(gestor));
				}
				@Override
				public void seleccionar(String s) {
				}
				@Override
				public void salir() {
					reportados.dispose();
				}
			});
			
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
			String[][] datos = (new SA_GameMastering()).datosGuionesPropuestos(gestor);
			
			JDialog propuestos = new JDialog(ventana, "Guiones Propuestos", ModalityType.DOCUMENT_MODAL);
			ListaPropuestosUI listaPropuestos = new ListaPropuestosUI(datos);
			listaPropuestos.setGPListener(new GuionesPropuestosListener(){
				@Override
				public void actualizar() {
					listaPropuestos.setDatos((new SA_GameMastering()).datosGuionesPropuestos(gestor));
				}
				@Override
				public void seleccionar(String s) {
					InfoGuion info = (new SA_GameMastering()).leerGuion(gestor, s);
					AceptarGuionUI acGuion = new AceptarGuionUI(info);
					acGuion.setAGListener(new AceptarGuionListener(){
						
						@Override //aceptar el guion elegido
						public void aceptar() {
							(new SA_GameMastering()).aceptarGuion(gestor,info.getTitulo(),acGuion.getNivel());
							String[][] datos = (new SA_GameMastering()).datosGuionesPropuestos(gestor);
							ListaPropuestosUI nuevaLista = new ListaPropuestosUI(datos);
							propuestos.setContentPane(nuevaLista);
							propuestos.pack();
							propuestos.setVisible(true);
							propuestos.repaint();
						}
						@Override	//rechazar el guion elegido
						public void rechazar() {
							(new SA_GameMastering()).eliminarGuion(gestor,info.getTitulo());
							String[][] datos = (new SA_GameMastering()).datosGuionesPropuestos(gestor);
							ListaPropuestosUI nuevaLista = new ListaPropuestosUI(datos);
							propuestos.setContentPane(nuevaLista);
							propuestos.pack();
							propuestos.setVisible(true);
							propuestos.repaint();
						}
						@Override	//salir de la ventana
						public void salir() {
							propuestos.setContentPane(listaPropuestos);
							propuestos.pack();
							propuestos.setVisible(true);
							propuestos.repaint();
						}						
					});
					propuestos.setContentPane(acGuion);
					propuestos.pack();
					propuestos.setVisible(true);
					propuestos.repaint();
				}
				
			});
			propuestos.setSize(800, 600);
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
			JDialog jc = new JDialog(ventana, "Cambiar contrase�a", ModalityType.DOCUMENT_MODAL);
			CambiarPassUI a = new CambiarPassUI();
			a.setListener(new CambiarPassUIListener() {
				@Override
				public void cambiarPulsado() {
					if (a.coinciden()) {
						Jugador jugador = (Jugador) modelo.getUsuario();
						if (new SA_Usuario().cambiarPass(gestor, jugador, a.getOld(), a.getPass1())) {
							JOptionPane.showMessageDialog(new JFrame(), "Contrase�a cambiada correctamente", "Exito",
									JOptionPane.INFORMATION_MESSAGE);
							jc.dispose();
						} else {
							JOptionPane.showMessageDialog(new JFrame(), "Contrase�a antigua incorrecta", "Error",
									JOptionPane.ERROR_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(new JFrame(), "Las contrase�as no coinciden", "Error",
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
	
	public void notificarBuscador(BuscadorEvent e) {
		switch(e.getBuscadorType()) {
		
		}
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
			InicioUsuarioUI prinUsuario = new InicioUsuarioUI((Jugador) modelo.getUsuario());
			prinUsuario.addPrinciUsuarioListener(this);
			ventana.add(prinUsuario);
			prinUsuario.updateUI();
			break;
		case PrinAdmin:
			InicioAdminUI prinAdmin = new InicioAdminUI(modelo.getUsuario().getId(),
					0, new SA_GameMastering().getNumGuiones(gestor),  new SA_GameMastering().getNumReportados(gestor));
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