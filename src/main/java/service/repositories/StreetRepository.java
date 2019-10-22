package service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import service.models.Street;

public interface StreetRepository extends JpaRepository<Street, Long> {
}
