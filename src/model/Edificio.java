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
		
		
		reloj.startTime();
	}
	
	public void enviarTiempo(int segundos) {
		Logger.log("Actualizando tiempos");
		bitacora.actualizarTiempo(segundos);
		//elevador.actualizarTiempo(segundos);
	}
	
	
	public Piso getPiso(int piso) {
		if(piso == 1) {
			return this.pisos[0];
		}
		else {
			return this.pisos[1];
		}
	}
	
}
