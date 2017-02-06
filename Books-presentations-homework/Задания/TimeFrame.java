import java.awt.Color;
import java.util.Date;
import java.util.Random;

import javax.swing.*;

public class TimeFrame extends JFrame {

	JLabel label = new JLabel("Hello");
	Random r = new Random();

	public TimeFrame() {
		super("Time");
		// TODO Auto-generated constructor stub
		add(label);
		// Создание потока
		Thread t = new Thread(new Runnable() {
			public void run() {
				while (true) {
					label.setText(new Date().toString());
					//revalidate();
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		// Запуск потока
		t.start();
		// Создание потока
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				while (true) {
					Color c = new Color(r.nextInt());
					getContentPane().setBackground(c);
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		// Запуск потока
		t2.start();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame app = new TimeFrame();
		app.setVisible(true);
		// app.setSize(400,600);
		app.pack(); /*
					 * Эта команда подбирает оптимальный размер в зависимости от
					 * содержимого окна
					 */

	}

}
