package model;

public class Campana {
	private boolean estado;
	
	public Campana() {
		this.estado = false;
	}
	
	public String getEstado(){
		if(estado == false) {
			return "No esta sonando";
		}
		else {
			return "Esta sonando";
		}
	}
}
