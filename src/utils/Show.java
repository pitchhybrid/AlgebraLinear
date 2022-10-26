package utils;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Show extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	public static final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	public Show() {
		add(new Buttons((int) (screenSize.width * 0.1), screenSize.height));		
		add(new Graphic((int) (screenSize.width * 0.9), screenSize.height));
		this.revalidate();
		this.repaint();
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
