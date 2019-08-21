import java.util.ArrayList;
import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        ArrayList<Double> arrayList = new ArrayList<Double>(
                Arrays.asList(0.0, 10.2, 2.2, 7.2, 4.0, 9.0, 0.8, 5.0, 6.0, 8.1));

        MergeSort d = new MergeSort();
        d.setArrayList(arrayList);

        System.out.println("Berore Sort:");
        d.traverseByIterator();

        d.MergeSort();

        System.out.println("\nAfter Sort:");
        d.traverseByIterator();
    }
}
