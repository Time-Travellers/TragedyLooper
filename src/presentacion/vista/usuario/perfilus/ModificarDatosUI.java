package presentacion.vista.usuario.perfilus;

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

import presentacion.modelo.usuario.Jugador;
import presentacion.modelo.usuario.Paises;
import presentacion.vista.usuario.registro.RegistroUI.RegistroUIListener;

public class ModificarDatosUI extends JPanel {

	private static final long serialVersionUID = -2518382752312836635L;

	public interface ModifDatosListener{
		public void cambiarPulsado();
		public void cancelarPulsado();
	}
	
	private JTextField email;
	private JTextField edad;
	private JComboBox<Paises> pais;
	private ModifDatosListener list;
	
	public ModificarDatosUI(Jugador j) {
		initGUI(j.getDatos().getCorreo(), j.getDatos().getEdad(), j.getDatos().getPais());
	}
	
	public void setModificarDatosListener(ModifDatosListener list) {
		this.list = list;
	}

	private void initGUI(String correo, int edad, Paises pais) {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(new JLabel("Email:"));
		this.email = new JTextField(correo);
		this.add(email);
		this.add(new JLabel("Introduce tu edad:"));
		this.edad = new JTextField(new Integer(edad).toString());
		this.add(this.edad);
		this.add(new JLabel("Introduce tu pais:"));
		this.pais = new JComboBox<Paises>(Paises.values());
		this.pais.setSelectedItem(pais);
		this.add(this.pais);
		JPanel botones = new JPanel();
		JButton cambiar = new JButton("Cambiar");
		cambiar.setEnabled(false);
		cambiar.addActionListener((e)-> this.list.cambiarPulsado());
		this.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				cambiar.setEnabled(todoRelleno());
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				cambiar.setEnabled(todoRelleno());
			}
			
		});
		JButton cancelar = new JButton("Cancelar");
		cancelar.setEnabled(true);
		cancelar.addActionListener((e) -> this.list.cancelarPulsado());
		botones.add(cambiar);
		botones.add(cancelar);
		this.add(botones);
		this.setVisible(true);
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
	
	//Metodo para saber si ha rellenado todos los campos:
	public boolean todoRelleno() {
		return  !getEmail().equals("") &&
				!getEdad().equals("") && getPais() != null;
	}
	
	public boolean todoCorrecto() {
		try {
			int a = Integer.parseInt(getEdad());
			if(a < 0) return false;
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}	
}
