package negocio;

import integracion.factorias.DAO_FactoryGuion;
import integracion.factorias.DAO_FactoryUsuarios;

import java.util.ArrayList;

import presentacion.modelo.juego.InfoGuion;
import presentacion.modelo.marketing.InfoNivel;
import presentacion.modelo.marketing.Tienda;
import presentacion.modelo.usuario.Jugador;

public class SA_Marketing {

	public Tienda iniciarTienda() {
		ArrayList<InfoNivel> list = new ArrayList<InfoNivel>();
		for (int i = 0; i < Tienda.NIVEL; ++i)
			list.add(new InfoNivel(i + 1, 25 * (i + 1), new ArrayList<String>()));
		ArrayList<InfoGuion> guiones = new ArrayList<InfoGuion>(
				DAO_FactoryGuion.getFactoria().creaListaDAO().leer().values());
		for (int i = 0; i < guiones.size(); ++i) {
			list.get(guiones.get(i).getNivel()).getGuiones().add(guiones.get(i).getTitulo());
		}
		return new Tienda(list);
	}

	public void comprarRelojes(Jugador usuario, boolean anuncio, int relojes) {
		if (anuncio) {
			usuario.setAnuncios(usuario.getAnuncios() - 1);
			usuario.setReloj(usuario.getReloj() + 1);
		} else {
			usuario.setReloj(usuario.getReloj() + relojes);
		}
		DAO_FactoryUsuarios.getFactoria().creaDAO().actualizar(usuario);
	}

	public boolean comprarNivel(Jugador usuario, InfoNivel nivel) {
		if (usuario.getReloj() >= nivel.getPrecio()) {
			usuario.setNivel(usuario.getNivel() + 1);
			usuario.setReloj(usuario.getReloj() - nivel.getPrecio());
			DAO_FactoryUsuarios.getFactoria().creaDAO().actualizar(usuario);
			return true;
		} else
			return false;
	}

}
