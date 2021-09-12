package model;

public class Elevador {
	private static Elevador instance = null;
	
	private Puerta puerta;
	private Campana campana;
	private BotonElevador boton;
	
	private Persona persona;
	private Piso[] pisos;
	private Piso pisoElevador;
	
	public Elevador(Piso[] pisos) {
		puerta = new Puerta();
		campana = new Campana();
		boton = new BotonElevador();
		
		this.pisos = pisos;
		
		pisoElevador = pisos[0];
	}
	
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
	public void presionarBoton() {
		boton.presionarBoton();
		cambiarPiso();
	}
	
	public void cambiarPiso() {
		//moverse al otro piso
	}
	
	public void ElevadorLlegaPiso() {
		boton.apagarLuz();
		puerta.abrirPuerta();
		campana.sonarCampana();
	}
	
	//TODO
	//El elevador cierra su puerta y se queda en el piso si no hay una persona esperando 
	//y el botón del otro piso no se encuentra activo.
	//El elevador toma 5 segundos para moverse de un piso al otro. 
}
