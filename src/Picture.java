
/*
 *Description: This class is the page for suggestions of exercises on thursday
 *
 *Method List:
 *Picture(ImageIcon i)
 *Picture(String words)
 *void setPicLoc(String s, int x, int y)
 *void resetWord(String phrase)
 *void resetFont(String font, int special, int size)
 *void resetColor(Color col)
 *void resetColor(int r, int g, int b)
 *void changeImage(String s)
 *void resetRectangle()
 *void paint(Graphics g)
 */
import java.awt.*;
import javax.swing.*;

public class Picture extends JComponent {
	// Instance Variables
	private Color c;
	private ImageIcon img;
	private boolean paintImg;
	private boolean title;
	private boolean cord;
	private String text;
	private int xCord;
	private int yCord;
	private Font font;

	/**
	 * Creates a new instance of <code>Picture</code>.
	 */
	public Picture() { // default constructor
		this.c = Color.RED;
		this.img = null;
		this.cord = false;
		this.title = false;
		paintImg = false;
		repaint();
	}

	public Picture(ImageIcon i) {
		this.c = Color.RED;
		this.title = false;
		this.img = i;
		this.cord = false;
		paintImg = true;
		repaint();
	}

	public Picture(String words) {
		this.c = Color.BLACK;
		this.img = null;
		this.cord = false;
		this.title = true;
		this.text = words;
		paintImg = false;
		repaint();
	}

	public void setPicLoc(String s, int x, int y) {
		this.title = false;
		this.cord = true;
		this.xCord = x;
		this.yCord = y;
		this.img = new ImageIcon(s);
		paintImg = true;
		repaint();
	}

	public void resetWord(String phrase) {
		paintImg = false;
		this.img = null;
		this.text = phrase;
		this.title = true;
		repaint();
	}

	public void resetFont(String font, int special, int size) {
		this.title = true;
		this.font = new Font(font, special, size);
		repaint();
	}

	public void resetColor(Color col) {
		this.c = col;
		repaint();
	}

	public void resetColor(int r, int g, int b) {
		this.c = new Color(r, g, b);
		repaint();
	}

	public void changeImage(String s) {
		this.img = new ImageIcon(s);
		paintImg = true;
		this.cord = false;
		repaint();

	}

	public void resetRectangle() {
		this.c = Color.RED;
		this.img = null;
		this.cord = false;
		this.title = false;
		paintImg = false;
		repaint();
	}

	public void paint(Graphics g) {

		if (this.paintImg && this.cord == false) {
			this.img.paintIcon(this, g, 0, 0);
		} else if (this.title == true) {
			g.setColor(this.c);
			g.setFont(this.font);
			g.drawString(this.text, 100, 60);
		} else if (this.cord == true && this.paintImg == true) {
			this.img.paintIcon(this, g, xCord, yCord);
		} else {
			g.setColor(this.c);
			g.drawRect(100, 10, 200, 50);
			g.drawOval(100, 10, 200, 50);
			g.fillOval(175, 10, 50, 50);
		}

	}

	/**
	 * @param args
	 *            the command line arguments self testing main
	 */
	public static void main(String[] args) {

		JFrame frame = new JFrame();
		Picture pic = new Picture();

		frame.setSize(400, 500);
		frame.add(pic);
		frame.setVisible(true);

		JOptionPane.showMessageDialog(null, "press ok");
		pic.resetColor(Color.BLUE);

		JOptionPane.showMessageDialog(null, "press ok");
		pic.resetColor(255, 0, 128);

		JOptionPane.showMessageDialog(null, "press ok");
		frame.remove(pic);
		Picture pic1 = new Picture(new ImageIcon("minion.png"));
		frame.add(pic1);
		frame.setVisible(true);

		JOptionPane.showMessageDialog(null, "press ok");
		frame.remove(pic1);
		Picture pic3 = new Picture("hello");
		frame.add(pic3);
		frame.setVisible(true);

	}
}
