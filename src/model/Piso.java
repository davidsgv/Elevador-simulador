package model;

public class Piso{
	private boolean empty; // Hay una persona en el piso?
	private Luz luz;
	private BotonElevador botonElevador;
	
	public Piso(){
		empty = true;
		luz = new Luz();
		botonElevador = new BotonElevador();
	}
	
	public void personaExiste(boolean state){
		this.empty = state;
	}
	
	public void cambiarLuz(boolean estado){
		luz.setEstado(estado);
	}
	
	public void encenderBotonElevador(boolean iluminacion){
		botonElevador.setIluminacion(iluminacion);
	}
	
	public boolean getLuz(){
		return luz.getEstado();
	}
	
	public boolean getBotonElevador(){
		return botonElevador.getIluminacion();
	}
	
}
