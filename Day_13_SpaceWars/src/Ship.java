import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;


public class Ship extends Rectangle implements FlyingObject, Reducible {
	
	private static final int START_SIZE = 40;
	private int dx, sw;
	
	public Ship(int x, int y, int dx, int sw){
		super(x,y, START_SIZE, START_SIZE/2);
		setDx(dx);
		this.sw = sw;
	}
	
	@Override
	public boolean move(){
		x += dx;
		if(x > sw)
			x = -width;
		else if( x< -width)
			x = sw;
		return true;
	}
	@Override
	public boolean reduce() {
		if(width <= (START_SIZE/4)) return false;
		width /= 2;
		height /= 2;
		
		return true;
	}
	
	public void draw(Graphics2D g){
		g.setColor(Color.GREEN);
		g.fill(this);
		g.setColor(Color.BLACK);
		g.draw(this);
	}
	
	public void setDx(int dx){
		if(dx< -5)
			this.dx = dx;
		else if (dx > 5)
			this.dx = 5;
		else if(dx==0)
			this.dx = (int)(Math.random()*5 +1);
		
		this.dx = dx;
	}

	

}
