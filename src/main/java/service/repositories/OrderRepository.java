package service.repositories;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import service.models.Order;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findAllByCustomerNumber(String customerNumber);
    List<Order> findAllByCustomer(String customer);
    List<Order> findAllByReceiverNumber(String receiverNumber);
    List<Order> findAllByReceiver(String receiver);
    Optional<Order> findOneById(Long id);
}
