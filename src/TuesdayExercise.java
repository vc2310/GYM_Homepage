
/*
 *Description: This class is the page for suggestions of exercises on Tuesday
 *
 */
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;

public class TuesdayExercise extends JFrame implements ActionListener {

	// declaring private instance variables
	private JPanel inputPanel;
	private JLabel lblInstruction;
	private JButton btnBack;
	private Picture picTop, picSecond, picThird, picForth, picBottom;
	private static TuesdayExercise tue;
	WorkoutSchedule ws;

	public TuesdayExercise() {
		super("Day 2");

		setLayout(new GridLayout(6, 1));// setting layout as grid layout

		inputPanel = new JPanel();
		inputPanel.setLayout(new GridLayout(1, 1));

		btnBack = new JButton("Back");// making the back button

		// displaying pictures and texts
		picTop = new Picture(new ImageIcon(""));
		picTop.resetWord("Day 2-->CHEST DAY");
		picTop.resetFont("Comic Sans MS", Font.BOLD, 30);

		picSecond = new Picture(new ImageIcon("src/images/InclineBenchPress.PNG"));

		picThird = new Picture(new ImageIcon("src/images/DumbbellBenchPress.PNG"));

		picForth = new Picture(new ImageIcon("src/images/Butterfly.PNG"));

		picBottom = new Picture(new ImageIcon("src/images/BentArmPullover.PNG"));

		inputPanel.add(btnBack);

		// adding all the grids in order
		add(picTop);
		add(picSecond);
		add(picThird);
		add(picForth);
		add(picBottom);
		add(inputPanel);

		setSize(500, 600);
		setVisible(true);
		setLocation(50, 50);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		btnBack.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		// if back button is pressed
		if (e.getSource() == btnBack) {
			setVisible(false);// closes this tab
			ws = new WorkoutSchedule();// open the workout schedule page
		}
	}

	public static void main(String[] args) {
		tue = new TuesdayExercise();
	}
}
