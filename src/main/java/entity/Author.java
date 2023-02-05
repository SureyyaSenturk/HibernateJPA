package entity;


import jakarta.persistence.*;
import lombok.Data;
import java.util.Set;


@Entity(name="author")
@Data
@Table(name="author")

public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
   private String name;
   private int age;

   @OneToMany(mappedBy = "author")
    private Set<Book> book;
    @OneToOne
    @JoinColumn(name = "address_id",referencedColumnName = "id")
    private Address address;

}
