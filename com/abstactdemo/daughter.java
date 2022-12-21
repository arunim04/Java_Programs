package com.abstactdemo;

public class daughter extends parent {
    public daughter(int age){
        super(age);
    }

    @Override
    void career() {
        System.out.println("i am going to be a doctor");
    }

    @Override
    void partner() {
        System.out.println("i love him");
    }
}
