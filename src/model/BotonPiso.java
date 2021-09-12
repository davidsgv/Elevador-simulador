package model;

public class BotonPiso {
	private boolean iluminacion;
	
	public BotonPiso(){
		iluminacion = false;
	}
	
	public void setIluminacion(boolean estado){
		this.iluminacion = estado;
	}
	
	public boolean getIluminacion(){
		return iluminacion;
	}
	
}
