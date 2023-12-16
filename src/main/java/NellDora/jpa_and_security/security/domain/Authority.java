package NellDora.jpa_and_security.security.domain;

import lombok.Data;

import javax.persistence.*;


@Entity
@Table(name = "authority")
@Data
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int num;

    @ManyToOne
    @JoinColumn(name = "url")
    private String url;

    @ManyToOne
    @JoinColumn(name = "user")
    private Member member;
}
