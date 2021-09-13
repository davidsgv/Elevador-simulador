package model;

public class BotonElevador {
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
	
	public void restablecerBoton(){
		Logger.log("BotonElevador -> Restablecer");
		estadoBoton = true;
	}
	
}
