package model;

public class Piso{
	private boolean empty; // Hay una persona en el piso?
	private Luz luz;
	private BotonPiso botonPiso;
	
	public Piso(){
		empty = true;
		luz = new Luz();
		botonPiso = new BotonPiso();
	}
	
	public void personaExiste(boolean state){
		this.empty = state;
	}
	
	public void cambiarLuz(boolean estado){
		luz.setEstado(estado);
	}
	
	public void encenderBotonPiso(boolean iluminacion){
		botonPiso.setIluminacion(iluminacion);
	}
	
	public boolean getLuz(){
		return luz.getEstado();
	}
	
	public boolean getBotonPiso(){
		return botonPiso.getIluminacion();
	}
	
}
