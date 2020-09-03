package com.java.project2;

import java.util.ArrayList;
import java.util.Arrays;

public class InterfaceTest {
    public static void main(String[] args) {
        Coin[] arr = new Coin[5];
        arr[0] = new Coin(100);

        ArrayList<Coin> arrList = new ArrayList<>();
        arrList.add(new Coin(100));
        arrList.add(new Coin(50));
        arrList.add(new Coin(300));

        arrList.add(1, new Coin(200));

        Coin c = arrList.get(2);
        System.out.println("2번 인덱스의 값 : " + c.getValue());

        arrList.clear();

        /*
        Arrays.sort(arrList);
        for (Coin n : arrList) System.out.println(n);
         */
    }
}
