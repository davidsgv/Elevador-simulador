package model;

public class Piso{
	//private boolean empty; // Hay una persona en el piso?
	private Luz luz;
	private BotonPiso botonPiso;
	private Persona persona;
	private Elevador elevador;
	
	private int tiempoPersona;
	
	private int numero;
	
	public Piso(int numero){
		persona = null;
		this.numero= numero; 
		
		luz = new Luz();
		//botonPiso = new BotonPiso();
		//elevador = Elevador.getInstance();
	}
	
	public int getNumero(){
		return numero;
	}
	
	public int getTiempoPersona(){
		return tiempoPersona;
	}
	
	public boolean existePersona(){
		return persona != null;
	}
	
	public void setPersona(Persona persona, int tiempo){
		this.persona = persona;
		
		String mensaje = "Entra persona al piso " + this.numero;
		Logger.log(mensaje);
		
		tiempoPersona = tiempo;
		
		llamarElevador(tiempo);
	}
	
	public void llegaElevador() {
		botonPiso.restablecer();
		luz.encender();
	}
	
	public void setElevador(Elevador elevador){
		this.elevador = elevador;
		this.botonPiso = new BotonPiso(this.elevador);
	}
	
	public boolean llamarElevador(int tiempo) {
		if(elevador.llamada(numero,tiempo,persona)){
			persona = null;
			Logger.log("Persona deja piso " + Integer.toString(numero));
			return true;
		}
		return false;
	}
	
}
