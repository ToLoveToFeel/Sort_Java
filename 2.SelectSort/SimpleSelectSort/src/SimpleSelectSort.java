import java.util.ArrayList;
import java.util.Iterator;

public class SimpleSelectSort {
    private ArrayList<Double> arrayList = new ArrayList<Double>();    //默认第0项为哨兵项

    public void setArrayList(ArrayList<Double> arrayList) {
        this.arrayList = arrayList;
    }

    //排序函数
    public void SimpleSelectSort()
    {
        final int size = arrayList.size() - 1;
        int i, j;
        int min;
        for(i=0; i < size; i++)
        {
            min = i;
            for (j = i + 1; j <= size; j++)
            {
                if (arrayList.get(min) > arrayList.get(j))
                {
                    min = j;
                }
            }
            if(min != i)
            {
                arrayList.set(0, arrayList.get(i));
                arrayList.set(i, arrayList.get(min));
                arrayList.set(min, arrayList.get(0));
            }
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
