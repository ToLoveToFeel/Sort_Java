import java.util.ArrayList;
import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<String>(
                Arrays.asList( "369", "367", "167", "239", "237", "138", "230", "139" ));
        RadixSort radixSort = new RadixSort();
        radixSort.list.recnum = arrayList.size();
        radixSort.list.keynum = RadixSort.NUM_OF_NUM;

        for (int i = 0; i < radixSort.list.recnum; i++)
        {
            SLCell slCell = new SLCell();
            slCell.keys = arrayList.get(i);
            radixSort.list.r.add(slCell);
        }

        System.out.println("Before Sort : ");
        for (int i = 0; i < arrayList.size(); i++)
        {
            System.out.println(arrayList.get(i));
        }
        radixSort.RadixSort();
        System.out.println("After Sort  : ");
        radixSort.RadixPrint();
    }
}
