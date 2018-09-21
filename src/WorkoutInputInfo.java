
/**
 * @(#)WorkoutInputInfo.java
 *
 *
 * @author 
 * @version 1.00 2016/6/10
 */
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;

public class WorkoutInputInfo extends JFrame implements ActionListener {

	// declaring all private instance variables
	private JTextField txtName, txtGender, txtAge, txtWeight, txtHeight;
	private JPanel inputPanel;
	private JButton btnHome, btnAdd, btnBMI;
	private static int counter3;
	private String realUserName, realPassword;

	// AddAccount constructor
	public WorkoutInputInfo(String userName, String password) {
		super("Workout Input Info");
		realUserName = userName;
		realPassword = password;
		// setting layout of frame
		setLayout(new GridLayout(1, 1));

		// intializing inputPanel and setting layout
		inputPanel = new JPanel();
		inputPanel.setLayout(new GridLayout(7, 1));

		// initializing all textfields and buttons
		txtName = new JTextField("Enter Name");
		txtGender = new JTextField("Enter your gender");
		txtAge = new JTextField("Enter your age");
		txtWeight = new JTextField("Enter your weight in kg (no decimals)");
		txtHeight = new JTextField("Enter your height in cm (no decimals)");

		btnAdd = new JButton("Add and Generate Workout");
		btnHome = new JButton("Home");

		// adding all components to inputPanel in specific order
		inputPanel.add(txtName);
		inputPanel.add(txtGender);
		inputPanel.add(txtAge);
		inputPanel.add(txtWeight);
		inputPanel.add(txtHeight);
		inputPanel.add(btnAdd);
		inputPanel.add(btnHome);

		// adding inputPanel to frame
		add(inputPanel);

		// setting size of frame
		setSize(400, 600);

		setVisible(true);
		// setting location of frame
		setLocation(100, 100);

		// adding action listeners for btnHome and btnAdd
		btnHome.addActionListener(this);
		btnAdd.addActionListener(this);

		// setting BankAccount instance variable to specific instance given by
		// BankHomepage

		// Setting size of customer savings and chequing object arrays

	}

	public void actionPerformed(ActionEvent e) {
		// if home is pressed
		if (e.getSource() == btnHome) {
			// set current window to invisible
			setVisible(false);

			WorkoutRegistration wr = new WorkoutRegistration();

		}

		// if btnAdd is pressed
		if (e.getSource() == btnAdd) {

			try {
				// FileWriter
				// File f = new File (realUserName+".txt");
				PrintWriter writer = new PrintWriter(realUserName + ".txt");
				writer.println(realUserName);
				writer.println(realPassword);
				writer.println(txtName.getText());
				writer.println(txtGender.getText());
				writer.println(txtAge.getText());
				writer.println(txtWeight.getText());
				writer.println(txtHeight.getText());
				writer.println(/* writes to new line everytime you do a new writer println */);
				writer.close();

				setVisible(false);
				WorkoutSchedule ws = new WorkoutSchedule();

				JOptionPane.showMessageDialog(null, "New Account Has Been Added to Database!");

				// adding 1 to counter 3

				// resetting all textfields
				txtName.setText("Enter Name");
				txtGender = new JTextField("Enter your gender");
				txtAge = new JTextField("Enter your age");
				txtWeight = new JTextField("Enter your weight in kg (no decimals)");
				txtHeight = new JTextField("Enter your height in cm (no decimals)");

			} catch (Exception NumberFormatException) {
				JOptionPane.showMessageDialog(null, "Please fill in the the information properly as instructed.");
			}

		}
	}

	public WorkoutInputInfo() {
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		WorkoutInputInfo wii = new WorkoutInputInfo();
		wii.setVisible(true);
	}
}
