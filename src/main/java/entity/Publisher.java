package entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity(name = "publisher")
@Data
@Table(name = "publisher")
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

   public String publisher;

   @OneToMany(mappedBy = "publisher")
    private Set<Book> book;

}
