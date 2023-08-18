package NellDora.jpa_and_security.jpa.dao.userRepository;

import NellDora.jpa_and_security.jpa.dto.item.Condition;
import lombok.Data;
import lombok.RequiredArgsConstructor;


@Data
public class UpdateItemParam {


    private String itemName;

    private long price;

    private int quantity;

    private Condition condition;

    public UpdateItemParam() {
    }

    public UpdateItemParam(String itemName, long price, int quantity, Condition condition) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
        this.condition = condition;
    }
}
