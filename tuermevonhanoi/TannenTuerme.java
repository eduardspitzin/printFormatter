package de.ituvsoft.tuermevonhanoi;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Stack;

import javax.swing.JPanel;

public class TannenTuerme extends JPanel {
	int x_coordinates;
	int y_coordinates =450;
	int x_stamm = 210;
	int width;
	int height = 40;
	ArrayList<Stack<Integer>> towers;
	
	
	
	public TannenTuerme(ArrayList<Stack<Integer>> tuerme) {
	/*
		towers = new ArrayList<Stack<Integer>>();
		towers.add(new Stack<Integer>());
		towers.add(new Stack<Integer>());
		towers.add(new Stack<Integer>());

		for (int i = 5; i > 0; i--) {
			towers.get(0).push(i);
		}
		
		towers.get(1).push(4);
		towers.get(1).push(2);
		towers.get(1).push(2);
		towers.get(2).push(2);
		for (Stack<Integer> ausgabe : towers) {
			System.out.println(ausgabe);
		}
		System.out.println(" ");
		*/
		this.towers = tuerme;
			
	}
	@Override 
	public void paintComponent(Graphics g) {
		//new Stylesheet().paintComponent(g);
		
	for(int j =0; j<3;j++) {	//TODO Wieder zu 3 ändern!
		System.out.println(towers.get(j).size());
		for(int i = 0;i<towers.get(j).size();i++) {
			int f = towers.get(j).get(i);
			width = 20*towers.get(j).get(i);
			y_coordinates -=height;
			x_coordinates = x_stamm -width/2;
			g.setColor(new Color(0x00,0x71,0x23));
			g.fillRect(x_coordinates, y_coordinates, width, height);
			
			
			
			
			
		}
		System.out.println("Ich bin in der Schleifeee!");
		x_stamm += 300;
		y_coordinates = 450;
	}
	}
		
	public static void main (String[] args) {
		//TannenTuerme turm = new TannenTuerme();
		
		
		
	}
	
	
	
	}