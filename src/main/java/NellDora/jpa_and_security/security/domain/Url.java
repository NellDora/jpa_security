package NellDora.jpa_and_security.security.domain;


import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "url")
@Data
public class Url {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "num")
    private int num;

    @Column(name = "url")
    private String url;

    @OneToMany(mappedBy = "url")
    List<Authority> authorities = new ArrayList<>();

}
