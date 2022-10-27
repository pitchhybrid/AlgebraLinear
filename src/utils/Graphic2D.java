package utils;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JPanel;

import vector.Vector;

public class Graphic2D extends JPanel {
	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	
	private Vector vector;

	public Graphic2D(int from, int width, int height) {
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
	
	public Vector getVector() {
		return vector;
	}
	
	public void setGrade(Graphics2D g2d) {
		g2d.setStroke(new BasicStroke(0.1f));
		g2d.setColor(Color.LIGHT_GRAY);
		g2d.drawLine(0, -500, 0, 1000);
		g2d.drawLine(-500, 0, 1000, 0);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		setBackground(Color.WHITE);
		Graphics2D g2d = (Graphics2D) g;
		Rectangle rectangle = g2d.getDeviceConfiguration().getBounds();
		g2d.translate(rectangle.getWidth() / 2.5, rectangle.getHeight() / 2);
		g2d.scale(15, -15);
		setGrade(g2d);
		if(vector != null) {			
			g2d.setStroke(new BasicStroke(0.1f));
			g2d.setColor(Color.BLACK);
			g2d.drawLine(0, 0, (int) Math.ceil(vector.v[0]), (int) Math.ceil(vector.v[1]));
		}
		

	}

}
