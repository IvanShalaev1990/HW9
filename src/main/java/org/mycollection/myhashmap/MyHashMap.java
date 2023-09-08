package org.mycollection.myhashmap;

import java.util.Objects;

/**
 * MyHashMap class describes the data structure Hash Map.
 *
 * @author Shalaiev Ivan.
 * @version 1.0.0 09.09.2023
 */
public class MyHashMap<K, V> {
    private final int DEFAULT_SIZE = 8;
    private int nodeNumber;
    private int bucketsNumber = DEFAULT_SIZE;
    private Entry<K, V>[] buckets = new Entry[bucketsNumber];

    private static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    /**
     * Add a key value pair.
     */
    public void put(K key, V value) {
        int index = hashFunction(key);
        Entry<K, V> current = new Entry<>(key, value);
        if (buckets[index] == null) {
            buckets[index] = current;
        } else {
            Entry<K, V> pointer = buckets[index];
            while (pointer.next != null && !current.key.equals(pointer.next.key)) {
                pointer = pointer.next;
            }
            if (pointer.next == null && current.key.equals(pointer.key)) {
                buckets[index] = current;
            } else if (pointer.next == null) {
                pointer.next = current;
            } else {
                current.next = pointer.next.next;
                pointer.next.next = null;
                pointer.next = current;
            }
        }
        nodeNumber++;
    }

    /**
     * Remove a pair by key.
     */
    public void remove(K key) {
        int index = hashFunction(key);
        Entry<K, V> current = buckets[index];
        if (current == null) {
            throw new IndexOutOfBoundsException("This key: " + key + "doesn't exist");
        } else if (key.equals(current.key)) {
            buckets[index] = current.next;
            current.next = null;
        } else {
            while (current.next != null && !current.next.key.equals(key)) {
                current = current.next;
            }
            if (current.next == null) {
                throw new IndexOutOfBoundsException("This key: " + key + " doesn't exist");
            } else {
                current.next = current.next.next;
                current.next.next = null;
            }
        }
        nodeNumber--;
    }

    /**
     * Remove all elements from this hash map.
     */
    public void clear() {
        buckets = null;
    }

    /**
     * Returns the number of elements in this hash map.
     */
    public int size() {
        return nodeNumber;
    }

    /**
     * Returns the value by key.
     */
    public V get(K key) {
        int index = hashFunction(key);
        Entry<K, V> current = buckets[index];
        while (current != null && !current.key.equals(key)) {
            current = current.next;
        }
        if (current == null) {
            throw new IndexOutOfBoundsException("This key: " + key + " doesn't exist");
        }
        return current.value;
    }
    /**
     * Utility method that calculates the bucket number.
     */
    private int hashFunction(K key) {
        return Math.abs(Objects.hash(key) % bucketsNumber);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < buckets.length; i++) {
            Entry<K, V> current = buckets[i];
            while (current != null) {
                sb.append(current.value);
                if (current.next == null) {
                    sb.append("\n");
                } else {
                    sb.append(", ");
                }
                current = current.next;
            }
        }
        return String.valueOf(sb);
    }
}
