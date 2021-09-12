package model;

public class Piso{
	private boolean empty;
	private Luz luz;
	
	public Piso(){
		empty = true;
		luz = new Luz();
	}
	
	public void personaExiste(boolean state){
		this.empty = state;
	}
	
	public void encenderLuz(){
		luz.setEstado(true);
	}
	
	
}
