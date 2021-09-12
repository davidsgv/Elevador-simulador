package model;

public class Piso{
	//private boolean empty; // Hay una persona en el piso?
	private Luz luz;
	private BotonPiso botonPiso;
	private Persona persona;
	private Elevador elevador;
	
	private int numero;
	
	public Piso(int numero){
		persona = null;
		this.numero= numero; 
		
		luz = new Luz();
		botonPiso = new BotonPiso();
	}
	
	public boolean existePersona(){
		return persona != null;
	}
	
	public void setPersona(Persona persona){
		this.persona = persona;
		
		String mensaje = "entra persona al piso " + this.numero;
		Logger.log(mensaje);
		
		llamarElevador();
	}
	
	public void llegaElevador() {
		botonPiso.restablecer();
		luz.encender();
	}
	
	//ToDO
	public void llamarElevador() {
		Logger.log("LLamando elevador");
	}
	
}
