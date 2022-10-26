package utils;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import vector.Vector;

public class Controls extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final int width;
	
	private JLabel de = new JLabel();
	private JLabel para = new JLabel();
	
	private JTextField vectorField = new JTextField();
	
	private JTextField argsField = new JTextField();
	
	private Map<R, List<Map.Entry<String, ActionListener>>> buttons = new HashMap<R, List<Map.Entry<String,ActionListener>>>();
	
	private Runnable action2d = () -> { };
	
	private Runnable action3d = () -> { };
	
	private ActionListener resetAction = e ->{};
	
	public Controls(int width, int height) {
		this.width = width;
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBounds(0, 0, width, height);
		setVisible(true);
		setPreferredSize(new Dimension(width, height));
		setSize(getPreferredSize());
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		buttons.put(R._2D, new ArrayList<>());
		buttons.put(R._3D, new ArrayList<>());
		addButton(width, 25, "2D", e -> {
			action2d.run();
			hideButton("2D");
			hideButton("3D");
			addButton(width,25,"RESET", resetAction);
			for(Map.Entry<String, ActionListener> entry:buttons.get(R._2D)) {
				addButton(width, 25, entry.getKey(),entry.getValue());
			};

			addVectorField();
			addArgs();
		});
		addButton(width, 25, "3D", e -> {
			action3d.run();
			hideButton("3D");
			hideButton("2D");
			addButton(width,25,"RESET", resetAction);
			for(Map.Entry<String, ActionListener> entry:buttons.get(R._3D)) {
				addButton(width, 25, entry.getKey(),entry.getValue());
			};
			
			addVectorField();
			addArgs();
		});
		
	}

	public void setAction2d(Runnable action2d) {
		this.action2d = action2d;
	}

	public void setAction3d(Runnable action3d) {
		this.action3d = action3d;
	}

	private final void hideButton(String name) {
		for (Component component : getComponents()) {
			if (component instanceof JButton) {
				if (((JButton) component).getText().equals(name)) {
					component.setVisible(false);
				}
			}
		}
	}

	public Vector getVector() {
		this.revalidate();
		this.repaint();
		return new Vector(Arrays.stream(vectorField.getText().split(",")).mapToDouble(e -> {
			if (e.trim().equals("")) {
				return 0;
			}
			return Double.valueOf(e);
		}).toArray());
	}
	
	public int[] getArgs() {
		this.revalidate();
		this.repaint();
		return Arrays.stream(argsField.getText().split(",")).mapToInt(e -> {
			if (e.trim().equals("")) {
				return 0;
			}
			return Integer.valueOf(e);
		}).toArray();
	}
	
	public void addVectorField() {
		vectorField.setBorder(null);
		add(new JLabel("Vetor:"));
		vectorField.setMaximumSize(new Dimension(width * 5, 30));
		add(vectorField);
		this.revalidate();
		this.repaint();
	}
	
	public void addArgs() {
		argsField.setBorder(null);
		add(new JLabel("Argumentos:"));
		argsField.setMaximumSize(new Dimension(width * 5, 30));
		add(argsField);
		this.add(argsField);
		this.revalidate();
		this.repaint();
	}
	
	public void addButton(R r,String name, ActionListener action) {
		buttons.get(r).add(new Entry<String,ActionListener>(name, action));
	}
	
	public void addButton(int width, int height, String name, ActionListener action) {
		JButton button = new JButton(name);
		button.addActionListener(action);
		button.setMaximumSize(new Dimension(width, height));
		this.add(button);
		this.revalidate();
		this.repaint();
	}

	public JTextField getVectorField() {
		return vectorField;
	}
	
	public JTextField getArgsField() {
		return argsField;
	}

	public void setResetAction(ActionListener actionListener) {
		this.resetAction = actionListener;
	}
	
	public void setLabel(Vector anterior, Vector atual) {
		de.setText("De: " + (anterior == null ? "":anterior));
		this.add(de);
		para.setText("Para: " + (atual == null ? "":atual));
		this.add(para);
		this.revalidate();
		this.repaint();
	}
}
