package presentacion.controlador.comprarreloj;

import presentacion.modelo.marketing.InfoReloj;

public class ComprarRelojEvent {
	public enum ComprarRelojType {
		Comprar, VerAnuncio
	}

	private ComprarRelojType tipo;
	private InfoReloj info;

	public ComprarRelojEvent(ComprarRelojType t) {
		this.tipo = t;
	}

	public ComprarRelojEvent(ComprarRelojType t, InfoReloj info) {
		this.info = info;
		this.tipo = t;
	}

	public String getComprarRelojType() {
		return tipo.toString();
	}

	public InfoReloj getInfo() {
		return info;
	}

}
