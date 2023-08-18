package NellDora.jpa_and_security.jpa.dto.user;

import lombok.Data;

import javax.persistence.*;

@Entity//JPA 사용하기 위해 필요한 어노테이션. Entuty가 붙은 클래스는 JPA가 관리한다.
@Table(name="user") //앤티티와 연결할 DB 테이블을 지정하는 어노테이션
@Data
public class User {

    //@Id
    //@Column(name="code")
    //@GeneratedValue(strategy = GenerationType.IDENTITY) //MySQL에서 AUTO_Increment와 동일한 기능
    //GenerationType.AUTO -> DB 타입에 따라 자동으로 설정
    //private Long code;

    @Id
    @Column(name="user_id")
    private String UserId;

    @Column(name="user_name")//@column : 매핑할 테이블 이름 지정
    private String userName;

    private int age;

    @Enumerated(EnumType.STRING) //DB에 ENUM 명으로 저장
    private Gender gender;

    //@ManyToMany
    //@JoinColumn(name="COUNTRY_ID")
    @Column(name = "country_id")
    @Enumerated(EnumType.STRING)
    private Country country;
    //DB에 따로 나라별 유저 테이블 등록을 위해

    @Column(name="level")
    private int Level;

    @Column(name="exp")
    private int EXP;


    
    /*
    @ManyToOne : N:1 매핑 -> 간단히 말해서 여러 테이블에 한번에 생성되어야할 경우에 사용되는 어노테이션
    @JoinColumn : 외래 키 매핑시에 사용
     [@ManyToOne 이랑 @JoinColumn은 한쌍으로 다닌다고 봐야하는듯
     */

    public User(String userId, String userName, int age, Gender gender, Country country) {
        this.UserId = userId;
        this.userName = userName;
        this.age = age;
        this.gender = gender;
        this.country = country;
    }
}
