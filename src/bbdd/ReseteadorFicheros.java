package bbdd;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import presentacion.modelo.gameMastering.Reporte;
import presentacion.modelo.juego.InfoGuion;
import presentacion.modelo.usuario.Administrador;
import presentacion.modelo.usuario.Paises;
import presentacion.modelo.usuario.Usuario;

public class ReseteadorFicheros {

	static File file1 = new File("src/resources/usuarios.ser");
	static File file2 = new File("src/resources/reportados.ser");
	static File file3 = new File("src/resources/guiones.ser");
	static File file4 = new File("src/resources/guiones_propuestos.ser");

	public static void main(String... args) throws IOException {

		file1.createNewFile();
		HashMap<String, Usuario> usuarios = new HashMap<String, Usuario>();
		usuarios.put("admin1",
				new Administrador("admin1", "admin1", true, "Administrador 1", 100, Paises.China, "admin1@gmail.com"));
		usuarios.put("admin2",
				new Administrador("admin2", "admin2", true, "Administrador 2", 200, Paises.Nueva_Zelanda, "admin2@gmail.com"));
		usuarios.put("admin3", 
				new Administrador("admin3", "admin3", true, "Administrador 3", 300, Paises.Japón, "admin3@gmail.com"));
		new IO<Usuario>("usuarios.ser").almacenar(usuarios);

		file2.createNewFile();
		HashMap<String, Reporte> reportes = new HashMap<String, Reporte>();
		new IO<Reporte>("reportados.ser").almacenar(reportes);

		file3.createNewFile();
		HashMap<String, InfoGuion> guiones = new HashMap<String, InfoGuion>();
		InfoGuion guion = new InfoGuion(null, "Cuando las gaviotas lloran", null, null, 8, 2, null, null, null);
		guion.setNivel(0);
		guiones.put(guion.getTitulo(), guion);
		InfoGuion guion1 = new InfoGuion(null, "Leyenda de la Bruja Dorada", null, null, 8, 2, null, null, null);
		guion1.setNivel(1);
		guiones.put(guion1.getTitulo(), guion1);
		InfoGuion guion2 = new InfoGuion(null, "Turno de la Bruja Dorada", null, null, 8, 2, null, null, null);
		guion2.setNivel(2);
		guiones.put(guion2.getTitulo(), guion2);
		InfoGuion guion3 = new InfoGuion(null, "Banquete de la Bruja Dorada", null, null, 8, 2, null, null, null);
		guion3.setNivel(3);
		guiones.put(guion3.getTitulo(), guion3);
		InfoGuion guion4 = new InfoGuion(null, "Alianza de la Bruja Dorada", null, null, 8, 2, null, null, null);
		guion4.setNivel(4);
		guiones.put(guion4.getTitulo(), guion4);
		InfoGuion guion5 = new InfoGuion(null, "Fin de la Bruja Dorada", null, null, 8, 2, null, null, null);
		guion5.setNivel(5);
		guiones.put(guion5.getTitulo(), guion5);
		InfoGuion guion6 = new InfoGuion(null, "Amanecer de la Bruja Dorada", null, null, 8, 2, null, null, null);
		guion6.setNivel(6);
		guiones.put(guion6.getTitulo(), guion6);
		InfoGuion guion7 = new InfoGuion(null, "Requiem de la Bruja Dorada", null, null, 8, 2, null, null, null);
		guion7.setNivel(7);
		guiones.put(guion7.getTitulo(), guion7);
		InfoGuion guion8 = new InfoGuion(null, "Crepusculo de la Bruja Dorada", null, null, 8, 2, null, null, null);
		guion8.setNivel(8);
		guiones.put(guion8.getTitulo(), guion8);
		InfoGuion guion9 = new InfoGuion(null, "Cuando las cigarras lloran", null, null, 8, 2, null, null, null);
		guion9.setNivel(0);
		guiones.put(guion9.getTitulo(), guion9);
		InfoGuion guion10 = new InfoGuion(null, "Raptado por demonios", null, null, 8, 2, null, null, null);
		guion10.setNivel(1);
		guiones.put(guion10.getTitulo(), guion10);
		InfoGuion guion11 = new InfoGuion(null, "El fluir del algodon", null, null, 8, 2, null, null, null);
		guion11.setNivel(2);
		guiones.put(guion11.getTitulo(), guion11);
		InfoGuion guion12 = new InfoGuion(null, "Asesinato maldito", null, null, 8, 2, null, null, null);
		guion12.setNivel(3);
		guiones.put(guion12.getTitulo(), guion12);
		InfoGuion guion13 = new InfoGuion(null, "Tiempo desperdiciado", null, null, 8, 2, null, null, null);
		guion13.setNivel(4);
		guiones.put(guion13.getTitulo(), guion13);
		InfoGuion guion14 = new InfoGuion(null, "Revelaciones", null, null, 8, 2, null, null, null);
		guion14.setNivel(5);
		guiones.put(guion14.getTitulo(), guion14);
		InfoGuion guion15 = new InfoGuion(null, "Expiacion", null, null, 8, 2, null, null, null);
		guion15.setNivel(6);
		guiones.put(guion15.getTitulo(), guion15);
		InfoGuion guion16 = new InfoGuion(null, "Masacre", null, null, 8, 2, null, null, null);
		guion16.setNivel(7);
		guiones.put(guion16.getTitulo(), guion16);
		InfoGuion guion17 = new InfoGuion(null, "Musica del festival", null, null, 8, 2, null, null, null);
		guion17.setNivel(8);
		guiones.put(guion17.getTitulo(), guion17);
		new IO<InfoGuion>("guiones.ser").almacenar(guiones);
		
		file4.createNewFile();
		HashMap<String, InfoGuion> guionesPropuestos = new HashMap<String, InfoGuion>();
		new IO<InfoGuion>("guiones_propuestos.ser").almacenar(guionesPropuestos);
	}

}
