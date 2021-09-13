package model;

public class Persona{
	
	private Elevador elevador = null;
	
	public Persona(Elevador elevador){
		this.elevador = elevador;
	}
	
	/*public void setElevador(Elevador elevador){
		this.elevador = elevador;
	}*/
		
	public void entrarElevador() {
		Logger.log("Persona -> Presiona boton del elevador");
		elevador.setPersona(this);
		elevador.presionarBoton();
	}	
}
