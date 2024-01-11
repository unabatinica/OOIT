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

public class DialogDonut extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textInnerRadius;
	private JTextField textOuterRadius;
	private JTextField textXCenter;
	private JTextField textYCenter;
	private JButton btnOuterColor;
	private JButton btnInnerColor;
	private boolean succes;

	public static void main(String[] args) {
		try {
			DialogDonut dialog = new DialogDonut();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public DialogDonut() {
		setTitle("Dialog Donut");
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
			JLabel lblXCenter = new JLabel("Center X :");
			GridBagConstraints gbc_lblXCenter = new GridBagConstraints();
			gbc_lblXCenter.anchor = GridBagConstraints.EAST;
			gbc_lblXCenter.insets = new Insets(0, 0, 5, 5);
			gbc_lblXCenter.gridx = 2;
			gbc_lblXCenter.gridy = 1;
			contentPanel.add(lblXCenter, gbc_lblXCenter);
		}
		{
			textXCenter = new JTextField();
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
			GridBagConstraints gbc_lblYCenter = new GridBagConstraints();
			gbc_lblYCenter.anchor = GridBagConstraints.EAST;
			gbc_lblYCenter.insets = new Insets(0, 0, 5, 5);
			gbc_lblYCenter.gridx = 2;
			gbc_lblYCenter.gridy = 2;
			contentPanel.add(lblYCenter, gbc_lblYCenter);
		}
		{
			textYCenter = new JTextField();
			GridBagConstraints gbc_textYCenter = new GridBagConstraints();
			gbc_textYCenter.anchor = GridBagConstraints.WEST;
			gbc_textYCenter.insets = new Insets(0, 0, 5, 0);
			gbc_textYCenter.gridx = 3;
			gbc_textYCenter.gridy = 2;
			contentPanel.add(textYCenter, gbc_textYCenter);
			textYCenter.setColumns(10);
		}
		{
			JLabel lblOuterRadius = new JLabel("Outer Radius :");
			GridBagConstraints gbc_lblOuterRadius = new GridBagConstraints();
			gbc_lblOuterRadius.anchor = GridBagConstraints.EAST;
			gbc_lblOuterRadius.insets = new Insets(0, 0, 5, 5);
			gbc_lblOuterRadius.gridx = 2;
			gbc_lblOuterRadius.gridy = 3;
			contentPanel.add(lblOuterRadius, gbc_lblOuterRadius);
		}
		{
			textOuterRadius = new JTextField();
			GridBagConstraints gbc_textOuterRadius = new GridBagConstraints();
			gbc_textOuterRadius.anchor = GridBagConstraints.WEST;
			gbc_textOuterRadius.insets = new Insets(0, 0, 5, 0);
			gbc_textOuterRadius.gridx = 3;
			gbc_textOuterRadius.gridy = 3;
			contentPanel.add(textOuterRadius, gbc_textOuterRadius);
			textOuterRadius.setColumns(10);
		}
		{
			JLabel lblInnerRadius = new JLabel("Inner Radius :");
			GridBagConstraints gbc_lblInnerRadius = new GridBagConstraints();
			gbc_lblInnerRadius.insets = new Insets(0, 0, 5, 5);
			gbc_lblInnerRadius.anchor = GridBagConstraints.EAST;
			gbc_lblInnerRadius.gridx = 2;
			gbc_lblInnerRadius.gridy = 4;
			contentPanel.add(lblInnerRadius, gbc_lblInnerRadius);
		}
		{
			textInnerRadius = new JTextField();
			GridBagConstraints gbc_textInnerRadius = new GridBagConstraints();
			gbc_textInnerRadius.anchor = GridBagConstraints.WEST;
			gbc_textInnerRadius.insets = new Insets(0, 0, 5, 0);
			gbc_textInnerRadius.gridx = 3;
			gbc_textInnerRadius.gridy = 4;
			contentPanel.add(textInnerRadius, gbc_textInnerRadius);
			textInnerRadius.setColumns(10);
		}
		{
			JLabel lblOuterColor = new JLabel("Outer color");
			GridBagConstraints gbc_lblOuterColor = new GridBagConstraints();
			gbc_lblOuterColor.insets = new Insets(0, 0, 5, 5);
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
			gbc_btnOuterColor.insets = new Insets(0, 0, 5, 0);
			gbc_btnOuterColor.gridx = 3;
			gbc_btnOuterColor.gridy = 6;
			contentPanel.add(btnOuterColor, gbc_btnOuterColor);
		}
		{
			JLabel lblInnerColor = new JLabel("Inner color");
			GridBagConstraints gbc_lblInnerColor = new GridBagConstraints();
			gbc_lblInnerColor.insets = new Insets(0, 0, 0, 5);
			gbc_lblInnerColor.gridx = 2;
			gbc_lblInnerColor.gridy = 7;
			contentPanel.add(lblInnerColor, gbc_lblInnerColor);
		}
		{
			btnInnerColor = new JButton("Inner color");
			btnInnerColor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Color innerColor = JColorChooser.showDialog(btnInnerColor, "Choose your color", btnInnerColor.getBackground());
					if (innerColor !=null) {
						btnInnerColor.setBackground(innerColor);
					}
				}
			});
			GridBagConstraints gbc_btnInnerColor = new GridBagConstraints();
			gbc_btnInnerColor.anchor = GridBagConstraints.WEST;
			gbc_btnInnerColor.gridx = 3;
			gbc_btnInnerColor.gridy = 7;
			contentPanel.add(btnInnerColor, gbc_btnInnerColor);
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
							if (textXCenter.getText().isEmpty() || textYCenter.getText().isEmpty() ||
								textOuterRadius.getText().isEmpty() || textInnerRadius.getText().isEmpty()) {
								JOptionPane.showMessageDialog(okButton, "Please insert all fields");
							}
							else if(Integer.parseInt(textXCenter.getText()) < 0 ||	
									Integer.parseInt(textXCenter.getText()) > 810) {
								
								JOptionPane.showMessageDialog(okButton, "Please insert a value of the x-coordinate of the center greater than 0 and less than 810");
							}
							else if(
									Integer.parseInt(textYCenter.getText()) < 0 ||
									Integer.parseInt(textYCenter.getText()) > 650
									) {
								
								JOptionPane.showMessageDialog(okButton, "Please insert a value of the y-coordinate of the center greater than 0 and less than 650");
							}
							else if(Integer.parseInt(textOuterRadius.getText()) <= 0 ||  
									Integer.parseInt(textInnerRadius.getText()) <= 0 ||
									Integer.parseInt(textOuterRadius.getText()) > 350 ||
									Integer.parseInt(textInnerRadius.getText()) > 350){
								
									JOptionPane.showMessageDialog(okButton, "Please insert a radius value greater than 0 and less than 350");
								
							}
							else if(Integer.parseInt(textOuterRadius.getText()) < Integer.parseInt(textInnerRadius.getText()) + 10) {
								JOptionPane.showMessageDialog(okButton, "Outter radius must be greater than inner radius for 10");
							}
							else {
								succes = true;
								dispose();
							}
						} catch(Exception exception) {
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
						succes = false;
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public JTextField getTextInnerRadius() {
		return textInnerRadius;
	}

	public void setTextInnerRadius(JTextField textInnerRadius) {
		this.textInnerRadius = textInnerRadius;
	}

	public JTextField getTextOuterRadius() {
		return textOuterRadius;
	}

	public void setTextOuterRadius(JTextField textOuterRadius) {
		this.textOuterRadius = textOuterRadius;
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
