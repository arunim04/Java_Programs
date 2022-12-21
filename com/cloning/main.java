package com.cloning;

import java.util.Arrays;

public class main {
    public static void main(String[] args) throws CloneNotSupportedException {
        human arunim=new human(34,"arunim");
//        human twin=new human(arunim);
        human twin=(human) arunim.clone();
        System.out.println(twin.age+""+twin.name);
        System.out.println(Arrays.toString(twin.arr));
        twin.arr[0]=100;
        System.out.println(Arrays.toString(arunim.arr));
    }
}
