package jbb.kultur.services;

import jbb.kultur.models.Band;
import jbb.kultur.models.User;
import jbb.kultur.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service  // gør at Spring "ser" denne klasse
public class UserService implements IUserService{
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Set<User> findAll() {
        return null;
    }

    @Override
    public User save(User object) {
        return userRepository.save(object);
    }

    @Override
    public void delete(User object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public Optional<User> findById(Long aLong) {
        return userRepository.findById(aLong);
    }

    @Override
    public List<User> findUserByName(String name) {
        return userRepository.findBandByName(name);
    }
}