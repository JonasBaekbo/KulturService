package jbb.kultur.repositories;

import jbb.kultur.models.Band;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BandRepository extends JpaRepository<Band,Long> {
}
