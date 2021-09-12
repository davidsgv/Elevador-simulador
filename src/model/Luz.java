package model;

public class Luz(){

	private boolean estado; //false = apagado | true = encendido
	
	public Luz(){
		this.estado = false;
	}
	
	public void setEstado(boolean estado){
		this.estado = estado;
	}
	
	public boolean getEstado(){
		return estado;
	}
	
}
