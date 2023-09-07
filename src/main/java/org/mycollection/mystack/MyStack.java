package org.mycollection.mystack;


import java.util.Objects;

/**
 * MyStack class describes the data structure Stack.
 *
 * @author Shalaiev Ivan.
 * @version 1.0.0 06.09.2023
 */
public class MyStack<T> {
    private Node<T> first;
    private Node<T> last;
    private int size;

    public static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value) {
            this.value = value;
        }
    }
    /**
     * Add element to the end.
     */
    public void push(T value) {
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
     * Removes the element at the specified index from this stack.
     */
    public void remove(int index) {
        Objects.checkIndex(index, size);
        if (size == 1) {
            first = last = null;
        } else {
            Node<T> prev = getNodeByIndex(index - 1);
            prev.next = prev.next.next;
            if (prev.next == null) {
                last = prev;
            }
        }
        size--;
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
     * Returns the number of elements in this stack.
     */
    public int size() {
        return size;
    }
    /**
     * Returns the first element from the stack.
     */
    public T peek() {
        return last.value;
    }
    /**
     * Returns the first element from the stack and remove it.
     */
    public T pop() {
        T lastValue;
        if (size == 1) {
            lastValue = first.value;
            first = last = null;
        } else {
            Node<T> prev = getNodeByIndex(size() - 2);
            lastValue = last.value;
            prev.next = prev.next.next;
            last = prev;
        }
        size--;
        return lastValue;
    }
    /**
     * Utility method that returns the node under the specified index.
     */
    private Node<T> getNodeByIndex(int index) {
        Node<T> current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    @Override
    public String toString() {
        int index = size();
        if (index == 0) {
            return "[]";
        } else {
            StringBuilder sb = new StringBuilder("[");
            MyStack.Node<T> current = first;
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
