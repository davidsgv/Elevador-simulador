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
	private int traslados;
	
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
		traslados = 0;
		
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
				Logger.log("Elevador -> Llegando a piso " + Integer.toString(piso));
				
				anunciarLlegada();
				
				enMovimiento = false;
				puerta.abrirPuerta();
				campana.sonarCampana();
				
				if(persona != null){
					Logger.log("Elevador -> Persona sale de ascensor de piso " + Integer.toString(piso));
					persona = null;
					// Si sube con persona hay que verificar que no haya una persona para cerrar las puertas inmediatamente
					if(pisoVacio(pisos[piso-1])){
						puerta.cerrarPuerta();
					}					
				}
				else{
					// Si sube vacio es porque hay una persona esperando
					Logger.log("Elevador -> Elevador llega vacio a piso " + Integer.toString(piso));
				}
				
			}
			else{
				boton.apagarLuz();
				//Logger.log("Elevador -> En movimiento");
			}
		}
		/*else{
			Logger.log("Elevador -> Piso actual " + Integer.toString(piso));
		}*/
	}
	
	private void anunciarLlegada(){
		Logger.log("Elevador -> Anunciar llegada a piso " + Integer.toString(piso));
		pisos[piso-1].llegaElevador(); //Anunciar llegada a piso
	}
	
	private boolean pisoVacio(Piso piso){
		return !piso.existePersona();
	}
	
	public boolean llamada(int piso, int tiempo, Persona persona){
		if(!enMovimiento){
			enMovimiento = true;
			this.tiempo = tiempo+5;
			if(this.piso == piso){
				Logger.log("Elevador -> Persona en elevador desde " + Integer.toString(piso));
				//this.persona = persona;
				persona.entrarElevador();
				if(this.persona == null){
					this.persona = new Persona(this);
				}
				puerta.cerrarPuerta();
				//cambiarPiso();
				return true;
			}
			else{
				cambiarPiso();
			}
			puerta.cerrarPuerta(); // Cerrar despues de que ingrese la persona
		}
		
		return false;
	}
	
	//TODO
	//El elevador cierra su puerta y se queda en el piso si no hay una persona esperando 
	//y el boton del otro piso no se encuentra activo.
	//El elevador toma 5 segundos para moverse de un piso al otro. 
}
