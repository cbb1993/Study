package com.andy.study.数据结构和算法.线性表;

/**
 * Created by 坎坎 on 2017/12/20.
 */

public class 单向链表 {
    public static void main(String[] args) {
        MyLinkedList<Integer> linkedList=new MyLinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);

        linkedList.reverse2(linkedList.first);
        for (int i = 0; i < linkedList.size; i++) {
            System.out.println(linkedList.get(i));
        }
    }


    static class MyLinkedList<E>{
        Node<E> first; // 第一个结点
        Node<E> last; //最后一个结点
        int size; //长度

        /**
        * 构建列表结点类型
        */
        class Node<E>{
            E data;
            Node next;
             Node(E data, Node next) {
                this.data = data;
                this.next = next;
            }
        }

        /**
         * 尾部增加元素
         */
         void add(E e){
            // 构造结点
            Node<E> newNode=new Node<>(e,null);
            //临时储存last，并给last赋予新添加元素的值
            Node<E> l=last;
            last=newNode;
            //尾结点不为空，就把 l.next指向新结点
            if(l!=null){
                l.next = newNode;
            }else {
                // 添加第一个元素
                first=newNode;
            }
            size++;
        }

        /**
         * 指定位置增加元素
         */
        void add(E e,int index){
            if(index<0 || index > size){
                // 可抛出异常
                return;
            }
            if(index==size){
                //表示尾部插入
                add(e);
            }else {
                //拿到当前位置的上一个结点
                Node<E> preNode=node(index-1);
                //构造新结点
                Node<E> newNode=new Node<>(e,null);
                if(index==0){
                    //表示添加到表头
                    newNode.next=first;
                    first=newNode;
                }else {
                    // 先连后断
                    newNode.next=preNode.next;
                    preNode.next=newNode;
                }
                size++;
            }
        }

        /**
         * 查询元素
         */
        E get(int index){
           Node<E> node = node(index);
           if(node==null){
               return null;
           }
            return node.data;
        }
        /**
         * 查询结点
         */
        Node<E> node(int index){
            if(index<0 || index > size-1){
                // 可抛出异常
                return null;
            }
            Node<E> node=first;
            for(int i=0 ;i <index ;i++){
                node=node.next;
            }
            return  node;
        }

        /**
        * 删除指定位置
        */
        void remove(int index) {
            if (index < 0 || index > size - 1) {
                // 可抛出异常
                return;
            }
            //拿到当前位置的上一个结点
            Node<E> preNode=node(index-1);
            Node<E> curNode=node(index);
            if(index==0){
                //表示删除表头
                if(first==null){
                    //空表
                    return;
                }
                first=first.next;
            }else {
                preNode.next=curNode.next;
                if(index==size){
                    //删除表尾
                    last=preNode;
                }
            }
            size--;
        }

        /**
        * 循环方式逆置 只知道头结点
        **/
        public void reverse(){
            Node<E> curNode = first;
            Node<E> temp=null; //保存上一个结点
            while ( curNode != null){
                Node<E> curTemp=curNode;
                curNode=curNode.next;
                curTemp.next=temp;
                temp=curTemp;
            }
            first=temp;
        }

        /**
         * 递归方式逆置 只知道头结点
         **/
        public Node<E> reverse2(Node<E> head){
            if(head==null || head.next==null){
                first=head;
                return head;
            }
            Node<E> tail = reverse2(head.next);
            head.next.next=head;
            head.next=null;
            return tail;
        }
    }
}
