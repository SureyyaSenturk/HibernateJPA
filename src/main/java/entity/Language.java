package entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "language")
@Data
@Table(name = "language")
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String language;

    @OneToOne(mappedBy = "language")
    private Book book;
}
