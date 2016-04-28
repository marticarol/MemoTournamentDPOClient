package view;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class GameWindow extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	public final static int BOLD = 1;
	public final static int NORMAL = 0;
	
	public final static String MEMORIA = "MEMORIA";
	public final static String CONCENTRACIO = "CONCENTRACIO";
	public final static String CONTRAMAQUINA = "CONTRAMAQUINA";
	public final static String MEMORIAMAQUINA = "MEMORIA MAQUINA";
	public final static String CONCENTRACIOMAQUINA = "c";
	
	public final static String NIVELL_FACIL = "FACIL";
	public final static String NIVELL_NORMAL = "NORMAL";
	public final static String NIVELL_DIFICIL = "DIFICIL";
	
	private JPanel mainPanel;
	private String nivell;
	private String mode;
	private JButton buttonPausa;
	private JLabel labelTurnUser = new JLabel(" ");;
	private JLabel labelTurnMachine = new JLabel(" ");;
	
	public GameWindow(String nivell, String mode) {

		super();
		this.nivell = nivell;
		this.mode = mode;
    	
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setSize(800, 600);
    	super.getContentPane().setBackground(Color.WHITE);
    
    	// Inicialitzem els panel principal
    	createMainPanel();
    	super.getContentPane().add(mainPanel);
    	
    	setVisible(true);
    	super.setTitle("Game");
		super.setResizable(false);
		super.setLocationRelativeTo(null);
	}
	
	private void createMainPanel(){
		mainPanel = new JPanel();
		mainPanel.setName("Main");
    	mainPanel.setLayout(new BorderLayout());
    	mainPanel.setPreferredSize(new Dimension(700, 500));

    	// Inicialitzem els subPanells
    	createTopPanel();
    	createEastPanel();
    	createSouthPanel();
    	createWestPanel();
    	createCenterPanel();
	}
	
	private void createTopPanel(){
		JPanel panel = new JPanel();
		panel.setName("Top");
		panel.setBackground(Color.WHITE);
    	panel.setLayout(new BorderLayout());
    	
    	JLabel labelTitle = new JLabel("MEMO TOURNAMENT");
    	labelTitle.setPreferredSize(new Dimension(100, 80));
    	labelTitle.setFont(getFontName(BOLD, 45));
    	labelTitle.setHorizontalAlignment(JLabel.CENTER);
    	labelTitle.setAlignmentX(CENTER_ALIGNMENT);
    	panel.add(labelTitle, BorderLayout.NORTH);

    	mainPanel.add(panel, BorderLayout.NORTH);
	}
	
	private void createSouthPanel(){
		JPanel panel = new JPanel();
		panel.setName("South");
		panel.setBackground(Color.WHITE);
    	panel.setLayout(new FlowLayout(FlowLayout.LEFT, 35,25));
    	panel.setPreferredSize(new Dimension(0,80));
		
    	// Em permet aliniar-los un sobre l'altre
		JPanel modePanel = new JPanel();
		modePanel.setBackground(Color.WHITE);
		modePanel.setLayout(new BoxLayout(modePanel, BoxLayout.Y_AXIS));
		// Creacio dels Labels
		createLabel(modePanel, "Mode: " + mode, null, "modePanel");
		createLabel(modePanel, "Nivell: " + nivell, null, "modePanel");
	
    	panel.add(modePanel);
    	
    	mainPanel.add(panel, BorderLayout.SOUTH);
	}
	
	// Metode que agrupa modificacions iguals en funció del JPanel a dissenyar
	private void createLabel(JPanel innerPanel, String text, String location, String panel) {
		JLabel labelMode = new JLabel(text);
		if(panel.equals("modePanel")){
	    	labelMode.setFont(getFontName(NORMAL, 15));
		}else{
			if(panel.equals("panelMachine") || panel.equals("yourGrid")){
				labelMode.setHorizontalAlignment(JLabel.CENTER);
		    	labelMode.setAlignmentX(Component.CENTER_ALIGNMENT);
	    		if(text.equals("MAQUINA:") || text.equals("TORN:")){
	    			labelMode.setFont(getFontName(NORMAL, 20));
	    			if(text.equals("TORN:")){
	    				labelMode.setForeground(Color.RED);
	    			}
	    		}else{
	    			labelMode.setFont(getFontName(BOLD, 25));
	    		}
			}
			if (panel.equals("topPanelTime") || panel.equals("topPanelPoints")){
	    		if(text.equals("TEMPS: ") || text.equals("PUNTS: ") || text.equals("COMPTE ENRERE: ")){
	    			labelMode.setFont(getFontName(NORMAL, 25));
	    		}else{
	    			labelMode.setFont(getFontName(BOLD, 30));
	    		}
	    	}
		}
    	innerPanel.add(labelMode, location);
	}
	
	private void createEastPanel(){
		JPanel panel = new JPanel();
		panel.setName("East");
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    	panel.setBackground(Color.WHITE);
        panel.setPreferredSize(new Dimension(140, 80));
        
        GridLayout grid = new GridLayout(4,1);
        JPanel yourGrid = new JPanel(grid);
    	yourGrid.setBackground(Color.WHITE);
  
    	if (mode.equals(CONCENTRACIOMAQUINA) || mode.equals(MEMORIAMAQUINA)){
    		createLabel(yourGrid, "TORN:", null, "yourGrid");
    		contraMaquina(yourGrid);
    		panel.add(yourGrid);
    	}
    	mainPanel.add(panel, BorderLayout.EAST);
	}
	
	private void contraMaquina(JPanel innerPanel){
		JPanel panelMachine = new JPanel();
		panelMachine.setName("panelMachine");
    	panelMachine.setBackground(Color.WHITE);
    	panelMachine.setLayout(new GridLayout(2,0));
    	
    	createLabel(panelMachine, "MAQUINA:", null, "panelMachine");
    	createLabel(panelMachine, "0", null, "panelMachine");
		
    	// Torn entre Maquina i Usuari
		labelTurnUser = new JLabel(" ");
		labelTurnUser.setFont(getFontName(NORMAL, 20));
		labelTurnUser.setHorizontalAlignment(JLabel.CENTER);
		labelTurnUser.setAlignmentX(CENTER_ALIGNMENT);
		labelTurnUser.setForeground(Color.RED);
		
		labelTurnMachine = new JLabel(" ");
		labelTurnMachine.setFont(getFontName(NORMAL, 20));
		labelTurnMachine.setHorizontalAlignment(JLabel.CENTER);
		labelTurnMachine.setAlignmentX(CENTER_ALIGNMENT);
		labelTurnMachine.setForeground(Color.RED);
		
		innerPanel.add(labelTurnUser);
		innerPanel.add(labelTurnMachine);
		innerPanel.add(panelMachine);
	}
	
	protected static ImageIcon createImageIcon(String path) {
		 java.net.URL ImageIconX = GameWindow.class.getResource(path);
	        if (ImageIconX != null) {
	            return new ImageIcon(ImageIconX);
	        } else {
	            System.err.println("Couldn't find file: " + path);
	            return null;
	        }
	    }

	private void createWestPanel(){
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.setName("West");
		panel.setBackground(Color.WHITE);
		panel.setPreferredSize(new Dimension(140, 80));
		panel.setBorder(BorderFactory.createTitledBorder("Ranquing"));
    	//createRankingPanel();
		mainPanel.add(panel, BorderLayout.WEST);
	}
	
	private void createCenterPanel(){
		JPanel panel = new JPanel();
		panel.setName("Center");
    	panel.setLayout(new BorderLayout());
    	
    	// Creació panel Punts i Temps
    	createInnerTopPanel(panel);
    	//Creació Taulell
    	createInnerCenterPanel(panel);
    	mainPanel.add(panel);
	}
	
	private void createInnerTopPanel(JPanel innerPanel){
		
		JPanel panel = new JPanel();
		panel.setName("InnerTop");
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
    	panel.setBackground(Color.WHITE);
        panel.setPreferredSize(new Dimension(0, 80));
        
        GridLayout grid = new GridLayout(2,1);
        JPanel yourGrid = new JPanel(grid);
    	yourGrid.setBackground(Color.WHITE);
    	
    	JPanel TimePoint = new JPanel();
    	TimePoint.setLayout(new GridLayout(1,2));
    	TimePoint.setBackground(Color.WHITE);
    	
    	JPanel topPanelTime = new JPanel();
		topPanelTime.setBackground(Color.WHITE);
    	topPanelTime(mode,topPanelTime);
    	
    	JPanel topPanelPoints = new JPanel();
		topPanelPoints.setBackground(Color.WHITE);
		
    	createLabel(topPanelPoints, "PUNTS: ", null, "topPanelPoints");
		createLabel(topPanelPoints, "0", null, "topPanelPoints");
		
		TimePoint.add(topPanelTime);
		TimePoint.add(topPanelPoints);
		
		//BOTO PAUSA
    	ImageIcon middleButtonIcon = createImageIcon("../Images/pause.png");
    	ImageIcon middleButtonIcon1 = createImageIcon("../Images/play.png");
    	buttonPausa = new JButton("Pause", middleButtonIcon);
		buttonPausa.setAlignmentX(CENTER_ALIGNMENT);
		buttonPausa.setHorizontalAlignment(JButton.CENTER);
		
		buttonPausa.setFocusPainted(false);
		buttonPausa.setBorderPainted(false);
		buttonPausa.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	 Object source = e.getSource();
	     	    if (source instanceof JButton) {
	     	       if (buttonPausa.getText().equals("Start")){
	     	    	  buttonPausa.setText("Pause");
	     	    	  buttonPausa.setIcon(middleButtonIcon);
	     	    	  labelTurnMachine.setText(" ");
	     	    	  labelTurnUser.setText("TU");
	     	       } else if (buttonPausa.getText().equals("Pause")) {
	     	    	  buttonPausa.setText("Start");
	     	    	  buttonPausa.setIcon(middleButtonIcon1);
	     	    	  labelTurnMachine.setText("MAQUINA");
	     	    	  labelTurnUser.setText(" ");
	     	       }
	     	    }
	         }
		});
		
		yourGrid.add(TimePoint);
		yourGrid.add(buttonPausa);
		panel.add(yourGrid);
		innerPanel.add(panel, BorderLayout.NORTH);
	}
	
	private void topPanelTime(String mode, JPanel innerPanel){
		
		if(mode.equals(MEMORIA) || mode.equals(MEMORIAMAQUINA)){
			createLabel(innerPanel, "TEMPS: ", null, "topPanelTime");
			createLabel(innerPanel, "0", null, "topPanelTime");
		}
		if(mode.equals(CONCENTRACIO) || mode.equals(CONCENTRACIOMAQUINA)){
			createLabel(innerPanel, "COMPTE ENRERE: ", null, "topPanelTime");
			createLabel(innerPanel, "0", null, "topPanelTime");
		}
		
	}
	
	private void addTemps(){
		
	}

	private void createInnerCenterPanel(JPanel innerPanel){
		JPanel panel = new JPanel(null);
		panel.setName("InnerCenter");
		panel.setBackground(Color.WHITE);
    	
		// Creació Taulell de joc
		Taulell tableGame = new Taulell(nivell);
		
		// Establir dimensions taulell
		tableGame.setBounds(centeredWidth(tableGame), centeredHeight(tableGame), tableGame.getPreferredSize().width, tableGame.getPreferredSize().height);
		
		panel.add(tableGame);
		innerPanel.add(panel, BorderLayout.CENTER);
	}
	
	// Metode que ens permet centrar el Taulell
	
	private int centeredWidth(Component c) {
		return (super.getWidth() - 280) / 2 - (c.getPreferredSize().width/2);
	}
	
	// Metode que ens permet centrar el Taulell
	
	private int centeredHeight(Component c) {
		return (((super.getHeight() - 160) / 2) - 25 - 10) - (c.getPreferredSize().height/2);
	}
	
	// Metode que ens permet ajustar la Font de la lletra
	
	public static Font getFontName(int type, int size) {
		Font f;
		if (type == 0) {
			f = new Font("DJB Straight Up Now Bounce", 0, size);
		}else {
			f = new Font("DJB Straight Up Now Bold", 0, size);
		}
		return f;
	}	
}