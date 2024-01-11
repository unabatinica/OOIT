package drawing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DialogLine extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textXStartPoint;
	private JTextField textYStartPoint;
	private JTextField textXEndPoint;
	private JTextField textYEndPoint;
	private JButton btnOuterColor;
	private boolean success;

	
	public static void main(String[] args) {
		try {
			DialogLine dialog = new DialogLine();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public DialogLine() {
		setTitle("Dialog Line");
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblXStartPoint = new JLabel("x coordinate start point");
			GridBagConstraints gbc_lblXStartPoint = new GridBagConstraints();
			gbc_lblXStartPoint.anchor = GridBagConstraints.WEST;
			gbc_lblXStartPoint.insets = new Insets(0, 0, 5, 5);
			gbc_lblXStartPoint.gridx = 2;
			gbc_lblXStartPoint.gridy = 1;
			contentPanel.add(lblXStartPoint, gbc_lblXStartPoint);
		}
		{
			textXStartPoint = new JTextField();
			GridBagConstraints gbc_textXStartPoint = new GridBagConstraints();
			gbc_textXStartPoint.anchor = GridBagConstraints.WEST;
			gbc_textXStartPoint.insets = new Insets(0, 0, 5, 0);
			gbc_textXStartPoint.gridx = 3;
			gbc_textXStartPoint.gridy = 1;
			contentPanel.add(textXStartPoint, gbc_textXStartPoint);
			textXStartPoint.setColumns(10);
		}
		{
			JLabel lblYStartPoint = new JLabel("y coordinate start point ");
			GridBagConstraints gbc_lblYStartPoint = new GridBagConstraints();
			gbc_lblYStartPoint.anchor = GridBagConstraints.WEST;
			gbc_lblYStartPoint.insets = new Insets(0, 0, 5, 5);
			gbc_lblYStartPoint.gridx = 2;
			gbc_lblYStartPoint.gridy = 2;
			contentPanel.add(lblYStartPoint, gbc_lblYStartPoint);
		}
		{
			textYStartPoint = new JTextField();
			GridBagConstraints gbc_textYStartPoint = new GridBagConstraints();
			gbc_textYStartPoint.anchor = GridBagConstraints.NORTHWEST;
			gbc_textYStartPoint.insets = new Insets(0, 0, 5, 0);
			gbc_textYStartPoint.gridx = 3;
			gbc_textYStartPoint.gridy = 2;
			contentPanel.add(textYStartPoint, gbc_textYStartPoint);
			textYStartPoint.setColumns(10);
		}
		{
			JLabel lblXEndPoint = new JLabel("x coordinate end point");
			GridBagConstraints gbc_lblXEndPoint = new GridBagConstraints();
			gbc_lblXEndPoint.anchor = GridBagConstraints.WEST;
			gbc_lblXEndPoint.insets = new Insets(0, 0, 5, 5);
			gbc_lblXEndPoint.gridx = 2;
			gbc_lblXEndPoint.gridy = 3;
			contentPanel.add(lblXEndPoint, gbc_lblXEndPoint);
		}
		{
			textXEndPoint = new JTextField();
			GridBagConstraints gbc_textXEndPoint = new GridBagConstraints();
			gbc_textXEndPoint.anchor = GridBagConstraints.WEST;
			gbc_textXEndPoint.insets = new Insets(0, 0, 5, 0);
			gbc_textXEndPoint.gridx = 3;
			gbc_textXEndPoint.gridy = 3;
			contentPanel.add(textXEndPoint, gbc_textXEndPoint);
			textXEndPoint.setColumns(10);
		}
		{
			JLabel lblYEndPoint = new JLabel("y coordinate end point");
			GridBagConstraints gbc_lblYEndPoint = new GridBagConstraints();
			gbc_lblYEndPoint.anchor = GridBagConstraints.WEST;
			gbc_lblYEndPoint.insets = new Insets(0, 0, 5, 5);
			gbc_lblYEndPoint.gridx = 2;
			gbc_lblYEndPoint.gridy = 4;
			contentPanel.add(lblYEndPoint, gbc_lblYEndPoint);
		}
		{
			textYEndPoint = new JTextField();
			GridBagConstraints gbc_textYEndPoint = new GridBagConstraints();
			gbc_textYEndPoint.insets = new Insets(0, 0, 5, 0);
			gbc_textYEndPoint.anchor = GridBagConstraints.NORTHWEST;
			gbc_textYEndPoint.gridx = 3;
			gbc_textYEndPoint.gridy = 4;
			contentPanel.add(textYEndPoint, gbc_textYEndPoint);
			textYEndPoint.setColumns(10);
		}
		{
			JLabel lblOuterColor = new JLabel("Outer color");
			GridBagConstraints gbc_lblOuterColor = new GridBagConstraints();
			gbc_lblOuterColor.anchor = GridBagConstraints.EAST;
			gbc_lblOuterColor.insets = new Insets(0, 0, 0, 5);
			gbc_lblOuterColor.gridx = 2;
			gbc_lblOuterColor.gridy = 6;
			contentPanel.add(lblOuterColor, gbc_lblOuterColor);
		}
		{
			btnOuterColor = new JButton("Outer color");
			btnOuterColor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Color outerColor = JColorChooser.showDialog(btnOuterColor, "Choose your outer color", btnOuterColor.getBackground());
					if (outerColor != null) {
						btnOuterColor.setBackground(outerColor);
					}
				}
			});
			GridBagConstraints gbc_btnOuterColor = new GridBagConstraints();
			gbc_btnOuterColor.anchor = GridBagConstraints.WEST;
			gbc_btnOuterColor.gridx = 3;
			gbc_btnOuterColor.gridy = 6;
			contentPanel.add(btnOuterColor, gbc_btnOuterColor);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							if (textXStartPoint.getText().isEmpty() ||
								textYStartPoint.getText().isEmpty() ||
								textXEndPoint.getText().isEmpty() || 
								textYEndPoint.getText().isEmpty()) {
								
								JOptionPane.showMessageDialog(okButton, "Please insert all fields");
							}
							else if (Integer.parseInt(textXStartPoint.getText()) <= 0 ||
									Integer.parseInt(textXStartPoint.getText()) > 810 ||
									Integer.parseInt(textXEndPoint.getText()) <= 0 ||
									Integer.parseInt(textXEndPoint.getText()) > 810) {
										
									JOptionPane.showMessageDialog(okButton, "Please insert a value of the x-coordinate greater than 0 and less than 810");
								
							}
							else if(Integer.parseInt(textYStartPoint.getText()) <= 0 ||
									Integer.parseInt(textYStartPoint.getText()) > 650 ||
									Integer.parseInt(textYEndPoint.getText()) <= 0 || 
									Integer.parseInt(textYEndPoint.getText()) > 650) {
								
								JOptionPane.showMessageDialog(okButton, "Please insert a value of the y-coordinate greater than 0 and less than 650");
								
							}
							else {
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
				JButton cancelButton = new JButton("Cancel");
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


	public JTextField getTextXStartPoint() {
		return textXStartPoint;
	}


	public void setTextXStartPoint(JTextField textXStartPoint) {
		this.textXStartPoint = textXStartPoint;
	}


	public JTextField getTextYStartPoint() {
		return textYStartPoint;
	}


	public void setTextYStartPoint(JTextField textYStartPoint) {
		this.textYStartPoint = textYStartPoint;
	}


	public JTextField getTextXEndPoint() {
		return textXEndPoint;
	}


	public void setTextXEndPoint(JTextField textXEndPoint) {
		this.textXEndPoint = textXEndPoint;
	}


	public JTextField getTextYEndPoint() {
		return textYEndPoint;
	}


	public void setTextYEndPoint(JTextField textYEndPoint) {
		this.textYEndPoint = textYEndPoint;
	}


	public boolean isSuccess() {
		return success;
	}


	public void setSuccess(boolean success) {
		this.success = success;
	}


	public JButton getBtnOuterColor() {
		return btnOuterColor;
	}


	public void setBtnOuterColor(JButton btnOuterColor) {
		this.btnOuterColor = btnOuterColor;
	}

}
