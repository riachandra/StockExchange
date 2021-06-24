import controller.OrderController;
import model.Order;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StockExchange {
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new FileReader("resources/file.txt"));
        List<Order> orders = new ArrayList<>();
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                String[] data = line.split("\\s+");
                Order order;
                try {
                    order = new Order(data[0], LocalTime.parse(data[1]),data[2],data[3],Double.valueOf(data[4]),Integer.valueOf(data[5]));
                    orders.add(order);
                } catch(Exception e) {
                    System.out.println("Couldn't process order "+ line);
                }
                line = br.readLine();

            }
            Collections.sort(orders);
            OrderController controller = new OrderController();
            controller.processOrders(orders);
        } finally {
            br.close();
        }
    }


}
