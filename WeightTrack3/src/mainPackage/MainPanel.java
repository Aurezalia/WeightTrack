package mainPackage;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class MainPanel extends JPanel {
	String Record, puname, ppaswd;
	Weight driver;
	String nameText = "", heightText = "", weightText = "", goalText = "", newName = "", userName = "", password = "",
			userText = "", passText = "", newHeight = "", newGoal = "", newWeight = "";
	double heightNum, weightNum, goalNum;
	ArrayList<Record> weightArray;
	JButton blogin, baccount;
	JTextField txuser;
	JPasswordField pass;
	JLabel userLabel, passLabel;
	static Creation login = new Login(/*userLabel, passLabel, txuser, pass, blogin, baccount*/);
	//static Creation welcome = new Welcome();


	private static final long serialVersionUID = 1L;

	// creates the initial login JPanel in the MainPanel
	public MainPanel() {
		initUI();
	}

	public void initUI(){
		add(login);
	}
}
