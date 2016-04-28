package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.*;


public class WelcomeWindow extends JFrame{

	private JPanel contenedor;
	private JPanel rectangle;
	
	private JLabel user;
	private JLabel password;
	
	private JTextField user_field;
	private JPasswordField password_field;
	private JButton register_button;
	private JButton start_button;
	private JButton invitado_button;
	
	public WelcomeWindow(){
		
		setBounds(100, 100, 470, 350);
		setLocation(700,300);
		setTitle("MemoTournament");
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		contenedor = new JPanel();
        getContentPane().add(contenedor);
                
        SpringLayout sp = new SpringLayout();
        contenedor.setLayout(sp);
        
        rectangle = new JPanel();
        rectangle.setBackground(Color.LIGHT_GRAY);
        rectangle.setBorder(BorderFactory.createLineBorder(Color.black));
        rectangle.setLayout(sp);
        
        contenedor.add(rectangle);
        sp.putConstraint(SpringLayout.NORTH, rectangle, 30, SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, rectangle, 30, SpringLayout.WEST, contenedor);
        sp.putConstraint(SpringLayout.EAST, rectangle, -30, SpringLayout.EAST, contenedor);
        sp.putConstraint(SpringLayout.SOUTH, rectangle, -135, SpringLayout.SOUTH, contenedor);
      
        //USUARIO
        //Label Usuario
        user = new JLabel("Usuario:"); 
        rectangle.add(user);
        sp.putConstraint(SpringLayout.NORTH, user, 20, SpringLayout.NORTH, rectangle);
        sp.putConstraint(SpringLayout.WEST, user,  10, SpringLayout.WEST, rectangle);
        
        //Campo Texto Usuario
        user_field = new JTextField();
        rectangle.add(user_field);
        sp.putConstraint(SpringLayout.NORTH, user_field, 20, SpringLayout.NORTH, rectangle);
        sp.putConstraint(SpringLayout.WEST, user_field, 90, SpringLayout.WEST, rectangle);
        sp.putConstraint(SpringLayout.EAST, user_field, -10, SpringLayout.EAST, rectangle);
        
        //CONTRASE�A
        //Label Contrase�a
        password = new JLabel("Contrase�a:");
        rectangle.add(password);
        sp.putConstraint(SpringLayout.NORTH, password, 70, SpringLayout.NORTH, rectangle);
        sp.putConstraint(SpringLayout.WEST, password,  10, SpringLayout.WEST, rectangle);
                
        //Campo Texto Contrase�a	
        password_field = new JPasswordField();
        rectangle.add(password_field);    
        sp.putConstraint(SpringLayout.NORTH, password_field, 70, SpringLayout.NORTH, rectangle);
        sp.putConstraint(SpringLayout.WEST, password_field, 90, SpringLayout.WEST, rectangle);
        sp.putConstraint(SpringLayout.EAST, password_field, -10, SpringLayout.EAST, rectangle);
        
        
        //BOTONES
        //Registrar
        start_button = new JButton("Inicia Sessi�");
        rectangle.add(start_button);
        sp.putConstraint(SpringLayout.SOUTH, start_button, -15, SpringLayout.SOUTH, rectangle);
        sp.putConstraint(SpringLayout.WEST, start_button,   150, SpringLayout.WEST, rectangle);
        
        //Inicio
        register_button = new JButton("Crea un Compte");
        contenedor.add(register_button);
        sp.putConstraint(SpringLayout.SOUTH, register_button, -90, SpringLayout.SOUTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, register_button,  170, SpringLayout.WEST, contenedor);
        
        //Invitado
        invitado_button = new JButton("Invitado");
        contenedor.add(invitado_button);
        sp.putConstraint(SpringLayout.SOUTH, invitado_button, -40, SpringLayout.SOUTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, invitado_button,  195, SpringLayout.WEST, contenedor);
        
        setVisible(true);
	}
}
