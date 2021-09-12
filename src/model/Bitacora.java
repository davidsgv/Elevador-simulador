package model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;


public class Bitacora {
	private Edificio edificio;
	private Piso piso1;
	private Piso piso2;
	private int tiempoPersona1;
	private int tiempoPersona2;
	
	private Reloj reloj;
	private Timer timerpiso1;
	private Timer timerpiso2;
	
	public Bitacora(Edificio edificio) {		
		tiempoPersona1 = 0;
		tiempoPersona2 = 0;
		
		this.edificio = edificio;
		
		//obetener referencia de los pisos
		piso1 = edificio.getPiso(1);
		piso2 = edificio.getPiso(2);
	}
	
	public void actualizarTiempo(int segundos) {
		if(tiempoPersona1 < segundos) {
			tiempoPersona1 = (int)(Math.random() * 16 + 5) + segundos;
			String mensaje = "Tiempo generacion persona piso 1: " + tiempoPersona1;
			Logger.log(mensaje);
		}
		if(tiempoPersona2 < segundos) {
			tiempoPersona2 = (int)(Math.random() * 16 + 5) + segundos;
			String mensaje = "Tiempo generacion persona piso 2: " + tiempoPersona2;
			Logger.log(mensaje);
		}
		
		
		if(tiempoPersona1 == segundos && !piso1.existePersona()) {
			crearPersona(piso1,new Persona());
		}
		if(tiempoPersona2 == segundos && !piso2.existePersona()) {
			crearPersona(piso2,new Persona());
		}
	}
	

	public void crearPersona(Piso piso, Persona persona) {
		piso.setPersona(persona);
	}
}
