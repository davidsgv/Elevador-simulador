package model;

public class Elevador {
	private static Elevador instance = null;
	
	private Puerta puerta;
	private Campana campana;
	private BotonElevador boton;
	
	private Persona persona;
	private Piso[] pisos;
	private Piso pisoElevador;
	
	private int piso;
	private int tiempo;
	
	//private Edificio edificio;
	
	public boolean enMovimiento;
	
	//private Elevador(Piso[] pisos) {
	public Elevador(Piso[] pisos) {
		puerta = new Puerta();
		campana = new Campana();
		boton = new BotonElevador();
		
		persona = null;
		
		this.pisos = pisos;
		
		tiempo = 0;
		
		pisoElevador = pisos[0]; // Inicia en piso 1
		piso = 1;
		
		enMovimiento = false;
	}
	
	/*public static Elevador CreateInstance(Piso[] pisos) {
		if (instance == null) {
            		instance = new Elevador(pisos);
	        }
        	return instance;
	}
	
	public static Elevador getInstance(){
		if (instance == null){
			Logger.log("ERROR: Instance de elevador no ha sido creada");
		}
		return instance;
	}*/
	
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
	public void presionarBoton() {
		boton.presionarBoton();
		cambiarPiso();
	}
	
	public void cambiarPiso() {
		//moverse al otro piso
		if(piso == 1){ piso = 2; }
		else{ piso = 1; }
	}
	
	public void elevadorLlegaPiso(int tiempo) {
		if(enMovimiento){
			if(this.tiempo == tiempo){
				if(persona != null){
					Logger.log("Elevador -> Persona sale de ascensor de piso " + Integer.toString(piso));
					persona = null;
				}
				else{
					Logger.log("Elevador -> Elevador llega vacio a piso " + Integer.toString(piso));
				}
				enMovimiento = false;
				boton.apagarLuz();
				puerta.abrirPuerta();
				campana.sonarCampana();
			}
			else{
				Logger.log("Elevador -> En movimiento");
			}
		}
		else{
			Logger.log("Elevador -> Piso actual " + Integer.toString(piso));
		}
	}
	
	public boolean llamada(int piso, int tiempo, Persona persona){
		if(!enMovimiento){
			enMovimiento = true;
			this.tiempo = tiempo+5;
			if(this.piso == piso){
				Logger.log("Elevador -> Persona en elevador desde " + Integer.toString(piso));
				//this.persona = persona;
				if(this.persona == null){
					this.persona = new Persona();
				}
				cambiarPiso();
				return true;
			}
			else{
				cambiarPiso();
			}
		}
		
		return false;
	}
	
	//TODO
	//El elevador cierra su puerta y se queda en el piso si no hay una persona esperando 
	//y el boton del otro piso no se encuentra activo.
	//El elevador toma 5 segundos para moverse de un piso al otro. 
}
