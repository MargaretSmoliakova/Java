package aaa;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.JPanel;

public class Layouts extends JFrame implements MouseListener {

	JPanel p2;
	public static int N = 4;
	String text;

	public Layouts() {
		super("Buttons");
		setLayout(new GridLayout(N, N));
		for (int i = 1; i <= N * N; i++) {
			JButton button = new JButton(i + "");
			button.setBackground(Color.BLUE);
			add(button);
			button.addMouseListener(this);
		}
	}

	public Layouts(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
		setLayout(new BorderLayout());

		JPanel p = new JPanel();
		JButton b1 = new JButton(">");
		JButton b2 = new JButton("<");
		p.add(b1);
		p.add(b2);

		b1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				((CardLayout) p2.getLayout()).show(p2, "2");
				;
				;
			}
		});

		getContentPane().add(p, BorderLayout.SOUTH);

		p2 = new JPanel();
		p2.setLayout(new CardLayout());

		JPanel first = new JPanel();
		first.add(new JTextField("qwerty"));
		first.add(new JCheckBox());

		JPanel second = new JPanel();
		second.add(new JTextArea(10, 4));
		second.add(new JLabel("Area"));

		p2.add(first, "1");
		p2.add(second, "2");

		getContentPane().add(p2, BorderLayout.CENTER);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String args[]) {
		JFrame frame = new Layouts();
		frame.setSize(200, 200);
		frame.setVisible(true);

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		JButton b = (JButton) (arg0.getSource());
		b.setBackground(Color.WHITE);

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		JButton b = (JButton) (arg0.getSource());
		b.setBackground(Color.BLUE);

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getButton() == MouseEvent.BUTTON1) {
			JButton b = (JButton) (arg0.getSource());
			text = b.getText();
			b.setText("Clicked");
		}

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getButton() == MouseEvent.BUTTON1) {
		JButton b = (JButton) (arg0.getSource());
		b.setText(text);
		}
	}

}
