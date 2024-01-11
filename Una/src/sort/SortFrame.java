package sort;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Rectangle;
import stack.RectangleDialog;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;

public class SortFrame extends JFrame {

	private JPanel contentPane;
	private DefaultListModel<Rectangle> model = new DefaultListModel<Rectangle>();
	private ArrayList<Rectangle> sortList = new ArrayList<Rectangle>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SortFrame frame = new SortFrame();
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
	public SortFrame() {
		setTitle("IM 43-2016 Batinica Una");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 250, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelSouth = new JPanel();
		panelSouth.setBackground(new Color(255, 182, 193));
		contentPane.add(panelSouth, BorderLayout.SOUTH);
		
		JButton btnAddRectangle = new JButton("Add rectangle");
		btnAddRectangle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RectangleDialogSort rectangleDialogSort = new RectangleDialogSort();
				rectangleDialogSort.setVisible(true);
				if(rectangleDialogSort.isSuccess()) {
					Rectangle rectangle = rectangleDialogSort.getRectangle();
					model.addElement(rectangle);
					sortList.add(rectangle);
				}
			}
		});
		panelSouth.add(btnAddRectangle);
		
		JButton btnSortRectangle = new JButton("Sort rectangle");
		btnSortRectangle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(model.size() == 0) {
					JOptionPane.showMessageDialog(btnSortRectangle, "You do not have any rectangle. Please add new rectangle");
				}
				else {
					Rectangle tempRectangle;
					model.removeAllElements();
					for(int i = 0; i < sortList.size(); i++) {
						for(int j = 0; j < sortList.size() - i - 1; j++) {
							if(sortList.get(j).area() > sortList.get(j+1).area()) {
								tempRectangle = sortList.get(j);
								sortList.set(j, sortList.get(j+1));
								sortList.set(j+1, tempRectangle);
							}
						}
					}
					for(int i = 0; i < sortList.size(); i++) {
						model.addElement(sortList.get(i));
					}
				}
			}
		});
		panelSouth.add(btnSortRectangle);
		
		JPanel panelCenter = new JPanel();
		contentPane.add(panelCenter, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		panelCenter.add(scrollPane);
		
		JList list = new JList();
		list.setModel(model);
		scrollPane.setPreferredSize(new Dimension(380, 190));
		scrollPane.setViewportView(list);
		
		JPanel panelNorth = new JPanel();
		contentPane.add(panelNorth, BorderLayout.NORTH);
		
		JLabel lblSort = new JLabel("Sort");
		lblSort.setHorizontalAlignment(SwingConstants.LEFT);
		panelNorth.add(lblSort);
	}

}
