package tragedylooper.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class IniciarSesionUI extends JFrame {
	
	private JTextField userIn;
	private JPasswordField passwIn;
	private JButton iniciarSesion;
	private JButton crearCuenta;

	public IniciarSesionUI() {
		inicializarGUI();
	}

	private void inicializarGUI() {
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		this.setSize(new Dimension(800, 600));
		
		JPanel cuadroEntrada = new JPanel();
		cuadroEntrada.setLayout(new BoxLayout(cuadroEntrada, BoxLayout.Y_AXIS));
		
		JPanel usuario =  new JPanel();
		usuario.setLayout(new FlowLayout(FlowLayout.CENTER));
		userIn = new JTextField(15);
		usuario.add(new JLabel("Usuario"));
		usuario.add(userIn);
		usuario.setPreferredSize(new Dimension(300, 50));
		usuario.setMaximumSize(usuario.getPreferredSize());
		
		JPanel pw =  new JPanel();
		pw.setLayout(new FlowLayout(FlowLayout.CENTER));
		passwIn = new JPasswordField(15);
		passwIn.setEchoChar('*');
		pw.add(new JLabel("Contraseña"));
		pw.add(passwIn);
		pw.setPreferredSize(new Dimension(300, 50));
		pw.setMaximumSize(usuario.getPreferredSize());
		
		iniciarSesion = new JButton("Iniciar Sesión");
		crearCuenta = new JButton("Darse de Alta");

		cuadroEntrada.add(Box.createRigidArea(new Dimension(1,20)));
		cuadroEntrada.add(usuario);
		cuadroEntrada.add(pw);
		cuadroEntrada.add(Box.createRigidArea(new Dimension(1,20)));
		cuadroEntrada.add(iniciarSesion);
		cuadroEntrada.add(Box.createRigidArea(new Dimension(1,10)));
		cuadroEntrada.add(crearCuenta);
		cuadroEntrada.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.black));
		cuadroEntrada.setPreferredSize(new Dimension(205,220));
		cuadroEntrada.setMaximumSize(cuadroEntrada.getPreferredSize());
		
		
		
		this.add(Box.createRigidArea(new Dimension(185, 150)));
		this.add(cuadroEntrada);
		this.setVisible(true);	
	}

	
	public static void main(String[] args) {
		new IniciarSesionUI();

	}
	
	
}