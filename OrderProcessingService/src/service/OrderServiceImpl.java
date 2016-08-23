package service;

import dao.OrderDao;
import model.Order;

public class OrderServiceImpl implements OrderService {

    private OrderDao orderDao;

    @Override
    public boolean placeOrder(Order order) {

	int result = orderDao.create(order);

	if (result == 0)
	    return false;
	else
	    return true;
    }

    @Override
    public boolean cancelOrder(int id) {

	Order order = orderDao.read(id);
	order.setStatus("Cancelled");
	int result = orderDao.update(order);

	if (result == 0)
	    return false;
	else
	    return true;
    }

    @Override
    public boolean deleteOrder(int id) {

	boolean result = orderDao.delete(id);

	if (result)
	    return true;
	else
	    return false;
    }

    /**
     * @return the orderDao
     */
    public OrderDao getOrderDao() {
	return orderDao;
    }

    /**
     * @param orderDao
     *            the orderDao to set
     */
    public void setOrderDao(OrderDao orderDao) {
	this.orderDao = orderDao;
    }

}
