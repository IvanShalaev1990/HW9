package org.mycollection.myarraylist;

/**
 * MyArrayList class describes the data structure Array List
 *
 * @author Shalaiev Ivan
 * @version 1.0.0 04.09.2023
 */

public class MyArrayList<T> {
    public static final int START_CAPACITY = 10;
    private T[] arrays = (T[]) new Object[START_CAPACITY];
    private int elementsAmount;

    public MyArrayList() {

    }

    /**
     * Add element to this list.
     * Returns true if element was added in this list.
     */
    public boolean add(T value) {
        if (elementsAmount == arrays.length) {
            T[] newArrays = (T[]) new Object[arrays.length * 2];
            System.arraycopy(arrays, 0, newArrays, 0, arrays.length);
            arrays = newArrays;
        }
        arrays[elementsAmount++] = value;
        return true;
    }

    /**
     * Returns -1 if the index is greater than the elements in the array or the index is less than zero.
     * Removes the element at the specified index from this list.
     */
    public int remove(int index) {
        if (index > elementsAmount - 1 || index < 0) {
            return -1;
        }
        T[] newArrays = (T[]) new Object[arrays.length - 1];
        System.arraycopy(arrays, 0, newArrays, 0, index);
        System.arraycopy(arrays, index + 1, newArrays, index, elementsAmount - index - 1);
        arrays = newArrays;
        return 1;
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
        return elementsAmount;
    }

    /**
     * Returns the element at the specified position in this list.
     */
    public T get(int index) {
        if (index > elementsAmount - 1 || index < 0) {
            throw new IllegalArgumentException(
                    "Illegal argument " + index
            );
        }
        return arrays[index];
    }
}

