package utils;

import model.Order;


public class StockUtils {
    public static void printOrder(Order b, Order s) {
        System.out.println(b.getOrderId() + " "+s.getPrice()+" "+b.getQuantity()+" "+s.getOrderId());
    }

}
