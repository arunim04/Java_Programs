package com.access;

public class a {
    public int num;
    String name;
    int[] arr;

    public int getNum(){
        return num;
    }

    public void setNum(int num){
        this.num=num;
    }

    public  a(int num,String name){
        this.num=num;
        this.name=name;
        this.arr=new int[num];
    }
}
