package com.company;

/**
 * @ClassName DeleteMax
 * @Description TODO
 * @Author GYY
 * @Date 2020/10/7
 **/
public class DeleteMax {

        static class LinkList {  //单链表泛型类
            public DeleteMax.LinkNode head;

            public LinkList() {
                head = new DeleteMax.LinkNode();
                head.next = null;
            }

            public LinkList(Integer[] data){
                head = new DeleteMax.LinkNode();
                head.next = null;
                addArray(data);
            }

            public void add(Integer value) {
                LinkNode newNode = new LinkNode(value);
                newNode.next = this.head.next;
                this.head.next = newNode;
            }

            public void addArray(Integer[] data){
                for (Integer item:data) {
                    add(item);
                }
            }

            @Override
            public String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append("{");
                LinkNode p = head;
                while (p.next != null) {
                    sb.append(" ");
                    sb.append(p.next.data);
                    sb.append(" ");
                    p = p.next;
                }
                sb.append("}");
                return sb.toString();
            }
        }


        static class LinkNode {
            public Integer data;
            public DeleteMax.LinkNode next;

            public LinkNode() {
                next = null;
            }

            public LinkNode(Integer d) {
                data = d;
                next = null;
            }
            public LinkNode(Integer data,LinkNode next){
                this.next = next;
                this.data = data;
            }
        }

        public static void main(String[] args) {
            Integer[] tmp = new Integer[]{1, 2, 5, 6, 8, 4, 8, 2, 8, 5, 5, 8};
            DeleteMax.LinkList temp = new DeleteMax.LinkList();
            temp.addArray(tmp);
            System.out.println(temp);
            delmax(temp);


        }

        public static void delmax(LinkList list1)
        {   Integer maxe;
            LinkNode p=list1.head.next,pre;
            maxe=p.data;

            while(p.next!=null){
                if(p.next.data>maxe)
                {
                    maxe=p.next.data;
                }
                else
                {
                    p=p.next;
                }
            }
            LinkNode preNode = list1.head;
            p = preNode.next;
            while(p != null){
                if (maxe.equals(p.data)) {
                    preNode.next = p.next;
                }else{
                    preNode =  preNode.next;
                }
                p = preNode.next;
            }
            System.out.println("===>>>>>" + list1.toString());
        }

}
