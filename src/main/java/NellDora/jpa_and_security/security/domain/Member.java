package NellDora.jpa_and_security.security.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "member")
@Data
public class Member {

    @Id
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name = "department")
    private String department;

    @OneToMany(mappedBy = "member")
    List<Authority>authorities = new ArrayList<>();

}
