import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        ArrayList<Double> arrayList = new ArrayList<Double>(
                Arrays.asList(0.0, 6.0, 2.2, 7.2, 4.0, 9.0, 0.8, 5.0, 6.0));
//        Double[] y = new Double[]{ 0.0, 6.0, 2.2, 7.2, 4.0, 9.0, 0.8, 5.0, 6.0 };
        DirectInsertSort d = new DirectInsertSort();
        d.setArrayList(arrayList);
        d.traverseByIndex();
        d.DirectInsertSort();
        d.traverseByIndex();
    }
}
