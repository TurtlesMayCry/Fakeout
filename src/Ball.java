
public class Ball {
	private int x, y, xVel, yVel, direction;
	private final int WIDTH = 20;
	private final int HEIGHT = 20;
	
	public Ball() {
		// Ball appears from range x = 100 - 900;
		this.x = (int)(Math.random() * 801) + 100;
		this.y = 400;
		// Ball moves left or right at the start
		// 1 is right and 2 is right
		this.direction = (int)(Math.random() * 2) + 1;
		if(direction == 1)
			this.xVel = 2;
		else if(direction == 2)
			this.xVel = -2;
		this.yVel = 2;
	}

	public void moveX() {
		this.x += this.xVel;
	}
	
	public void moveY() {
		this.y += this.yVel;
	}
	
	public void reverseXVel() {
		this.xVel = -this.xVel;
	}
	
	public void reverseYVel() {
		this.yVel = -this.yVel;
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

	public int getYVel() {
		return yVel;
	}

	public void setYVel(int yVel) {
		this.yVel = yVel;
	}

	public int getWidth() {
		return WIDTH;
	}

	public int getHeight() {
		return HEIGHT;
	}
}
