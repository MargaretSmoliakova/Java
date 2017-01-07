import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;
import java.io.*;

class Student implements Serializable {
	String fio;
	double ave;
	Sharik s;

	public Student(String fio, double ave, Sharik s) {
		super();
		this.fio = fio;
		this.ave = ave;
		this.s = s;
	}

	@Override
	public String toString() {
		return "Student [fio=" + fio + ", ave=" + ave + ", s=" + s + "]";
	}

}

class Sharik implements Serializable {
	int x, y, r;
	Color color;

	@Override
	public String toString() {
		return "Sharik [x=" + x + ", y=" + y + ", r=" + r + ", color=" + color + "]";
	}

	public Sharik(int x, int y, int r) {
		super();
		this.x = x;
		this.y = y;
		this.r = r;
		// Math.random()
		Random rand = new Random();
		color = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
	}

	public boolean isInside(int x1, int y1) {
		return true;
	}

	public void incRadius(int delta) {
		r += delta;
	}

	public void paint(Graphics g) {
		g.setColor(color);
		g.drawOval(x - r, y - r, 2 * r, 2 * r);
	}
}

public class Streams {
	public static void main(String[] a) {

		try {
			ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream("stud.dat"));
			for (int i = 0; i < 10; i++) {
				Student s = new Student("aaa" + i, 5.5 + i, new Sharik(2, 3, 6));
				stream.writeObject(s);
			}

			stream.close();
			ObjectInputStream streamIn = new ObjectInputStream(new FileInputStream("stud.dat"));
			try {
				while (true) {
					Student s = (Student) (streamIn.readObject());
					System.out.println(s);
				}

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (EOFException e) {
				// TODO Auto-generated catch block
				System.out.println("Чтение закончено");
				;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream("studList.dat"));
			ArrayList<Student> arr = new ArrayList<>();
			for (int i = 0; i < 10; i++) {
				Student s = new Student("aaa" + i, 5.5 * i, new Sharik(2, 3, 6));
				arr.add(s);
			}
			stream.writeObject(arr);
			stream.close();
			ObjectInputStream streamIn = new ObjectInputStream(new FileInputStream("studList.dat"));

			arr = (ArrayList<Student>) (streamIn.readObject());
			System.out.println(arr);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
