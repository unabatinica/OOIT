
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
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Font;

public class DialogRectangle extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textXUpperLeftPoint;
	private JTextField textYUpperLeftPoint;
	private JTextField textWidth;
	private JTextField textHeight;
	private JButton btnOuterColor;
	private JButton btnInnerColor;
	private boolean success;
	

	
	public static void main(String[] args) {
		try {
			DialogRectangle dialog = new DialogRectangle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public DialogRectangle() {
		setTitle("Dialog Rectangle");
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(250, 250, 210));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblXUpperLeftPoint = new JLabel("x coordinate upper left point : ");
			lblXUpperLeftPoint.setFont(new Font("Century Gothic", Font.BOLD, 12));
			lblXUpperLeftPoint.setForeground(new Color(85, 107, 47));
			GridBagConstraints gbc_lblXUpperLeftPoint = new GridBagConstraints();
			gbc_lblXUpperLeftPoint.insets = new Insets(0, 0, 5, 5);
			gbc_lblXUpperLeftPoint.anchor = GridBagConstraints.EAST;
			gbc_lblXUpperLeftPoint.gridx = 2;
			gbc_lblXUpperLeftPoint.gridy = 1;
			contentPanel.add(lblXUpperLeftPoint, gbc_lblXUpperLeftPoint);
		}
		{
			textXUpperLeftPoint = new JTextField();
			textXUpperLeftPoint.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					if (textXUpperLeftPoint.getText().length() >= 4 ) 
			            e.consume();
				}
			});
			GridBagConstraints gbc_textXUpperLeftPoint = new GridBagConstraints();
			gbc_textXUpperLeftPoint.anchor = GridBagConstraints.WEST;
			gbc_textXUpperLeftPoint.insets = new Insets(0, 0, 5, 0);
			gbc_textXUpperLeftPoint.gridx = 3;
			gbc_textXUpperLeftPoint.gridy = 1;
			contentPanel.add(textXUpperLeftPoint, gbc_textXUpperLeftPoint);
			textXUpperLeftPoint.setColumns(10);
		}
		{
			JLabel lblYUpperLeftPoint = new JLabel("y coordinate upper left point : ");
			lblYUpperLeftPoint.setForeground(new Color(85, 107, 47));
			lblYUpperLeftPoint.setFont(new Font("Century Gothic", Font.BOLD, 12));
			GridBagConstraints gbc_lblYUpperLeftPoint = new GridBagConstraints();
			gbc_lblYUpperLeftPoint.anchor = GridBagConstraints.SOUTHEAST;
			gbc_lblYUpperLeftPoint.insets = new Insets(0, 0, 5, 5);
			gbc_lblYUpperLeftPoint.gridx = 2;
			gbc_lblYUpperLeftPoint.gridy = 2;
			contentPanel.add(lblYUpperLeftPoint, gbc_lblYUpperLeftPoint);
		}
		{
			textYUpperLeftPoint = new JTextField();
			textYUpperLeftPoint.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					if (textYUpperLeftPoint.getText().length() >= 3 ) 
			            e.consume();
				}
			});
			GridBagConstraints gbc_textYUpperLeftPoint = new GridBagConstraints();
			gbc_textYUpperLeftPoint.anchor = GridBagConstraints.WEST;
			gbc_textYUpperLeftPoint.insets = new Insets(0, 0, 5, 0);
			gbc_textYUpperLeftPoint.gridx = 3;
			gbc_textYUpperLeftPoint.gridy = 2;
			contentPanel.add(textYUpperLeftPoint, gbc_textYUpperLeftPoint);
			textYUpperLeftPoint.setColumns(10);
		}
		{
			JLabel lblWidth = new JLabel("Width : ");
			lblWidth.setForeground(new Color(85, 107, 47));
			lblWidth.setFont(new Font("Century Gothic", Font.BOLD, 12));
			GridBagConstraints gbc_lblWidth = new GridBagConstraints();
			gbc_lblWidth.anchor = GridBagConstraints.EAST;
			gbc_lblWidth.insets = new Insets(0, 0, 5, 5);
			gbc_lblWidth.gridx = 2;
			gbc_lblWidth.gridy = 3;
			contentPanel.add(lblWidth, gbc_lblWidth);
		}
		{
			textWidth = new JTextField();
			textWidth.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					if (textWidth.getText().length() >= 4 ) 
			            e.consume();
				}
			});
			GridBagConstraints gbc_textWidth = new GridBagConstraints();
			gbc_textWidth.anchor = GridBagConstraints.WEST;
			gbc_textWidth.insets = new Insets(0, 0, 5, 0);
			gbc_textWidth.gridx = 3;
			gbc_textWidth.gridy = 3;
			contentPanel.add(textWidth, gbc_textWidth);
			textWidth.setColumns(10);
		}
		{
			JLabel lblHeight = new JLabel("Height : ");
			lblHeight.setForeground(new Color(85, 107, 47));
			lblHeight.setFont(new Font("Century Gothic", Font.BOLD, 12));
			GridBagConstraints gbc_lblHeight = new GridBagConstraints();
			gbc_lblHeight.anchor = GridBagConstraints.EAST;
			gbc_lblHeight.insets = new Insets(0, 0, 5, 5);
			gbc_lblHeight.gridx = 2;
			gbc_lblHeight.gridy = 4;
			contentPanel.add(lblHeight, gbc_lblHeight);
		}
		{
			textHeight = new JTextField();
			textHeight.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					if (textHeight.getText().length() >= 3 ) 
			            e.consume();
				}
			});
			GridBagConstraints gbc_textHeight = new GridBagConstraints();
			gbc_textHeight.anchor = GridBagConstraints.WEST;
			gbc_textHeight.insets = new Insets(0, 0, 5, 0);
			gbc_textHeight.gridx = 3;
			gbc_textHeight.gridy = 4;
			contentPanel.add(textHeight, gbc_textHeight);
			textHeight.setColumns(10);
		}
		{
			JLabel lblOuterColor = new JLabel("Line color");
			lblOuterColor.setForeground(new Color(85, 107, 47));
			lblOuterColor.setFont(new Font("Century Gothic", Font.BOLD, 12));
			GridBagConstraints gbc_lblOuterColor = new GridBagConstraints();
			gbc_lblOuterColor.insets = new Insets(0, 0, 5, 5);
			gbc_lblOuterColor.gridx = 2;
			gbc_lblOuterColor.gridy = 6;
			contentPanel.add(lblOuterColor, gbc_lblOuterColor);
		}
		{
			btnOuterColor = new JButton("Line color");
			btnOuterColor.setFont(new Font("Century Gothic", Font.BOLD, 12));
			btnOuterColor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Color outerColor = JColorChooser.showDialog(btnOuterColor, "Choose your line color", btnOuterColor.getBackground());
					if (outerColor != null) {
						btnOuterColor.setBackground(outerColor);
					}
				}
			});
			
			GridBagConstraints gbc_btnOuterColor = new GridBagConstraints();
			gbc_btnOuterColor.anchor = GridBagConstraints.WEST;
			gbc_btnOuterColor.insets = new Insets(0, 0, 5, 0);
			gbc_btnOuterColor.gridx = 3;
			gbc_btnOuterColor.gridy = 6;
			contentPanel.add(btnOuterColor, gbc_btnOuterColor);
		}
		{
			JLabel lblInnerColor = new JLabel("Inner color");
			lblInnerColor.setForeground(new Color(85, 107, 47));
			lblInnerColor.setFont(new Font("Century Gothic", Font.BOLD, 12));
			GridBagConstraints gbc_lblInnerColor = new GridBagConstraints();
			gbc_lblInnerColor.insets = new Insets(0, 0, 0, 5);
			gbc_lblInnerColor.gridx = 2;
			gbc_lblInnerColor.gridy = 7;
			contentPanel.add(lblInnerColor, gbc_lblInnerColor);
		}
		{
			btnInnerColor = new JButton("Inner color");
			btnInnerColor.setFont(new Font("Century Gothic", Font.BOLD, 12));
			btnInnerColor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Color innerColor = JColorChooser.showDialog(btnInnerColor, "Choose your outer color", btnInnerColor.getBackground());
					if (innerColor != null) {
						btnInnerColor.setBackground(innerColor);
					}
				}
			});
			GridBagConstraints gbc_btnInnerColor = new GridBagConstraints();
			gbc_btnInnerColor.anchor = GridBagConstraints.SOUTHWEST;
			gbc_btnInnerColor.gridx = 3;
			gbc_btnInnerColor.gridy = 7;
			contentPanel.add(btnInnerColor, gbc_btnInnerColor);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(85, 107, 47));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setForeground(new Color(85, 107, 47));
				okButton.setFont(new Font("Century Gothic", Font.BOLD, 12));
				okButton.setBackground(new Color(250, 250, 210));
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						try {
							if (textXUpperLeftPoint.getText().isEmpty() ||
								textYUpperLeftPoint.getText().isEmpty() ||
								textWidth.getText().isEmpty() ||
								textHeight.getText().isEmpty()) {
								
								JOptionPane.showMessageDialog(okButton, "Please insert all fields");
							}
							else if (Integer.parseInt(textXUpperLeftPoint.getText()) < 0 ||
									Integer.parseInt(textXUpperLeftPoint.getText()) > 1360) {
										
								JOptionPane.showMessageDialog(okButton, "Please insert a value of the x-coordinate of the upper left point 0 or greater than 0 and less than 1360");
								
							}
							else if(Integer.parseInt(textYUpperLeftPoint.getText()) < 0 ||
									Integer.parseInt(textYUpperLeftPoint.getText()) > 755) {
								
								JOptionPane.showMessageDialog(okButton, "Please insert a value of the y-coordinate of the upper left point 0 or greater than 0 and less than 755");
								
							}
							else if(Integer.parseInt(textWidth.getText()) <= 0 ||
									Integer.parseInt(textWidth.getText()) > 1200) {
								
								JOptionPane.showMessageDialog(okButton, "Please insert width value greater than 0 and less than 1200");
								
							}
							else if(Integer.parseInt(textHeight.getText()) <= 0 ||
									Integer.parseInt(textHeight.getText()) > 900) {
								
								JOptionPane.showMessageDialog(okButton, "Please insert height value greater than 0 and less than 900");
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
				cancelButton.setBackground(new Color(250, 250, 210));
				cancelButton.setFont(new Font("Century Gothic", Font.BOLD, 12));
				cancelButton.setForeground(new Color(85, 107, 47));
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


	public boolean isSuccess() {
		return success;
	}


	public void setSuccess(boolean success) {
		this.success = success;
	}

	
	
	

}
