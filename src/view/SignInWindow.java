package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class SignInWindow extends JFrame{
	
	private JPanel contenedor;
	
	private JLabel usuario_1;
	private JLabel usuario_2;
	private JLabel password_1;
	private JLabel password_2;
	
	private JTextField user1_field;
	private JTextField user2_field;
	private JPasswordField pass1_field;
	private JPasswordField pass2_field;
	
	private JButton registro;
	
	public SignInWindow(){
		
		setBounds(100, 100, 450, 400);
		setLocation(710,280);
		setTitle ("Registro");
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		contenedor = new JPanel();
		getContentPane().add(contenedor);
		
		SpringLayout sp = new SpringLayout();
		contenedor.setLayout(sp);
		
		//USUARIOS
		//Labels
		usuario_1 = new JLabel("Nombre Usuario:");
		contenedor.add(usuario_1);
	    sp.putConstraint(SpringLayout.NORTH, usuario_1, 30, SpringLayout.NORTH, contenedor);
	    sp.putConstraint(SpringLayout.WEST, usuario_1,  20, SpringLayout.WEST, contenedor);
		
	    usuario_2 = new JLabel("Repetir Usuario:");
	    contenedor.add(usuario_2);
	    sp.putConstraint(SpringLayout.NORTH, usuario_2, 90, SpringLayout.NORTH, contenedor);
	    sp.putConstraint(SpringLayout.WEST, usuario_2, 20, SpringLayout.WEST, contenedor);
	    
	    //Fields
	    user1_field = new JTextField();
	    contenedor.add(user1_field);
	    sp.putConstraint(SpringLayout.NORTH, user1_field, 30, SpringLayout.NORTH, contenedor);
	    sp.putConstraint(SpringLayout.WEST, user1_field, 150, SpringLayout.WEST, contenedor);
	    sp.putConstraint(SpringLayout.EAST, user1_field, 400, SpringLayout.WEST, contenedor);
	    
	    user2_field = new JTextField();
	    contenedor.add(user2_field);
	    sp.putConstraint(SpringLayout.NORTH, user2_field, 90, SpringLayout.NORTH, contenedor);
	    sp.putConstraint(SpringLayout.WEST, user2_field, 150, SpringLayout.WEST, contenedor);
	    sp.putConstraint(SpringLayout.EAST, user2_field, 400, SpringLayout.WEST, contenedor);
		
	    //PASSWORD
	    //Labels
	    password_1 = new JLabel("Contrase�a:");
		contenedor.add(password_1);
	    sp.putConstraint(SpringLayout.NORTH, password_1, 150, SpringLayout.NORTH, contenedor);
	    sp.putConstraint(SpringLayout.WEST, password_1,  20, SpringLayout.WEST, contenedor);
		
	    password_2 = new JLabel("Repetir Contrase�a:");
	    contenedor.add(password_2);
	    sp.putConstraint(SpringLayout.NORTH, password_2, 210, SpringLayout.NORTH, contenedor);
	    sp.putConstraint(SpringLayout.WEST, password_2, 20, SpringLayout.WEST, contenedor);
	    
	    //Fields
	    pass1_field = new JPasswordField();
	    contenedor.add(pass1_field);
	    sp.putConstraint(SpringLayout.NORTH, pass1_field, 150, SpringLayout.NORTH, contenedor);
	    sp.putConstraint(SpringLayout.WEST, pass1_field, 150, SpringLayout.WEST, contenedor);
	    sp.putConstraint(SpringLayout.EAST, pass1_field, 400, SpringLayout.WEST, contenedor);
	    
	    pass2_field = new JPasswordField();
	    contenedor.add(pass2_field);
	    sp.putConstraint(SpringLayout.NORTH, pass2_field, 210, SpringLayout.NORTH, contenedor);
	    sp.putConstraint(SpringLayout.WEST, pass2_field, 150, SpringLayout.WEST, contenedor);
	    sp.putConstraint(SpringLayout.EAST, pass2_field, 400, SpringLayout.WEST, contenedor);
	    
	    //BUTTONS
	    registro = new JButton("Registrar");
	    contenedor.add(registro);
	    sp.putConstraint(SpringLayout.SOUTH, registro, -50, SpringLayout.SOUTH, contenedor);
	    sp.putConstraint(SpringLayout.WEST, registro, 200, SpringLayout.WEST, contenedor);
	  
		setVisible(true);
		
	}
	
}
