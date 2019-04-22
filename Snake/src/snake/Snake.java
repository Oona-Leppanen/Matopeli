package snake;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.Timer;

public class Snake implements ActionListener, KeyListener{
	
	public JFrame naytto;
	public static Snake matopeli;
	public RenderPanel renderPanel;
	public Timer timer = new Timer(30, this);
	public ArrayList<Point> matoosat= new ArrayList<Point>(); 
	public int aikayksikko=0, score =0, hantaPituus;
	public char direction =DOWN;
	public Point head;
	public Point omena;
	public static final char UP = 'u', DOWN = 'd', LEFT = 'l', RIGHT = 'r';
	public boolean peliOhi = true;
	
	
	public Snake() {
		naytto = new JFrame("Matopeli");
		naytto.setVisible(true);
		naytto.setSize(400, 340);
		naytto.setLocation(300,200);;
		naytto.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		naytto.addKeyListener(this);
		naytto.add(renderPanel = new RenderPanel());//RenderPanelissa piirretään kaikki
		head = new Point(5,1); //madon pää
		omena = new Point(5,8); 
		timer.start();
		
	}
	
	public static void main(String[] args) {
		matopeli = new Snake();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		renderPanel.repaint();
		aikayksikko++; //Mato ei liiku eteenpäin joka timerin aikayksiköllä, vaan vain joka viidennellä, johon aikayksikkö inttiä tarvitaan
		
		if (head.x < 0 || head.x > 11 || head.y < 0 || head.y > 11) {//Jos mato menee rajojen ulkopuolelle
			peliOhi=true;		
		}
		
		if (aikayksikko%5==0 && head!=null && !peliOhi ) { //Mato liikkuu 0.15 sekunnin välein
			matoosat.add((Point) head.clone());//Listätään osa matoa
			if(matoosat.size() > 0) {
				while(matoosat.size()>hantaPituus+1) { //Poistaa ensimmäisen Pointin, ilman tätä mato kasvaisi koko ajan
					matoosat.remove(0);
				}
			}//Näillä saadaan aikaan madon kasvu oikeaan suuntaan
			if (direction ==UP)
				head = new Point(head.x, head.y-1);
			if (direction == DOWN)
				head = new Point(head.x, head.y+1);
			if (direction == LEFT)
				head = new Point(head.x-1, head.y);
			if (direction == RIGHT)
				head = new Point(head.x+1, head.y);
			//System.out.println(matoosat); //<-näillä saa outprintattuu koko madon ja omenan jos kiinnostaa.
			//System.out.println(omena);
			
			if(omena!=null) {//Omenan myötä häntä kasvaa, ja pisteet lisääntyvät
				if(head.equals(omena)){
					score++;
					hantaPituus++;
					omena.setLocation(new Random().nextInt(12),new Random().nextInt(12));
				}//Omenalle uusi koordinaatio, tarkastetaan, ettei omena ilmesty madolle
				while (onkoMadolla()) {
					onkoMadolla();	
				}
				
			}
			for(Point point : matoosat) { //Jos mato osuu itseensä
				if (point.equals(head) && (!point.equals(matoosat.get(0)) || hantaPituus<2)) {
					peliOhi=true;
				}
			}
		}
	}
	
	public boolean onkoMadolla() { //funktio joka tarkastaa voiko omena tulla esiin aikomassaan paikassa.
		for (int i=0; i<matoosat.size(); i++) {
			if (omena.equals(matoosat.get(i))) {
				omena.setLocation(new Random().nextInt(12),new Random().nextInt(12));								
				return true;
			}
		}
		return false;
	}

	@Override
	public void keyTyped(KeyEvent e) {//Tällä ei tee mitään, mutta on pakko olla.
		// TODO Auto-generated method stub
		
	}

	public void keyPressed(KeyEvent e) { //Saadaan näppäimistö toimimaan
		int keyCode = e.getKeyCode();
        if(keyCode == KeyEvent.VK_LEFT) {
        	direction = LEFT;
        }
        if(keyCode == KeyEvent.VK_RIGHT) {
        	direction = RIGHT;
        }
        if(keyCode == KeyEvent.VK_DOWN) {
        	direction = DOWN;
        }
        if(keyCode == KeyEvent.VK_UP) {
        	direction = UP;
        }
        if(peliOhi==true && keyCode == KeyEvent.VK_SPACE){ //Saadaan peli uudelleen käyntiin.
        	score =0;
        	direction = DOWN;
        	matoosat.clear();
        	hantaPituus=0;
        	head.move(5, 1);
        	peliOhi = false; 	
        }
	}

	@Override
	public void keyReleased(KeyEvent e) {//Tällä ei tee mitää, mutta on pakko olla
		// TODO Auto-generated method stub
		
	}

}
