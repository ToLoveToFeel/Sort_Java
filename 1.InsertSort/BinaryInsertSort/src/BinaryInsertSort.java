import java.util.ArrayList;
import java.util.Iterator;

public class BinaryInsertSort {
    private ArrayList<Double> arrayList = new ArrayList<Double>();    //默认第0项为哨兵项

    public void setArrayList(ArrayList<Double> arrayList) {
        this.arrayList = arrayList;
    }

    //排序函数
    public void BinaryInsertSort()
    {
        final int size = arrayList.size() - 1;
        int i, j;
        int high, low, middle;
        for(i=2; i<=size; i++)
        {
            arrayList.set(0, arrayList.get(i));
            high = i - 1;
            low = 1;
            while (low <= high)
            {
                middle = (high + low) / 2;
                if (arrayList.get(0) > arrayList.get(middle))
                    low = middle + 1;
                else
                    high = middle - 1;
            }
            for (j=i-1; j>=high+1; j--)
                arrayList.set(j+1, arrayList.get(j));
            arrayList.set(high+1, arrayList.get(0));
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
