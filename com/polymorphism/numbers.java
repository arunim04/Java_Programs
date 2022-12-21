package com.polymorphism;

public class numbers {
    double sum(double a,int b){
        return a+b;
    }

    double sum(int a,int b){
        return a+b;
    }

    int sum(int a,int b,int c){
        return a+b+c;
    }

    public static void main(String[] args){
        numbers obj=new numbers();
        obj.sum(2,3);
        obj.sum(1,3,7);
    }
}
