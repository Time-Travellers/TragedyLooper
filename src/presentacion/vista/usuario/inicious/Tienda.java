package presentacion.vista.usuario.inicious;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import presentacion.controlador.iniciousuario.InicioUsuarioEvent;
import presentacion.controlador.iniciousuario.InicioUsuarioListener;
import presentacion.controlador.iniciousuario.InicioUsuarioEvent.PrinciUsuarioType;
import presentacion.modelo.usuario.Jugador;

public class Tienda extends JPanel {

	private static final long serialVersionUID = -660897330434834732L;

	private JLabel tienda;
	private PanelBotInfoIcono relojes;
	private PanelBotInfoIcono nivel;

	public Tienda(Jugador jugador, ArrayList<InicioUsuarioListener> listeners) {
		JPanel panelmayor = new JPanel();
		this.setLayout(new BoxLayout(panelmayor, BoxLayout.X_AXIS));

		relojes = new PanelBotInfoIcono(jugador.getReloj(), "Relojes: ", null, (e) -> {
			for (int i = 0; i < listeners.size(); ++i)
				listeners.get(i).notificarPrinciUsuario(new InicioUsuarioEvent(PrinciUsuarioType.comprarRelojes));
		});
		nivel = new PanelBotInfoIcono(jugador.getNivel(), "Nivel: ", null, (e) -> {
			for (int i = 0; i < listeners.size(); ++i)
				listeners.get(i).notificarPrinciUsuario(new InicioUsuarioEvent(PrinciUsuarioType.comprarNivel));
		});
		panelmayor.add(relojes);
		panelmayor.add(nivel);
		panelmayor.setBackground(new Color(172, 246, 213));
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		tienda = new JLabel("Tienda");
		tienda.setFont(new Font("", Font.BOLD, 20));
		tienda.setAlignmentX(CENTER_ALIGNMENT);
		this.add(tienda);
		this.add(Box.createRigidArea(new Dimension(0, 10)));
		this.add(panelmayor);
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		this.setBackground(new Color(172, 246, 213));
		this.setPreferredSize(new Dimension(450, 200));
	}

}
