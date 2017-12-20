package com.andy.study.线性表;

/**
 * Created by 坎坎 on 2017/12/20.
 */

public class 双向链表 {

    public static void main(String[] args) {
        MyLinkedList<Integer> linkedList=new MyLinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);

        linkedList.add(10,0);
        linkedList.add(11,2);
        linkedList.add(12,5);


        linkedList.remove(5);

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
            Node pre;
            Node next;
            Node(Node pre,E data, Node next) {
                this.pre = pre;
                this.data = data;
                this.next = next;
            }
        }
        /**
         * 尾部增加元素
         */
        void add(E e) {
            final Node<E> l = last;
            final Node<E> newNode = new Node<>(l, e, null);
            last = newNode;
            if (l == null)
                first = newNode;
            else
                l.next = newNode;
            size++;
        }

        /**
         * 指定位置增加元素
         */
        void add(E e,int index) {
            if(index<0 || index > size){
                // 可抛出异常
                return ;
            }
            if(index==size){
                add(e);
            }else {
                //当前结点
                Node<E> cur= node(index);
                //上一个结点
                Node<E> pre=cur.pre;
                //构造一个结点
                Node<E> newNode = new Node<>(pre, e, cur);
                cur.pre = newNode;
                if (pre == null)
                    //第一个节点
                    first = newNode;
                else
                    pre.next = newNode;
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
        Node<E> node(int index) {
            if(index<0 || index > size-1){
                // 可抛出异常
                return null;
            }
            if (index < (size >> 1)) {
                Node<E> node = first;
                for (int i = 0; i < index; i++)
                    node = node.next;
                return node;
            } else {
                Node<E> node = last;
                for (int i = size - 1; i > index; i--)
                    node = node.pre;
                return node;
            }
        }
        /**
         * 删除指定位置
         */
        void remove(int index) {
            if (index < 0 || index > size - 1) {
                // 可抛出异常
                return;
            }
            final Node<E> cur= node(index);
            final Node<E> next = cur.next;
            final Node<E> pre = cur.pre;
            //头结点
            if (pre == null) {
                first = next;
            } else {
                pre.next = next;
                cur.pre = null;
            }
            //尾结点
            if (next == null) {
                last = pre;
            } else {
                next.pre = pre;
                cur.next = null;
            }
            cur.data = null;
            size--;
        }
    }
}
