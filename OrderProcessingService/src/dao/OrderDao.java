package dao;

import model.Order;

public interface OrderDao {

    int create(Order order);

    boolean delete(int id);

    int update(Order order);

    Order read(int id);
}
