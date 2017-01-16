import java.lang.Math;

/**
 * Created by Маргарита on 16.01.2017.
 */
public class Bubbles {

    int x;
    int y;
    int r;

    int red;
    int green;
    int blue;

    double number;

    public Bubbles (int x, int y, int r, int red, int  green, int blue) {
        this.x = x;
        this.y = y;
        this.r = r;

        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public Bubbles () {}

    public boolean isInside (int x, int y) {

        boolean inside = false;
        number = Math.sqrt(Math.pow((double) Math.abs(this.x - x), 2) + Math.pow((double) Math.abs(this.y - y), 2));

        inside = number <= r;

        return inside;
    }

    public void incRadius () {

        r += 2;
    }
}
