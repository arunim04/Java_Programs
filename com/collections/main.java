package com.collections;

import java.util.*;

public class main {
    public static void main(String[] args){
        List<Integer> list=new ArrayList<>();
        List<Integer> list1=new LinkedList<>();

        list1.add(2);
        list1.add(50);
        list1.add(45);
        list1.add(70);
        System.out.println(list1);

        List<Integer> vector=new Vector<>();
        vector.add(11);
        vector.add(5);
        vector.add(71);
        vector.add(56);
        System.out.println(vector);
    }
}
