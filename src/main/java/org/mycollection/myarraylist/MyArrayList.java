package org.mycollection.myarraylist;

import java.util.Arrays;

public class MyArrayList<T> {
    public static final int START_CAPACITY = 10;
    private T[] arrays = (T[]) new Object[START_CAPACITY];
    private int elementsAmount;

    public MyArrayList() {

    }


    public boolean add(T value) {
        if (elementsAmount == arrays.length) {
            T[] newArrays = (T[]) new Object[arrays.length * 2];
            System.arraycopy(arrays, 0, newArrays, 0, arrays.length);
            arrays = newArrays;
        }
        arrays[elementsAmount++] = value;
        return true;
    }

    public int remove(int index) {
        if (index >= arrays.length) {
            return -1;
        }
        T[] newArrays = (T[]) new Object[arrays.length - 1];
        System.arraycopy(arrays, 0, newArrays, 0, index);
        System.arraycopy(arrays, index + 1, newArrays, index, elementsAmount - index - 1);
        arrays = newArrays;
        return 1;
    }

    public void clear() {
        arrays = (T[]) new Object[0];
    }

    public int size() {
        return elementsAmount;
    }

    public T get(int index) {
        if (index > elementsAmount - 1){
            throw new IllegalArgumentException(
                    "Illegal argument " + index
            );
        }
        return arrays[index];
    }
}

