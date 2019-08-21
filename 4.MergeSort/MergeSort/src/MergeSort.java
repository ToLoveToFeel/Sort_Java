import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class MergeSort {
    private ArrayList<Double> arrayList = new ArrayList<Double>();    //默认第0项为哨兵项

    public void setArrayList(ArrayList<Double> arrayList) {
        this.arrayList = arrayList;
    }

    //归并排序
    private void Merge(ArrayList<Double> list2, ArrayList<Double> list, int left, int middle, int right)
    {
        //list为合并后的目标数组，将有序的序列 list2[s..m] 和 list2[m+1..t]归并为有序的序列 list[s..t]
        int i, j, k;
        for (i = left, j = middle + 1, k = left; (i <= middle) && (j <= right); k++) {
            if (list2.get(i) <= list2.get(j))
                list.set(k, list2.get(i++));
            else
                list.set(k, list2.get(j++));
        }
        if (i <= middle)
            for (; i <= middle;)
                list.set(k++, list2.get(i++));
        if (j <= right)
            for (; j <= right;)
                list.set(k++, list2.get(j++));
    }

    //归并排序
    private void Msort(ArrayList<Double> list2, ArrayList<Double> list, int start, int end)
    {
        //将 list2[s..t] 通过 list3[] 归并排序为 list[s..t]
        //static std::array<T, N> list3{ list };	//error，list3其实为list的引用
//        ArrayList<Double> list3 = new ArrayList<Double>(
//                Arrays.asList(0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0));
        ArrayList<Double> list3 = new ArrayList<Double>();
        for (int i = 0; i < arrayList.size(); i++)
        {
            list3.add(0.0);
        }
        if (start == end)
            list.set(start, list2.get(start));
        else
        {
            int middle = (start + end) / 2;
            Msort(list2, list3, start, middle);		//体现了分久必合的思想
            Msort(list2, list3, middle + 1, end);
            Merge(list3, list, start, middle, end);
        }
    }

    //排序函数
    public void MergeSort()
    {
        int size = arrayList.size() - 1;
        Msort(arrayList, arrayList, 1, size);
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
