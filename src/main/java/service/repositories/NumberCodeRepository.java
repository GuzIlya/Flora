package service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import service.models.NumberCode;


public interface NumberCodeRepository extends JpaRepository<NumberCode, Long> {
}
