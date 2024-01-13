package drawing;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import geometry.Shape;
import javax.swing.JPanel;

public class PnlDrawing extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Shape> shapes;
	
	public PnlDrawing() {
		
		shapes = new ArrayList<Shape>();
		
	}
	
	public void paint(Graphics g) {
		
		super.paint(g);
		
		Iterator<Shape> iterator = shapes.iterator();
		
		while(iterator.hasNext()) {
			
			Shape shape = iterator.next();
			shape.draw(g);
			
		}
	}
	
	public void addShape(Shape shape) {
		
		shapes.add(shape);
		repaint();
	}
	
	public void deleteShape(Shape shape) {
		
		shape.setSelected(false);
		shapes.remove(shape);
		repaint();
	}

	public ArrayList<Shape> getShapes() {
		return shapes;
	}

	public void setShapes(ArrayList<Shape> shapes) {
		this.shapes = shapes;
	}
	
	

}
