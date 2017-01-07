package aaa;

import java.util.*;

class MyComparator implements Comparator<Student>
{

	@Override
	public int compare(Student arg0, Student arg1) {
		// TODO Auto-generated method stub
		return arg0.fio.compareTo(arg1.fio);
	}
	
}

public class Student implements Comparable {
	String fio;
	int course;
	double ave;
	public Student(String fio, int course, double ave) {
		this.fio = fio;
		this.course = course;
		this.ave = ave;
	}
	
	@Override
	public String toString() {
		return "Student [fio=" + fio + ", course=" + course + ", ave=" + ave + "]"+'\n';
	}

	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		Student s = (Student) arg0;
		// this s ???
		if (course != s.course)
			return course - s.course;
		//else
		if (ave != s.ave)
			return Double.compare(s.ave, ave);
			//return -Double.compare(ave, s.ave);
		return fio.compareTo(s.fio);
	}
	
	public static void main (String [] args)
	{
		List<Student> c = new ArrayList<>();
		c.add(new Student ("xxx",3,6.5));
		c.add(new Student ("xxx",5,9.5));
		c.add(new Student ("zzz",5,6.4));
		c.add(new Student ("aaa",3,6.5));
		c.add(new Student ("aaa",5,6.5));
		
		
		System.out.println(c);
		
		Collections.sort(c);
		
		System.out.println(c);
		
		System.out.println(Collections.min(c));
		
		Collections.sort(c, new MyComparator());
		//System.out.println(c);
		Iterator<Student> it = c.iterator();
		while (it.hasNext())
		{
			System.out.print(it.next());
		}
		System.out.println("Version 2");
		for(Object x: c)
		{
			System.out.print(x);
		}
		
		
	}
	

}
