package mainPackage;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class Login extends Creation {
	//String puname, ppaswd;
	//String password = "";
	File file;
	JLabel user, password;
	JTextField userText;
	JPasswordField passText;
	JButton login, create;

	public Login(/*JLabel user, JLabel password, JTextField userText, JPasswordField passText, JButton login, JButton create*/) {
		//super(user, password, userText, passText, login, create);
		//makeLogin();
		login = new JButton("Login");
		create = new JButton("Make an account");
		userText = new JTextField(15);
		passText = new JPasswordField(15);
		user = new JLabel("Username: ");
		password = new JLabel("Password: ");
		
		setPreferredSize(new Dimension(400, 500));
		setBorder(new EmptyBorder(new Insets(100, 100, 100, 100)));
		setLocation(500, 280);
		setLayout(null);
		
		user.setBounds(100, 20, 200, 20);
		password.setBounds(100, 70, 200, 20);
		userText.setBounds(100, 40, 200, 20);
		passText.setBounds(100, 90, 200, 20);
		login.setBounds(140, 130, 120, 20);
		create.setBounds(100, 165, 200, 20);

		add(create);
		add(login);
		add(userText);
		add(passText);
		add(user);
		add(password);
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkLogin();
			}
		});
		create.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//panel.setVisible(false);
				//createAccount();
			}
		});
	}
	

	
	@Override
	public void checkLogin() {

		puname = userText.getText();
		ppaswd = passText.getText();
		file = new File("./src/mainPackage/" + puname);
		Scanner scanner = null;

		try {
			scanner = new Scanner(file).useDelimiter(",");
		} catch (FileNotFoundException e1) {
		}

		if (!file.exists()) {
			JOptionPane.showMessageDialog(null, "Username does not exist. Please make an account.");
		}

		else {
			String password = scanner.next().trim();

			if (ppaswd.equals(password)) {
				driver = new Weight(file);
				weightArray = driver.weightArray;
				//loginSuccess();
				//panel.setVisible(false);
			}

			else {
				JOptionPane.showMessageDialog(null, "Incorrect username/password");
				passText.setText("");
				passText.requestFocus();
			}
		}
	}

}
