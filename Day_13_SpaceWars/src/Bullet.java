import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;


public class Bullet extends Rectangle implements FlyingObject {
	
	private static final int START_SIZE = 5;
	private static final int BULLET_SPEED = -3;
	private int dy;
	
	public Bullet(int x, int y){
		super(x,y, START_SIZE, START_SIZE*2);
		
	}
	
	@Override
	public boolean move(){
		y += BULLET_SPEED;
		
		return !(y < -START_SIZE*2); 
		
	}
	
	
	public void draw(Graphics2D g){
		g.setColor(Color.RED);
		g.fill(this);
		g.setColor(Color.BLACK);
		g.draw(this);
	}
	
	
	
	
	
	
	
	

	

}
