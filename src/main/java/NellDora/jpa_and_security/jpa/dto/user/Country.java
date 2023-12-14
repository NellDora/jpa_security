package NellDora.jpa_and_security.jpa.dto.user;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="country")
public class Country {

    @Id
    @Column(name = "country_id")
    private int id;

    @Column(name = "country_name")
    private String name;

    //연관관계에 있는 (ManyToOne)쪽에서 매핑한 이름값 지정
    @OneToMany(mappedBy ="country")
    private List<User> userList = new ArrayList<User>();
    //DB상의 추가 작업 필요 X.
    //자바코드만으로 구현
    
    public List<User> getUserList() {
        return userList;
    }


    public Country() {
    }

    public Country(String name) {
        this.name = name;
    }

    public Country(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
