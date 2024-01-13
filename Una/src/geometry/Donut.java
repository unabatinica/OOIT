package geometry;



import java.awt.Color;
import java.awt.Graphics;

public class Donut extends Circle {
	
	
		private int innerRadius;
		
		public Donut() {
			
		}
		
		public Donut(Point center, int radius, int innerRadius) {
			super(center, radius);
			this.innerRadius = innerRadius;
		}
		
		public Donut(Point center, int radius, int innerRadius, boolean selected) {
			this(center, radius, innerRadius);
			this.selected = selected;
		}
		
		public Donut(Point center, int radius, int innerRadius, boolean selected, Color outerColor) {
			this(center, radius, innerRadius,selected);
			setOuterColor(outerColor);
			
		}
		
		public Donut(Point center, int radius, int innerRadius, boolean selected, Color outerColor,Color innerColor) {
			this(center, radius, innerRadius,selected,outerColor);
			setInnerColor(innerColor);	
		}
		
		@Override
		public double area() {
			double outerCircle = super.area();
			double innerCircle = this.innerRadius * this.innerRadius * Math.PI;
			return outerCircle - innerCircle;
		}
		
		@Override
		public boolean contains(int x, int y) {
			double dFromCenter = 
						getCenter().distance(new Point(x,y));
			return dFromCenter >= this.innerRadius && dFromCenter <= getRadius();
		}
		
		public boolean contains(Point p) {
			double dFromCenter = getCenter().distance(p);
			return dFromCenter >= this.innerRadius && dFromCenter <= getRadius();
		}
		
		public boolean equals(Object obj) {
			if(obj instanceof Donut) {
				Donut donut = (Donut) obj;
				if(getCenter().equals(donut.getCenter()) && getRadius() == donut.getRadius() && this.innerRadius == donut.innerRadius) {
					return true;
				}else {
					return false;
				}
			}else {
				return false;
			}
		}
		
		@Override
		public int compareTo(Object o) {
			if(o instanceof Donut) {
				return (int)((area() - ((Donut)o).area()));
			}
			return 0;
		}
		
		
		public void draw(Graphics g) {
			super.draw(g);
			g.setColor(getOuterColor());
			g.drawOval(this.getCenter().getX() - this.innerRadius, this.getCenter().getY() - this.innerRadius, this.innerRadius*2, this.innerRadius*2);
			g.setColor(Color.WHITE);
			g.fillOval(this.getCenter().getX() - this.innerRadius + 1, this.getCenter().getY() - this.innerRadius + 1, this.innerRadius*2 - 2, this.innerRadius*2 - 2);
			if(this.isSelected()) {
				g.setColor(Color.BLUE);
				g.drawRect(this.getCenter().getX() - this.innerRadius - 3, this.getCenter().getY() - 3, 6, 6);
				g.drawRect(this.getCenter().getX() - 3, this.getCenter().getY() + this.innerRadius - 3, 6, 6);
				g.drawRect(this.getCenter().getX() + this.innerRadius - 3, this.getCenter().getY() - 3, 6, 6);
				g.drawRect(this.getCenter().getX() - 3, this.getCenter().getY() - this.innerRadius - 3, 6, 6);
			}
		}
		
	
		
		public String toString() {
			return "Center: ("+ getCenter().getX()+", "+getCenter().getY() +"), " + "outer radius = "+ getRadius()+ ", inner radius = " + this.innerRadius; 
		}
		
		public int getInnerRadius() {
			return innerRadius;
		}

		public void setInnerRadius(int innerRadius) {
			this.innerRadius = innerRadius;
		}
	}


