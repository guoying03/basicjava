package com.company;

/**
 * @ClassName Example4_4
 * @Description TODO
 * @Author GYY
 * @Date 2020/10/13
 **/
public class Example4_4 {
    class LinkNode
    {
        char data;
        LinkNode next;
        public LinkNode()
        {
            next = null;
        }
        public LinkNode(char ch)
        {
            data = ch;
            next = null;
        }
    }
    public class LinkStringClass{
        LinkNode head;
        int size;
        public LinkStringClass()
        {
            head = new LinkNode();
            size = 0;
        }

    }
     public LinkStringClass InsStr(int i,LinkStringClass t){
         LinkStringClass s = new LinkStringClass();
         if (i <0 || i> s.size)
             return s;
         LinkNode P = s.head.next,p1 = t.head.next,q,r;
         r = s.head;

         for (int k = 0; k<i; k++)
         {
             q = new LinkNode(p1.data);
             r.next = q; r = q;
             p1 = p1.next;

         }
         while (p1!= null)
         {
             q = new LinkNode(p1.data);
             r.next = q;r = q;
             p1 = p1.next;
         }
         while(p1!= null)
         {
             q = new LinkNode(p1.data);
             r.next = q; r = q;
             p1 = p1.next;
         }
         s.size = s.size + t.size;
         r.next = null;
         return s;
     }


}
