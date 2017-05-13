package presentacion.vista.usuario;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import presentacion.vista.gameMastering.UsuariosReportadosUI;
/**
 * Ejecutar este
 * @author jfiwj
 *
 */
public class InicioAdminUI extends JPanel{
	private MensajesAdminUI mensajes;
	private GuionesPropuestosUI guiones;
	private UsuariosReportadosUI reportados;
	/**
	 * este para las pruebas
	 * @param name
	 * @param numMensajes
	 * @param propuestos
	 * @param report
	 */
	public InicioAdminUI(String name, int numMensajes, int propuestos, int report){
		FlowLayout layout=new FlowLayout();
		layout.setAlignment(HEIGHT);
		layout.setVgap(8);
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		this.add(new JLabel(name));
		mensajes=new MensajesAdminUI(numMensajes);
		this.add(mensajes);
		guiones=new GuionesPropuestosUI(propuestos);
		this.add(guiones);
		reportados=new UsuariosReportadosUI(report);
		this.add(reportados);
		this.add(new JLabel("    "));
	}
	/**
	 * 
	 * Usar este en el definitivo
	 * @param name
	 * @param numMensajes
	 * @param propuestos
	 * @param report
	 * @param l1
	 * @param l2
	 * @param l3
	 */
	public InicioAdminUI(String name, int numMensajes, int propuestos, int report,
			ActionListener l1, ActionListener l2, ActionListener l3){
		FlowLayout layout=new FlowLayout();
		layout.setAlignment(HEIGHT);
		layout.setVgap(8);
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		this.add(new JLabel(name));
		mensajes=new MensajesAdminUI(numMensajes);
		mensajes.setListener(l1);
		this.add(mensajes);
		guiones=new GuionesPropuestosUI(propuestos);
		guiones.setListener(l2);
		this.add(guiones);
		reportados=new UsuariosReportadosUI(report);
		reportados.setListener(l3);
		this.add(reportados);
		this.add(new JLabel("    "));
	}
	
	public static void main(String args[]){
		JFrame ventana=new JFrame("prueba");
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setSize(800,400);
		ventana.setContentPane(new InicioAdminUI("peter", 10 ,1 ,5));
		ventana.setVisible(true);
	}
	
}
