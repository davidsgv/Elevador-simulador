package model;

public class Luz{

	//false = apagado | true = encendido
	private boolean estado;
	
	public Luz(){
		this.estado = false;
	}
	
	public void apagar(){
		estado = false;
	}
	
	public void encender(){
		estado = true;
	}
	
}
