package NellDora.jpa_and_security.security.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int number;

    @Column(name = "name")
    private String name;

    @Column(name = "department")
    private String department;

    @OneToMany(mappedBy = "user")
    List<Authority>authorities = new ArrayList<>();

}
