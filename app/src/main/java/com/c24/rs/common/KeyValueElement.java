package com.c24.rs.common;

public class KeyValueElement<T, E> {
    private final T key;
    private final E value;

    public KeyValueElement(T key, E value) {
        this.key = key;
        this.value = value;
    }

    public T getKey() {
        return key;
    }

    public E getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.getValue().toString();
    }
}