package jbb.kultur.repositories;
import jbb.kultur.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {
    List<User> findBandByName(String name);

}
