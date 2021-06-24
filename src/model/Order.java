package model;

import utils.BuyComparator;
import utils.SellComparator;

import java.time.LocalTime;
import java.util.Objects;

public class Order implements Comparable<Order> {

    String orderId;
    LocalTime time;
    String stock;
    String type;
    Double price;
    int quantity;


    public Order(String orderId,LocalTime time,String stock, String type, Double price, int quantity ) {
        this.stock = stock;
        this.type = type;
        this.price = price;
        this.quantity = quantity;
        this.orderId = orderId;
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return quantity == order.quantity &&
                Objects.equals(stock, order.stock) &&
                Objects.equals(type, order.type) &&
                Objects.equals(price, order.price) &&
                Objects.equals(orderId, order.orderId) &&
                Objects.equals(time, order.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stock, type, price, quantity, orderId, time);
    }

    @Override
    public String toString() {
        return "model.Order{" +
                "stock='" + stock + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", orderId='" + orderId + '\'' +
                ", time=" + time +
                '}';
    }

    @Override
    public int compareTo(Order o) {
        int val =  this.getTime().compareTo(o.getTime());
        if(val==0) {
           val = "buy".equalsIgnoreCase(o.getType())? new BuyComparator().compare(this,o):new SellComparator().compare(this,o);
        }
        return val;
    }
}
