package utils;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Buttons extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Map<R, Map<String, ActionListener>> buttons = new HashMap<R, Map<String,ActionListener>>();
	
	private Runnable action2d = () ->{};
	
	private Runnable action3d = () ->{};
	
	public Buttons(int width, int height) {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBounds(0, 0, width, height);
		setVisible(true);
		Dimension dimension = new Dimension(width, height);
		setPreferredSize(dimension);
		setSize(dimension);
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		buttons.put(R._2D, new HashMap<String, ActionListener>());
		buttons.put(R._3D, new HashMap<String, ActionListener>());
		addButton(0, 0, 30, 20, "2D", e -> {
			action2d.run();
			hideButton("2D");
			hideButton("3D");
			for(Map.Entry<String, ActionListener> entry:buttons.get(R._2D).entrySet()) {
				addButton(0, 0, 30, 20, entry.getKey(),entry.getValue());
			};
		});
		addButton(0, 0, 30, 20, "3D", e -> {
			action3d.run();
			hideButton("2D");
			hideButton("3D");
			for(Map.Entry<String, ActionListener> entry:buttons.get(R._3D).entrySet()) {
				addButton(0, 0, 30, 20, entry.getKey(),entry.getValue());
			};
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
	
	public void addButton(R r,String name, ActionListener action) {
		buttons.get(r).put(name, action);
	}
	
	public void addButton(int x, int y, int width, int height, String name, ActionListener action) {
		JButton button = new JButton(name);
		button.addActionListener(action);
		button.setBounds(x, y, width, height);
		this.add(button);
		this.revalidate();
		this.repaint();
	}
}
