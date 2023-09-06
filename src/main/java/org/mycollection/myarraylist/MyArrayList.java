package org.mycollection.myarraylist;

import java.util.Objects;

/**
 * MyArrayList class describes the data structure Array List
 *
 * @author Shalaiev Ivan
 * @version 1.0.0 04.09.2023
 */

public class MyArrayList<T> {
    public static final int START_CAPACITY = 10;
    private T[] arrays = (T[]) new Object[START_CAPACITY];
    private int size;

    public MyArrayList() {

    }

    /**
     * Add element to this list.
     */
    public void add(T value) {
        if (size == arrays.length) {
            T[] newArrays = (T[]) new Object[arrays.length * 2];
            System.arraycopy(arrays, 0, newArrays, 0, arrays.length);
            arrays = newArrays;
        }
        arrays[size++] = value;
    }

    /**
     * Removes the element at the specified index from this list.
     */
    public void remove(int index) {
        Objects.checkIndex(index, size);
        T[] newArrays = (T[]) new Object[arrays.length - 1];
        System.arraycopy(arrays, 0, newArrays, 0, index);
        System.arraycopy(arrays, index + 1, newArrays, index, size - index - 1);
        arrays = newArrays;

    }
    /**
     * Remove all elements from this list.
     */
    public void clear() {
        arrays = (T[]) new Object[0];
    }

    /**
     * Returns the number of elements in this list.
     */
    public int size() {
        return size;
    }

    /**
     * Returns the element at the specified position in this list.
     */
    public T get(int index) {
        Objects.checkIndex(index, size);
        return arrays[index];
    }
}

