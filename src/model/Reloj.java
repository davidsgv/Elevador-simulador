package model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public final class Reloj {
	public static Reloj instance = null;
	
	public Timer timer;
	public int segundos;
	
	private Edificio edificio;
	
	private Reloj(Edificio edificio) {
		this.edificio = edificio;
		segundos = 0;
		timer = new Timer(1000, new ActionListener ()
		{
		    public void actionPerformed(ActionEvent e)
		    {
		    	segundos++;
		    	edificio.enviarTiempo(segundos);
		        //System.out.println(segundos);
		     }
		});
	}
	
	public static Reloj CreateInstance(Edificio edificio) {
		if (instance == null) {
            instance = new Reloj(edificio);
        }
        return instance;
	}
	
	
	public void startTime() {
		timer.start();
	}
	
	public void resetTime() {
		timer.restart();
	}
	
}
