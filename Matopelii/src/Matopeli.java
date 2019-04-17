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
		JFrame naytto= new JFrame("Matopeli");
		naytto.setSize(WIDTH, HEIGHT);
		naytto.setResizable(false);
		naytto.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		naytto.setLocationRelativeTo(null);
		naytto.setVisible(true);
		
	}

}
