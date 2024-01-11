package sort;

import java.awt.BorderLayout;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import geometry.Point;
import geometry.Rectangle;

public class RectangleDialogSort extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textXUpperLeftPoint;
	private JTextField textYUpperLeftPoint;
	private JTextField textWidth;
	private JTextField textHeight;
	private boolean success;
	private Rectangle rectangle;
	private JButton okButton;
	private JButton cancelButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RectangleDialogSort dialog = new RectangleDialogSort();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RectangleDialogSort() {
		setTitle("Dialog Rectangle Sort");
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblXUpperLeftPoint = new JLabel("x coordinate upper left point");
			GridBagConstraints gbc_lblXUpperLeftPoint = new GridBagConstraints();
			gbc_lblXUpperLeftPoint.insets = new Insets(0, 0, 5, 5);
			gbc_lblXUpperLeftPoint.anchor = GridBagConstraints.EAST;
			gbc_lblXUpperLeftPoint.gridx = 2;
			gbc_lblXUpperLeftPoint.gridy = 1;
			contentPanel.add(lblXUpperLeftPoint, gbc_lblXUpperLeftPoint);
		}
		{
			textXUpperLeftPoint = new JTextField();
			GridBagConstraints gbc_textXUpperLeftPoint = new GridBagConstraints();
			gbc_textXUpperLeftPoint.anchor = GridBagConstraints.WEST;
			gbc_textXUpperLeftPoint.insets = new Insets(0, 0, 5, 0);
			gbc_textXUpperLeftPoint.gridx = 3;
			gbc_textXUpperLeftPoint.gridy = 1;
			contentPanel.add(textXUpperLeftPoint, gbc_textXUpperLeftPoint);
			textXUpperLeftPoint.setColumns(10);
		}
		{
			JLabel lblYUpperLeftPoint = new JLabel("y coordinate upper left point");
			GridBagConstraints gbc_lblYUpperLeftPoint = new GridBagConstraints();
			gbc_lblYUpperLeftPoint.anchor = GridBagConstraints.SOUTHEAST;
			gbc_lblYUpperLeftPoint.insets = new Insets(0, 0, 5, 5);
			gbc_lblYUpperLeftPoint.gridx = 2;
			gbc_lblYUpperLeftPoint.gridy = 2;
			contentPanel.add(lblYUpperLeftPoint, gbc_lblYUpperLeftPoint);
		}
		{
			textYUpperLeftPoint = new JTextField();
			GridBagConstraints gbc_textYUpperLeftPoint = new GridBagConstraints();
			gbc_textYUpperLeftPoint.anchor = GridBagConstraints.WEST;
			gbc_textYUpperLeftPoint.insets = new Insets(0, 0, 5, 0);
			gbc_textYUpperLeftPoint.gridx = 3;
			gbc_textYUpperLeftPoint.gridy = 2;
			contentPanel.add(textYUpperLeftPoint, gbc_textYUpperLeftPoint);
			textYUpperLeftPoint.setColumns(10);
		}
		{
			JLabel lblWidth = new JLabel("Width");
			GridBagConstraints gbc_lblWidth = new GridBagConstraints();
			gbc_lblWidth.insets = new Insets(0, 0, 5, 5);
			gbc_lblWidth.gridx = 2;
			gbc_lblWidth.gridy = 3;
			contentPanel.add(lblWidth, gbc_lblWidth);
		}
		{
			textWidth = new JTextField();
			GridBagConstraints gbc_textWidth = new GridBagConstraints();
			gbc_textWidth.anchor = GridBagConstraints.WEST;
			gbc_textWidth.insets = new Insets(0, 0, 5, 0);
			gbc_textWidth.gridx = 3;
			gbc_textWidth.gridy = 3;
			contentPanel.add(textWidth, gbc_textWidth);
			textWidth.setColumns(10);
		}
		{
			JLabel lblHeight = new JLabel("Height");
			GridBagConstraints gbc_lblHeight = new GridBagConstraints();
			gbc_lblHeight.insets = new Insets(0, 0, 5, 5);
			gbc_lblHeight.gridx = 2;
			gbc_lblHeight.gridy = 4;
			contentPanel.add(lblHeight, gbc_lblHeight);
		}
		{
			textHeight = new JTextField();
			GridBagConstraints gbc_textHeight = new GridBagConstraints();
			gbc_textHeight.anchor = GridBagConstraints.WEST;
			gbc_textHeight.insets = new Insets(0, 0, 5, 0);
			gbc_textHeight.gridx = 3;
			gbc_textHeight.gridy = 4;
			contentPanel.add(textHeight, gbc_textHeight);
			textHeight.setColumns(10);
		}
		
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							if (textXUpperLeftPoint.getText().isEmpty() ||
								textYUpperLeftPoint.getText().isEmpty() ||
								textWidth.getText().isEmpty() ||
								textHeight.getText().isEmpty()) {
								
								JOptionPane.showMessageDialog(okButton, "Please insert all fields");
							}
							else if(Integer.parseInt(textWidth.getText()) <= 0 ||
									Integer.parseInt(textHeight.getText()) <= 0) {
								
								    JOptionPane.showMessageDialog(okButton, "Please insert width and height values greater than 0");
								
							}
							else {
								int x = Integer.parseInt(textXUpperLeftPoint.getText());
								int y = Integer.parseInt(textYUpperLeftPoint.getText());
								int height = Integer.parseInt(textHeight.getText());
								int width = Integer.parseInt(textWidth.getText());
								Point upperLeftPoint = new Point(x,y);
								rectangle = new Rectangle(upperLeftPoint,width,height);
								
								success = true;
								dispose();
							}
						
						} catch (Exception exception) {
							JOptionPane.showMessageDialog(okButton, "It is not possible to enter letters", "Error", JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						success = false;
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public JTextField getTextXUpperLeftPoint() {
		return textXUpperLeftPoint;
	}

	public void setTextXUpperLeftPoint(JTextField textXUpperLeftPoint) {
		this.textXUpperLeftPoint = textXUpperLeftPoint;
	}

	public JTextField getTextYUpperLeftPoint() {
		return textYUpperLeftPoint;
	}

	public void setTextYUpperLeftPoint(JTextField textYUpperLeftPoint) {
		this.textYUpperLeftPoint = textYUpperLeftPoint;
	}

	public JTextField getTextWidth() {
		return textWidth;
	}

	public void setTextWidth(JTextField textWidth) {
		this.textWidth = textWidth;
	}

	public JTextField getTextHeight() {
		return textHeight;
	}

	public void setTextHeight(JTextField textHeight) {
		this.textHeight = textHeight;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Rectangle getRectangle() {
		return rectangle;
	}

	public void setRectangle(Rectangle rectangle) {
		this.rectangle = rectangle;
	}

	public JButton getOkButton() {
		return okButton;
	}

	public void setOkButton(JButton okButton) {
		this.okButton = okButton;
	}

	public JButton getCancelButton() {
		return cancelButton;
	}

	public void setCancelButton(JButton cancelButton) {
		this.cancelButton = cancelButton;
	}

}
