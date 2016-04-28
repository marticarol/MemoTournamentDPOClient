package view;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class OptionsWindow extends JFrame {
	//Definición de las variables
	private JLabel jlNomjugador;
	private JLabel jlMemo;
	private JButton jbRanking;
	private JLabel jlJugar;
	private JButton jbInfoj;
	private JComboBox<String> jcbRellotge;
	private JComboBox<String> jcbMaquina;
	private JLabel jlDificultat;
	private JButton jbInfoD; 
	private JComboBox<String> jcbDificultat;
	private JButton jbInici;
	private JButton jbSesion;
	private JFrame frame;
	
	public OptionsWindow() {
		//Creación Ventana
		frame = new JFrame();
		frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		
		//Inici
		JPanel inici = new JPanel();
		inici.setLayout(new FlowLayout());
		
		jlNomjugador = new JLabel ("nom_jugador");
		jlMemo = new JLabel ("MEMOTOURNAMENT");
		jbRanking = new JButton ("Ranking");
		
		inici.add(jlNomjugador);
		inici.add(jlMemo);
		inici.add (jbRanking);
		
		frame.add(inici);
		
		//Título: Jugar
		JPanel tjugar = new JPanel();
		tjugar.setLayout(new FlowLayout());
		
		jlJugar = new JLabel ("JUGAR");
		tjugar.add(jlJugar);
		
		jbInfoj = new JButton ("?");
		tjugar.add(jbInfoj);
		
		frame.add(tjugar);
	
		//Selección: Contrarelltoge
		JPanel srellotge = new JPanel();
		srellotge.setLayout(new FlowLayout());
		
		JLabel titol = new JLabel ("Contrarellotge");
		srellotge.add(titol);
		
		String[] opcions = {"","Memòria","Concentració","No es juga"};
		jcbRellotge = new JComboBox<> (opcions);
		srellotge.add(jcbRellotge);
		
		frame.add(srellotge);
		
		//Selección: Contra la máquina
		JPanel smaquina = new JPanel();
		smaquina.setLayout(new FlowLayout());
		
		JLabel titolm = new JLabel ("Contra la Maquina");
		smaquina.add(titolm);
		
		String[] opcionsm = {"","Memòria","Concentració","No es juga"};
		jcbMaquina = new JComboBox<> (opcionsm);
		smaquina.add(jcbMaquina);
		
		frame.add(smaquina);
		
		//Título: Dificultad
		JPanel tdificultat = new JPanel();
		tdificultat.setLayout(new FlowLayout());
		
		jlDificultat = new JLabel ("DIFICULTAT");
		tdificultat.add(jlDificultat);
		
		jbInfoD = new JButton ("?");
		tdificultat.add(jbInfoD);
		
		frame.add(tdificultat);
		
		//Selección: Dificultat
		JPanel difi = new JPanel ();
		difi.setLayout(new FlowLayout());
		
		String[] opcionsd = {"FACIL","NORMAL","DIFICIL"};
		jcbDificultat = new JComboBox<> (opcionsd);
		
		difi.add(jcbDificultat);
		
		frame.add(difi);
		
		//Button: Inici joc
		JPanel joc = new JPanel();
		joc.setLayout(new FlowLayout());
		
		jbInici = new JButton("COMENÇAR JOC");
		
		joc.add(jbInici);
		frame.add(joc);
		
		//button: Cerrar Sessió
		
		JPanel close = new JPanel();
		close.setLayout(new FlowLayout());
		
		jbSesion = new JButton("TANCA SESSION");
		
		close.add(jbSesion);
		frame.add(close);

		//Configuración ventana
		frame.pack();
		frame.setSize(800,600);
		frame.setTitle("Opcions per Jugar");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
		
	}
	
}