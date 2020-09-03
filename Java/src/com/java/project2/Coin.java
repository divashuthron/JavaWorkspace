package com.java.project2;

import java.util.ArrayList;

public class Coin implements Comparable<Coin> {
    private int value;

    public Coin(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "" + value;
    }

    @Override
    public int compareTo(Coin c) {
        return Integer.compare(value, c.value);
    }
}
