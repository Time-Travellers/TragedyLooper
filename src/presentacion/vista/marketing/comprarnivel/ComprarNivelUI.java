package presentacion.vista.marketing.comprarnivel;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import presentacion.modelo.marketing.InfoNivel;

public class ComprarNivelUI extends JPanel {

	private static final long serialVersionUID = -6931407663483390176L;

	private ComprarNivelUIListener list;

	// Interfaz a implementar si se quieren insertar listeners:
	public interface ComprarNivelUIListener {
		void confirmar();

		void salir();
	}

	public void setNivelListener(ComprarNivelUIListener listener) {
		this.list = listener;
	}

	public ComprarNivelUI(InfoNivel nivelSiguiente) {

		JPanel todo = new JPanel();

		todo.setLayout(new BoxLayout(todo, BoxLayout.Y_AXIS));
		todo.setAlignmentX(CENTER_ALIGNMENT);

		todo.setBorder(BorderFactory.createLineBorder(Color.black));

		// titulo
		JLabel title = new JLabel(
				"¿Quieres comprar el siguiente nivel por " + nivelSiguiente.getPrecio() + " relojes?");
		title.setFont(new Font("", 20, 20));
		title.setAlignmentX(CENTER_ALIGNMENT);

		// panel para la lista de guiones
		JPanel niveles = new JPanel();
		niveles.setLayout(new BoxLayout(niveles, BoxLayout.Y_AXIS));
		niveles.setBorder(new EmptyBorder(20, 30, 20, 30));
		niveles.setPreferredSize(new Dimension(500, 200));
		niveles.setAlignmentX(CENTER_ALIGNMENT);

		JLabel info = new JLabel("Contiene los siguientes guiones:");
		info.setFont(new Font("", 15, 15));
		info.setAlignmentX(CENTER_ALIGNMENT);
		niveles.add(info);
		niveles.add(Box.createRigidArea(new Dimension(0, 30)));

		int rojo = 250, verde = 250, azul = 100;
		for (int i = 0; i < nivelSiguiente.getGuiones().size(); ++i) {
			JLabel guion = new JLabel(nivelSiguiente.getGuiones().get(i));
			guion.setBackground(new Color(rojo, verde, azul));
			guion.setAlignmentX(CENTER_ALIGNMENT);
			guion.setOpaque(true);
			guion.setBorder(new EmptyBorder(0, 20, 0, 20));
			guion.setMaximumSize(new Dimension(250, 30));

			niveles.add(guion);
			niveles.add(Box.createRigidArea(new Dimension(0, 10)));
			verde -= 20;
			azul -= 20;
		}

		// panel inferior para los dos botones
		JPanel south = new JPanel();
		south.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 0));

		// boton aceptar
		JButton aceptar = new JButton("Aceptar");
		aceptar.addActionListener((e) -> list.confirmar());
		aceptar.setBackground(new Color(150, 200, 150));

		// boton cancelar
		JButton cancelar = new JButton("Cancelar");
		cancelar.setBackground(new Color(250, 70, 50));
		cancelar.addActionListener((e) -> list.salir());

		south.add(aceptar);
		south.add(cancelar);

		todo.add(title);
		todo.add(Box.createRigidArea(new Dimension(0, 10)));
		todo.add(niveles);
		todo.add(Box.createVerticalGlue());
		todo.add(south, BorderLayout.SOUTH);

		todo.setBorder(new EmptyBorder(20, 20, 20, 20));
		this.setPreferredSize(new Dimension(600, 350));

		JPanel scroller = new JPanel();
		scroller.setLayout(new BorderLayout());
		scroller.add(new JScrollPane(todo));
		this.setLayout(new BorderLayout());
		this.add(scroller, BorderLayout.CENTER);
		this.setVisible(true);

		this.setVisible(true);
	}
}
