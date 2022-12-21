package com.enumexamples;

public class basic {
    enum week{
        monday,tuesday,wednesday,thursday,friday,saturday,sunday
        //these are public ,static and final
        //type is week
    }

    public static void main(String[] args){
        week week = null;
        week=week.monday;

        for(week day:week.values()){
            System.out.println(day);
        }
    }
}
