package com.cloning;

public class human implements Cloneable{
    int age;
    String name;
    int[] arr;

    public human(int age,String name){
        this.age=age;
        this.name=name;
        this.arr=new int[]{3,4,5,6,7,8};
    }

    public human(human other){
        this.age=other.age;
        this.name=other.name;
    }

//    @Override
//    public Object clone() throws CloneNotSupportedException{
//        return super.clone();
//    }

    @Override
    public Object clone() throws CloneNotSupportedException{
        human twin=(human) super.clone();
        twin.arr=new int[twin.arr.length];
        for(int i=0;i<twin.arr.length;i++){
            twin.arr[i]=this.arr[i];
        }
        return twin;
    }
}
