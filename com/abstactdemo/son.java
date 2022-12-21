package com.abstactdemo;

public class son extends parent {
    public son(int age){
        super(age);
    }

    @Override
    void career() {
        System.out.println("i am going to be engineer");
    }

    @Override
    void partner() {
        System.out.println("i love someone");
    }
}
