import javax.swing.JFrame;

public class Breakout extends JFrame {
	// Add an offset of 7 to WIDTH because JPanel takes up extra pixels on the right side
	private static final int WIDTH = 1007;
	private static final int HEIGHT = 720;
	
	public Breakout() {
		super();
		PlayField pf = new PlayField();
		setTitle("Breakout");
		setSize(WIDTH, HEIGHT);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		add(pf);
		addKeyListener(pf);
	}

	public static void main(String args[]) {
		Breakout game = new Breakout();
	}
}
