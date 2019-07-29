
public class Paddle {
	private int x, y, xVel;
	private final int WIDTH = 200;
	private final int HEIGHT = 20;
	
	public Paddle() {
		this.x = 450;
		this.y = 650;
		this.xVel = 0;
	}
	
	public void moveX() {
		this.x += this.xVel;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}

	public int getXVel() {
		return xVel;
	}

	public void setXVel(int xVel) {
		this.xVel = xVel;
	}

	public int getWidth() {
		return WIDTH;
	}

	public int getHeight() {
		return HEIGHT;
	}
}
