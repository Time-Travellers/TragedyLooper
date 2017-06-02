package presentacion.modelo.marketing;

import java.util.ArrayList;

public class InfoNivel {
	private int nivel;
	private int precio;
	private ArrayList<String> guiones;

	public InfoNivel(int nivel, int precio, ArrayList<String> guiones) {
		this.nivel = nivel;
		this.precio = precio;
		this.guiones = guiones;
	}

	public int getNivel() {
		return nivel;
	}

	public int getPrecio() {
		return precio;
	}

	public ArrayList<String> getGuiones() {
		return guiones;
	}
}
