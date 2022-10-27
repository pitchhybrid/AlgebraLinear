package utils;

import static java.lang.Math.ceil;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JPanel;

import vector.Vector;

public class Graphic3D extends JPanel {

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	
	private Vector vector;

	public Graphic3D(int from, int width, int height) {
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
	
	public void setGrade(Graphics2D g2d, Rectangle rectangle) {
		g2d.setStroke(new BasicStroke(0.1f));
		g2d.setColor(Color.LIGHT_GRAY);
		g2d.drawLine(0, 0, 0, 1000); //Z Axis
		g2d.setColor(Color.LIGHT_GRAY);
		g2d.drawLine(0, 0, 1000, 0);// x Axis
		g2d.setColor(Color.RED);
		g2d.drawLine(0, 0, -1000, -1000); // yAxis
		setBackground(Color.WHITE);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		Rectangle rectangle = g2d.getDeviceConfiguration().getBounds();
		g2d.translate(rectangle.getWidth() / 2.7, rectangle.getHeight() / 2);
		g2d.scale(15, 15);
		g2d.rotate(4);
		setGrade(g2d, rectangle);
		if(vector != null) {
			g2d.setColor(Color.BLACK);
			g2d.setStroke(new BasicStroke(0.1f));
			double x = (int) ceil(vector.v[0]);
			double y = (int) ceil(vector.v[1]);
			double z = (int) ceil(vector.v[2]);
			g2d.drawLine(0, 0, (int ) Math.ceil(x / z) ,  (int) Math.ceil(y / z));
		}

	}

}
