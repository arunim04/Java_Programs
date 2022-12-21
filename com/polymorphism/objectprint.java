package com.polymorphism;

public class objectprint {
    int num;

    public  objectprint(int num){
        this.num=num;
    }

    @Override
    public  String toString(){
        return "Objectprint{"+"num"+num+"}";
    }

    public static void main(String[] args){
        objectprint obj=new objectprint(54);
        System.out.println(obj);
    }
}
