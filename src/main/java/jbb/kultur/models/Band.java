package jbb.kultur.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Band {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "band")
    private Set<Event> events = new HashSet<>();

    @ManyToMany(mappedBy = "bandsLiked")
    @JsonBackReference
    private Set<User> userLikes = new HashSet<>();
}