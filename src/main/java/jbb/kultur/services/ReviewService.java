package jbb.kultur.services;

import jbb.kultur.models.Review;
import jbb.kultur.repositories.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


@Service
public class ReviewService implements IReviewService {

    private ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public Set<Review> findAll() {
        Set<Review> set = new HashSet<>();
        reviewRepository.findAll().forEach(set::add);
        return set;
    }

    @Override
    public Review save(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public void delete(Review review) {
        reviewRepository.delete(review);
    }

    @Override
    public void deleteById(Long aLong) {
        reviewRepository.deleteById(aLong);
    }

    @Override
    public Optional<Review> findById(Long aLong) {
        return reviewRepository.findById(aLong);
    }

}
