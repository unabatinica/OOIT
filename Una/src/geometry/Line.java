package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Line extends Shape {
	
	private Point startPoint;
	private Point endPoint;
	
	public Line() {
		
	}
	
	public Line(Point startPoint, Point endPoint) {
		this.startPoint = startPoint;
		this.endPoint = endPoint;
	}
	
	public Line(Point startPoint, Point endPoint, boolean selected) {
		this(startPoint, endPoint);
		this.selected = selected;
	}
	
	public Line(Point startPoint, Point endPoint, boolean selected, Color outerColor) {
		this(startPoint, endPoint);
		this.selected = selected;
		setOuterColor(outerColor);
	}
	
	public double length() {
		return startPoint.distance(endPoint);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Line) {
			Line temp =  (Line) obj;
			if(this.startPoint.equals(temp.startPoint) && this.endPoint.equals(temp.endPoint)) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public boolean contains(int x, int y) {
		Point klik = new Point(x,y);
		return (this.startPoint.distance(klik) + this.endPoint.distance(klik) - length()) <= 2;
	}
	
	@Override
	public void moveTo(int x,int y) {
		startPoint.moveTo(x, y);
		
	}

	@Override
	public void moveBy(int byX, int byY) {
		startPoint.moveBy(byX, byY);
		endPoint.moveBy(byX, byY);
	}
	
	@Override
	public int compareTo(Object o) {
		if(o instanceof Line) {
			return (int) (length() - ((Line)o).length());
		}
		return 0;
	}
		
	@Override
	public void draw(Graphics g) {
		g.setColor(getOuterColor());
		g.drawLine(this.startPoint.getX(), this.startPoint.getY(), this.endPoint.getX(), this.endPoint.getY());
		if(this.isSelected()) {
			g.setColor(Color.BLUE);
			g.drawRect(this.startPoint.getX()-3, this.startPoint.getY()-3, 6, 6);
			g.drawRect(this.endPoint.getX() - 3, this.endPoint.getY() - 3, 6, 6);
		}
	}
	
	@Override
	public String toString() {
		return "(" + this.startPoint.getX() + ", " + this.startPoint.getY() + ")"
				+ " --> (" + this.endPoint.getX() + ", " + this.endPoint.getY() + ")";
 	}
	
	public Point getStartPoint() {
		return startPoint;
	}

	public void setStartPoint(Point startPoint) {
	this.startPoint = startPoint;
	}

	public Point getEndPoint() {
	return endPoint;
	}

	public void setEndPoint(Point endPoint) {
	this.endPoint = endPoint;
	}


}
