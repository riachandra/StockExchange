package utils;

import model.Order;

import java.util.Comparator;

public  class SellComparator implements Comparator<Order> {

    @Override
    public int compare(Order o1, Order o2) {

        int val  = Double.compare(o1.getPrice(),o2.getPrice());
        if(val==0) {
            return o1.getTime().compareTo(o2.getTime());
        } return val;

    }
}