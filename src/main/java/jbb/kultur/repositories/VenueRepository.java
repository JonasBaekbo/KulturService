package jbb.kultur.repositories;

import jbb.kultur.models.User;
import jbb.kultur.models.Venue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VenueRepository extends JpaRepository<Venue,Long> {

}
