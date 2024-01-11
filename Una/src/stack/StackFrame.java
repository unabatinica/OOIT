package stack;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Rectangle;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StackFrame extends JFrame {

	private JPanel contentPane;
	private DefaultListModel<String> model = new DefaultListModel<String>() ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StackFrame frame = new StackFrame();
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
	public StackFrame() {
		setTitle("IM 43-2016 Batinica Una");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 250, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelNorth = new JPanel();
		contentPane.add(panelNorth, BorderLayout.NORTH);
		
		JLabel lblTitle = new JLabel("Stack");
		panelNorth.add(lblTitle);
		
		JPanel panelSouth = new JPanel();
		contentPane.add(panelSouth, BorderLayout.SOUTH);
		
		JButton btnAddRectangle = new JButton("Add rectangle");
		btnAddRectangle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RectangleDialog rectangleDialog = new RectangleDialog();
				rectangleDialog.setVisible(true);
				if(rectangleDialog.isSuccess()) {
					Rectangle rectangle = rectangleDialog.getRectangle();
					model.add(0, rectangle.toString());
				}
			}
		});
		panelSouth.add(btnAddRectangle);
		
		JButton btnDeleteRectangle = new JButton("Delete rectangle");
		btnDeleteRectangle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(model.size());
				if(model.size() == 0) {
					JOptionPane.showMessageDialog(btnDeleteRectangle, "Stack is empty, please add new rectangle in stack");
				}
				else {
					String rectangle = model.get(0);
					String[] elements = rectangle.split(" ");
					RectangleDialog rectangleDialog = new RectangleDialog();
					rectangleDialog.setTitle("Are you sure you want to delete first rectangle?");
					rectangleDialog.getTextXUpperLeftPoint().setText(elements[6]);
					rectangleDialog.getTextXUpperLeftPoint().setEditable(false);
					rectangleDialog.getTextYUpperLeftPoint().setText(elements[8]);
					rectangleDialog.getTextYUpperLeftPoint().setEditable(false);
					rectangleDialog.getTextWidth().setText(elements[13]);
					rectangleDialog.getTextWidth().setEditable(false);
					rectangleDialog.getTextHeight().setText(elements[17]);
					rectangleDialog.getTextHeight().setEditable(false);
					rectangleDialog.getOkButton().setText("Yes");
					rectangleDialog.getCancelButton().setText("No");
					rectangleDialog.setVisible(true);
					if(rectangleDialog.isSuccess()) {
						
						model.remove(0);
						
					}
					
				}
			}
		});
		panelSouth.add(btnDeleteRectangle);
		
		JPanel panelCenter = new JPanel();
		contentPane.add(panelCenter, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane(); 
		panelCenter.add(scrollPane);
		
		JList list = new JList();
		list.setModel(model);
		scrollPane.setPreferredSize(new Dimension(400, 190));
		scrollPane.setViewportView(list);
	}

}
