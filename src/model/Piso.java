package model;

public class Piso{
	//private boolean empty; // Hay una persona en el piso?
	private Luz luz;
	private BotonPiso botonPiso;
	private Persona persona;
	private Elevador elevador;
	
	public Piso(){
		persona = null;
		luz = new Luz();
		botonPiso = new BotonPiso();
		persona = new Persona();
	}
	
	public boolean existePersona(){
		return persona == null;
	}
	
	public void setPersona(Persona persona){
		this.persona = persona;
	}
	
	public void llegaElevador() {
		botonPiso.restablecer();
		luz.encender();
	}
	
	//ToDO
	public void llamarElevador() {
		
	}
	
}
