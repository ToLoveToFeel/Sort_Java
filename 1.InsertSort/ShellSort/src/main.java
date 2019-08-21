import java.util.ArrayList;
import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        ArrayList<Double> arrayList = new ArrayList<Double>(
                Arrays.asList(0.0, 6.2, 2.2, 7.2, 4.0, 9.0, 0.8, 5.0, 6.0, 10.1));
        int[] a = new int[]{ 5,3,1 };

        ShellSort d = new ShellSort();
        d.setArrayList(arrayList);

        System.out.println("Berore Sort:");
        d.traverseByFor();

        for (int i = 0; i < a.length; i++) {
            d.ShellSort(a[i]);
        }

        System.out.println("\nAfter Sort:");
        d.traverseByFor();
    }
}
