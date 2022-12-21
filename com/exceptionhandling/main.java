package com.exceptionhandling;

public class main {
    public static void main(String[] args) {
        int a = 5;
        int b = 0;
        try {
//            divide(a,b);
            String name="aruuu";
            if (name.equals("aruuu")){
                throw new myexception("name is aruuu");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("this will always execute");
        }
    }
    static int divide(int a,int b) throws ArithmeticException{
        if(b==0){
            throw new ArithmeticException("please do not divide by zero");
        }
        return a/b;
    }
}
