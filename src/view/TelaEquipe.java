package view;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class TelaEquipe extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8636653354165218629L;

	public TelaEquipe() {
		this.setLayout(new FlowLayout());
		this.setBackground(Color.WHITE);
		this.add(new JLabel(""), FlowLayout.LEFT);
		this.add(new JLabel("Alisson vinícios -"));
		this.add(new JLabel("Éric Lucena -"));
		this.add(new JLabel("Iago de Aquino -"));
		this.add(new JLabel("Josafá Dieb"));
	}

}
