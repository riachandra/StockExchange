package service;


import model.Order;

import java.util.PriorityQueue;

public interface OrderService {



    void registerNewOrder(Order o);


    void orderComplete(Order o);

    PriorityQueue<Order> getAllOrders(String stock);

}
