package com.abstactdemo;

public class main {
    public static void main(String[] args){
        son son=new son(30);
        son.career();
        daughter daughter=new daughter(28);
        daughter.career();

        parent mom=new parent(45) {
            @Override
            void career() {

            }

            @Override
            void partner() {

            }
        };
    }
}
