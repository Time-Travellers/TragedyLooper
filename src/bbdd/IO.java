package bbdd;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.logging.Logger;

public class IO< T > {
	
	final private String name;
	final private String dir = "src/tragedylooper/ficheros/";
	final private Logger log = Logger.getLogger("log");
	
	public IO(String name){
		this.name = name;
	}
	
	public void almacenar(HashMap< String, T > list){
		try{
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(dir + name));
			oos.writeObject(list);
			oos.close();
		} catch (IOException e){
			log.severe("Error al abrir el fichero " + name + " para guardar");
		}
	}
	
	public HashMap< String, T > leer(){
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(dir + name));
			@SuppressWarnings("unchecked")
			HashMap< String, T > ret = (HashMap< String, T >) ois.readObject();
			ois.close();
			return ret;
		} catch (IOException e) {
			log.severe("Error al abrir el fichero " + name + " de guiones para cargar");
		} catch (ClassNotFoundException e) {
			log.severe("No se ha encontrado la clase de los datos");
		}
	    return null;
	}

}
