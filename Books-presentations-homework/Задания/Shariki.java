package aaa;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;

public class Shariki extends JFrame {
	public Shariki()
	{
		super("Shariki");
		JPanel p = new JMyPanel();
		setContentPane(p);


		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame fr = new Shariki();
		fr.setSize(200,200);
		fr.setVisible(true);

	}
	
	class Sharik
	{
		int x,y,r;
		Color color;
		public Sharik(int x, int y, int r) {
			super();
			this.x = x;
			this.y = y;
			this.r = r;
			//Math.random()
			Random rand = new Random();
			color = new Color (rand.nextInt(256),rand.nextInt(256),rand.nextInt(256));
		}
		public boolean isInside(int x1,int y1)
		{
			return true;
		}
		public void incRadius(int delta)
		{
			r+=delta;
		}
		public void paint(Graphics g)
		{
			g.setColor(color);
			g.drawOval(x-r, y-r, 2*r, 2*r);
		}
	}
	
	class JMyPanel extends JPanel
	{
		public static final int RADIUS = 20;
		ArrayList<Sharik> list = new ArrayList<>();

		@Override
		protected void paintComponent(Graphics arg0) {
			// TODO Auto-generated method stub
			super.paintComponent(arg0);
			for(Sharik i : list)
			{
				i.paint(arg0);
			}
			
		}
		
		public JMyPanel()
		{
			addMouseListener(new MouseAdapter()
					{

						@Override
						public void mouseClicked(MouseEvent arg0) {
							// TODO Auto-generated method stub
							super.mouseClicked(arg0);
							boolean stop=false;
							for (Sharik i: list)
							{
								if (i.isInside(arg0.getX(), arg0.getY()))
								{
									i.incRadius(5);
									stop = true;
								}
								
							}
							if (stop==false){ //(!stop)
								list.add(new Sharik(arg0.getX(),arg0.getY(),RADIUS));
							}
							repaint();
							
						}
						
					});
		}
		
	}

}
