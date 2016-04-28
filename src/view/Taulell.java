package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class Taulell extends JPanel{
	
	public final static Color BLUE_COLOR = new Color(135,206,250);
	
	public final static String MEMORIA = "MEMORIA";
	public final static String CONCENTRACIO = "CONCENTRACIO";
	public final static String CONTRAMAQUINA = "CONTRA MAQUINA";
	public final static String CONTRARRELLOTGE = "CONTRARRELLOTGE";
	
	public final static String NIVELL_FACIL = "FACIL";
	public final static String NIVELL_NORMAL = "NORMAL";
	public final static String NIVELL_DIFICIL = "DIFICIL";
	public final static String NIVELL_EXTREM = "EXTREM";
	
	private String nivell;
	private Cela grid[][];
	private int col;
	private int row;

	
	//S'implementa i es disenya l'estructura del taulell de joc.
	//NIVELL = nivell en el que es vol fer la partida.
	public Taulell(String nivell) {
		this.setBackground(BLUE_COLOR);
		this.nivell = nivell;
		
		setTableDimension();
		
		grid = new Cela[row][col];
		
		super.setLayout(new GridLayout(row, col));
		
		ompleCasella();
		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				super.add(grid[i][j]);
			}
		}		
		super.setPreferredSize(new Dimension(col * 70, row * 70));
	}
	
	
	//Retorna una casella determinada del Taulell [ i = fila del taulell, j = columna del taulell]
	public Cela getCela(int i, int j){
		return grid[i][j];
	}
	
	
	public int getRow() {
		return row;
	}
	
	public int getCol() {
		return col;
	}
	
	//Determina les caselles en funcio del nivell
	private void setTableDimension(){
		if(nivell.equals(NIVELL_FACIL)){
			col = 4;
			row = 4;
		}else if(nivell.equals(NIVELL_NORMAL)){
			col = 5;
			row = 4;
		}else if(nivell.equals(NIVELL_DIFICIL)){
			col = 6;
			row = 4;
		}else{
			col = 0;
			row = 0;
		}
	}
	
	//Omple les caselles
	private void ompleCasella() {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				grid[i][j] = new Cela();
			}
		}
	}
}

