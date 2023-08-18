package NellDora.jpa_and_security.jpa.dto.item;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "item")
@Data
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long itemID;

    @Column(name = "item_name")
    private String itemName;

    private long price;

    private int quantity;

    @Column(name="user_id")
    private String user_id;

    @Enumerated(EnumType.STRING)
    @Column(name = "item_condition")
    private Condition condition;

    public Item(String itemName, long price,int quantity, String user_id, Condition condition) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
        this.user_id = user_id;
        this.condition = condition;
    }

    public Item() {
    }
}
