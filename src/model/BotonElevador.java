package model;

public class BotonElevador {
<<<<<<< HEAD
	private boolean estadoIluminacion;
	private boolean estadoBoton;
	
	public BotonElevador() {
		estadoIluminacion = false;
		estadoBoton = false;
	}
	
	public void presionarBoton() {
		estadoBoton = true;
		estadoIluminacion = true;
	}
	
	public void soltarBoton() {
		estadoBoton = false;
	}
	
	public void apagarLuz() {
		estadoIluminacion = false;
	}
	
}
