package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends SurfaceShape {
	
	private Point upperLeft;
	private int width;
	private int height;
	
	public Rectangle() {
		
	}
	
	public Rectangle(Point upperLeft, int width, int height) {
		this.upperLeft = upperLeft;
		this.width = width;
		this.height = height;
	}
	
	public Rectangle(Point upperLeft, int width, int height, boolean selected) {
		this(upperLeft, width, height);
		this.selected = selected;
	}
	
	public Rectangle(Point upperLeft, int width, int height, boolean selected,Color outerColor) {
		this(upperLeft, width, height,selected);
		setOuterColor(outerColor);
	}
	
	public Rectangle(Point upperLeft, int width, int height, boolean selected,Color outerColor,Color innerColor) {
		this(upperLeft, width, height,selected,outerColor);
		setInnerColor(innerColor);
	}
	
	@Override
	public double area() {
		return width*height;
	}
	
	public int circumference() {
		return 2*width + 2*height;
	}

	@Override 
	public boolean equals(Object obj) {
		if(obj instanceof Rectangle) {
			Rectangle temp = (Rectangle) obj;
			if(this.upperLeft.equals(temp.upperLeft)
					&& this.width == temp.width && this.height == temp.height) {
				return true;
			}
		}
		return false;
	}
	
	
	@Override
	public boolean contains(int x, int y) {
		return this.upperLeft.getX() <= x && this.upperLeft.getX() + width >= x
				&& this.upperLeft.getY() <= y && this.upperLeft.getY() + height >= y;
	}
	
	public boolean contains(Point p) {
		return contains(p.getX(), p.getY());
	}
	
	
	@Override
	public void moveTo(int x, int y) {
		upperLeft.moveTo(x, y);
	}
	

	@Override
	public void moveBy(int byX, int byY) {
		upperLeft.moveBy(byX, byY);
	}
	
	@Override
	public int compareTo(Object o) {
		if(o instanceof Rectangle) {
			return (int) (area() - ((Rectangle)o).area());
		}
		return 0;
	}
	
	
	@Override
	public void draw(Graphics g) {
		g.setColor(getOuterColor());
		g.drawRect(this.upperLeft.getX(), this.upperLeft.getY(), this.width, this.height);
		this.fill(g);
		if(this.isSelected()) {
			g.setColor(Color.BLUE);
			g.drawRect(this.upperLeft.getX() - 3, this.upperLeft.getY() - 3, 6, 6);
			g.drawRect(this.upperLeft.getX() + this.width - 3, this.upperLeft.getY() - 3, 6, 6);
			g.drawRect(this.upperLeft.getX() - 3, this.upperLeft.getY() + this.height - 3, 6, 6);
			g.drawRect(this.upperLeft.getX() + this.width - 3, this.upperLeft.getY() + this.height - 3, 6, 6);
		}
	}
	
	@Override
	public void fill(Graphics g) {
		g.setColor(getInnerColor());
		g.fillRect(this.upperLeft.getX() + 1, this.upperLeft.getY() + 1, this.width - 1, this.height - 1);	
	}
	
	@Override
	public String toString() {
		return "Rectangle: upper left point : ( " + this.upperLeft.getX() + " , " + this.upperLeft.getY()
		+ " ) , width = " + getWidth() + " , height = " + this.height; 
	}
	
	public Point getUpperLeft() {
		return upperLeft;
	}
	public void setUpperLeft(Point upperLeft) {
		this.upperLeft = upperLeft;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}

	


}
