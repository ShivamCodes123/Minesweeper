import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class Interface implements MouseListener{
	Frame frame = new Frame();
	Panel panel = new Panel();
	ArrayList<Button> buttons = new ArrayList<Button>();
	Integer[] bombs = new Integer[20];
	int firstClick = 0;
	boolean fromFirstClick = false;
	
	public Interface() {
		
		for (int i = 0; i < bombs.length; i++) {
			bombs[i] = (int)(Math.random()*100);
		}	
		
		panel.setLayout(new GridLayout(10, 10));
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				Button button = new Button();
				button.setEnabled(true);
				button.addMouseListener(this);
				panel.add(button);
				buttons.add(button);
			}
		}
		frame.setSize(800, 800);
		frame.add(panel);
		frame.setVisible(true);
		
	}


	private String howManyBombs(int index) {
		Integer count = 0;
		
		for (int i = 0; i < bombs.length; i++) {
			if(index == bombs[i]) {
				for (int j = 0; j < buttons.size(); j++) {
					buttons.get(j).setEnabled(false);
				}
				JOptionPane.showMessageDialog(frame, "You lose. Get gud kid");
			}
			else {
				if(fromFirstClick) {
					fromFirstClick = false;
					buttons.get(index).setLabel(howManyBombs(index));
					buttons.get(index).setBackground(Color.green);
					buttons.get(index).setEnabled(false);
					fromFirstClick = true;
				}
			}
			if(index + 10 == bombs[i]) {
				count++;
			}
			else {
				if(fromFirstClick) {
					fromFirstClick = false;
					buttons.get(index + 10).setLabel(howManyBombs(index + 10));
					buttons.get(index + 10).setBackground(Color.green);
					buttons.get(index + 10).setEnabled(false);
					fromFirstClick = true;
				}
			}
			if(index - 10 == bombs[i]) {
				count++;
			}
			else {
				if(fromFirstClick) {
					fromFirstClick = false;
					buttons.get(index - 10).setLabel(howManyBombs(index - 10));
					buttons.get(index - 10).setBackground(Color.green);
					buttons.get(index - 10).setEnabled(false);
					fromFirstClick = true;
				}
			}
			if(index - 9 == bombs[i]) {
				count++;
			}
			else {
				if(fromFirstClick) {
					fromFirstClick = false;
					buttons.get(index - 9).setLabel(howManyBombs(index - 9));
					buttons.get(index - 9).setBackground(Color.green);
					buttons.get(index - 9).setEnabled(false);
					fromFirstClick = true;
				}
			}
			if(index - 11 == bombs[i]) {
				count++;
			}
			else {
				if(fromFirstClick) {
					fromFirstClick = false;
					buttons.get(index - 11).setLabel(howManyBombs(index - 11));
					buttons.get(index - 11).setBackground(Color.green);
					buttons.get(index - 11).setEnabled(false);
					fromFirstClick = true;
				}
			}
			if(index + 9 == bombs[i]) {
				count++;
			}
			else {
				if(fromFirstClick) {
					fromFirstClick = false;
					buttons.get(index + 9).setLabel(howManyBombs(index + 9));
					buttons.get(index + 9).setBackground(Color.green);
					buttons.get(index + 9).setEnabled(false);
					fromFirstClick = true;
				}
			}
			if(index + 11 == bombs[i]) {
				count++;
			}
			else {
				if(fromFirstClick) {
					fromFirstClick = false;
					buttons.get(index + 11).setLabel(howManyBombs(index + 11));
					buttons.get(index + 11).setBackground(Color.green);
					buttons.get(index + 11).setEnabled(false);
					fromFirstClick = true;
				}
			}
			if(index + 1 == bombs[i]) {
				count++;
			}
			else {
				if(fromFirstClick) {
					fromFirstClick = false;
					buttons.get(index + 1).setLabel(howManyBombs(index + 1));
					buttons.get(index + 1).setBackground(Color.green);
					buttons.get(index + 1).setEnabled(false);
					fromFirstClick = true;
				}
			}
			if(index - 1 == bombs[i]) {
				count++;
			}
			else {
				if(fromFirstClick) {
					fromFirstClick = false;
					buttons.get(index - 1).setLabel(howManyBombs(index + 1));
					buttons.get(index - 1).setBackground(Color.green);
					buttons.get(index - 1).setEnabled(false);
					fromFirstClick = true;
				}
			}
		}
		return count.toString();
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		for (int j = 0; j < buttons.size(); j++) {
			if(e.getSource() == buttons.get(j)) {
				if(SwingUtilities.isLeftMouseButton(e)) {
					if(firstClick == 0) {
						firstClick(j);
						firstClick = 1;
					}
					buttons.get(j).setLabel(howManyBombs(j));
					buttons.get(j).setEnabled(false);
					for (int i = 0; i < bombs.length; i++) {
						if(j != bombs[i]) {
							buttons.get(j).setBackground(Color.green);
						}
						else {
							buttons.get(j).setBackground(Color.red);
							System.out.println("You Lose");
							i = bombs.length;
						}
					}
				}
				else {
					buttons.get(j).setLabel("MARKED AS BOMB!");
					buttons.get(j).setBackground(Color.orange);
				}
			}
		}
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void firstClick(int index) {
		for (int i = 0; i < bombs.length; i++) {
			while(index == bombs[i]) {
				bombs[i] = (int)(Math.random()*100);
			}
		}
		fromFirstClick = false;
		howManyBombs(index);
		
	}
}
