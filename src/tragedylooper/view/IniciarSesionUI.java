package tragedylooper.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

public class IniciarSesionUI extends JPanel {
	
	private JPanel user;
	private JPanel password;
	

	public IniciarSesionUI() {
		inicializarGUI();
	}
	
	public void inicializarGUI() {
		
		this.setMaximumSize(new Dimension(500, 500));
		
		//Panel user:
		
		this.user = new JPanel();
		JTextField userIn = new JTextField(15);
		userIn.setVisible(true);
		JLabel userTitle = new JLabel("Usuario");
		userIn.add(userTitle);
		userTitle.setVisible(true);
		this.user.add(userIn);
		this.setVisible(true);
		this.add(this.user);
		
		this.password=new JPanel();
		
		/*this.setMaximumSize(new Dimension(200, 100));
		//this.setPreferredSize(new Dimension(500,500));
		Border borde = BorderFactory.createLineBorder(Color.blue, 5);
		JPanel ctrlPabel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		this.add(ctrlPabel);
		this.setBackground(Color.red);
		this.setVisible(true);
		JLabel ctrlLabel = new JLabel("Usuario");
		this.usuario=new JTextField(15);
		ctrlLabel.add(this.usuario);
		this.usuario.setBorder(borde);
		
		
		this.add(ctrlLabel);
		JLabel ctrlLabel2 = new JLabel("Contraseña");
		this.contrasena=new JTextField(15);
		ctrlLabel2.add(this.contrasena);
		this.contrasena.setBorder(borde);
		this.add(ctrlLabel2);
		this.setLayout(new GridLayout(2,0));
		this.add(this.usuario);
		this.add(this.contrasena);
		
		this.setMaximumSize(new Dimension(500, 500));
		*/
		
	}
	
	
	public static void main(String[] args) {
		JFrame ventana=new JFrame("test");
		ventana.getContentPane().add(new IniciarSesionUI());
		ventana.setVisible(true);
		ventana.setSize(800,600);
		ventana.setBackground(Color.blue);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//SwingUtilities.invokeLater(() -> new IniciarSesionUI());
	}
	
	
}
