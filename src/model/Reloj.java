package model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public final class Reloj {
	public static Reloj instance;
	
	public Timer timer;
	public int segundos;
	
	private Reloj() {
		segundos = 0;
		timer = new Timer(1000, new ActionListener ()
		{
		    public void actionPerformed(ActionEvent e)
		    {
		    	segundos++;
		        
		     }
		});
	}
	
	public static Reloj getInstance() {
		if (instance == null) {
            instance = new Reloj();
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
