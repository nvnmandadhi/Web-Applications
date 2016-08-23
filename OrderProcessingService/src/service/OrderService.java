package service;

import model.Order;

public interface OrderService {

    boolean placeOrder(Order order);

    boolean cancelOrder(int id);

    boolean deleteOrder(int id);
}
