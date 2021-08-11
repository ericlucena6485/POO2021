package view.components;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;

public class CustomButton extends JButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomButton(String text, Color textColor, Color buttonColor) {
		this.setText(text);
		this.setSize(new Dimension(100, 60));
		this.setBackground(buttonColor);
		this.setFont(new Font("Arial", 1, 15));
		this.setAlignmentX(CENTER_ALIGNMENT);
		this.setForeground(textColor);
		this.setMargin(new Insets(10, 10, 10, 10));
		this.setBorder(BorderFactory.createCompoundBorder(
		        BorderFactory.createLineBorder(textColor, 0), 
		        BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		this.setFocusPainted(false);
		this.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {

				e.getComponent().setForeground(textColor);
				e.getComponent().setBackground(buttonColor);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				e.getComponent().setBackground(textColor);
				e.getComponent().setForeground(buttonColor);
				Cursor pointer = new Cursor(Cursor.HAND_CURSOR);
				e.getComponent().setCursor(pointer);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}

}
