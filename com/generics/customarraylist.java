package com.generics;

import java.util.ArrayList;
import java.util.Arrays;

public class customarraylist<t> {
    private Object[] data;
    private static int defaultsize=10;
    private int size=0;
    public customarraylist(){
        this.data=new Object[defaultsize];
    }

    public void add(t num){
        if(isFull()){
            resize();
        }
        data[size++]=num;
    }

    private void resize() {
        Object[] temp= new Object[data.length*2];
        for(int i=0;i<data.length;i++){
            temp[i]=data[i];
        }
        data=temp;
    }

    private boolean isFull(){
        return size==data.length;
    }

    public t remove(){
        t removed=(t)(data[--size]);
        return removed;
    }

    public t get(int index){
        return (t)data[index];
    }

    public int size(){
        return size;
    }

    public void set(int index,t value){
        data[index]=value;
    }

    @Override
    public String toString() {
        return "customarraylist{" +
                "data=" + Arrays.toString(data) +
                ", size=" + size +
                '}';
    }

    public static void main(String[] args){
//        ArrayList list =new ArrayList();
        customarraylist list=new customarraylist();
//        list.add(3);
//        list.add(5);
//        list.add(9);

//        for (int i=0;i<14;i++){
//            list.add(2*i);
//        }
//        System.out.println(list);
        customarraylist<Integer> list1=new customarraylist<>();
        list1.add(45);
        customarraylist<Integer> list2=new customarraylist<>();
        for(int i=0;i<14;i++){
            list2.add(2*i);
        }
        System.out.println(list2);
    }
}
