package com.example.hashmap;

public class MyHashMap<K, V> {

    private static final int SIZE = 500;
    private Entry<K, V> table[];

    public MyHashMap() {
        table = new Entry[SIZE];
    }

    public void put(K key, V value) {
        int hash = (key.hashCode() & 0x7fffffff) % SIZE;
        
        // Retrieves the first entry alocated to the table for the key
        
        Entry<K, V> e = table[hash];

        // First time inserting a value into the linked list
        if(e == null) {
            table[hash] = new Entry<K, V>(key, value);
            return;
        }

        while(e.next != null) {
            if(e.getKey() == key) {
                e.setValue(value);
                return;
            }
            e = e.next;
        }

        if(e.getKey() == key) {
            e.setValue(value);
            return;
        }

        e.next = new Entry<K, V>(key, value);
    }

    public V get(K key) {
        int hash = (key.hashCode() & 0x7fffffff) % SIZE;
        // Retrieves the first entry alocated to the table for the key
        Entry<K, V> e = table[hash];

        if(e == null) {
            return null;
        }

        while(e.next != null) {
            if(e.getKey() == key) {
                return e.getValue();
            }
            e = e.next;
        }

        return null;
    }

    public void remove(K key) {
        int hash = (key.hashCode() & 0x7fffffff) % SIZE;
      
        // Retrieves the first entry alocated to the table for the key
        Entry<K, V> e = table[hash];

        if(e == null) {
            return;
        }

        if(e.getKey() == key) {
            table[hash] = e.next;
            e.next = null;
            return;
        }

        Entry<K, V> prev = e;
        e = e.next;

        while(e != null) {

            if(e.getKey() == key) {
                prev.next = e.next;
                e.next = null;
                return;
            }
            prev = e;
            e = e.next;
        }

        return;

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < SIZE; i++) {
            if(table[i] != null) {
                sb.append(i + " " + table[i] + "\n");
            }else{
                sb.append(i + " " + "null" + "\n");
            }
        }
        return sb.toString();
    }
}
