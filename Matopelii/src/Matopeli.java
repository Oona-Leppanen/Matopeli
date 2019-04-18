import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Color;
import java.awt.Component;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Matopeli {
	
	public final static int WIDTH = 600, HEIGHT = 400; //ruudun koko
	
	public Matopeli() {
		
	}
	
	public static void main(String[] args) {
		
		Matopeli matopeli = new Matopeli();
		JFrame naytto= new JFrame("Matopeli"); //Uusi näyttö, missä matopeli tulee näkymään
		naytto.setSize(WIDTH, HEIGHT); //Näytön koko
		naytto.setResizable(false); //Pystyykö näytön kokoa suurentamaan vai ei, tässä: ei
		naytto.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ohjelma lakkaa pyörimästä, kun ruutu suljetaan
		naytto.setLocationRelativeTo(null); //Missä kohtaa tietokoneen ruutua matopelinäyttö avautuu
		naytto.setVisible(true); //Tämä tulee olla kommenon jälkeen, joka piirtää näytölle, muuten piiretyt asiat eivät välttämättä tule näkyviin.
		
	}

}
