package megacloud.vapeshopapi.service;

import megacloud.vapeshopapi.entity.Order;
import java.util.List;

public interface OrderService {
    List<Order> findAll();
    Order findById(Integer id);
    Order create(Order order);
    Order updateStatus(Integer id, Order.OrderStatus status);
    List<Order> findByCustomerEmail(String email);
    void delete(Integer id);
}