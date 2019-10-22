package service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import service.models.PaymentMethod;

public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Long> {
}
