public class arrays {
    public static class retailstore {
        private int[] itemid= {1001,1002,1003,1004,1005};
        private double[] price= {13.50,18.00,19.50,25.50};
        private double computeprice(int value){
            for (int i=0;i<price.length;++i){
                if(itemid[i]==value){
                    return price[i];
                }
            }
            return price[value];
        }
    }
    public static void main(String[] args){
        retailstore retailone= new retailstore();
        System.out.println("price of item id 1003 is"+retailone.computeprice(1003));
        System.out.println("price of item id 1004 is"+retailone.computeprice(1004));
        System.out.println("price of item id 1009 is"+retailone.computeprice(1009));
    }
}
