package utils;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Buttons extends JPanel{

	public Buttons(int width, int height) {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBounds(0, 0, width, height);
		setVisible(true);
		addButton(0, 0, 30, 20, "2D", e -> {
			hideButton("2D");
			hideButton("3D");
			addButton(0, 0, 30, 20, "translate2D", ev ->{
				
			});
			addButton(0, 0, 30, 20, "rotation2D", ev ->{
				
			});
			addButton(0, 0, 30, 20, "reflection2DX", ev ->{
				
			});
			addButton(0, 0, 30, 20, "reflection2DY", ev ->{
				
			});
			addButton(0, 0, 30, 20, "projection2DX", ev ->{
				
			});
			addButton(0, 0, 30, 20, "projection2DY", ev ->{
				
			});
			addButton(0, 0, 30, 20, "shearing", ev ->{
				
			});
		});
		addButton(0, 0, 30, 20, "3D", e -> {
			hideButton("2D");
			hideButton("3D");
			addButton(0, 0, 30, 20, "translate3D", ev ->{
				
			});
			addButton(0, 0, 30, 20, "rotation3D", ev ->{
				
			});
			addButton(0, 0, 30, 20, "reflection3DX", ev ->{
				
			});
			addButton(0, 0, 30, 20, "reflection3DY", ev ->{
				
			});
			addButton(0, 0, 30, 20, "reflection3DZ", ev ->{
				
			});
			addButton(0, 0, 30, 20, "projection3DX", ev ->{
				
			});
			addButton(0, 0, 30, 20, "projection3DY", ev ->{
				
			});
			addButton(0, 0, 30, 20, "projection3DZ", ev ->{
				
			});
		});
		setPreferredSize(new Dimension(width, height));
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}
	private final void hideButton( String name) {
		for(Component component: getComponents()) {
			if(component instanceof JButton) {				
				if(((JButton) component).getText().equals(name)) {
					component.setVisible(false);
				}
			}
		}
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
