package com.interfaces.nested;

public class a {
    public interface nestedinterface{
        boolean isodd(int num);
    }
}

class b implements a.nestedinterface{
    @Override
    public boolean isodd(int num){
        return (num & 1)==1;
    }
}


