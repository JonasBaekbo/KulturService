package jbb.kultur.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String venue;
    //private LocalDateTime date;

    @ManyToOne
    @JsonBackReference
    @EqualsAndHashCode.Exclude
    private Band band;
}
