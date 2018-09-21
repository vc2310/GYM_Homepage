
/*
 *Description: This class will allow users to register for our workout application and store their information in files to be read later
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
//import java.io.File.*;

public class WorkoutRegistration extends JFrame implements ActionListener {
	JLabel quote;
	JLabel lblName; // declaring components for the gui
	JLabel lblNumber;
	JTextField txtName;
	JButton btnFindAccount;
	JButton btnCreateAccount;
	Container frame;
	JLabel lblPic;
	JTextField txtPassword;
	JButton btnClear;
	String name, num, checkPassword, checkUsername;
	FitCustomer cust;

	public WorkoutRegistration() {
		super("Gym Registration"); // Set the frame's name

		frame = getContentPane();

		// creating gui components

		lblName = new JLabel("Username");
		lblNumber = new JLabel("Password");
		txtName = new JTextField();
		btnFindAccount = new JButton("Find Account");
		btnCreateAccount = new JButton("Create Account");
		lblPic = new JLabel(new ImageIcon("src/images/moves.gif"));
		txtPassword = new JTextField();
		quote = new JLabel("YOUR BEST WORKOUT PARTNER!");
		btnClear = new JButton("Clear Fields");

		frame.setLayout(null);

		lblName.setBounds(10, 10, 100, 15); // sets locations
		lblNumber.setBounds(10, 40, 150, 15);
		lblPic.setBounds(70, 130, 200, 400);
		txtName.setBounds(120, 10, 150, 25);
		txtPassword.setBounds(120, 37, 150, 25);
		btnClear.setBounds(95, 100, 150, 25);
		btnCreateAccount.setBounds(175, 70, 150, 25);
		btnFindAccount.setBounds(15, 70, 150, 25);
		quote.setFont(new Font("Courier New", Font.BOLD, 19));
		quote.setForeground(Color.BLUE);
		quote.setBounds(25, 520, 300, 50);

		frame.add(lblPic);
		frame.add(txtPassword);
		frame.add(lblName);
		frame.add(lblNumber);
		frame.add(txtName);
		frame.add(btnFindAccount);
		frame.add(btnClear);
		frame.add(btnCreateAccount);
		frame.add(quote);
		btnClear.addActionListener(this);
		btnCreateAccount.addActionListener(this);
		btnFindAccount.addActionListener(this); // add this frame as listens to the button

		setSize(350, 600); // Set the frame's size
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2); // makes
																												// frame
																												// pop
																												// up
																												// centre
																												// screen
		setVisible(true); // Show the frame
	} // Constructor

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnFindAccount) {
			try {

				FileReader file = new FileReader(txtName.getText() + ".txt");
				BufferedReader accountInfo = new BufferedReader(file); // file read

				String checkUsername = accountInfo.readLine();
				String checkPassword = accountInfo.readLine();

				if (((txtName.getText()).equals(checkUsername)) && ((txtPassword.getText()).equals(checkPassword))) {

					JOptionPane.showMessageDialog(null, "Welcome back " + checkUsername);
					setVisible(false);
					WorkoutInputInfo wii = new WorkoutInputInfo(checkUsername, checkPassword);
				} else {
					JOptionPane.showMessageDialog(null, "Incorrect username or password, please try again");
				}
			} catch (Exception f) {
				JOptionPane.showMessageDialog(null, "Incorrect Username or password please try again");
			}

		} else if (e.getSource() == btnClear) {
			txtName.setText("");
			txtPassword.setText("");

		} else if (e.getSource() == btnCreateAccount) {
			try {
				String testUsername = txtName.getText();
				String testPassword = txtPassword.getText();
				File f = new File(testUsername + ".txt");
				testUsername = testUsername.toLowerCase();
				testPassword = testPassword.toLowerCase();
				if (f.exists() && !f.isDirectory()) {
					JOptionPane.showMessageDialog(null, "This username already exists please try another");
				} else if (((txtName.getText()).equals("")) || ((txtPassword.getText()).equals(""))) {
					JOptionPane.showMessageDialog(null, "Please enter a username and password");
				}

				else {

					cust = new FitCustomer(testUsername, testPassword);
					PrintWriter writer = new PrintWriter(testUsername + ".txt");
					writer.println(cust.getUserName());
					writer.println(cust.getPassword());
					writer.close();
					JOptionPane.showMessageDialog(null, "You account has been created " + cust.getUserName());
					setVisible(false);

					WorkoutInputInfo wii = new WorkoutInputInfo(cust.getUserName(), cust.getPassword());
				}
			} catch (Exception f) {
				JOptionPane.showMessageDialog(null, f);
			}
		}
	}

	public static void main(String[] args) {
		new WorkoutRegistration(); // Create a GUI frame

	} // main method

} // end WorkoutRegistration
