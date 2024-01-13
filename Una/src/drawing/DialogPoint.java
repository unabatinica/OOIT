package drawing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
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
import javax.swing.JColorChooser;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Font;

public class DialogPoint extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textX;
	private JTextField textY;
	private JButton btnOuterColor;
	private boolean success;

	
	public static void main(String[] args) {
		try {
			DialogPoint dialog = new DialogPoint();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public DialogPoint() {
		setTitle("Dialog Point");
		setBounds(100, 100, 450, 300);
		setModal(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(250, 250, 210));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblX = new JLabel("x coordinate : ");
			lblX.setFont(new Font("Century Gothic", Font.BOLD, 12));
			lblX.setForeground(new Color(85, 107, 47));
			GridBagConstraints gbc_lblX = new GridBagConstraints();
			gbc_lblX.anchor = GridBagConstraints.WEST;
			gbc_lblX.insets = new Insets(0, 0, 5, 5);
			gbc_lblX.gridx = 2;
			gbc_lblX.gridy = 1;
			contentPanel.add(lblX, gbc_lblX);
		}
		{
			textX = new JTextField();
			textX.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					if (textX.getText().length() >= 4 ) 
			            e.consume();
				}
			});
			GridBagConstraints gbc_textX = new GridBagConstraints();
			gbc_textX.anchor = GridBagConstraints.WEST;
			gbc_textX.insets = new Insets(0, 0, 5, 0);
			gbc_textX.gridx = 3;
			gbc_textX.gridy = 1;
			contentPanel.add(textX, gbc_textX);
			textX.setColumns(10);
		}
		{
			JLabel lblY = new JLabel("y coordinate : ");
			lblY.setForeground(new Color(85, 107, 47));
			lblY.setFont(new Font("Century Gothic", Font.BOLD, 12));
			GridBagConstraints gbc_lblY = new GridBagConstraints();
			gbc_lblY.anchor = GridBagConstraints.WEST;
			gbc_lblY.insets = new Insets(0, 0, 5, 5);
			gbc_lblY.gridx = 2;
			gbc_lblY.gridy = 2;
			contentPanel.add(lblY, gbc_lblY);
		}
		{
			textY = new JTextField();
			textY.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					if (textY.getText().length() >= 3 ) 
			            e.consume();
				}
			});
			GridBagConstraints gbc_textY = new GridBagConstraints();
			gbc_textY.insets = new Insets(0, 0, 5, 0);
			gbc_textY.anchor = GridBagConstraints.NORTHWEST;
			gbc_textY.gridx = 3;
			gbc_textY.gridy = 2;
			contentPanel.add(textY, gbc_textY);
			textY.setColumns(10);
		}
		{
			JLabel lblOuterColor = new JLabel("Color");
			lblOuterColor.setFont(new Font("Century Gothic", Font.BOLD, 12));
			lblOuterColor.setForeground(new Color(85, 107, 47));
			GridBagConstraints gbc_lblOuterColor = new GridBagConstraints();
			gbc_lblOuterColor.insets = new Insets(0, 0, 0, 5);
			gbc_lblOuterColor.gridx = 2;
			gbc_lblOuterColor.gridy = 4;
			contentPanel.add(lblOuterColor, gbc_lblOuterColor);
		}
		{
			btnOuterColor = new JButton("Color");
			btnOuterColor.setFont(new Font("Century Gothic", Font.BOLD, 12));
			btnOuterColor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Color outerColor = JColorChooser.showDialog(btnOuterColor, "Choose your color", btnOuterColor.getBackground());
					if (outerColor != null) {
						btnOuterColor.setBackground(outerColor);
					}
				}
			});
			GridBagConstraints gbc_btnOuterColor = new GridBagConstraints();
			gbc_btnOuterColor.anchor = GridBagConstraints.WEST;
			gbc_btnOuterColor.gridx = 3;
			gbc_btnOuterColor.gridy = 4;
			contentPanel.add(btnOuterColor, gbc_btnOuterColor);
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
							if (textX.getText().isEmpty() || textY.getText().isEmpty()) {
								JOptionPane.showMessageDialog(okButton, "Please insert all fields");
							}
							else if (Integer.parseInt(textX.getText()) < 0 ||
									 Integer.parseInt(textX.getText()) > 1360) {
										
									JOptionPane.showMessageDialog(okButton, "Please insert a value of the x-coordinate 0 or greater than 0 and less than 1360");	
							}
							else if(Integer.parseInt(textY.getText()) < 0 ||
									Integer.parseInt(textY.getText()) > 755) {
								
									JOptionPane.showMessageDialog(okButton, "Please insert a value of the y-coordinate 0 or greater than 0 and less than 755");
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
				cancelButton.setFont(new Font("Century Gothic", Font.BOLD, 12));
				cancelButton.setBackground(new Color(250, 250, 210));
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

	public JTextField getTextX() {
		return textX;
	}

	public void setTextX(JTextField textX) {
		this.textX = textX;
	}

	public JTextField getTextY() {
		return textY;
	}

	public void setTextY(JTextField textY) {
		this.textY = textY;
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
