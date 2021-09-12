package model;

public class Puerta {
	private boolean estado;
	
	public Puerta() {
		this.estado = true;
	}
	
	public String getEstado(){
		if(estado == true) {
			return "cerradas";
		}
		else {
			return "abiertas";
		}
	}
	
	public void abrirPuerta() {
		this.estado = false;
	}
	
	public void cerrarPuerta() {
		this.estado = true;
	}
}
