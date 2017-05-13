package  presentacion.vista.usuario;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import presentacion.controlador.IniSesionEvent;
import presentacion.controlador.IniSesionEvent.IniSesionType;
import presentacion.controlador.IniSesionListenable;
import presentacion.controlador.IniSesionListener;

public class IniciarSesionUI extends JPanel implements IniSesionListenable {
	
	private static final long serialVersionUID = -7214920190889223616L;
	private JTextField userIn;
	private JTextField passwIn;
	private JButton iniciarSesion;
	private JButton crearCuenta;
	private ArrayList<IniSesionListener> listeners;

	public IniciarSesionUI() {
		listeners = new ArrayList<IniSesionListener>();
		inicializarGUI();
	}

	private void inicializarGUI() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setSize(new Dimension(800, 600));
		
		JPanel usuario =  new JPanel();
		usuario.setLayout(new FlowLayout(FlowLayout.CENTER));
		userIn = new JTextField(15);
		usuario.add(new JLabel("Usuario"));
		usuario.add(userIn);
		usuario.setPreferredSize(new Dimension(300, 50));
		usuario.setMaximumSize(usuario.getPreferredSize());
		
		JPanel pw =  new JPanel();
		pw.setLayout(new FlowLayout(FlowLayout.CENTER));
		passwIn = new JTextField(15);
		pw.add(new JLabel("Contraseña"));
		pw.add(passwIn);
		pw.setPreferredSize(new Dimension(300, 50));
		pw.setMaximumSize(usuario.getPreferredSize());
		
		iniciarSesion = new JButton("Iniciar Sesión");
		crearCuenta = new JButton("Darse de Alta");
		
		JPanel cuadroEntrada = new JPanel();
		cuadroEntrada.setLayout(new BoxLayout(cuadroEntrada, BoxLayout.Y_AXIS));
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
		
		JPanel cuadroEntradaConTitulo = new JPanel();
		cuadroEntradaConTitulo.setLayout(new BoxLayout(cuadroEntradaConTitulo, BoxLayout.Y_AXIS) );
		JLabel titulo =  new JLabel("Tragedy Looper");
		Font font = new Font("personalizada", Font.BOLD, 26);
		titulo.setFont(font);
		cuadroEntradaConTitulo.add(titulo);
		cuadroEntradaConTitulo.add(Box.createRigidArea(new Dimension(0, 50)));
		cuadroEntradaConTitulo.add(cuadroEntrada);
		
		ImageIcon icon = new ImageIcon("src\\resources\\mainart.png");
		JLabel imagen = new JLabel();
		imagen.setIcon(icon);
		
		JPanel cuadroFinal = new JPanel();
		cuadroFinal.setLayout(new BoxLayout(cuadroFinal, BoxLayout.X_AXIS));
		cuadroFinal.add(Box.createRigidArea(new Dimension(125, 0)));
		cuadroFinal.add(cuadroEntradaConTitulo);
		cuadroFinal.add(Box.createRigidArea(new Dimension(100, 0)));
		cuadroFinal.add(imagen);
		this.setLayout(new BorderLayout());
		this.add(cuadroFinal);
		
		iniciarSesion.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < listeners.size(); ++i)
					listeners.get(i).notificarIniSesion(new IniSesionEvent(
							IniSesionType.IniciarSesion, userIn.getText(), passwIn.getText()));
			}
		});
		
		crearCuenta.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < listeners.size(); ++i)
					listeners.get(i).notificarIniSesion(new IniSesionEvent(IniSesionType.DarseAlta));
			}
		});
		
		
	}
	
	@Override
	public void addIniSesionListener(IniSesionListener list) {
		listeners.add(list);
	}

	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		IniciarSesionUI ui = new IniciarSesionUI();
		
		frame.add(ui);
		frame.setSize(new Dimension(1024, 768));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		IniSesionListener test =  new IniSesionListener(){
			@Override
			public void notificarIniSesion(IniSesionEvent e) {
				System.out.println(e.getIniSesionType());
				System.out.println(e.getUsuario());
				System.out.println(e.getContrasena());
			}
		};
		ui.addIniSesionListener(test);
		
	}


	

}