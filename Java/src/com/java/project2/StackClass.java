package com.java.project2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

public class StackClass {
    public static void main(String[] args) {
        Stack s = new Stack();
        ArrayList<Coin> arrlist = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            arrlist.add(new Coin(sc.nextInt()));
            s.push(arrlist.get(i).getValue());
        }

        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }

        Iterator<Coin> it = arrlist.iterator();
        while(it.hasNext()) {
            Coin c = it.next();
            System.out.println(c);
        }
    }
}
