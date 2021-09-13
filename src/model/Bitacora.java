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
	
	private int tiempo;
	private int prioridad;
	
	public Bitacora(Edificio edificio) {		
		tiempoPersona1 = 0;
		tiempoPersona2 = 0;
		
		this.edificio = edificio;
		
		//obtener referencia de los pisos
		piso1 = edificio.getPiso(1);
		piso2 = edificio.getPiso(2);
		
		prioridad = 0;
	}
	
	public void actualizarTiempo(int segundos) {
		tiempo = segundos;
		if(segundos == 0){
			tiempoPersona1 = establecerTiempo(1,tiempo);
			tiempoPersona2 = establecerTiempo(2,tiempo);
		}
		else{
			/*if(existePersona()){
				establecerPrioridad();
			}*/
			if(tiempoPersona1 == segundos){
				if(!piso1.existePersona()) {
					crearPersona(piso1,new Persona());
					tiempoPersona1 = establecerTiempo(1,tiempo);
				}
				else{
					tiempoPersona1++; // Crear en el siguiente segundo
					Logger.log("Crear persona piso 1 en el siguiente segundo");
				}
			}
			if(tiempoPersona2 == segundos){
				if(!piso2.existePersona()) {
					crearPersona(piso2,new Persona());
					tiempoPersona2 = establecerTiempo(2,tiempo);
				}
				else{
					tiempoPersona2++; // Crear en el siguiente segundo
					Logger.log("Crear persona piso 2 en el siguiente segundo");
				}
			}
		}
	}
	
	private void validarAscensor(Piso piso){
		if(piso.existePersona()){
			Logger.log("Persona en espera en piso " + piso.getNumero());
			if(piso.llamarElevador(tiempo)){ prioridad = 0; };
		}
	}
	
	private boolean existePersona(){
		return piso1.existePersona() || piso2.existePersona();
	}
	
	private boolean existePersona(Piso piso){
		return piso.existePersona();
	}
	
	private void establecerPrioridad(){
		if(tiempoPersona1<=tiempoPersona2 && (prioridad == 0 || prioridad == 1)){		
			validarAscensor(piso1);
			validarAscensor(piso2);
			if(prioridad == 0){prioridad = 1;}
		}
		else{
			//if(tiempoPersona1>tiempoPersona2 && (prioridad == 0 || prioridad == 2)){
				validarAscensor(piso2);
				validarAscensor(piso1);
				if(prioridad == 0){prioridad = 2;}
			/*}
			else{
				if(prioridad == 1){
					validarAscensor(piso1);
				}
				else{
					validarAscensor(piso2);
				}
			}*/			
		}
	}
	
	private int establecerTiempo(int piso, int segundos){
		int tiempo = ((int)(Math.random()*16) + 5) + segundos;
		String mensaje = "Tiempo generacion siguiente persona piso " + Integer.toString(piso) + ": " + tiempo;
		Logger.log(mensaje);
		return tiempo;
	}

	public void crearPersona(Piso piso, Persona persona) {
		piso.setPersona(persona, tiempo);
	}
}
