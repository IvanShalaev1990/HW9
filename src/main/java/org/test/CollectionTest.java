package org.test;

import org.mycollection.myarraylist.MyArrayList;
import org.mycollection.myhashmap.MyHashMap;
import org.mycollection.mylinkedlist.MyLinkedList;
import org.mycollection.myqueue.MyQueue;
import org.mycollection.mystack.MyStack;

import java.util.HashMap;
import java.util.Objects;


public class CollectionTest {
    public static void main(String[] args) {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        MyLinkedList<String> mylinkedList = new MyLinkedList<>();
        MyQueue<String> myQueue = new MyQueue<>();
        MyStack<String> myStack = new MyStack<>();
        MyHashMap<String, Integer> myHashMap = new MyHashMap<>();
    }
}
