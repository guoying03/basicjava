package com.company;

/**
 * @ClassName Exam2_19
 * @Description TODO
 * @Author GYY
 * @Date 2020/10/7
 **/
public class Exam2_19 {
    private static void swap(DLinkNode1<Integer> p, DLinkNode1<Integer> q)
    {
        int temp = p.data;
        p.data = q.data;
        q.data=temp;
        temp = p.freq;
        p.freq = q.freq;
        q.freq = temp;
    }

    static class DLinkNode1<E> {
        E data;
        int freq;
        DLinkNode1<E> prior;
        DLinkNode1<E> next;

        public DLinkNode1() {
            freq = 0;
            prior = null;
            next = null;
        }

        public DLinkNode1(E d) {
            freq = 0;
            data = d;
            prior = null;
            next = null;
        }
    }

    static class DLinkListClass1<E> {
        DLinkNode1<E> dhead;

        public DLinkListClass1(){
            dhead = new DLinkNode1<E>();
            dhead.prior = null;
            dhead.next = null;
        }

        //线性表的基本运算算法
        public void CreateListR(E[] a)

        {
            DLinkNode1<E> s, t;
            t = dhead;
            for (int i = 0; i < a.length; i++) {
                s = new DLinkNode1<E>(a[i]);
                t.next = s;
                s.prior = t;
                t = s;
            }
            t.next = null;
        }
        @Override
        public String toString()
        {
            String ans = "";
            DLinkNode1<E> p = dhead.next;
            while (p != null) {
                ans += p.data + "[" + p.freq +"]";
                p = p.next;
            }
            return ans;
        }
    }



    public static boolean LocateElem(DLinkListClass1<Integer>L,Integer x)
    {
        DLinkNode1<Integer> p,pre;
        p=L.dhead.next;
        while(p!=null&& !p.data.equals(x)) {
            p = p.next;
        }
        if(p==null) {
            return false;
        }
        p.freq++;
        pre=p.prior;
        while(pre!=L.dhead && pre.freq<p.freq)
        {
            swap(pre,p);
            p=pre;pre=p.prior;
        }
        return true;
    }

    public static void Find(DLinkListClass1<Integer> L,Integer x)
    {
        System.out.println("查找值为"+x+"的结点");
        if(LocateElem(L,x)) {
            System.out.println("查找成功，双链表 L:" + L.toString());
        }
        else {
            System.out.println("查找失败");
        }
    }

    public static void main(String[] args) {
        Integer [] a ={1,2,3,4,5};
        DLinkListClass1<Integer> L = new DLinkListClass1<Integer>();
        L.CreateListR(a);
        System.out.println("L:"+L.toString());
        Find(L,5);   Find(L,1);
        Find(L,4);   Find(L,5);
        Find(L,2);   Find(L,4);
        Find(L,5);
    }

}
