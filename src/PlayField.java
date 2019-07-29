import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class PlayField extends JPanel implements ActionListener, KeyListener{
	private static final int WIDTH = 1000;
	private static final int HEIGHT = 720;
	private Timer time;
	private boolean gameState = false;
	//score counter
	private int score = 0;
	
	//paddle create instance
	private Paddle paddle = new Paddle();
	
	//ball create instance
	private Ball ball = new Ball();
	
	//map create map
	private CreateMap map = new CreateMap();
	
	public PlayField() {
		time = new Timer(5, this);
		setBackground(Color.BLACK);
		addKeyListener(this);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.WHITE);
		if(gameState == false)
			g.drawString("Press ENTER to begin the game", WIDTH/2 - 50, HEIGHT/2);
		
		//draw score counter
		g.drawString("SCORE: " + score, 900, 10);
		
		//draw paddle
		g.fillRect(paddle.getX(), paddle.getY(), paddle.getWidth(), paddle.getHeight());
		
		//draw ball
		g.fillOval(ball.getX(), ball.getY(), ball.getWidth(), ball.getHeight());
		
		//draw map
		map.paintMap(g);
		
		if(map.allBlocksGone() == true) {
			g.drawString("Congratulations, you win!", WIDTH/2 - 50, HEIGHT/2);
			time.stop();
		}
		else if(map.allBlocksGone() == false && !time.isRunning() && gameState == true)
			g.drawString("Better luck next time!", WIDTH/2 - 50, HEIGHT/2);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//check if block is hit
		for(int i = 0; i < map.getBlocks().length; i++)
			for(int a = 0; a < map.getBlocks()[i].length; a++)
				if(map.getBlocks()[i][a] != null)
					checkCollision(map.getBlocks()[i][a], i, a);
		
		//check if paddle is hit
		checkPaddleCollision();
		
		//check if ball hits bounds
		if(ball.getX() < 0 || ball.getX() > WIDTH - ball.getWidth()) //left and right walls
			ball.reverseXVel();
		else if(ball.getY() < 0) //upper wall
			ball.reverseYVel();
		else if(ball.getY() > HEIGHT) //bottom wall
			time.stop();
		
		//check if paddle goes out of bounds
		if(paddle.getX() < 0)
			paddle.setX(0);
		else if(paddle.getX() > WIDTH - paddle.getWidth())
			paddle.setX(WIDTH - paddle.getWidth());
		
		//Moving the objects on the screen
		ball.moveX();
		ball.moveY();
		paddle.moveX();
		
		repaint();
	}

	public void checkCollision(Rectangle r, int x, int y) {
		//check if the ball hits a block and destroys it if it does
		Rectangle bl = new Rectangle(ball.getX(), ball.getY(), ball.getWidth(), ball.getHeight());
		boolean detection = r.intersects(bl);
		if(detection) {
			ball.reverseYVel();
			map.getBlocks()[x][y] = null;
			map.changeAmtOfBlocks(-1);
			score += 100;
		}
	}
	
	public void checkPaddleCollision() {
		Rectangle pd = new Rectangle(paddle.getX(), paddle.getY(), paddle.getWidth(), paddle.getHeight());
		Rectangle bl = new Rectangle(ball.getX(), ball.getY(), ball.getWidth(), ball.getHeight());
		boolean detection = pd.intersects(bl);
		if(detection && ball.getYVel() > 0)
			ball.reverseYVel();
	}
	
	@Override
	public void keyPressed(KeyEvent event) {
		if(event.getKeyCode() == KeyEvent.VK_ENTER) {
			gameState = true;
			time.start();
		}
			
		if(event.getKeyCode() == KeyEvent.VK_LEFT)
			paddle.setXVel(-4);
		else if(event.getKeyCode() == KeyEvent.VK_RIGHT)
			paddle.setXVel(4);
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		paddle.setXVel(0);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
