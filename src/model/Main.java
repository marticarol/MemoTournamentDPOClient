package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.SwingUtilities;

import view.GameWindow;

public class Main {
	private static String mode = null ;
	private static String nivell = null;
	
	public static void main(String[] args) {
		System.out.println("Quin nivell?");
		nivell = getUserSelectionString();
		System.out.println("Quin mode? ");
		mode = getUserSelectionString();
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new GameWindow(nivell, mode);
			}
		});
	}
	
	//Get user option String
			private static String getUserSelectionString() {
				try {
					return (new BufferedReader(new InputStreamReader(System.in))).readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
				return null;
			}
}