package utils;

import model.Order;

import java.util.Comparator;

public class BuyComparator implements Comparator<Order> {

    @Override
    public int compare(Order o1, Order o2) {
        int val  = Double.compare(o2.getPrice(), o1.getPrice());
        if(val==0) {
            return o1.getTime().compareTo(o2.getTime());
        } return val;
    }
}