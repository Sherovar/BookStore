package kz.everset.bookStore.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class PeperItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
