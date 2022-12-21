package com.inheritance;

public class boxprice extends boxweight {
    double cost;

    boxprice(){
        super();
        this.cost=-1;
    }
    boxprice(boxprice other){
        super(other);
        this.cost= other.cost;
    }
    public boxprice(double side,double weight,double cost){
        super(side,weight);
        this.cost=cost;
    }
}
