import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;

public class Prueba extends Canvas{
	
	public final int WIDTH = 500;
	public final int HEIGHT = 500;
	
	private JFrame jframe;
	
	private int pisos = 2;
	private int strokeWidth = 10;
	
	public Prueba() {
		jframe = new JFrame();
		jframe.setTitle("Space Ship Game");
		jframe.setSize(WIDTH + 25, HEIGHT + 25);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//jframe.setResizable(false);
		jframe.setLocationRelativeTo(null);
		
		
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setMaximumSize(new Dimension(WIDTH, HEIGHT));
		this.setMinimumSize(new Dimension(WIDTH, HEIGHT));
		this.setFocusable(true);
		
		jframe.add(this);
		jframe.setVisible(true);
		
		
		this.setBackground(Color.BLACK);
	}
	
	public void paint(Graphics g){
		super.paint(g);
		
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(Color.WHITE);
		g2d.setStroke(new BasicStroke(15));
		
		
		paintPiso(g2d);
		paintElevator(g2d);
	}
	
	public void linea(Graphics2D g2d) {
        g2d.setStroke(new BasicStroke(strokeWidth));
        g2d.drawLine(WIDTH/4, HEIGHT/4, WIDTH/2, HEIGHT/2);
	}
	
	public void paintPiso(Graphics2D g2d) {
		g2d.setColor(Color.GRAY);
		for(int i = 0; i < pisos; i++) {
			if(i != 0 && i != pisos-1 || pisos == 2 && i != 0) {
				int y = i * (HEIGHT / pisos);
				g2d.drawLine(0, y, WIDTH, y);	
			}
		}
		g2d.setColor(Color.WHITE);
	}
	
	public void paintElevator(Graphics2D g2d) {
		int elevatorHeight = HEIGHT/pisos - 30;
		int elevatorWidth =  WIDTH/4;
		int initialLineX = WIDTH - elevatorWidth;
		int initialLineY = HEIGHT - HEIGHT/pisos + strokeWidth + 3;
		
		System.out.println(initialLineX);
		System.out.println(initialLineY);
		
		System.out.println(elevatorWidth);
		System.out.println(elevatorHeight);
		
		g2d.drawRect(initialLineX, initialLineY, elevatorWidth, elevatorHeight);
	}
}