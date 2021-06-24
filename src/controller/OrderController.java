package controller;

import model.Order;
import service.BuyOrders;
import service.OrderService;
import service.SellOrders;
import utils.StockUtils;

import java.util.List;
import java.util.PriorityQueue;

public class OrderController {

    BuyOrders buyOrders = new BuyOrders();
    SellOrders sellOrders = new SellOrders();

    private void registerNewOrder(OrderService ox, Order o) {
      ox.registerNewOrder(o);

    }
    // notify All Sells and Buys whenever new Order comes
    private void notifyAllOrders(String stock, OrderService b, OrderService s) {
        PriorityQueue<Order> buys = b.getAllOrders(stock);
        PriorityQueue<Order> sells = s.getAllOrders(stock);
        if(buys==null || sells == null) return;
        while(!buys.isEmpty() && !sells.isEmpty() &&
                buys.peek().getPrice() >= sells.peek().getPrice()) {
            Order buyOrder=buys.peek();
            Order sellOrder = sells.peek();
            int bq = buyOrder.getQuantity();
            int sq = sellOrder.getQuantity();

            if(bq<=sq) {
                StockUtils.printOrder(buyOrder,sellOrder);
                b.orderComplete(buyOrder);
                sellOrder.setQuantity(sq-bq);
            }
            else {
                buyOrder.setQuantity(sq);
                StockUtils.printOrder(buyOrder,sellOrder);
                buyOrder.setQuantity(bq-sq);
                s.orderComplete(sellOrder);

            }
        }

    }
    public  void processOrders(List<Order> orders) {


        orders.stream().forEach(e->{
            if("buy".equalsIgnoreCase(e.getType())) {
               registerNewOrder(buyOrders,e);
            } else {
                registerNewOrder(sellOrders,e);
            }
            notifyAllOrders(e.getStock(),buyOrders,sellOrders);
        });
    }
}
