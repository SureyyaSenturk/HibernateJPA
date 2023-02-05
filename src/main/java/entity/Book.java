package entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "book")
@Data
@Table(name = "book")
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private int pages;

    @ManyToOne
    @JoinColumn(name="author_id",nullable = false)
    private Author author;

    @ManyToOne
    @JoinColumn(name="category_id",nullable = false)
    private Category category;


    @ManyToOne
    @JoinColumn(name = "publisher_id",nullable = false)
    private Publisher publisher;

    @OneToOne
    @JoinColumn(name = "language_id",referencedColumnName = "id")
    private Language language;

    public Book(String name, int pages,Language language,Author author,
                Category category,Publisher publisher){

        this.name=name;
        this.pages=pages;
        this.language=language;
        this.author=author;
        this.category=category;
        this.publisher=publisher;
    }



}
