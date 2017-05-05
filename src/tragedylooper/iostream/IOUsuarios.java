package tragedylooper.iostream;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import tragedylooper.Usuario;

public class IOUsuarios {
	
	final private static String ficheroJug = "src/tragedylooper/ficheros/jugadores.txt";
	final private static String ficheroAdm = "src/tragedylooper/ficheros/administradores.txt";
	
	public static void almacenar(List<Usuario> listUsuarios){
		try{
			PrintWriter escJug = new PrintWriter(new FileWriter(ficheroJug));
			PrintWriter escAdm = new PrintWriter(new FileWriter(ficheroAdm));
			
			for(int i = 0; i < listUsuarios.size(); ++i)
				if(listUsuarios.get(i).id.charAt(0)=='a')
						almacenarAdmin(escAdm, listUsuarios.get(i));
				else
						almacenarJug(escJug, listUsuarios.get(i));
			
		} catch (IOException e){
			System.out.println("Error al abrir el fichero de usuarios para guardar");
		} finally {
			
		}
		
	}

	private static void almacenarAdmin(PrintWriter escAdm, Usuario usuario) {
		
	}

	private static void almacenarJug(PrintWriter escritor, Usuario usuario) {
		escritor.println("-XXX-");
		escritor.println(usuario.id);
		escritor.println(usuario.password);
		escritor.println(usuario.datos.nombre + ' ' + usuario.datos.edad + ' ' + usuario.datos.pais);
		escri
	}
	
}
