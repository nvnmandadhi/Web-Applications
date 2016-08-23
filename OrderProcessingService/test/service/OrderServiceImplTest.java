/**
 * 
 */
package service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import dao.OrderDao;
import model.Order;

/**
 * @author Naveen
 *
 */
public class OrderServiceImplTest {

    @Mock
    OrderDao orderDao;

    OrderServiceImpl orderService;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {

	MockitoAnnotations.initMocks(this);

	orderService = new OrderServiceImpl();

	orderService.setOrderDao(orderDao);
    }

    /**
     * Test method for {@link service.OrderServiceImpl#placeOrder(model.Order)}.
     */
    @Test
    public void testPlaceOrder() {

	Order order = new Order();

	when(orderDao.create(order)).thenReturn(new Integer(1));

	boolean result = orderService.placeOrder(order);

	assertTrue(result);
    }

    @Test
    public void testPlaceOrder_false() {

	Order order = new Order();

	when(orderDao.create(order)).thenReturn(new Integer(0));

	boolean result = orderService.placeOrder(order);

	assertFalse(result);
    }

    /**
     * Test method for {@link service.OrderServiceImpl#cancelOrder(int)}.
     */
    @Test
    public void testCancelOrder() {

	Order order = new Order();

	int id = order.getId();

	when(orderDao.read(id)).thenReturn(order);

	when(orderDao.update(order)).thenReturn(new Integer(1));

	boolean result = orderService.cancelOrder(id);

	assertTrue(result);

	verify(orderDao).read(id);

	verify(orderDao).update(order);
    }

    @Test
    public void testCancelOrder_false() {

	Order order = new Order();

	int id = order.getId();

	when(orderDao.read(id)).thenReturn(order);

	when(orderDao.update(order)).thenReturn(new Integer(0));

	boolean result = orderService.cancelOrder(id);

	assertFalse(result);

	verify(orderDao).read(id);

	verify(orderDao).update(order);
    }

    /**
     * Test method for {@link service.OrderServiceImpl#deleteOrder(int)}.
     */
    @Test
    public void testDeleteOrder() {

	int id = 0;

	when(orderDao.delete(id)).thenReturn(true);

	boolean result = orderService.deleteOrder(id);

	assertTrue(result);
    }

    @Test
    public void testDeleteOrder_false() {

	int id = 0;

	when(orderDao.delete(id)).thenReturn(false);

	boolean result = orderService.deleteOrder(id);

	assertFalse(result);
    }

}
