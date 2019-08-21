import java.util.ArrayList;
import java.util.Iterator;

public class QuickSort {
    private ArrayList<Double> arrayList = new ArrayList<Double>();    //默认第0项为哨兵项

    public void setArrayList(ArrayList<Double> arrayList) {
        this.arrayList = arrayList;
    }

    //快排
    private int partition(int low, int high)
    {
        arrayList.set(0, arrayList.get(low));
        while (low < high)
        {
            while ((low < high) && (arrayList.get(high) > arrayList.get(0)))
                high--;
            if (low < high)
            {
                arrayList.set(low, arrayList.get(high));
                low++;
            }
            while ((low < high) && (arrayList.get(low) < arrayList.get(0)))
                low++;
            if (low < high)
            {
                arrayList.set(high, arrayList.get(low));
                high--;
            }
        }
        arrayList.set(high, arrayList.get(0));

        return high;
    }

    //排序函数
    public void QuickSort(int low, int high)
    {
        int t;
        if (low < high)
        {
            t = partition(low, high);
            QuickSort(low, t - 1);
            QuickSort(t + 1, high);
        }
    }

    //迭代器输出
    public void  traverseByIterator()
    {
        long startTime = System.nanoTime();

        Iterator<Double> iterator = arrayList.iterator();
        while (iterator.hasNext()){
            Double value = (Double)(iterator.next());
            System.out.println(value);
        }

        System.out.println("===========traverseByIterator===========");
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println(duration + "纳秒");
    }

    //普通for循环输出
    public void traverseByIndex()
    {
        long startTime = System.nanoTime();

        for (int i=0; i<arrayList.size(); i++)
        {
            System.out.println(arrayList.get(i));
        }

        System.out.println("===========traverseByIndex===========");
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println(duration + "纳秒");
    }

    //简单方式for循环输出
    public void traverseByFor()
    {
        long startTime = System.nanoTime();

        for(Double item : arrayList)
        {
            System.out.println(item);
        }
        System.out.println("===========traverseByIndex===========");
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println(duration + "纳秒");
    }

}
