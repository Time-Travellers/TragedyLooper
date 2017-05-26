package presentacion.controlador;

import java.awt.Dialog.ModalityType;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import bbdd.Gestor;
import negocio.SA_Usuario;
import presentacion.modelo.GUIModelo;
import presentacion.modelo.usuario.Usuario;
import presentacion.modelo.usuario.Jugador;
import presentacion.vista.usuario.InicioAdminUI;
import presentacion.vista.usuario.PrincipalUsuarioUI;
import presentacion.vista.usuario.RegistroUI;
import presentacion.vista.usuario.RegistroUI.RegistroUIListener;

public class GUIController implements IniSesionListener {

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
					ventana.add(content);
					content.updateUI();
				}
				
			} else {
				JOptionPane.showMessageDialog(new JFrame(), "Usuario o contraseña incorrectos", "Error",
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
							JOptionPane.showMessageDialog(new JFrame(), "Usuario creado correctamente", "Éxito",
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

	public void closeGestor() {
		gestor.close();
	}

}
