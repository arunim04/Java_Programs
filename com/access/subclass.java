package com.access;

public class subclass extends a{
    public subclass(int num, String name) {
        super(num, name);
    }

    public static void main(String[] args){
        subclass obj=new subclass(10,"arunim");
        int n=obj.num;
    }
}
