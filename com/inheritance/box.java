package com.inheritance;

public class box {
    double l;
    double h;
    double w;

    static  void greeting(){
        System.out.println("hey i am in box class greeting");
    }
    box(){
        this.h=-1;
        this.l=-1;
        this.w=-1;
    }
    box(double side){
        this.w=side;
        this.l=side;
        this.h=side;
    }
    box(double l,double h,double w){
        this.w=w;
        this.l=l;
        this.h=h;
    }
    box(box old){
        this.h=old.h;
        this.l=old.l;
        this.w=old.w;
    }
    public void information(){
        System.out.println("running the box");
    }
}
