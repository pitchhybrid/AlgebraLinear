package utils;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.geom.AffineTransform;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class Graphic extends JPanel {
	int[] polygonXs = { -20, 0, +20, 0 };
	int[] polygonYs = { 20, 10, 20, -20 };
	double x = 50.0, y = 50.0;  // (x, y) position of this Shape
	Shape shape = new Polygon(polygonXs, polygonYs, polygonXs.length);

	public Graphic(int width, int height) {
		setVisible(true);
		setBounds(width, 0, width, height);
//		setPreferredSize(new Dimension(width, height));
//		setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}
	public void update() {
		this.validate();
		this.repaint();
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		setBackground(Color.WHITE);
		Graphics2D g2d = (Graphics2D) g;

		// Save the current transform of the graphics contexts.
		AffineTransform saveTransform = g2d.getTransform();
		// Create a identity affine transform, and apply to the Graphics2D context
		AffineTransform identity = new AffineTransform();
		g2d.setTransform(identity);

		// Paint Shape (with identity transform), centered at (0, 0) as defined.
		g2d.setColor(Color.GREEN);
		g2d.fill(shape);
		// Translate to the initial (x, y) position, scale, and paint
		g2d.translate(x, y);
		g2d.scale(1.2, 1.2);
		g2d.fill(shape);

		// Try more transforms
		for (int i = 0; i < 5; ++i) {
			g2d.translate(50.0, 5.0); // translates by (50, 5)
			g2d.setColor(Color.BLUE);
			g2d.fill(shape);
			g2d.rotate(Math.toRadians(15.0)); // rotates about transformed origin
			g2d.setColor(Color.RED);
			g2d.fill(shape);
		}
		// Restore original transform before returning
		g2d.setTransform(saveTransform);
		update();

	}

}
