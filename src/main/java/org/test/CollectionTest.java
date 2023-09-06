package org.test;

import org.mycollection.myarraylist.MyArrayList;
import org.mycollection.mylinkedlist.MyLinkedList;
import org.mycollection.myqueue.MyQueue;


public class CollectionTest {
    public static void main(String[] args) {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        MyLinkedList<String> linkedList = new MyLinkedList<>();
        MyQueue<Integer> myQueue = new MyQueue<>();
        for (int i = 0; i < 10; i++) {
            myQueue.add(i);
        }
    }
}
