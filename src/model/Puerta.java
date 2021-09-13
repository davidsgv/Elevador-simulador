package model;

public class Puerta {
	private boolean estado;
	
	public Puerta() {
		this.estado = true;
	}
	
	public String getEstado(){
		return (estado)?"cerradas":"abiertas";
	}
	
	public void abrirPuerta() {
		this.estado = false;
		Logger.log("Puerta -> Abriendo puerta");
	}
	
	public void cerrarPuerta() {
		this.estado = true;
		Logger.log("Puerta -> Cerrando puerta");
	}
}
