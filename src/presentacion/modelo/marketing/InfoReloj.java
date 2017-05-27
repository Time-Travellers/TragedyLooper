package presentacion.modelo.marketing;
public class InfoReloj{
	
	private String nombre;
	private int numReloj;
	private double precio;
	
	public InfoReloj(String nombre, int numReloj, double precio){
		this.nombre = nombre;
		this.numReloj = numReloj;
		this.precio = precio;
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public int getNumReloj(){
		return numReloj;
	}
	
	public double getPrecio(){
		return precio;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(nombre);
		sb.append(" - ");
		sb.append(numReloj);
		sb.append(" relojes(");
		sb.append(precio);
		sb.append(" ?)");
		return sb.toString();
		
	}
}
