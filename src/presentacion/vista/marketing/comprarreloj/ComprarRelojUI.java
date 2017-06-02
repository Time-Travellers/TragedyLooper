package presentacion.vista.marketing.comprarreloj;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import presentacion.controlador.comprarreloj.ComprarRelojEvent;
import presentacion.controlador.comprarreloj.ComprarRelojEvent.ComprarRelojType;
import presentacion.controlador.comprarreloj.ComprarRelojListenable;
import presentacion.controlador.comprarreloj.ComprarRelojListener;
import presentacion.modelo.marketing.InfoReloj;

public class ComprarRelojUI extends JPanel implements ComprarRelojListenable {

	private static final long serialVersionUID = 3764237795715936211L;

	private JButton verAnuncio;
	private ArrayList<JButton> botones;
	private JButton cancelar;
	private ArrayList<ComprarRelojListener> listeners;

	public ComprarRelojUI(boolean a, ArrayList<InfoReloj> paquetes, JDialog jc) {

		JPanel container = new JPanel();
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

		listeners = new ArrayList<ComprarRelojListener>();

		// botones de comprar reloj con dinero

		botones = new ArrayList<JButton>();

		// boton de comprar reloj viendo anuncios
		verAnuncio = new JButton("1 reloj (Ver anuncio)");
		verAnuncio.setMaximumSize(new Dimension(500, 30));
		verAnuncio.setBackground(new Color(250, 250, 100));
		verAnuncio.setAlignmentX(CENTER_ALIGNMENT);
		verAnuncio.addActionListener((e) -> {
			for (int i = 0; i < listeners.size(); ++i)
				listeners.get(i).notificarComprarReloj(new ComprarRelojEvent(ComprarRelojType.VerAnuncio));
			jc.dispose();
		});

		if (a) {
			verAnuncio.setVisible(true);
			verAnuncio.setEnabled(true);
		} else {
			verAnuncio.setVisible(false);
			verAnuncio.setEnabled(false);
		}

		container.add(verAnuncio);
		container.add(Box.createRigidArea(new Dimension(0, 10)));

		int rojo = 250, verde = 230, azul = 80;
		botones = new ArrayList<JButton>();
		for (int i = 0; i < paquetes.size(); ++i) {
			Color color = new Color(rojo, verde, azul);
			InfoReloj info = paquetes.get(i);

			JButton button = new JButton(info.toString());
			button.setMaximumSize(new Dimension(500, 30));

			button.setVisible(true);
			button.setAlignmentX(CENTER_ALIGNMENT);
			button.setBackground(color);
			button.addActionListener((e) -> {
				for (int j = 0; j < listeners.size(); ++j)
					listeners.get(j).notificarComprarReloj(new ComprarRelojEvent(ComprarRelojType.Comprar, info));
				jc.dispose();
			});
			botones.add(button);
			container.add(button);
			container.add(Box.createRigidArea(new Dimension(0, 10)));
			verde -= 15;
			azul -= 10;
		}

		// boton cancelar
		cancelar = new JButton("Cancelar");
		cancelar.setBackground(new Color(250, 50, 50));
		cancelar.addActionListener((e) -> {
			jc.dispose();
		});
		cancelar.setAlignmentX(RIGHT_ALIGNMENT);

		JPanel south = new JPanel();
		south.setLayout(new FlowLayout(FlowLayout.RIGHT));
		south.add(cancelar);

		container.add(Box.createRigidArea(new Dimension(0, 20)));
		container.add(south, BorderLayout.SOUTH);
		container.setBorder(new EmptyBorder(20, 20, 20, 20));
		container.setPreferredSize(new Dimension(600, 350));

		JPanel scroller = new JPanel();
		scroller.setLayout(new BorderLayout());
		scroller.add(new JScrollPane(container));
		this.setLayout(new BorderLayout());
		this.add(scroller, BorderLayout.CENTER);
		this.setVisible(true);

		this.setVisible(true);
	}

	@Override
	public void addComprarRelojListener(ComprarRelojListener list) {
		listeners.add(list);
	}

}
