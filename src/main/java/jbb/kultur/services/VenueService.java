package jbb.kultur.services;

import jbb.kultur.models.Venue;
import jbb.kultur.repositories.UserRepository;
import jbb.kultur.repositories.VenueRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service  // gør at Spring "ser" denne klasse
public class VenueService implements IVenueService{
    private VenueRepository venueRepository;

    public VenueService(VenueRepository VenueRepository) {
        this.venueRepository = VenueRepository;
    }
    @Override
    public Set<Venue> findAll() {
        return null;
    }

    @Override
    public Venue save(Venue object) {
        return venueRepository.save(object);
    }

    @Override
    public void delete(Venue object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public Optional<Venue> findById(Long aLong) {
        return venueRepository.findById(aLong);
    }
}
