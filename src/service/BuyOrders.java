package service;

import model.Order;

import java.util.HashMap;
import java.util.PriorityQueue;
import utils.*;

public class BuyOrders implements OrderService {
    HashMap<String, PriorityQueue<Order>> buyMap = new HashMap<>();




    @Override
    public void registerNewOrder(Order o) {
        buyMap.putIfAbsent(o.getStock(),new PriorityQueue<Order>(new BuyComparator()));
        buyMap.get(o.getStock()).add(o);
    }


    @Override
    public void orderComplete(Order o) {
        buyMap.get(o.getStock()).remove(o);
    }

    @Override
    public PriorityQueue<Order> getAllOrders(String stock) {
        return buyMap.get(stock);
    }


}
