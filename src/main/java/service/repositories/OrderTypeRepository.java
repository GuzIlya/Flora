package service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import service.models.OrderType;

public interface OrderTypeRepository extends JpaRepository<OrderType, Long> {
}
