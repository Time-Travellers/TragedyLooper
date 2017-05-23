package presentacion.controlador;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import bbdd.Gestor;
import negocio.SA_Usuario;
import presentacion.modelo.GUIModelo;
import presentacion.modelo.usuario.Usuario;
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
				ventana.removeAll();
				if (usuario.isAdmin())
					ventana.add(new InicioAdminUI(usuario.getId(), 5, 5, 6));
				else
					ventana.add(new PrincipalUsuarioUI(3, 4));//TODO que reciba usuario
			} else {
				JOptionPane.showMessageDialog
				(new JFrame(), "Usuario o contrase�a incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
			}
		} else {
			JFrame fRegistro = new JFrame();
			RegistroUI registro = new RegistroUI(new RegistroUIListener() {

				@Override
				public void registrarsePulsado() {
					Usuario usuario = registro.getUsuarioCompleto();
					boolean OK = new SA_Usuario().agregarUsuario(gestor, usuario);
					if(OK) {
						JOptionPane.showMessageDialog(new JFrame(), "Usuario creado correctamente", "�xito", JOptionPane.INFORMATION_MESSAGE);
						fRegistro.dispose();
					}
					else
						JOptionPane.showMessageDialog(new JFrame(), "Nombre de usuario repetido", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
			});
			fRegistro.add(registro);
		}
	}
	
	public void closeGestor() {
		gestor.close();
	}

}
