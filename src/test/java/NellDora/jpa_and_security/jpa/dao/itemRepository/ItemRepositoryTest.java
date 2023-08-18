package NellDora.jpa_and_security.jpa.dao.itemRepository;

import NellDora.jpa_and_security.jpa.dao.userRepository.UpdateItemParam;
import NellDora.jpa_and_security.jpa.dto.item.Condition;
import NellDora.jpa_and_security.jpa.dto.item.Item;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@Transactional
@SpringBootTest
class ItemRepositoryTest {

    @Autowired
    private ItemRepository itemRepository;

    @Test
    void updateTest() {

    }
}