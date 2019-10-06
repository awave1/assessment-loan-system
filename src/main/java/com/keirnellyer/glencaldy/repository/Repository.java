package com.keirnellyer.glencaldy.repository;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class Repository<K, V> {
    ArrayList<V> repoContents = new ArrayList<>();

    public ArrayList<V> getAll() {
        return repoContents;
    }

    public abstract V get(K key);

    public void add(V value) {
        this.repoContents.add(value);
    }

    @SafeVarargs
    public final void add(V... values) {
        this.repoContents.addAll(Arrays.asList(values));
    }
}
