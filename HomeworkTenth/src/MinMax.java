import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Маргарита on 28.01.2017.
 */
public class MinMax <T extends Comparable> extends ArrayList <T> {

    public T getMin (List<T> list) {
        return Collections.min(list, null);
    }

    public T getMax (List<T> list) {
        return Collections.max(list, null);
    }
}
