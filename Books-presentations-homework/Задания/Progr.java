package aaa;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Progr extends JFrame {
	JTextField t1 = new JTextField("5",10);
	public Progr()
	{
		super("Series");
		JPanel p = new JPanel();
		//p.setLayout(new GridLayout(2,2));
		
		
		

		JTextField t2 = new JTextField(10);
		JTextField t3 = new JTextField("20");
		
		final JComboBox c = new JComboBox();
		c.addItem("Linear");
		c.addItem("Geo");
		
		JButton b = new JButton("Press");
		
		
		
		p.add(t1);
		p.add(t2);
		p.add(t3);
		p.add(c);
		p.add(b);
		this.setContentPane(p);
		
		b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					//Series s;
					if (c.getSelectedItem().equals("Linear"))
					{
						Double.parseDouble(t1.getText());
						//s = new Linear(Double.parseDouble(t1.getText(),...);
						JOptionPane.showMessageDialog(Progr.this, "Linear");
					}
					else
					{
						//s = new Geo(Double.parseDouble(t1.getText(),...);
						JOptionPane.showMessageDialog(Progr.this, "Exp");
					}
				}
				catch(NumberFormatException e)
				{
					JOptionPane.showMessageDialog(Progr.this, "Error!");
				}
				
			}
		});
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame fr = new Progr();
		fr.setSize(200,200);
		fr.setVisible(true);

	}

}
