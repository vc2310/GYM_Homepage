
/*
 *Description: This class is the main page for workout suggestion
 *
 */
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;

public class WorkoutSchedule extends JFrame implements ActionListener {

	// declaring all private instance variables
	private JButton monday, tuesday, wednesday, thursday, friday, cheatDay, closeProg, back;
	private JPanel inputPanel;
	private static WorkoutSchedule ws;
	MondayExercise mon;
	TuesdayExercise tue;
	WednesdayExercise wed;
	ThursdayExercise thurs;
	FridayExercise fri;
	WorkoutRegistration wr;

	public WorkoutSchedule() {

		super("Workout");

		setLayout(new GridLayout(1, 1));

		// initializing and setting layout of inputPanel
		inputPanel = new JPanel();
		inputPanel.setLayout(new GridLayout(4, 1));

		// initializing all of the buttons in the program
		// giving them all labels
		monday = new JButton("Monday");
		tuesday = new JButton("Tuesday");
		wednesday = new JButton("Wednesday");
		thursday = new JButton("Thursday");
		friday = new JButton("Friday");
		cheatDay = new JButton("Saturday and Sunday");
		back = new JButton("Back to the homepage");
		closeProg = new JButton("Close the program");

		// adding all buttons to input panel in specific order
		inputPanel.add(monday);
		inputPanel.add(tuesday);
		inputPanel.add(wednesday);
		inputPanel.add(thursday);
		inputPanel.add(friday);
		inputPanel.add(cheatDay);
		inputPanel.add(back);
		inputPanel.add(closeProg);

		// adding input panel to frame
		add(inputPanel);

		// setting size of frame
		setSize(900, 600);

		setVisible(true);

		// setting location of frame
		setLocation(100, 100);

		// adding action listeners for all buttons
		monday.addActionListener(this);
		tuesday.addActionListener(this);
		wednesday.addActionListener(this);
		thursday.addActionListener(this);
		friday.addActionListener(this);
		cheatDay.addActionListener(this);
		closeProg.addActionListener(this);
		back.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		// if monday button is pressed
		if (e.getSource() == monday) {
			setVisible(false);
			mon = new MondayExercise();
		}
		// if tuesday button is pressed
		else if (e.getSource() == tuesday) {
			setVisible(false);
			tue = new TuesdayExercise();
		}
		// if wednesday button is pressed
		else if (e.getSource() == wednesday) {
			setVisible(false);
			wed = new WednesdayExercise();
		}
		// if thursday button is pressed
		else if (e.getSource() == thursday) {
			setVisible(false);
			thurs = new ThursdayExercise();
		}
		// if friday button is pressed
		else if (e.getSource() == friday) {
			setVisible(false);
			fri = new FridayExercise();
		}
		// if cheatDay button is pressed
		else if (e.getSource() == cheatDay) {
			JOptionPane.showMessageDialog(null, "No exercise on Saturday and Sunday \n Fun time/Cheat Day ");
		}
		// if Back button is pressed
		else if (e.getSource() == back) {
			setVisible(false);
			wr = new WorkoutRegistration();
		}
		// if close program button is pressed
		else if (e.getSource() == closeProg) {
			// making confirm dialog box for exiting
			int confirmed = JOptionPane.showConfirmDialog(null, "Exit Program?", "EXIT", JOptionPane.YES_NO_OPTION);

			// if yes is pressed
			if (confirmed == JOptionPane.YES_OPTION) {
				// exit
				System.exit(0);
			}
		}
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		ws = new WorkoutSchedule();
	}
}
