import java.util.ArrayList;

class SLCell{
    public String keys = "";
    public int next = 0;
}

class SLList{
    public ArrayList<SLCell> r = new ArrayList<SLCell>();
    public int keynum = 0;
    public int recnum = 0;
}


public class RadixSort {
    public final static int MAX_NUM_OF_NUM = 8;   //关键字项数的最大值,此时整数最多8位
    public final static int NUM_OF_NUM = 3;	    //实际关键字个数
    public final static int RADIX = 10;	        //关键字的基数，此时是十进制整数的基数
    public final static int MAX_SPACE = 100;

    public SLList list = new SLList();

    private int ord(String keys, int i)
    {
        if (i > keys.length())
            return 0;
        else
            return Integer.parseInt(String.valueOf(keys.charAt(i)));    // char to int
    }

    private void Distribute(ArrayList<SLCell> R, int t, int f[], int r[], int head)
    {
        int i;
        for (i = 0; i < RADIX; i++) {
            f[i] = -1;	//链尾指针置为-1
            r[i] = -1;
        }
        for (int p = head; p != -1; p = R.get(p).next) {
            i = ord(R.get(p).keys, NUM_OF_NUM - t - 1);		//ord将将记录中的第i个关键字映射到[]
            if (-1 == f[i]) {	//说明关键字为该数字的是第一个
                f[i] = p;
            }
            else {
                R.get(r[i]).next = p;
            }
            r[i] = p;
        }
    }

    private int Collect(ArrayList<SLCell> R, int f[], int r[], int head)
    {
        int i;
        int t;
        for (i = 0; i < RADIX && -1 == f[i]; ++i) {

        }
        head = f[i];		//找到第一个存在的
        t = r[i];
        while (i < RADIX) {
            for (++i; i < RADIX - 1 && -1 == f[i]; ++i) {

            }
            if (i < RADIX && -1 != f[i]) {
                R.get(t).next = f[i];
                t = r[i];
            }
        }
        R.get(t).next = -1;
        return head;
    }

    private int head = 0;
    public void RadixSort()
    {

        for (int i = 0; i < list.recnum; i++) {
            list.r.get(i).next = i + 1;
        }
        list.r.get(list.recnum - 1).next = -1;
        int[] f = new int[]{ -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
        int[] r = new int[]{ -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
        for (int i = 0; i < list.keynum; i++) {
            Distribute(list.r, i, f, r, head);
            head = Collect(list.r, f, r, head);
        }
    }

    public void RadixPrint()
    {
        int p = head;
        for (int i = 0; i < list.recnum; i++)
        {
            System.out.println(list.r.get(p).keys);
            p = list.r.get(p).next;
        }
    }

}
