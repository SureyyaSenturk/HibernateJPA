package entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity (name = "address")
@Data
@Table(name = "address")

public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String street;
    private int zipCode;

    @OneToOne(mappedBy = "address")
    private Author author;



}
