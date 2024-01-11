package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Circle extends SurfaceShape {
	
	private Point center;
	private int radius;
	//protected boolean shape;
	
	
	public Circle() {
		
	}
	
	public Circle(Point center, int radius) {
		this.center = center;
		this.radius = radius;
	}
	
	public Circle(Point center, int radius, boolean selected) {
		this(center,radius);
		this.selected = selected;
	}
	
	public Circle(Point center, int radius, boolean selected,Color outerColor) {
		this(center,radius,selected);
		setOuterColor(outerColor);
	}
	
	public Circle(Point center, int radius, boolean selected,Color outerColor,Color innerColor) {
		this(center,radius,selected,outerColor);
		setInnerColor(innerColor);
	}
	
	
	@Override
	public double area() {
		return radius*radius*Math.PI;
	}
	
	public double circumference() {
		return radius*2*Math.PI;
	}
		
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Circle) {
			Circle temp = (Circle) obj;
			if(this.center.equals(temp.center) && this.radius == temp.radius) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public boolean contains(int x, int y) {
		return this.center.distance(new Point(x,y)) <= radius;
	}
	
	public boolean contains(Point p) {
		return contains(p.getX(), p.getY());
	}
	
	@Override
	public void moveTo(int x, int y) {
		center.moveTo(x, y);
		
	}

	@Override
	public void moveBy(int byX, int byY) {
		center.moveBy(byX, byY);
	}
	
	@Override
	public int compareTo(Object o) {
		if(o instanceof Circle) {
			return (int)(area() - ((Circle)o).area());
		}
		return 0;
	}	
	
	@Override
	public void draw(Graphics g) {
		g.setColor(getOuterColor());
		g.drawOval(this.getCenter().getX() - this.radius, this.getCenter().getY() - this.radius, this.radius * 2, this.radius*2);
		this.fill(g);
		if(this.isSelected()) {
			g.setColor(Color.BLUE);
			g.drawRect(this.getCenter().getX() - this.radius - 3, this.getCenter().getY() - 3, 6, 6);
			g.drawRect(this.getCenter().getX() - 3, this.getCenter().getY() + this.radius - 3, 6, 6);
			g.drawRect(this.getCenter().getX() + this.radius - 3, this.getCenter().getY() - 3, 6, 6);
			g.drawRect(this.getCenter().getX() - 3, this.getCenter().getY() - this.radius - 3, 6, 6);
		}
	}

	@Override
	public void fill(Graphics g) {
		g.setColor(getInnerColor());
		g.fillOval(this.getCenter().getX() - this.radius + 1, this.getCenter().getY() - this.radius + 1, this.radius * 2 - 2, this.radius*2 - 2);
		
	}
	
	@Override
	public String toString() {
		return "Center: (" +this.center.getX() + ", " +this.center.getY() + "), radius = " + this.radius;
	}
	
	

	public Point getCenter() {
		return center;
	}

	public void setCenter(Point center) {
		this.center = center;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	
	
}
