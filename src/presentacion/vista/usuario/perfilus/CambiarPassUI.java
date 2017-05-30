package presentacion.vista.usuario.perfilus;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class CambiarPassUI extends JPanel {

	private static final long serialVersionUID = -2598419591630725044L;
	public interface CambiarPassUIListener{
		public void cambiarPulsado();
		public void cancelarPulsado();
	}
	
	private CambiarPassUIListener list;
	private JPasswordField old;
	private JPasswordField pass1;
	private JPasswordField pass2;
	
	public CambiarPassUI(){
		initGUI();
	}
	
	private void initGUI() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(new JLabel("Introduce tu contraseña antigua:"));
		this.old = new JPasswordField();
		this.add(old);
		this.add(new JLabel("Introduce tu contraseña nueva:"));
		this.pass1 = new JPasswordField();
		this.add(pass1);
		this.add(new JLabel("Introduce tu contraseña nueva otra vez:"));
		this.pass2 = new JPasswordField();
		this.add(pass2);
		
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
	}
	
	public boolean todoRelleno() {
		return !getOld().equals("") && !getPass1().equals("") && !getPass2().equals("");
	}
	
	public void setListener(CambiarPassUIListener list) {
		this.list = list;
	}
	
	public boolean coinciden() {
		return getPass1().equals(getPass2());
	}
	
	public String getOld() {
		char[] pass = old.getPassword();
		String res = "";
		for(char a : pass)
			res += a;
		return res;
	}
	
	public String getPass1() {
		char[] pass = pass1.getPassword();
		String res = "";
		for(char a : pass)
			res += a;
		return res;
	}
	
	public String getPass2() {
		char[] pass = pass2.getPassword();
		String res = "";
		for(char a : pass)
			res += a;
		return res;
	}

}
