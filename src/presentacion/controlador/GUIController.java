package presentacion.controlador;

import javax.swing.JFrame;

import bbdd.Gestor;
import negocio.SA_Usuario;
import presentacion.modelo.GUIModelo;
import presentacion.modelo.usuario.Usuario;
import presentacion.vista.usuario.InicioAdminUI;
import presentacion.vista.usuario.JugadorUI;

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
			Usuario usuario = SA_Usuario().iniciarSesion(gestor, e.getUsuario(), e.getContrasena());
			if (usuario != null) {
				modelo.setUsuario(usuario);
				ventana.removeAll();
				if (usuario.isAdmin())
					ventana.add(new InicioAdminUI(usuario.getId(), ));
				else
					ventana.add(new JugadorUI());
			}
		} else {

		}
	}

}
