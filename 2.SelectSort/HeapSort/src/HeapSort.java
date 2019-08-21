import java.util.ArrayList;
import java.util.Iterator;

public class HeapSort {
    private ArrayList<Double> arrayList = new ArrayList<Double>();    //默认第0项为哨兵项

    public void setArrayList(ArrayList<Double> arrayList) {
        this.arrayList = arrayList;
    }

    //建堆函数，从指定位置（即m）处开始建堆
    private void HeapAdjust(int m, int n)
    {
        int i;
        arrayList.set(0, arrayList.get(m));
        for (i = 2 * m; i <= n; i *=2)
        {
            if (i<n && arrayList.get(i) < arrayList.get(i+1))   //选择左右孩子最大的一个
                i++;
            if (arrayList.get(0) > arrayList.get(i))
                break;
            arrayList.set(m, arrayList.get(i));
            m = i;
        }
        arrayList.set(m, arrayList.get(0));
    }

    //排序函数
    public void HeapSort()
    {
        final int size = arrayList.size() - 1;
        int i;
        for (i = size / 2; i > 0; i--)
        {
            HeapAdjust(i, size);
        }
        for (i = size; i > 1; i--)
        {
            arrayList.set(0, arrayList.get(i));
            arrayList.set(i, arrayList.get(1));
            arrayList.set(1, arrayList.get(0));
            HeapAdjust(1, i - 1);
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
