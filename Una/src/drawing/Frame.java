package drawing;

import java.awt.EventQueue;



import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JToggleButton;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JColorChooser;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import geometry.*;
import drawing.DialogRectangle;

public class Frame extends JFrame {

	private JPanel contentPane;
	private JToggleButton tglbtnPoint;
	private JToggleButton tglbtnLine;
	private JToggleButton tglbtnRectangle;
	private JToggleButton tglbtnCircle;
	private JToggleButton tglbtnDonut;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JPanel panelButtonsEast;
	private JToggleButton tglbtnSelect;
	private JButton btnModify;
	private JButton btnDelete;
	private JPanel panelNorth;
	private JButton btnOuterColor;
	private JButton btnInnerColor;
	private Color outerColor = Color.BLACK;
	private Color innerColor = Color.WHITE;
	private PnlDrawing pnlDrawing = new PnlDrawing();
	private Point startPoint;
	private Shape selectedShape;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame frame = new Frame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Frame() {
		setTitle("IM 43-2016 Batinica Una");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 70, 1000, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelButtonsWest = new JPanel();
		contentPane.add(panelButtonsWest, BorderLayout.WEST);
		panelButtonsWest.setLayout(new GridLayout(0, 1, 0, 0));
		
		tglbtnPoint = new JToggleButton("Point");
		tglbtnPoint.setForeground(new Color(189, 183, 107));
		tglbtnPoint.setBackground(new Color(85, 107, 47));
		panelButtonsWest.add(tglbtnPoint);
		
		tglbtnLine = new JToggleButton("Line");
		tglbtnLine.setForeground(new Color(189, 183, 107));
		tglbtnLine.setBackground(new Color(85, 107, 47));
		panelButtonsWest.add(tglbtnLine);
		
		tglbtnRectangle = new JToggleButton("Rectangle");
		tglbtnRectangle.setForeground(new Color(189, 183, 107));
		tglbtnRectangle.setBackground(new Color(85, 107, 47));
		panelButtonsWest.add(tglbtnRectangle);
		
		tglbtnCircle = new JToggleButton("Circle");
		tglbtnCircle.setBackground(new Color(85, 107, 47));
		tglbtnCircle.setForeground(new Color(189, 183, 107));
		panelButtonsWest.add(tglbtnCircle);
		
		tglbtnDonut = new JToggleButton("Donut");
		tglbtnDonut.setBackground(new Color(85, 107, 47));
		tglbtnDonut.setForeground(new Color(189, 183, 107));
		panelButtonsWest.add(tglbtnDonut);
		
		panelButtonsEast = new JPanel();
		contentPane.add(panelButtonsEast, BorderLayout.EAST);
		panelButtonsEast.setLayout(new GridLayout(0, 1, 0, 0));
		
		tglbtnSelect = new JToggleButton("Select");
		tglbtnSelect.setBackground(new Color(85, 107, 47));
		tglbtnSelect.setForeground(new Color(189, 183, 107));
		panelButtonsEast.add(tglbtnSelect);
		
		btnModify = new JButton("Modify");
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(selectedShape == null ) {
					JOptionPane.showMessageDialog(panelButtonsWest, "Please select one shape");
				}
				else {
					if(selectedShape instanceof Point) {
						DialogPoint dlgPoint = new DialogPoint();
						Point point = (Point)selectedShape;
						dlgPoint.getTextX().setText(point.getX() + "");
						dlgPoint.getTextY().setText(point.getY() + "");
						dlgPoint.getBtnOuterColor().setBackground(point.getOuterColor());
						dlgPoint.setVisible(true);
						if(dlgPoint.isSuccess()) {
							int x = Integer.parseInt(dlgPoint.getTextX().getText());
							int y = Integer.parseInt(dlgPoint.getTextY().getText());
							Point modifyPoint = new Point(x,y,true,dlgPoint.getBtnOuterColor().getBackground());
							System.out.println("modifikacija" + point);
							point.setX(modifyPoint.getX());
							point.setY(modifyPoint.getY());
							point.setOuterColor(modifyPoint.getOuterColor());
							repaint();
						}
					}
					else if(selectedShape instanceof Line) {
						DialogLine dlgLine = new DialogLine();
						Line line = (Line)selectedShape;
						
						dlgLine.getTextXStartPoint().setText(line.getStartPoint().getX() + "");
						dlgLine.getTextYStartPoint().setText(line.getStartPoint().getY() + "");
						dlgLine.getTextXEndPoint().setText(line.getEndPoint().getX() + "");
						dlgLine.getTextYEndPoint().setText(line.getEndPoint().getY() + "");
						dlgLine.getBtnOuterColor().setBackground(line.getOuterColor());
						dlgLine.setVisible(true);
						if(dlgLine.isSuccess()) {
							int xStartPoint = Integer.parseInt(dlgLine.getTextXStartPoint().getText());
							int yStartPoint = Integer.parseInt(dlgLine.getTextYStartPoint().getText());
							int xEndPoint = Integer.parseInt(dlgLine.getTextXEndPoint().getText());
							int yEndPoint = Integer.parseInt(dlgLine.getTextYEndPoint().getText());
							Line modifyLine = new Line(new Point(xStartPoint,yStartPoint), new Point(xEndPoint,yEndPoint), true , 
									dlgLine.getBtnOuterColor().getBackground());
							System.out.println("modifikacija" + line);
							line.setStartPoint(modifyLine.getStartPoint());
							line.setEndPoint(modifyLine.getEndPoint());
							line.setOuterColor(modifyLine.getOuterColor());
							repaint();
						}
					}
					else if(selectedShape instanceof Rectangle){
						DialogRectangle dlgRectangle = new DialogRectangle();
						Rectangle rectangle = (Rectangle)selectedShape;
						
						dlgRectangle.getTextXUpperLeftPoint().setText(rectangle.getUpperLeft().getX() + "");
						dlgRectangle.getTextYUpperLeftPoint().setText(rectangle.getUpperLeft().getY() + "");
						dlgRectangle.getTextHeight().setText(rectangle.getHeight() + "");
						dlgRectangle.getTextWidth().setText(rectangle.getWidth() + "");
						dlgRectangle.getBtnOuterColor().setBackground(rectangle.getOuterColor());
						dlgRectangle.getBtnInnerColor().setBackground(rectangle.getInnerColor());
						dlgRectangle.setVisible(true);
						if(dlgRectangle.isSuccess()) {
							int x = Integer.parseInt(dlgRectangle.getTextXUpperLeftPoint().getText());
							int y = Integer.parseInt(dlgRectangle.getTextYUpperLeftPoint().getText());
							int height = Integer.parseInt(dlgRectangle.getTextHeight().getText());
							int width = Integer.parseInt(dlgRectangle.getTextWidth().getText());
							Rectangle modifyRectangle = new Rectangle(new Point(x,y),width,height, true,
									dlgRectangle.getBtnOuterColor().getBackground(), dlgRectangle.getBtnInnerColor().getBackground());
							rectangle.setUpperLeft(modifyRectangle.getUpperLeft());
							rectangle.setWidth(modifyRectangle.getWidth());
							rectangle.setHeight(modifyRectangle.getHeight());
							rectangle.setOuterColor(modifyRectangle.getOuterColor());
							rectangle.setInnerColor(modifyRectangle.getInnerColor());
							repaint();	
						}
					}
					else if(selectedShape instanceof Donut) {
						DialogDonut dlgDonut = new DialogDonut();
						Donut donut = (Donut)selectedShape;
						
						dlgDonut.getTextXCenter().setText(donut.getCenter().getX() + "");
						dlgDonut.getTextYCenter().setText(donut.getCenter().getY() + "");
						dlgDonut.getTextOuterRadius().setText(donut.getRadius() + "");
						dlgDonut.getTextInnerRadius().setText(donut.getInnerRadius() + "");
						dlgDonut.getBtnOuterColor().setBackground(donut.getOuterColor());
						dlgDonut.getBtnInnerColor().setBackground(donut.getInnerColor());
						dlgDonut.setVisible(true);
						if(dlgDonut.isSucces()) {
							int x = Integer.parseInt(dlgDonut.getTextXCenter().getText());
							int y = Integer.parseInt(dlgDonut.getTextYCenter().getText());
							int outerRadius = Integer.parseInt(dlgDonut.getTextOuterRadius().getText());
							int innerRadius = Integer.parseInt(dlgDonut.getTextInnerRadius().getText());
							Donut modifyDonut = new Donut(new Point(x,y),outerRadius,innerRadius,true, dlgDonut.getBtnOuterColor().getBackground(),
									dlgDonut.getBtnInnerColor().getBackground());
							donut.setCenter(modifyDonut.getCenter());
							donut.setInnerRadius(modifyDonut.getInnerRadius());
							donut.setOuterColor(modifyDonut.getOuterColor());
							donut.setInnerColor(modifyDonut.getInnerColor());
							repaint();
							
						}
					}
					else if(selectedShape instanceof Circle) {
						DialogCircle dlgCircle = new DialogCircle();
						Circle circle = (Circle)selectedShape;
						
						dlgCircle.getTextXCenter().setText(circle.getCenter().getX() + "");
						dlgCircle.getTextYCenter().setText(circle.getCenter().getY() + "");
						dlgCircle.getTextRadius().setText(circle.getRadius() + "");
						dlgCircle.getBtnOuterColor().setBackground(circle.getOuterColor());
						dlgCircle.getBtnInnerColor().setBackground(circle.getInnerColor());
						dlgCircle.setVisible(true);
						if(dlgCircle.isSucces()) {
							int x = Integer.parseInt(dlgCircle.getTextXCenter().getText());
							int y = Integer.parseInt(dlgCircle.getTextYCenter().getText());
							int radius = Integer.parseInt(dlgCircle.getTextRadius().getText());
							Circle modifyCircle = new Circle(new Point(x,y),radius,true,dlgCircle.getBtnOuterColor().getBackground(),
									dlgCircle.getBtnInnerColor().getBackground());
							circle.setCenter(modifyCircle.getCenter());
							circle.setOuterColor(modifyCircle.getOuterColor());
							circle.setInnerColor(modifyCircle.getInnerColor());
							repaint();
						}
					}
				}
			
			}
		});
		btnModify.setForeground(new Color(255, 255, 255));
		btnModify.setBackground(new Color(139, 0, 0));
		panelButtonsEast.add(btnModify);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(selectedShape == null) {
					
					JOptionPane.showMessageDialog(panelButtonsWest, "Please select one shape");
				}
				else {
					int response = JOptionPane.showConfirmDialog(panelButtonsWest, "Are you sure you want to delete selected shape?" , "Dialog delete" , JOptionPane.YES_NO_OPTION);
					if(response == JOptionPane.YES_OPTION) {
						
						pnlDrawing.deleteShape(selectedShape);
						selectedShape = null;
						
						
					}
				}
			}
		});
		btnDelete.setForeground(new Color(128, 0, 0));
		btnDelete.setBackground(new Color(255, 255, 255));
		panelButtonsEast.add(btnDelete);
		

		buttonGroup.add(tglbtnPoint);
		buttonGroup.add(tglbtnLine);
		buttonGroup.add(tglbtnRectangle);
		buttonGroup.add(tglbtnCircle);
		buttonGroup.add(tglbtnDonut);
		buttonGroup.add(tglbtnSelect);
		
		panelNorth = new JPanel();
		panelNorth.setBackground(new Color(85, 107, 47));
		contentPane.add(panelNorth, BorderLayout.NORTH);
		
		btnOuterColor = new JButton("Outer color");
		btnOuterColor.setForeground(new Color(245, 245, 245));
		btnOuterColor.setBackground(outerColor);
		btnOuterColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				outerColor = JColorChooser.showDialog(btnOuterColor, "Choose your outer color", outerColor);
				if (outerColor != null) {
					btnOuterColor.setBackground(outerColor);
				}
			}
		});
		panelNorth.add(btnOuterColor);
		
		btnInnerColor = new JButton("Inner color");
		btnInnerColor.setForeground(new Color(85, 107, 47));
		btnInnerColor.setBackground(innerColor);
		btnInnerColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				innerColor = JColorChooser.showDialog(btnInnerColor, "Choose your inner color", innerColor);
				if (innerColor != null) {
					btnInnerColor.setBackground(innerColor);
				}
			}
		});
		panelNorth.add(btnInnerColor);
		
		pnlDrawing.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if (tglbtnPoint.isSelected()) {
					int x = e.getX();
					int y = e.getY();
					Point point = new Point(x,y,false,outerColor);
					pnlDrawing.addShape(point);
					
				}
				else if (tglbtnLine.isSelected()) {
					if (startPoint == null) {
						int xStartPoint = e.getX();
						int yStartPoint = e.getY();
						startPoint = new Point(xStartPoint,yStartPoint,false);
					}
					else {
						int xEndPoint = e.getX();
						int yEndPoint = e.getY();
						Point endPoint = new Point(xEndPoint,yEndPoint,false);
						Line line = new Line(startPoint,endPoint,false,outerColor);
						pnlDrawing.addShape(line);
						startPoint = null;
					}
					
				}
				else if (tglbtnRectangle.isSelected()){
					 	
						int xUpperLeftPoint = e.getX();
						int yUpperLeftPoint = e.getY();
						Point upperLeftPoint = new Point(xUpperLeftPoint,yUpperLeftPoint,false);
						DialogRectangle dlgRectangle = new DialogRectangle();
						dlgRectangle.getTextXUpperLeftPoint().setText(String.valueOf(xUpperLeftPoint));
						dlgRectangle.getTextXUpperLeftPoint().setEditable(false);
						dlgRectangle.getTextYUpperLeftPoint().setText(String.valueOf(yUpperLeftPoint));
						dlgRectangle.getTextYUpperLeftPoint().setEditable(false);
						dlgRectangle.getBtnOuterColor().setBackground(outerColor);
						dlgRectangle.getBtnInnerColor().setBackground(innerColor);
						dlgRectangle.setVisible(true);
						if(dlgRectangle.isSuccess()) {
							int width = Integer.parseInt(dlgRectangle.getTextWidth().getText());
							int height = Integer.parseInt(dlgRectangle.getTextHeight().getText());
							Rectangle rect = new Rectangle(upperLeftPoint,width,height,false,dlgRectangle.getBtnOuterColor().getBackground(), 
									dlgRectangle.getBtnInnerColor().getBackground());
							pnlDrawing.addShape(rect);
						}
						
				}
				else if(tglbtnCircle.isSelected()){
					
						int xCenter = e.getX();
						int yCenter = e.getY();
						Point center = new Point(xCenter,yCenter,false);
						DialogCircle dlgCircle = new DialogCircle();
						dlgCircle.getTextXCenter().setText(String.valueOf(xCenter));
						dlgCircle.getTextXCenter().setEditable(false);
						dlgCircle.getTextYCenter().setText(String.valueOf(yCenter));
						dlgCircle.getTextYCenter().setEditable(false);
						dlgCircle.getBtnOuterColor().setBackground(outerColor);
						dlgCircle.getBtnInnerColor().setBackground(innerColor);
						dlgCircle.setVisible(true);
						if(dlgCircle.isSucces()) {
						int radius = Integer.parseInt(dlgCircle.getTextRadius().getText());
						Circle circle = new Circle(center,radius,false,dlgCircle.getBtnOuterColor().getBackground(),
								dlgCircle.getBtnInnerColor().getBackground());
						pnlDrawing.addShape(circle);
					}
				}
				else if(tglbtnDonut.isSelected()){
						
						int xCenter = e.getX();
						int yCenter = e.getY();
						Point center = new Point(xCenter,yCenter,false);
						DialogDonut dlgDonut = new DialogDonut();
						dlgDonut.getTextXCenter().setText(String.valueOf(xCenter));
						dlgDonut.getTextXCenter().setEditable(false);
				 		dlgDonut.getTextYCenter().setText(String.valueOf(yCenter));
						dlgDonut.getTextYCenter().setEditable(false);
						dlgDonut.getBtnOuterColor().setBackground(outerColor);
						dlgDonut.getBtnInnerColor().setBackground(innerColor);
						dlgDonut.setVisible(true);
						if(dlgDonut.isSucces()) {
						int outerRadius = Integer.parseInt(dlgDonut.getTextOuterRadius().getText());
						int innerRadius = Integer.parseInt(dlgDonut.getTextInnerRadius().getText());
						Donut donut = new Donut(center,outerRadius,innerRadius,false,dlgDonut.getBtnOuterColor().getBackground(),
								dlgDonut.getBtnInnerColor().getBackground());
						pnlDrawing.addShape(donut);
						}
					}
				else if(tglbtnSelect.isSelected()) {
					int x = e.getX();
					int y = e.getY();
					selectedShape = null;
					for (Shape shape : pnlDrawing.getShapes()) {
						if(shape.contains(x, y) ) {
							selectedShape = shape;
							System.out.println(selectedShape);
						}
					}
					for(Shape shape : pnlDrawing.getShapes()) {
						if(shape.equals(selectedShape) == false) {
							shape.setSelected(false);
						}
					}
					if(selectedShape != null) {
						if(selectedShape.isSelected() == false) {
							selectedShape.setSelected(true);
						}
						else {
							selectedShape.setSelected(false);
							selectedShape = null;
						}
					}
					repaint();
				}
			}
		});
		
		pnlDrawing.setBackground(new Color(255, 255, 255));
		contentPane.add(pnlDrawing, BorderLayout.CENTER);
	}

	public JToggleButton getTglbtnPoints() {
		return tglbtnPoint;
	}

	public void setTglbtnPoints(JToggleButton tglbtnPoints) {
		this.tglbtnPoint = tglbtnPoints;
	}

	public JToggleButton getTglbtnLine() {
		return tglbtnLine;
	}

	public void setTglbtnLine(JToggleButton tglbtnLine) {
		this.tglbtnLine = tglbtnLine;
	}

	public JToggleButton getTglbtnRectangle() {
		return tglbtnRectangle;
	}

	public void setTglbtnRectangle(JToggleButton tglbtnRectangle) {
		this.tglbtnRectangle = tglbtnRectangle;
	}

	public JToggleButton getTglbtnCircle() {
		return tglbtnCircle;
	}

	public void setTglbtnCircle(JToggleButton tglbtnCircle) {
		this.tglbtnCircle = tglbtnCircle;
	}

	public JToggleButton getTglbtnDonut() {
		return tglbtnDonut;
	}

	public void setTglbtnDonut(JToggleButton tglbtnDonut) {
		this.tglbtnDonut = tglbtnDonut;
	}

	public JButton getBtnOuterColor() {
		return btnOuterColor;
	}

	public void setBtnOuterColor(JButton btnOuterColor) {
		this.btnOuterColor = btnOuterColor;
	}

	public JButton getBtnInnerColor() {
		return btnInnerColor;
	}

	public void setBtnInnerColor(JButton btnInnerColor) {
		this.btnInnerColor = btnInnerColor;
	}

	public Color getOuterColor() {
		return outerColor;
		
	}

	public void setOuterColor(Color outerColor) {
		this.outerColor = outerColor;
	}

	public Color getInnerColor() {
		return innerColor;
	}

	public void setInnerColor(Color innerColor) {
		this.innerColor = innerColor;
	}
	
	

}
