package com.company;

/**
 * @ClassName DLinkNode1
 * @Description TODO
 * @Author GYY
 * @Date 2020/10/7
 **/
public class DLinkNode1 <E>{
    E data;
    int freq;
    DLinkNode1<E> prior;
    DLinkNode1<E> next;
    public DLinkNode1()
    {
        freq = 0;
        prior = null;
        next = null;

    }
    public DLinkNode1( E d)
    {
        freq = 0; data = d;
        prior = null;
        next = null;
    }
    class DLinkListClass1<E>
    {
        DLinkNode1<E> dhead;
        public DLinkListClass1()
        {
            dhead = new DLinkNode1<E>();
            dhead.prior = null;
            dhead.next = null;
        }
        public void CreateListE(E[] a)
        {
            DLinkNode1<E> s,t;
            t=dhead;
            for(int i = 0; i < a.length;i++) {
                s = new DLinkNode1<E>(a[i]);
                t.next = s;
                s.prior = t;
                t = s;
            }
            t.next = null;
            }
            public String toString()
            {
                String ans = "";
                DLinkNode1<E> p = dhead.next;
                while (p!= null)
                {
                    ans+= p.data + "[" +p.freq +"]";
                    p = p.next;

                }
                return ans;


            }
        }
    }


