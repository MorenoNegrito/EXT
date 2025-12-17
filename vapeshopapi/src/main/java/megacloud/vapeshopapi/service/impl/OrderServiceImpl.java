package megacloud.vapeshopapi.service.impl;

import lombok.RequiredArgsConstructor;
import megacloud.vapeshopapi.entity.Order;
import megacloud.vapeshopapi.entity.OrderItem;
import megacloud.vapeshopapi.repository.OrderRepository;
import megacloud.vapeshopapi.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository repository;

    @Override
    public List<Order> findAll() {
        return repository.findAll();
    }

    @Override
    public Order findById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado"));
    }

    @Override
    @Transactional
    public Order create(Order order) {
        // Calcular total
        double total = order.getItems().stream()
                .mapToDouble(item -> item.getPrice() * item.getQuantity())
                .sum();
        order.setTotalAmount(total);

        // Establecer relación bidireccional
        order.getItems().forEach(item -> item.setOrder(order));

        return repository.save(order);
    }

    @Override
    public Order updateStatus(Integer id, Order.OrderStatus status) {
        Order order = findById(id);
        order.setStatus(status);
        return repository.save(order);
    }

    @Override
    public List<Order> findByCustomerEmail(String email) {
        return repository.findByCustomerEmail(email);
    }

    @Override
    public void delete(Integer id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Pedido no encontrado");
        }
        repository.deleteById(id);
    }
}