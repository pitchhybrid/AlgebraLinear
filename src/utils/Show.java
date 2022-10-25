package utils;
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
		addButton(1000, 0, 30, 20, "name", e ->{
			System.out.println(e);
		});
		addButton(1000, 0, 30, 20, "name", e ->{
			System.out.println(e);
		});
		addButton(1000, 0, 30, 20, "name", e ->{
			System.out.println(e);
		});
	}
	
	public void addButton(int x, int y, int width, int height, String name, ActionListener action) {
		JButton button = new JButton(name);
		button.addActionListener(action);
		button.setBounds(x, y, width, height);
		this.add(button);
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
