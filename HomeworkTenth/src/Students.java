import java.util.StringTokenizer;

/**
 * Created by Маргарита on 26.01.2017.
 */
public class Students implements Comparable<Students> {

    private String surname;
    private int year;
    double avgGrade;

    public Students () {}

    public Students (String string) {

        StringTokenizer st = new StringTokenizer(string, "/");

        while (st.hasMoreTokens()) {
            this.surname = st.nextToken();
            this.year = Integer.parseInt(st.nextToken());
            this.avgGrade = Double.parseDouble(st.nextToken());
        }
    }

    public String getSurname () {
        return this.surname;
    }

    public int getYear () {
        return this.year;
    }

    public double getAvgGrade () {
        return this.avgGrade;
    }

    @Override
    public int compareTo(Students o) {
        return surname.compareTo(o.getSurname());
    }
}
