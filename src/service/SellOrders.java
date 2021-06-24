package service;

import model.Order;
import utils.SellComparator;
import java.util.HashMap;
import java.util.PriorityQueue;


public class SellOrders implements OrderService {

    HashMap<String, PriorityQueue<Order>> sellMap = new HashMap<>();

    @Override
    public void registerNewOrder(Order o) {
        sellMap.putIfAbsent(o.getStock(),new PriorityQueue<Order>(new SellComparator()));
        sellMap.get(o.getStock()).add(o);
    }


    @Override
    public void orderComplete(Order o) {
        sellMap.get(o.getStock()).remove(o);
    }

    @Override
    public PriorityQueue<Order> getAllOrders(String stock) {
        return sellMap.get(stock);
    }


}
