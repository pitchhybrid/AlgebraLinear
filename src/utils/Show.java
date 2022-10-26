package utils;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import vector.Transform;
import vector.Vector;

public class Show extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public R r;
	
	public static final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	public Graphic graphic = new Graphic((int) (screenSize.width * 0.12), (int) (screenSize.width * 0.9), screenSize.height);
	
	public Graphic3D graphic3d = new Graphic3D((int) (screenSize.width * 0.12), (int) (screenSize.width * 0.9), screenSize.height);

	public Controls control = new Controls((int) (screenSize.width * 0.12), screenSize.height);

	public Show() {
		add(control);
		this.revalidate();
		this.repaint();
		control.setResetAction(e -> {
			if (r == R._2D) {
				graphic.setVector(new Vector(0, 0));
			}
			if (r == R._3D) {
				graphic.setVector(new Vector(0, 0, 0));
			}
			control.getVectorField().setText("");
			control.getArgsField().setText("");
			this.revalidate();
			this.repaint();
		});
		control.setAction2d(() -> {
			this.r = R._2D;
			setButtons2D();
			this.add(graphic);
		});
		control.setAction3d(() -> {
			this.r = R._3D;
			setButtons3D();
			this.add(graphic3d);
		});
		control.getVectorField().getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				update(e);
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				update(e);
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				update(e);
			}

			public void update(DocumentEvent event) {
				Vector vector = control.getVector();
				if (vector.isValid3D()) {
					graphic3d.setVector(vector);
					return;
				}
				if (vector.isValid2D()) {
					graphic.setVector(vector);
					return;
				}
			}
		});
	}

	public void setButtons2D() {
		control.addButton(R._2D, "translate2D", ev -> {
			Vector vector = control.getVector();
			if (vector.isValid2D()) {

				Transform transform = new Transform(vector);
				if (control.getArgs().length >= 2) {

					control.getArgsField().setBorder(null);
					control.getVectorField().setBorder(null);

					int args[] = control.getArgs();
					graphic.setVector(transform.translate2D(args[0], args[1]));
					control.setLabel(vector, graphic.getVector());
				} else {
					control.getArgsField().setBorder(BorderFactory.createLineBorder(Color.RED));
				}
			}
		});
		control.addButton(R._2D, "rotation2D", ev -> {
			Vector vector = control.getVector();
			if (vector.isValid2D()) {

				Transform transform = new Transform(vector);
				if (control.getArgs().length >= 1) {

					control.getArgsField().setBorder(null);
					control.getVectorField().setBorder(null);

					int args[] = control.getArgs();
					graphic.setVector(transform.rotation2D(args[0]));

					control.setLabel(vector, graphic.getVector());
				} else {
					control.getArgsField().setBorder(BorderFactory.createLineBorder(Color.RED));
				}
			}
		});
		control.addButton(R._2D, "reflection2DX", ev -> {
			Vector vector = control.getVector();
			if (vector.isValid2D()) {

				control.getArgsField().setBorder(null);
				control.getVectorField().setBorder(null);

				Transform transform = new Transform(vector);
				graphic.setVector(transform.reflection2DX());

				control.setLabel(vector, graphic.getVector());
			}
		});
		control.addButton(R._2D, "reflection2DY", ev -> {
			Vector vector = control.getVector();
			if (vector.isValid2D()) {

				control.getArgsField().setBorder(null);
				control.getVectorField().setBorder(null);

				Transform transform = new Transform(vector);
				graphic.setVector(transform.reflection2DY());

				control.setLabel(vector, graphic.getVector());
			}
		});
		control.addButton(R._2D, "projection2DX", ev -> {
			Vector vector = control.getVector();
			if (vector.isValid2D()) {

				control.getArgsField().setBorder(null);
				control.getVectorField().setBorder(null);

				Transform transform = new Transform(vector);
				graphic.setVector(transform.projection2DX());

				control.setLabel(vector, graphic.getVector());
			}
		});
		control.addButton(R._2D, "projection2DY", ev -> {
			Vector vector = control.getVector();
			if (vector.isValid2D()) {

				control.getArgsField().setBorder(null);
				control.getVectorField().setBorder(null);

				Transform transform = new Transform(vector);
				graphic.setVector(transform.projection2DY());

				control.setLabel(vector, graphic.getVector());
			}
		});
		control.addButton(R._2D, "shearing", ev -> {
			Vector vector = control.getVector();
			if (vector.isValid2D()) {

				Transform transform = new Transform(vector);
				if (control.getArgs().length >= 2) {

					control.getArgsField().setBorder(null);
					control.getVectorField().setBorder(null);

					int args[] = control.getArgs();
					graphic.setVector(transform.shearing(args[0], args[1]));

					control.setLabel(vector, graphic.getVector());
				} else {
					control.getArgsField().setBorder(BorderFactory.createLineBorder(Color.RED));
				}
			}
		});
	}

	public void setButtons3D() {
		control.addButton(R._3D, "translate3D", ev -> {
			Vector vector = control.getVector();
			System.out.println(vector);
			if (vector.isValid3D()) {

				Transform transform = new Transform(vector);
				if (control.getArgs().length >= 3) {

					control.getArgsField().setBorder(null);
					control.getVectorField().setBorder(null);

					int args[] = control.getArgs();
					graphic3d.setVector(transform.translate3D(args[0], args[1], args[2]));

					control.setLabel(vector, graphic3d.getVector());
				} else {
					control.getArgsField().setBorder(BorderFactory.createLineBorder(Color.RED));
				}
			}
		});
		control.addButton(R._3D, "rotation3DX", ev -> {
			Vector vector = control.getVector();
			if (vector.isValid3D()) {

				Transform transform = new Transform(vector);
				if (control.getArgs().length >= 1) {

					control.getArgsField().setBorder(null);
					control.getVectorField().setBorder(null);

					int args[] = control.getArgs();
					graphic3d.setVector(transform.rotation3DX(args[0]));

					control.setLabel(vector, graphic3d.getVector());
				} else {

					control.getArgsField().setBorder(BorderFactory.createLineBorder(Color.RED));
				}
			}
		});
		control.addButton(R._3D, "rotation3DY", ev -> {
			Vector vector = control.getVector();
			if (vector.isValid3D()) {

				Transform transform = new Transform(vector);
				if (control.getArgs().length >= 1) {

					control.getArgsField().setBorder(null);
					control.getVectorField().setBorder(null);

					int args[] = control.getArgs();
					graphic3d.setVector(transform.rotation3DY(args[0]));

					control.setLabel(vector, graphic3d.getVector());
				} else {

					control.getArgsField().setBorder(BorderFactory.createLineBorder(Color.RED));
				}
			}
		});
		control.addButton(R._3D, "rotation3DZ", ev -> {
			Vector vector = control.getVector();
			if (vector.isValid3D()) {

				Transform transform = new Transform(vector);
				if (control.getArgs().length >= 1) {

					control.getArgsField().setBorder(null);
					control.getVectorField().setBorder(null);

					int args[] = control.getArgs();
					graphic3d.setVector(transform.rotation3DZ(args[0]));

					control.setLabel(vector, graphic3d.getVector());
				} else {

					control.getArgsField().setBorder(BorderFactory.createLineBorder(Color.RED));
				}
			}
		});
		control.addButton(R._3D, "reflection3DX", ev -> {
			Vector vector = control.getVector();
			if (vector.isValid3D()) {

				control.getArgsField().setBorder(null);
				control.getVectorField().setBorder(null);

				Transform transform = new Transform(vector);
				graphic3d.setVector(transform.reflection3DX());

				control.setLabel(vector, graphic3d.getVector());
			}
		});
		control.addButton(R._3D, "reflection3DY", ev -> {
			Vector vector = control.getVector();
			if (vector.isValid3D()) {

				control.getArgsField().setBorder(null);
				control.getVectorField().setBorder(null);

				Transform transform = new Transform(vector);
				graphic3d.setVector(transform.reflection3DY());

				control.setLabel(vector, graphic3d.getVector());
			}
		});
		control.addButton(R._3D, "reflection3DZ", ev -> {
			Vector vector = control.getVector();
			if (vector.isValid3D()) {

				control.getArgsField().setBorder(null);
				control.getVectorField().setBorder(null);

				Transform transform = new Transform(vector);
				graphic3d.setVector(transform.reflection3DZ());

				control.setLabel(vector, graphic3d.getVector());
			}
		});
		control.addButton(R._3D, "projection3DX", ev -> {
			Vector vector = control.getVector();
			if (vector.isValid3D()) {

				control.getArgsField().setBorder(null);
				control.getVectorField().setBorder(null);

				Transform transform = new Transform(vector);
				graphic3d.setVector(transform.projection3DX());

				control.setLabel(vector, graphic3d.getVector());
			}
		});
		control.addButton(R._3D, "projection3DY", ev -> {
			Vector vector = control.getVector();
			if (vector.isValid3D()) {

				control.getArgsField().setBorder(null);
				control.getVectorField().setBorder(null);

				Transform transform = new Transform(vector);
				graphic3d.setVector(transform.projection3DY());

				control.setLabel(vector, graphic3d.getVector());
			}
		});
		control.addButton(R._3D, "projection3DZ", ev -> {
			Vector vector = control.getVector();
			if (vector.isValid3D()) {

				control.getArgsField().setBorder(null);
				control.getVectorField().setBorder(null);

				Transform transform = new Transform(vector);
				graphic3d.setVector(transform.projection3DZ());

				control.setLabel(vector, graphic3d.getVector());
			}
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
			frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		});
	}
}
