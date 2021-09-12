package model;

public class Persona{
	
	int pisoOrigen;
	int pisoDestino;
	
	public enum Posicion{
		PISO_1(1),
		PISO_2(2),
		ELEVADOR(0)
	}
	
	Posicion posicion;
	
	public void setPosicion(){
		
	}
	
	public void presionarBotonElevador(BotonElevador botonElevador){
		botonElevador.setIluminacion(true);
	}
	
}
