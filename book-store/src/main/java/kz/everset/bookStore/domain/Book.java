package kz.everset.bookStore.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity(name = "book")
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @ManyToOne
    private Author author;
    @ManyToOne
    private Category category;
    private String isbn;
    private Date published_date;
    private Double price;

}
