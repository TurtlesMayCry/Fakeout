import java.awt.Graphics;
import java.awt.Rectangle;

public class CreateMap {
	// A 2D array holding rows and columns of blocks(rectangle objects)
	private Rectangle[][] blocks;
	private final int ROWS = 3; 
	private final int COLUMNS = 9; 
	private final int WIDTH = 100;
	private final int HEIGHT = 40;
	private int x, y, amtOfBlocks, initialX;
	
	public CreateMap() {
		this.blocks = new Rectangle[ROWS][COLUMNS];
		this.x = 50;
		this.y = 100;
		this.amtOfBlocks = ROWS * COLUMNS;
		this.initialX = this.x;
		generateBlocks();
	}
	
	public void generateBlocks() {
		for(int i = 0; i < blocks.length; i++) {
			for(int a = 0; a < blocks[0].length; a++) {
				blocks[i][a] = new Rectangle(x, y, WIDTH, HEIGHT);
				// Space each block by the width + 1
				x += WIDTH + 1;
			}
			// X goes back to the initial x position after a row of blocks is created
			x = initialX;
			y += HEIGHT + 1;
		}
	}
	
	public void paintMap(Graphics g) {
		for(int i = 0; i < blocks.length; i++) {
			for(int a = 0; a < blocks[0].length; a++) {
				if(blocks[i][a] != null)
					// Only paint the blocks that are still on the field
					g.fillRect(blocks[i][a].x, blocks[i][a].y, blocks[i][a].width, blocks[i][a].height);
			}
		}
	}
	
	public boolean allBlocksGone() {
		if(amtOfBlocks == 0)
			return true;
		
		return false;
	}
	
	public int getAmtOfBlocks() {
		return this.amtOfBlocks;
	}
	
	public void setAmtOfBlocks(int amt) {
		this.amtOfBlocks = amt;
	}
	
	public void changeAmtOfBlocks(int amt) {
		this.amtOfBlocks += amt;
	}
	
	public Rectangle[][] getBlocks() {
		return this.blocks;
	}
	
	public int getRows() {
		return this.ROWS;
	}
	
	public int getColumns() {
		return this.COLUMNS;
	}
	
}
