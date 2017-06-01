package  presentacion.vista.usuario.iniciarsesion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import presentacion.controlador.iniciarsesion.IniSesionEvent;
import presentacion.controlador.iniciarsesion.IniSesionListenable;
import presentacion.controlador.iniciarsesion.IniSesionListener;
import presentacion.controlador.iniciarsesion.IniSesionEvent.IniSesionType;

public class IniciarSesionUI extends JPanel implements IniSesionListenable {
	
	private static final long serialVersionUID = -7214920190889223616L;
	private JTextField userIn;
	private JPasswordField passwIn;
	private JButton iniciarSesion;
	private JButton crearCuenta;
	private ArrayList<IniSesionListener> listeners;

	public IniciarSesionUI() {
		listeners = new ArrayList<IniSesionListener>();
		initGUI();
	}

	public void initGUI() {
		
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
		passwIn = new JPasswordField(15);
		pw.add(new JLabel("Contraseña"));
		pw.add(passwIn);
		pw.setPreferredSize(new Dimension(300, 50));
		pw.setMaximumSize(usuario.getPreferredSize());
		
		iniciarSesion = new JButton("Iniciar Sesion");
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
		
		ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("resources/mainart.png"));
		JLabel imagen = new JLabel();
		imagen.setIcon(icon);
		
		JPanel cuadroFinal = new JPanel();
		cuadroFinal.setLayout(new BoxLayout(cuadroFinal, BoxLayout.X_AXIS));
		cuadroFinal.add(Box.createRigidArea(new Dimension(125, 0)));
		cuadroFinal.add(cuadroEntradaConTitulo);
		cuadroFinal.add(Box.createRigidArea(new Dimension(100, 0)));
		cuadroFinal.add(imagen);
		
		JPanel scroller = new JPanel();
		scroller.setLayout(new BorderLayout());
		scroller.add(new JScrollPane(cuadroFinal));
		this.setLayout(new BorderLayout());
		this.add(scroller, BorderLayout.CENTER);
		this.setVisible(true);
		
		iniciarSesion.addActionListener((e)->{
				char[] pass = passwIn.getPassword();
				String sPass = "";
				for(char a : pass)
					sPass = sPass + a;
				for (int i = 0; i < listeners.size(); ++i)
					listeners.get(i).notificarIniSesion(new IniSesionEvent(
							IniSesionType.IniciarSesion, userIn.getText(), sPass));
		});
		
		crearCuenta.addActionListener((e)->{
				for (int i = 0; i < listeners.size(); ++i)
					listeners.get(i).notificarIniSesion(new IniSesionEvent(IniSesionType.DarseAlta));
		});
	}
	
	@Override
	public void addIniSesionListener(IniSesionListener list) {
		listeners.add(list);
	}

}