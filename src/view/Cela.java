package view;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;

public class Cela extends JLabel{
	
	public Cela() {
		super();
		this.setBackground(Color.WHITE);
		setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, Color.BLUE, Color.BLUE));
		setHorizontalAlignment(JLabel.CENTER);
	}

}
