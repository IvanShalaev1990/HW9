package org.mycollection.myqueue;


/**
 * MyQueue class describes the data structure Queue.
 *
 * @author Shalaiev Ivan.
 * @version 1.0.0 06.09.2023
 */
public class MyQueue<T> {
    private Node<T> first;
    private Node<T> last;
    private int size;

    private static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value) {
            this.value = value;
        }
    }

    /**
     * Add element to the end.
     */
    public void add(T value) {
        Node<T> current = new Node<>(value);
        if (size == 0) {
            first = last = current;
        } else {
            last.next = current;
            last = current;
        }
        size++;
    }

    /**
     * Remove all elements from this queue.
     */
    public void clear() {
        Node<T> current = null;
        first = last = current;
        size = 0;
    }
    /**
     * Returns the number of elements in this queue.
     */
    public int size() {
        return size;
    }

    /**
     * Returns the first element from the queue.
     */
    public T peek() {
        if (first == null) {
            throw new IndexOutOfBoundsException("List is empty");
        }
        return first.value;
    }

    /**
     * Returns the first element from the queue and removes it.
     */
    public T poll() {
        if (first == null) {
            throw new IndexOutOfBoundsException("List is empty");
        }
        Node<T> current = first;
        first = first.next;
        current.next = null;
        size--;
        return current.value;
    }

    @Override
    public String toString() {
        int index = size();
        if (index == 0) {
            return "[]";
        } else {
            StringBuilder sb = new StringBuilder("[");
            MyQueue.Node<T> current = first;
            while (index != 0) {
                sb.append(current.value);
                current = current.next;
                index--;
                if (index == 0) {
                    sb.append("]");
                } else {
                    sb.append(", ");
                }
            }
            return String.valueOf(sb);
        }
    }
}
