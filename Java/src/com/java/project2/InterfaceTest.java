package com.java.project2;

import java.util.Arrays;

public class InterfaceTest {
    public static void main(String[] args) {
        Coin[] arr = {
                new Coin(10),
                new Coin(50),
                new Coin(100),
                new Coin(500)
        };

        Arrays.sort(arr);
        for (Coin n : arr) System.out.println(n);
    }
}
