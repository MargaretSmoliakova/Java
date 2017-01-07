package aaa;

public class Izd {
	String a,b;
	int c;
	public String getA() {
		return a;
	}
	public void setA(String a) {
		this.a = a;
	}
	public String getB() {
		return b;
	}
	public void setB(String b) {
		this.b = b;
	}
	public int getC() {
		return c;
	}
	public void setC(int c) {
		this.c = c;
	}
	@Override
	public String toString() {
		return "Izd [a=" + a + ", b=" + b + ", c=" + c + "]";
	}
	public Izd(String a, String b, int c) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
	}
	public Izd() {

		a="Pravda";
		b="x";
		c=16;
	}
	

}
