package utils;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import vector.Vector;

public class Show extends JPanel {

	private static final long serialVersionUID = 1L;

	public static final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	public Graphic graphic = new Graphic((int) (screenSize.width * 0.1), (int) (screenSize.width * 0.9), screenSize.height);
	public Buttons buttons = new Buttons((int) (screenSize.width * 0.1), screenSize.height);
	public Vector vector;
	public Show() {
		add(buttons);
		this.revalidate();
		this.repaint();
		buttons.setAction2d(() ->{			
			setButtons2D();
			this.add(graphic);
		});
		buttons.setAction3d(() ->{			
			setButtons3D();
		});
	}

	public void setButtons2D() {
		buttons.addButton(R._2D, "translate2D", ev -> {
			graphic.setVector(vector);
		});
		buttons.addButton(R._2D, "rotation2D", ev -> {
			graphic.setVector(vector);
		});
		buttons.addButton(R._2D, "reflection2DX", ev -> {
			graphic.setVector(vector);
		});
		buttons.addButton(R._2D, "reflection2DY", ev -> {
			graphic.setVector(vector);
		});
		buttons.addButton(R._2D, "projection2DX", ev -> {
			graphic.setVector(vector);
		});
		buttons.addButton(R._2D, "projection2DY", ev -> {
			graphic.setVector(vector);
		});
		buttons.addButton(R._2D, "shearing", ev -> {
			graphic.setVector(vector);
		});
	}
	
	public void setButtons3D() {
		buttons.addButton(R._3D, "translate3D", ev -> {
			graphic.setVector(vector);
		});
		buttons.addButton(R._3D, "rotation3D", ev -> {
			graphic.setVector(vector);
		});
		buttons.addButton(R._3D, "reflection3DX", ev -> {
			graphic.setVector(vector);
		});
		buttons.addButton(R._3D, "reflection3DY", ev -> {
			graphic.setVector(vector);
		});
		buttons.addButton(R._3D, "reflection3DZ", ev -> {
			graphic.setVector(vector);
		});
		buttons.addButton(R._3D, "projection3DX", ev -> {
			graphic.setVector(vector);
		});
		buttons.addButton(R._3D, "projection3DY", ev -> {
			graphic.setVector(vector);
		});
		buttons.addButton(R._3D, "projection3DZ", ev -> {
			graphic.setVector(vector);
		});
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			JFrame frame = new JFrame("Trabalho de algebra UNIDADE II");
			frame.setContentPane(new Show());
			frame.setLayout(null);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.pack();
			frame.setSize(Show.screenSize.width, Show.screenSize.height);
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
		});
	}
}
