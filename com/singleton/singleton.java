package com.singleton;

public class singleton {
    private singleton(){

    }

    private static singleton instance;
    public static singleton getinstance(){
        if(instance==null){
            instance=new singleton();
        }
        return instance;
    }
}
