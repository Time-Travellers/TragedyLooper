package tragedylooper.view.Admin;

import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class UsuariosReportadosUI extends JPanel{
	PanelGrande panel;
	public UsuariosReportadosUI(int n){
		this.panel=(new PanelGrande("Usuarios Reportados", n));
		this.add(panel);
	}

	public void setListener(ActionListener listener){
		panel.setListener(listener);
	}
	
public static void main(String args[]){
	JFrame ventana=new JFrame("prueba");
	ventana.setSize(800,600);
	ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	ventana.setContentPane(new UsuariosReportadosUI(10));
	ventana.setVisible(true);
}
	
}
