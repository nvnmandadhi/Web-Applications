package dao;

import model.Order;

public class OrderDaoImpl implements OrderDao {

    @Override
    public int create(Order order) {
	return 1;
    }

    @Override
    public boolean delete(int id) {
	return true;
    }

    @Override
    public int update(Order order) {
	return 1;
    }

    @Override
    public Order read(int id) {
	return new Order();
    }

}
