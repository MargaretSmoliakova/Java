import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Locking extends JFrame {

	public static final int DELAY = 1500;
	JLabel label = new JLabel("1");
	

	public Locking() {
		super("Time");
		setLayout(new FlowLayout());
		// TODO Auto-generated constructor stub
		add(label);
		final JTextField tf = new JTextField(20);
		tf.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				//lock
				label.setText(tf.getText());
				
			}
		});
		add(tf);
		// Создание потока
		Thread t = new Thread(new Runnable() {
			public void run() {
				while (true) {
					//lock
					label.setText(Integer.toString(Integer.parseInt(label.getText())+1));
					//revalidate();
					try {
						Thread.sleep(DELAY);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		// Запуск потока
		t.start();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame app = new Locking();
		app.setVisible(true);
		// app.setSize(400,600);
		app.pack(); /*
					 * Эта команда подбирает оптимальный размер в зависимости от
					 * содержимого окна
					 */

	}
}
