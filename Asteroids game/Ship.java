/**
 * A representation of a ship.
 */
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Ship extends Polygon implements KeyListener {
	public static final int SHIP_WIDTH = 40;
	public static final int SHIP_HEIGHT = 25;
	
	private boolean forward;
	private boolean right;
	private boolean left;
	private boolean fire;
	
	
	
	
	private ArrayList<Bullet> forthebullet=new ArrayList<Bullet>();
    
	public Ship(Point[] inShape, Point inPosition, double inRotation) {
		super(inShape, inPosition, inRotation);
	}
	//private ArrayList <T>;

	// Create paint method to paint a ship
	public void paint(Graphics brush, Color color) {
		//Point B=new Point(rotation, rotation);
		Point[] points = getPoints();
		int[] xPoints = new int[points.length];
		int[] yPoints = new int[points.length];
		int nPoints = points.length;
		for(int i = 0; i < nPoints; ++i) {
			xPoints[i] = (int) points[i].x;
			yPoints[i] = (int) points[i].y;
		}
		brush.setColor(color);
		brush.fillPolygon(xPoints, yPoints, nPoints);
		//Point B=new Point(385.0, 288.0);
		//Bullet bullet=new Bullet(B, rotation);
		//ArrayList<Bullet> bullet=getBullets();
		
		
	}
	public ArrayList<Bullet> getBullets() {
		
		
		
		return forthebullet;
		
	}
	

	public void move() {
		Point ForShip=position;
		//Point findB=new Point(400.0,288.0);
		// Check forward movement
        if(forward) {
        	//Point B=new Point(rotation, rotation);
            ForShip.x += 2 * Math.cos(Math.toRadians(rotation));
            ForShip.y += 2 * Math.sin(Math.toRadians(rotation));
            
            
            // This code was developed in milestone 2
            if(ForShip.x > Asteroids.SCREEN_WIDTH) {
                ForShip.x -= Asteroids.SCREEN_WIDTH;
            } else if(ForShip.x < 0) {
                ForShip.x += Asteroids.SCREEN_WIDTH;
            }
            if(ForShip.y > Asteroids.SCREEN_HEIGHT) {
                ForShip.y -= Asteroids.SCREEN_HEIGHT;
            } else if(ForShip.y < 0) {
                ForShip.y += Asteroids.SCREEN_HEIGHT;
            }
        }
        // The polygon class has a rotate() method that needs
        // to be called if they are moving right or left
       
        
        // Check rotation to right
        if(right) {
            rotate(2);
        }
        // Check rotation to left
        if(left) {
            rotate(-2);
        }
       


	}
	
	/**
	 * Following methods set appropriate boolean values when
	 * arrow keys are pressed.
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			forward = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			right = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			left = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			
			Point[] B=getPoints();
			Point B1=B[3];
			//Point B=new Point(400.0, 288.0);
			fire=true;
			Bullet b=new Bullet(B1, rotation);
			forthebullet.add(b);
		    }
	    }
			
			//b.paint(this.ship, Color.yellow);
			//System.out.println("x");
			
			//if(b.center.x==800.0||b.center.y==600.0) {
				//fire=false;
			//}
			
		//}

	//}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			forward = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			right = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			left = false;
		}
		
		
	}

	@Override
	public void keyTyped(KeyEvent e) { 
		return;
	}
}
