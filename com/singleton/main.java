package com.singleton;

import com.access.a;

public class main {
    public static void main(String[] args){
        singleton obj1=singleton.getinstance();
        singleton obj2=singleton.getinstance();
        singleton obj3=singleton.getinstance();

        a a=new a(10,"Arunim");
        a.getNum();
        int n=a.num;

    }
}
