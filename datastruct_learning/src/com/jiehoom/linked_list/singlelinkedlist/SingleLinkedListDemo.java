package com.jiehoom.linked_list.singlelinkedlist;

import java.awt.event.ItemEvent;

/**
 * 实现单链表
 */
public class SingleLinkedListDemo {

    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
//        singleLinkedList.addNode(new Node(1,"张三"));
//        singleLinkedList.addNode(new Node(2,"李四"));
//        singleLinkedList.addNode(new Node(5,"王五"));
        singleLinkedList.addByOrder(new Node(5, "张三"));
        singleLinkedList.addByOrder(new Node(2, "李四"));
        singleLinkedList.addByOrder(new Node(6, "赵六"));
        singleLinkedList.addByOrder(new Node(1, "王牌1"));
        //相同id的情况下有序添加是按照添加顺序查找到的
        singleLinkedList.addByOrder(new Node(1, "王牌2"));
        singleLinkedList.list();
        System.out.println("==============");
        singleLinkedList.deleteNode(3);
        //查出倒数第k个结点
        int k = 5;
        System.out.println("第" + k + "个结点为" + singleLinkedList.findLastKNode(5));
        System.out.println("==============");
        singleLinkedList.reserver(singleLinkedList.getHead());
        singleLinkedList.list();
    }


    //结点
    static class Node {
        private int id;
        private String name;
        private Node next;

        public Node() {
        }

        public Node(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    //单链表
    static class SingleLinkedList {

        private Node head;

        public SingleLinkedList() {
            head = new Node();
        }

        /**
         * 头插法添加结点
         *
         * @param node
         */
        public void addNode(Node node) {
            Node temp = head;
            node.next = temp.next;
            temp.next = node;
        }

        /**
         * 按照id的大小顺序添加
         * 当两个结点的id相同时,这里会添加到相同id的结点后面
         *
         * @param node
         */
        public void addByOrder(Node node) {
            Node temp = head;
            while (true) {
                if (temp.next == null) {
                    break;
                }
                if (temp.next.getId() > node.getId()) {
                    break;
                }
                temp = temp.next;
            }
            node.next = temp.next;
            temp.next = node;
        }

        //通过id删除
        public void deleteNode(int id) {
            Node temp = head;
            boolean flag = false;
            while (true) {
                if (temp.next == null) {
                    break;
                }
                if (temp.next.getId() == id) {
                    flag = true;
                    break;
                }
                temp = temp.next;
            }
            if (flag) {
                Node p = temp.next;
                temp.next = p.next;
            } else {
                System.out.println("你要删除的结点不存在");
            }
        }


        /**
         * 显示链表
         */
        public void list() {
            Node temp = head;
            while (true) {
                if (temp.next == null) {
                    break;
                }
                System.out.println(temp.next);
                temp = temp.next;
            }
        }

        public Node getHead(){
            return head;
        }

        /**
         * 查找倒数第k个结点,k的假想范围为1-maxSize
         *
         * @return
         */
        public Node findLastKNode(int k) {
            int length = 0;
            Node temp = head;
            if (temp.next == null) {
                return null;
            }
            while (temp.next != null) {
                length++;
                temp = temp.next;
            }
            if (k > length || k <= 0) {
                return null;
            }
            int i = length - k;
            temp = head;
            for (int j = 0; j <= i; j++) {
                temp = temp.next;
            }
            return temp;
        }

        public void reserver(Node node){
            if (node.next==null||node.next.next==null){
                return;
            }
            Node cur=node.next;
            Node next=null;
            //用一个新的链表使用头插法接收遍历到的结点,之后再将头结点的next域地址给原来的链表
            SingleLinkedList reverse=new SingleLinkedList();
            while (cur!=null){
                next=cur.next;
                cur.next=reverse.getHead().next;
                reverse.getHead().next=cur;
                cur=next;
            }
            node.next=reverse.getHead().next;
        }
    }
}
