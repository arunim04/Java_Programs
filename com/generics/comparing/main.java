package com.generics.comparing;

import java.util.ArrayList;
import java.util.Arrays;

public class main {
    public static void main(String[] args){
        student arunim=new student(15,90.75f);
        student arohi=new student(16,95.75f);
        student ankit=new student(17,86.75f);
        student nidhi=new student(18,97.75f);
        student prachi=new student(19,78.75f);

        student[] list={arunim,arohi,ankit,nidhi,prachi};
        System.out.println(Arrays.toString(list));
        Arrays.sort(list);
        System.out.println(Arrays.toString(list));

//        if(arunim.compareTo(arohi)<0){
//            System.out.println("Arunim has more marks");
//        }
    }
}
