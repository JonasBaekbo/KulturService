package jbb.kultur.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String venue;
    private Timestamp timestamp;

    @ManyToOne
    @JsonBackReference
    private Band band;

    @OneToMany(mappedBy = "event")
    private Set<Review> reviews = new HashSet<>();
}
