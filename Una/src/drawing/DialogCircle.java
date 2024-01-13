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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Font;

public class DialogCircle extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textXCenter;
	private JTextField textRadius;
	private JTextField textYCenter;
	private JButton btnOuterColor;
	private JButton btnInnerColor;
	private boolean succes;

	public static void main(String[] args) {
		try {
			DialogCircle dialog = new DialogCircle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public DialogCircle() {
		getContentPane().setBackground(new Color(250, 250, 210));
		setTitle("Dialog Circle");
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(250, 250, 210));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblXCenter = new JLabel("Center X :");
			lblXCenter.setForeground(new Color(85, 107, 47));
			lblXCenter.setFont(new Font("Century Gothic", Font.BOLD, 12));
			lblXCenter.setBackground(new Color(255, 255, 255));
			GridBagConstraints gbc_lblXCenter = new GridBagConstraints();
			gbc_lblXCenter.anchor = GridBagConstraints.EAST;
			gbc_lblXCenter.insets = new Insets(0, 0, 5, 5);
			gbc_lblXCenter.gridx = 2;
			gbc_lblXCenter.gridy = 1;
			contentPanel.add(lblXCenter, gbc_lblXCenter);
		}
		{
			textXCenter = new JTextField();
			textXCenter.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					if (textXCenter.getText().length() >= 4 ) 
			            e.consume();
				}
			});
			GridBagConstraints gbc_textXCenter = new GridBagConstraints();
			gbc_textXCenter.anchor = GridBagConstraints.WEST;
			gbc_textXCenter.insets = new Insets(0, 0, 5, 0);
			gbc_textXCenter.gridx = 3;
			gbc_textXCenter.gridy = 1;
			contentPanel.add(textXCenter, gbc_textXCenter);
			textXCenter.setColumns(10);
		}
		{
			JLabel lblYCenter = new JLabel("Center Y :");
			lblYCenter.setForeground(new Color(85, 107, 47));
			lblYCenter.setFont(new Font("Century Gothic", Font.BOLD, 12));
			GridBagConstraints gbc_lblYCenter = new GridBagConstraints();
			gbc_lblYCenter.anchor = GridBagConstraints.EAST;
			gbc_lblYCenter.insets = new Insets(0, 0, 5, 5);
			gbc_lblYCenter.gridx = 2;
			gbc_lblYCenter.gridy = 2;
			contentPanel.add(lblYCenter, gbc_lblYCenter);
		}
		{
			textYCenter = new JTextField();
			textYCenter.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					if (textYCenter.getText().length() >= 3 ) 
			            e.consume();
				}
			});
			GridBagConstraints gbc_textYCenter = new GridBagConstraints();
			gbc_textYCenter.anchor = GridBagConstraints.WEST;
			gbc_textYCenter.insets = new Insets(0, 0, 5, 0);
			gbc_textYCenter.gridx = 3;
			gbc_textYCenter.gridy = 2;
			contentPanel.add(textYCenter, gbc_textYCenter);
			textYCenter.setColumns(10);
		}
		{
			JLabel lblRadius = new JLabel("Radius :");
			lblRadius.setForeground(new Color(85, 107, 47));
			lblRadius.setFont(new Font("Century Gothic", Font.BOLD, 12));
			GridBagConstraints gbc_lblRadius = new GridBagConstraints();
			gbc_lblRadius.anchor = GridBagConstraints.EAST;
			gbc_lblRadius.insets = new Insets(0, 0, 5, 5);
			gbc_lblRadius.gridx = 2;
			gbc_lblRadius.gridy = 3;
			contentPanel.add(lblRadius, gbc_lblRadius);
		}
		{
			textRadius = new JTextField();
			textRadius.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					if (textRadius.getText().length() >= 3 ) 
			            e.consume();
				}
			});
			GridBagConstraints gbc_textRadius = new GridBagConstraints();
			gbc_textRadius.anchor = GridBagConstraints.WEST;
			gbc_textRadius.insets = new Insets(0, 0, 5, 0);
			gbc_textRadius.gridx = 3;
			gbc_textRadius.gridy = 3;
			contentPanel.add(textRadius, gbc_textRadius);
			textRadius.setColumns(10);
		}
		{
			JLabel lblOuterColor = new JLabel("Line color");
			lblOuterColor.setForeground(new Color(85, 107, 47));
			lblOuterColor.setFont(new Font("Century Gothic", Font.BOLD, 12));
			GridBagConstraints gbc_lblOuterColor = new GridBagConstraints();
			gbc_lblOuterColor.insets = new Insets(0, 0, 5, 5);
			gbc_lblOuterColor.gridx = 2;
			gbc_lblOuterColor.gridy = 5;
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
			gbc_btnOuterColor.insets = new Insets(0, 0 
					, 5, 0);
			gbc_btnOuterColor.anchor = GridBagConstraints.WEST;
			gbc_btnOuterColor.gridx = 3;
			gbc_btnOuterColor.gridy = 5;
			contentPanel.add(btnOuterColor, gbc_btnOuterColor);
		}
		{
			JLabel lblInnerColor = new JLabel("Inner color");
			lblInnerColor.setFont(new Font("Century Gothic", Font.BOLD, 12));
			lblInnerColor.setForeground(new Color(85, 107, 47));
			GridBagConstraints gbc_lblInnerColor = new GridBagConstraints();
			gbc_lblInnerColor.insets = new Insets(0, 0, 0, 5);
			gbc_lblInnerColor.gridx = 2;
			gbc_lblInnerColor.gridy = 6;
			contentPanel.add(lblInnerColor, gbc_lblInnerColor);
		}
		{
			btnInnerColor = new JButton("Inner color");
			btnInnerColor.setFont(new Font("Century Gothic", Font.BOLD, 12));
			btnInnerColor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Color innerColor = JColorChooser.showDialog(btnInnerColor, "Choose your inner color", btnInnerColor.getBackground());
					if (innerColor != null) {
						btnInnerColor.setBackground(innerColor);
					}
					
				}
			});
			GridBagConstraints gbc_btnInnerColor = new GridBagConstraints();
			gbc_btnInnerColor.anchor = GridBagConstraints.WEST;
			gbc_btnInnerColor.gridx = 3;
			gbc_btnInnerColor.gridy = 6;
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
				okButton.setBackground(new Color(250, 250, 210));
				okButton.setFont(new Font("Century Gothic", Font.BOLD, 12));
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							if (textXCenter.getText().isEmpty() || textYCenter.getText().isEmpty() || textRadius.getText().isEmpty() ) {
								
								JOptionPane.showMessageDialog(okButton, "Please insert all fields");
							}
							else if(Integer.parseInt(textXCenter.getText()) < 0 ||
									Integer.parseInt(textXCenter.getText()) > 1360) {
								
								JOptionPane.showMessageDialog(okButton, "Please insert a value of the x-coordinate of the center 0 or greater than 0 and less than 1360");
							}
							else if(
									Integer.parseInt(textYCenter.getText()) < 0 ||
									Integer.parseInt(textYCenter.getText()) > 755){
								
								JOptionPane.showMessageDialog(okButton, "Please insert a value of the y-coordinate of the center 0 or greater than 0 and less than 755");
								
							}
							else if(Integer.parseInt(textRadius.getText().toString()) <= 0 ||
									Integer.parseInt(textRadius.getText().toString()) > 500
									) {
								
								JOptionPane.showMessageDialog(okButton, "Please insert a radius value greater than 0 and less than 500");
							}
							else {
								succes = true;
								dispose();
							}
						} catch(Exception exception ){
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
				cancelButton.setForeground(new Color(85, 107, 47));
				cancelButton.setFont(new Font("Century Gothic", Font.BOLD, 12));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							succes=false;
							dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}


	public JTextField getTextXCenter() {
		return textXCenter;
	}


	public void setTextXCenter(JTextField textXCenter) {
		this.textXCenter = textXCenter;
	}


	public JTextField getTextYCenter() {
		return textYCenter;
	}


	public void setTextYCenter(JTextField textYCenter) {
		this.textYCenter = textYCenter;
	}


	public JTextField getTextRadius() {
		return textRadius;
	}


	public void setTextRadius(JTextField textRadius) {
		this.textRadius = textRadius;
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


	public boolean isSucces() {
		return succes;
	}


	public void setSucces(boolean succes) {
		this.succes = succes;
	}
	
	
	
}
