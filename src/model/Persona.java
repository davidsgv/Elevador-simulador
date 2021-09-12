package model;

public class Persona{
	
	private boolean existe;
	
	public Persona{
		this.existe = false;
	}
	
	public void setExiste(boolean existe){
		this.existe = existe;
	}
	
	public boolean getExiste(){
		return existe;
	}
	
	public void presionarBotonElevador(BotonElevador botonElevador){
		botonElevador.setIluminacion(true);
	}
	
}
