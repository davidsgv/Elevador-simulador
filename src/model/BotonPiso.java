package model;

public class BotonPiso {
	//true activo
	//false inactivo (no se puede presionar)
	private boolean estado;
	
	public BotonPiso(){
		estado = true;
	}
	
	public BotonPiso(Elevador elevador){
		if(elevador.enMovimiento){
			estado = false;
		}else{
			estado = true;
		}
	}

	public void presionar() {
		if(estado == true) {
			estado = false;
		}
	}
	
	public void restablecer() {
		estado = true;
	}
	
}
