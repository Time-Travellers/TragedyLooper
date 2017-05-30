package presentacion.vista.usuario.registro;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import presentacion.modelo.usuario.Jugador;
import presentacion.modelo.usuario.Paises;
import presentacion.modelo.usuario.Usuario;



/**
 * Pantalla que se abre cuando el usuario pulsa "Registrarse"
 * al iniciar sesion.
 *
 */

public class RegistroUI extends JPanel{

	private static final long serialVersionUID = 8255260005722253253L;

	//Interfaz a implementar si se quieren insertar listeners:
	public interface RegistroUIListener {
		void registrarsePulsado();
	}
	
	private JTextField username;
	private JTextField nombre;
	private JPasswordField password;
	private JPasswordField password2;
	private JTextField email;
	private JTextField edad;
	private JComboBox<Paises> pais;
	private JButton registrarse;
	private RegistroUIListener rListener;
	
	public RegistroUI(RegistroUIListener regListener) {
		this.rListener = regListener;
		initGUI();
	}
	
	public RegistroUI() {
		initGUI();
	}
	
	public void setRListener(RegistroUIListener rListener) {
		this.rListener = rListener;
	}

	private void initGUI() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		JLabel titulo = new JLabel("Rellena los siguientes campos...");
		titulo.setFont(new Font("", 25, 25));
		this.add(titulo);
		this.add(new JLabel("Introduce tu nombre de usuario:"));
		this.username = new JTextField();
		this.add(username);
		this.add(new JLabel("Introduce tu nombre:"));
		this.nombre = new JTextField();
		this.add(nombre);
		this.add(new JLabel("Introduce tu password:"));
		this.password = new JPasswordField();
		this.add(password);
		this.add(new JLabel("Introduce tu password de nuevo:"));
		this.password2 = new JPasswordField();
		this.password2.addMouseListener(new MouseAdapter() {
			public void mouseExited(MouseEvent e) {
				if(!passwordsIguales()) {
					JOptionPane.showMessageDialog(new JFrame(),
							"Los passwords no coinciden",
							"Comprueba tu password...",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		this.add(password2);
		this.add(new JLabel("Introduce tu email:"));
		this.email = new JTextField();
		this.add(email);
		this.add(new JLabel("Introduce tu edad:"));
		this.edad = new JTextField();
		this.add(edad);
		this.add(new JLabel("Introduce tu pais:"));
		this.pais = new JComboBox<Paises>(Paises.values());
		this.add(pais);
		this.registrarse = new JButton("Registrarse");
		this.registrarse.setEnabled(false);
		this.registrarse.addActionListener((e)-> this.rListener.registrarsePulsado());
		this.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				if(!todoRelleno()) registrarse.setEnabled(false);
				else registrarse.setEnabled(true);
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if(!todoRelleno()) registrarse.setEnabled(false);
				else registrarse.setEnabled(true);
			}
			
		});
		this.add(registrarse);
		this.setVisible(true);
	}
	
	//Metodos para obtener cada uno de los campos...
	
	public String getUsername() {
		return username.getText();
	}
	
	public String getNombre() {
		return nombre.getText();
	}
	
	public String getPassword() {
		char[] pass = password.getPassword();
		String res = "";
		for(char a : pass)
			res += a;
		return res;
	}
	
	@SuppressWarnings("deprecation")
	public String getPassword2() {
		char[] pass = password2.getPassword();
		String res = "";
		for(char a : pass)
			res += a;
		return res;
	}
	
	public String getEmail() {
		return email.getText();
	}
	
	public String getEdad() {
		return edad.getText();
	}
	
	public Paises getPais() {
		return (Paises)pais.getSelectedItem();
	}
	
	// Metodo para saber si ha repetido el password correctamente:
	public boolean passwordsIguales() {
		return getPassword().equals(getPassword2());
	}
	
	//Metodo para saber si ha rellenado todos los campos:
	public boolean todoRelleno() {
		return   !getUsername().equals("") && !getNombre().equals("") && !getPassword().equals("") &&
				!getPassword2().equals("") && !getEmail().equals("") &&
				!getEdad().equals("") && getPais() != null;
	}
	
	public String todoCorrecto() {
		String OK = null;
		if(!passwordsIguales()) OK = "Las contraseñas no coinciden";
		try {
			int a = Integer.parseInt(getEdad());
			if(a < 0) OK = "La edad no es válida";
		} catch (NumberFormatException e) {
			OK = "La edad no es válida";
		}
		return OK;
	}
	
	public Jugador getUsuarioCompleto() {
		return new Jugador(getUsername(), getPassword(), false, getNombre(), Integer.parseInt(getEdad()), getPais(), getEmail());
	}
	
	// Main para probar esta pantalla:
	public static void main(String[] args) {
		SwingUtilities.invokeLater(()-> {
			JFrame frame = new JFrame("Ventana de Registro");
			frame.setSize(600,508);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			RegistroUI registro = new RegistroUI(new RegistroUIListener() {

				@Override
				public void registrarsePulsado() {
					System.out.println("Pulsado Registrarse");
				}
				
			});
			frame.setContentPane(registro);
			frame.setVisible(true);
		});
	}

}