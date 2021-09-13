package model;

public class Edificio {
	private Reloj reloj;
	private Bitacora bitacora;
	private Piso[] pisos;
	private Elevador elevador;
	
	public Edificio() {
		reloj = Reloj.CreateInstance(this);
		
		pisos = new Piso[] {new Piso(1), new Piso(2)};
		bitacora = new Bitacora(this);
		
		elevador = new Elevador(pisos);
		//elevador = Elevador.CreateInstance(pisos);
		
		pisos[0].setElevador(elevador);
		pisos[1].setElevador(elevador);
				
		reloj.startTime();
	}
	
	public void enviarTiempo(int segundos) {
		String mensaje = "Tiempo actual: "+Integer.toString(segundos)+" s";
		Logger.log(mensaje);
		
		elevador.elevadorLlegaPiso(segundos);
		if(pisos[0].existePersona() && pisos[1].existePersona()){
			if(pisos[0].getTiempoPersona() < pisos[1].getTiempoPersona()){
				pisos[0].llamarElevador(segundos);
			}
			else{
				pisos[1].llamarElevador(segundos);
			}
			//bitacora.actualizarTiempo(segundos);
		}
		else{
			if(pisos[0].existePersona()){
				pisos[0].llamarElevador(segundos);
			}
			if(pisos[1].existePersona()){
				pisos[1].llamarElevador(segundos);
			}
		}
		//else
		bitacora.actualizarTiempo(segundos);
		//elevador.elevadorLlegaPiso(segundos);
	}
	
	
	public Piso getPiso(int piso) {
		if(piso == 1) {
			return this.pisos[0];
		}
		else { // piso 2
			return this.pisos[1];
		}
	}
	
}
