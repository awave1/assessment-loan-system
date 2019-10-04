package com.keirnellyer.glencaldy.repository;

import java.util.ArrayList;

public abstract class Repository<K, V> {
    ArrayList<V> repoContents = new ArrayList<>();

    public ArrayList<V> getAll() {
        return repoContents;
    }

    public abstract V get(K key);

    public void add(V value) {
        this.repoContents.add(value);
    }
}
