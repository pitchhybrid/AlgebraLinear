package utils;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import vector.Vector;

public class Graphic extends JPanel {
	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	
	private Vector vector;

	public Graphic(int from, int width, int height) {
		setVisible(true);
		setBounds(from + 20, 20, ((int) (width * 0.9)), ((int) (height * 0.9)));
	}

	public void update() {
		this.validate();
		this.repaint();
	}
	
	public void setVector(Vector vector) {
		this.vector = vector;
		update();
		repaint();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		setBackground(Color.WHITE);
		Graphics2D g2d = (Graphics2D) g;
		g2d.scale(15, 15);
		if(vector != null) {			
			g2d.setStroke(new BasicStroke(0.5f));
			g2d.setColor(Color.BLACK);
			g2d.drawLine(1, 1, (int)vector.v[0], (int) vector.v[1]);
		}
		

	}

}
