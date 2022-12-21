package com.inheritance;

public class main {
    public static void main(String[] args){
        box box1=new box(4);
//        box box2=new box(box1);
//        System.out.println(box.l+""+box.w+""+box.h);

//        boxweight box3=new boxweight();
//        boxweight box4=new boxweight(2,3,4,8);
//        System.out.println(box3.h+""+box3.weight);
//        box box5=new boxweight(1,2,3,4);
//        System.out.println(box5.h);
//        boxprice box=new boxprice(5,8,200);
        box box=new boxweight();

        box.greeting();
    }
}
