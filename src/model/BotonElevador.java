package model;

public class BotonElevador {
	private boolean iluminacion;
	
	public BotonElevador(){
		iluminacion = false;
	}
	
	public void setIluminacion(boolean estado){
		this.iluminacion = estado;
	}
	
	public boolean getIluminacion(){
		return iluminacion;
	}
	
}
