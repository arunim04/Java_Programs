package com.staticexample;

public class humans {
    int age;
    String name;
    int salary;
    boolean married;
    static  long population;
    //static makes population remain same for evevry object


    public humans(int age, String name, int salary, boolean married) {
        this.age = age;
        this.name=name;
        this.salary=salary;
        this.married=married;
        humans.population+=1;

    }
}
