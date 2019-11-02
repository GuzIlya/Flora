package service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import service.models.Order;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findAllByCustomerNumber(String customerNumber);
    List<Order> findAllByCustomer(String customer);
    List<Order> findAllByReceiverNumber(String receiverNumber);
    List<Order> findAllByReceiver(String receiver);
    List<Order> findAllByOrderList(String orderList);
    List<Order> findAllByStatus(String status);
    List<Order> findAllByStatusAndDateIsAfter(String status, String date);
    Optional<Order> findOneById(Long id);
}
