package de.ituvsoft.tuermevonhanoi;

import java.io.*;
import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
public class TowersOfHanoiG extends JFrame {
	
	JFrame toh;
	JPanel baeume;

	

	
	
	public TowersOfHanoiG(ArrayList<Stack<Integer>> liste) {
	
		
		toh = new JFrame("Die Türme von Hanoi");
		toh.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		toh.setSize(1000, 600);
		toh.setResizable(false);
		toh.setLocationByPlatform(true);
		baeume = new TannenTuerme(liste);
		toh.add(baeume);
		
	
		toh.setVisible(true);
		
	}
	public void refresh(ArrayList<Stack<Integer>> liste) {
		toh.remove(baeume);
		baeume = null;
		baeume = new TannenTuerme(liste);
		toh.add(baeume);
		toh.repaint();
		
		
		
		
		
	}
		
		
	
	public static void main(String[] args) {
	//TowersOfHanoiG turm = new TowersOfHanoiG();
	//turm.refresh();
	//turm.refresh();
	}

}
