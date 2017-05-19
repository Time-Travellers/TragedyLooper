package presentacion.vista.usuario.SugerirGuion;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JSpinner;
import javax.swing.JTextArea;

import presentacion.vista.usuario.SugerirGuion.EventosDias.PanelDias;

public class SugerenciaGuion extends JDialog{
	
	private PanelParaEscribir bucles;
	private PanelParaEscribir titulo;
	private PanelSeleccionTrama trama;
	private PanelSeleccionSubtrama subtrama;
	private PanelDias dias;
	
	public SugerenciaGuion(){
		this.bucles=new PanelParaEscribir("Bucles");
		this.titulo=new PanelParaEscribir("Titulo");
		this.trama=new PanelSeleccionTrama();
		this.subtrama=new PanelSeleccionSubtrama();
	}
	
	public static void main(String[] args) {
		SugerenciaGuion prueba=new SugerenciaGuion();
	}

}
