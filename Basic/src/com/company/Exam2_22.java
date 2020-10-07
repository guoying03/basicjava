package com.company;

import java.io.FileNotFoundException;

/**
 * @ClassName Exam2_22
 * @Description TODO
 * @Author GYY
 * @Date 2020/10/7
 **/
public class Exam2_22 {
    
    static class Child {
        int no;
        Child next;

        public Child(int no1) {
            no = no1;
            next = null;
        }
    }

    static class Joseph {
        int n, m;
        Child first;

        public Joseph(int n1, int m1) {
            Child p, t;
            n = n1;
            m = m1;
            first = new Child(1);
            t = first;
            for (int i = 2; i <= n; i++) {
                p = new Child(i);
                t.next = p;
                t = p;
            }
            t.next = first;
        }

        public String Jsequence() {
            String ans = "";
            int i, j;
            Child p, q;
            for (i = 1; i <= n; i++) {
                p = first;
                j = 1;
                while (j < m - 1) {
                    j++;
                    p = p.next;
                }
                q = p.next;        //q指向第m个结点
                ans += q.no + " ";        //该结点的小孩出列
                p.next = q.next;        //删除q结点
                first = p.next;        //从下一个结点重新开始
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        System.out.println("******测试1******");
        int n = 6, m = 3;
        Joseph L = new Joseph(n, m);
        System.out.println("n=" + n + ",m=" + m + "的约瑟夫序列");
        System.out.println(L.Jsequence());

        System.out.println("******测试2******");
        int n2 = 8;
        m = 4;
        L = new Joseph(n2, m);
        System.out.println("n=" + n2 + ",m=" + m + "的约瑟夫序列");
        System.out.println(L.Jsequence());
    }


}

