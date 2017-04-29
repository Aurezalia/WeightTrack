package mainPackage;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Welcome extends MainPanel {
	public Welcome(JLabel recordLabel, JLabel nameLabel, JTextField nameText, JLabel heightLabel, JTextField heightText, JLabel weightLabel, JTextField weightText, 
			JLabel goalLabel, JTextField goalText, JButton update, JButton calculate) {
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setPreferredSize(new Dimension(400, 500));
		setBorder(new EmptyBorder(new Insets(40, 100, 100, 100)));
		
		recordLabel = new JLabel("Your last weigh in: ");
		add(recordLabel);
		add(Box.createRigidArea(new Dimension(0, 50)));

		nameLabel = new JLabel("Name: ");
		nameText = new JTextField(puname);
		add(nameLabel);
		add(nameText);
		add(Box.createRigidArea(new Dimension(0, 25)));

		heightLabel = new JLabel("Height (in inches): ");
		heightText = new JTextField(driver.getHeightString());
		heightLabel.add(heightText);
		add(heightLabel);
		add(heightText);
		add(Box.createRigidArea(new Dimension(0, 25)));

		weightLabel = new JLabel("Current weight (in pounds): ");
		weightText = new JTextField(driver.getWeightString());
		add(weightLabel);
		add(weightText);
		add(Box.createRigidArea(new Dimension(0, 25)));

		goalLabel = new JLabel("Goal weight (in pounds): ");
		goalText = new JTextField(driver.getGoalString());
		add(goalLabel);
		add(goalText);
		add(Box.createRigidArea(new Dimension(0, 25)));

		update = new JButton("Update");
		add(update);
		add(Box.createRigidArea(new Dimension(0, 5)));
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//updateButtonPressed();
				//welcome.setVisible(false);
			}

		});


		calculate = new JButton("Calculate BMI");
		add(calculate);
		add(Box.createRigidArea(new Dimension(0, 5)));
		calculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//calculatePressed();
				//welcome.setVisible(false);
			}

		});
	}
	}
