package model;

public class Persona{
	
	private Elevador elevador = null;
	
	
	
	
	public void entrarElevador() {
		elevador.setPersona(this);
		elevador.presionarBoton();
	}
	
}
