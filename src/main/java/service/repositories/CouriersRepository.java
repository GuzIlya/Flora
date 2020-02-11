package service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import service.models.Courier;

public interface CouriersRepository extends JpaRepository<Courier, Long> {
}
