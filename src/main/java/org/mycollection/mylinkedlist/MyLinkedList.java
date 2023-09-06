package org.mycollection.mylinkedlist;

import java.util.Objects;
/**
 * MyLinkedList class describes the data structure Linked List
 *
 * @author Shalaiev Ivan
 * @version 1.0.0 06.09.2023
 */

public class MyLinkedList<T> {
    private Node<T> first;
    private Node<T> last;
    private int size;

    private static class Node<T> {
        T value;
        Node<T> prev;
        Node<T> next;

        public Node(T value) {
            this.value = value;
        }

    }
    /**
     * Add element to this list.
     */
    public void add(T value) {

        Node<T> current = new Node<>(value);
        if (size == 0) {
            first = last = current;
        } else {
            current.prev = last;
            last.next = current;
            last = current;
        }
        size++;
    }
    /**
     * Removes the element at the specified index from this list.
     */
    public void remove(int index) {
        Objects.checkIndex(index, size);
        if (index == 0) {
            first = first.next;
            first.prev = null;
        } else if (index == size - 1) {
            last = last.prev;
            last.next = null;
        } else {
            Node<T> current = first;
            for (int i = 1; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
            current = last;
            for (int i = 1; i < size - index; i++) {
                current = current.prev;
            }
            current.prev = current.prev.prev;
        }
        size--;
    }
    /**
     * Remove all elements from this list.
     */
    public void clear() {
        Node<T> current = null;
        first = last = current;
        size = 0;
    }
    /**
     * Returns the number of elements in this list.
     */
    public int size() {
        return size;
    }

    /**
     * Returns the element at the specified position in this list.
     * If int index > size / 2 then the search starts from the end.
     */
    public T get(int index) {
        Objects.checkIndex(index, size);
        Node<T> current;
        if (index > size / 2) {
            current = last;
            for (int i = 1; i < size - index; i++) {
                current = current.prev;
            }
        } else {
            current = first;
            for (int i = 1; i < index + 1; i++) {
                current = current.next;
            }
        }
        return current.value;
    }


}
