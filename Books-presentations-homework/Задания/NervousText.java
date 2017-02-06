import java.awt.event.*;
import java.awt.Graphics;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class NervousText extends JFrame implements Runnable, MouseListener {

	Thread runner = null; // The thread that is displaying the text
	boolean threadSuspended; // True when thread suspended (via mouse click)

	public NervousText() {
		super("Nervous text");
		threadSuspended = false;
				
		addMouseListener(this);
		MyPanel p = new MyPanel(); 
		add(p);
		start();
		setSize(p.wd + 10, 100);

	}

	public void start() {
		runner = new Thread(this);
		runner.start();
	}

	public void run() {
		//Thread me = Thread.currentThread();
		//while (runner == me) {
		while (true) {
			try {
				Thread.sleep(1);
				synchronized (this) {
					while (threadSuspended) {
						wait();
					}
				}
			} catch (InterruptedException e) {
			}
			repaint();
		}
	}

	class MyPanel extends JPanel {
		static final String TEXT = "HotJava";
		
		static final int REGULAR_WD = 15;
		static final int REGULAR_HT = 36;
		static final int SMALL_WD = 12;
		static final int SMALL_HT = 24;

		Font regularFont = new Font("Serif", Font.BOLD, REGULAR_HT);
		Font smallFont = new Font("Serif", Font.BOLD, SMALL_HT);
		
		String banner; // The text to be displayed
		char bannerChars[]; // The same text as an array of characters
		char attributes[]; // Character attributes ('^' for superscript)
		
		int wd;
		
		public MyPanel()
		{
			banner = TEXT;

			int bannerLength = banner.length();
			StringBuffer bc = new StringBuffer(bannerLength);
			StringBuffer attrs = new StringBuffer(bannerLength);
			wd = 0;
			for (int i = 0; i < bannerLength; i++) {
				char c = banner.charAt(i);
				char a = 0;
				if (c == '^') {
					i++;
					if (i < bannerLength) {
						c = banner.charAt(i);
						a = '^';
						wd += SMALL_WD - REGULAR_WD;
					} else {
						break;
					}
				}
				bc.append(c);
				attrs.append(a);
				wd += REGULAR_WD;
			}

			bannerLength = bc.length();
			bannerChars = new char[bannerLength];
			attributes = new char[bannerLength];
			bc.getChars(0, bannerLength, bannerChars, 0);
			attrs.getChars(0, bannerLength, attributes, 0);

		}
		public void paintComponent(Graphics g) {
			int length = bannerChars.length;
			for (int i = 0, x = 0; i < length; i++) {
				int wd, ht;
				if (attributes[i] == '^') {
					wd = SMALL_WD;
					ht = SMALL_HT;
					g.setFont(smallFont);
				} else {
					wd = REGULAR_WD;
					ht = REGULAR_HT;
					g.setFont(regularFont);
				}
				int px = (int) (10 * Math.random() + x);
				int py = (int) (10 * Math.random() + ht);
				g.drawChars(bannerChars, i, 1, px, py);
				x += wd;
			}
		}
	}

	public synchronized void mousePressed(MouseEvent e) {
		//e.consume();
		threadSuspended = !threadSuspended;
		if (!threadSuspended)
			notify();
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mouseClicked(MouseEvent e) {
	}

	public static void main(String args[]) {
		JFrame app = new NervousText();
		app.setVisible(true);
	}
}
