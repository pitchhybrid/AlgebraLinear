package utils;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Show extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	public static final int width = 1280;
	
	public static final int height = 720;
	
	public Show() {
		setBounds(0, 0, 200, height);
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
	}
	
	private final void hideButton( String name) {
		for(Component component: getComponents()) {
			if(((JButton) component).getText().equals(name)) {
				component.setVisible(false);
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
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Trabalho de algebra UNIDADE II");
            frame.add(new Show());
            FlowLayout flowLayout = new FlowLayout();
            flowLayout.setAlignment(FlowLayout.LEFT);
            frame.setLayout(flowLayout);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setSize(Show.width, Show.height);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
	      });
	}
}
