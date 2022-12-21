package com.inheritance;

public class boxweight extends box {
    double weight;

    public boxweight(){
        this.weight=-1;
    }


    static  void greeting(){
        System.out.println("hey i am in boxweight class greeting");
    }

    boxweight(boxweight other){
        super(other);
        weight=other.weight;
    }
    boxweight(double side,double weight){
        super(side);
        this.weight=weight;
    }

    public boxweight(double l,double h,double w,double weight){
        super(l,h,w);
        //used to initialise value in parent class
        this.weight=weight;
    }
}
