import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Tester extends JPanel {
	public JFrame window = new JFrame("My Space War Game");
	public ArrayList<Bullet> bullets = new ArrayList<Bullet>();
	public ArrayList<Ship> ships = new ArrayList<Ship>();
	public Timer timer = new Timer(10, new MoveObjects());
	
	public Tester(){
		window.setBounds(100,100,500,500);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.add(this);
		window.setVisible(true);
		addMouseListener(new ShootBullets());
		setUpShips();
		timer.start();
	}
	
	private void setUpShips() {
		Random rnd = new Random();
		
		for(int i = 0; i < 4; i++){
			ships.add(new Ship(
					rnd.nextInt(getWidth()),
					i * 25 + 5,
					(rnd.nextInt(5) + 1) * (rnd.nextBoolean() ? 1 : -1),
					getWidth()
					));
		}
		
	}

	@Override
	public void paint(Graphics g){
		for(Bullet b : bullets) b.draw((Graphics2D)g);
		for(Ship s : ships) s.draw((Graphics2D)g);
	}
	
	public class MoveObjects implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			
			for(int i = bullets.size()-1; i>=0; i--){
				if(bullets.get(i).move() == false){
					bullets.remove(i);
				}
			}
			
			
			
			for(int i = ships.size()-1; i>=0; i--){
				if(ships.get(i).move());
					
			}
			window.repaint();
		}
		
	}
	
	public class ShootBullets implements MouseListener{
		
		@Override
		public void mousePressed(MouseEvent e) {
			if(bullets.size() < 4){
				bullets.add(new Bullet(e.getX(),getHeight()));
			}
			
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			
			
		}

		

		@Override
		public void mouseReleased(MouseEvent e) {
			
			
		}
		
	}
	
	
	
	
	public static void main(String[] args) {
		new Tester();
	}

}
