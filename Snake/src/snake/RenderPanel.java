package snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;

/**
 *RenderPanel-luok
 * 
 * 
 *
 */

@SuppressWarnings("serial")
public class RenderPanel extends JPanel{
	
	public static Color matovari = new Color(255, 49, 243);
	public static Color omenavari = new Color(51, 255, 236);
	
	/**
	 *PaintComponent-metodilla maalataan kaikki (mato, omena, tausta, teksti)
	 *tarkistaa for-loopilla madon sijainnin madon maalausta varten
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 400, 340);
		g.setColor(Color.GRAY);
		g.drawRect(20, 20, 20*12,20*12);
		Snake snake = Snake.matopeli;
		for (Point point : snake.matoosat) { //Maalataan kaikki matoosat
			g.setColor(matovari);
			g.fillRect(point.x*20+20, point.y*20+20, 18, 18);
		}
		g.setColor(omenavari);
		if (!snake.peliOhi)//Omena tulee näkyviin kun peli on käynnissä
			g.fillRect(snake.omena.x*20+20, snake.omena.y*20+20, 18, 18);
		g.drawString("score: "+snake.score, 290, 100);
		if (snake.peliOhi && snake.aikayksikko%6!=0 ) {
		g.drawString("press space", 290, 60);
		}
		if (snake.score >=12*12) {
			g.drawString("You win!", 290, 140);
		}
		
	}
	
}
