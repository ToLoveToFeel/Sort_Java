import java.util.ArrayList;
import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        ArrayList<Double> arrayList = new ArrayList<Double>(
                Arrays.asList(0.0, 6.2, 2.2, 7.2, 4.0, 9.0, 0.8, 5.0, 6.0, 10.1));

        HeapSort d = new HeapSort();
        d.setArrayList(arrayList);

        System.out.println("Berore Sort:");
        d.traverseByIterator();

        d.HeapSort();

        System.out.println("\nAfter Sort:");
        d.traverseByIterator();
    }
}
