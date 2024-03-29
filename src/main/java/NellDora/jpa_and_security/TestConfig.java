package NellDora.jpa_and_security;

import NellDora.jpa_and_security.jpa.dao.itemRepository.ItemRepository;
import NellDora.jpa_and_security.jpa.dao.userRepository.UpdateItemParam;
import NellDora.jpa_and_security.jpa.dto.item.Condition;
import NellDora.jpa_and_security.jpa.dto.item.Item;
import NellDora.jpa_and_security.jpa.dao.userRepository.UserRepository;
import NellDora.jpa_and_security.jpa.dto.user.Country;
import NellDora.jpa_and_security.jpa.dto.user.Gender;
import NellDora.jpa_and_security.jpa.dto.user.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class TestConfig {


    private final UserRepository userRepository;
    private final ItemRepository itemRepository;




    //@Bean
    public void createUser() {
        User user1 = new User("Grandon", "Logan", 33, Gender.MALE);
        User user2 = new User("Leviathan", "Noah", 24, Gender.MALE);
        User user3 = new User("scarlett", "Lucas", 20, Gender.MALE);
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
    }


//    //@Bean
//    public void createItem(){
//        Item item1 = new Item("3000mA 보조배터리",7000,"scarlett", Condition.SELL);
//        Item item2 = new Item("30000mA 보조배터리",45000,"scarlett", Condition.SELL);
//        Item item3 = new Item("10000mA 보조배터리",10000,"scarlett", Condition.SELL);
//        Item item4 = new Item("20000mA 보조배터리",22000,"scarlett", Condition.SOLDOUT);
//        Item item5 = new Item("맥북 M1 16인치",2300000,"Grandon", Condition.RESERVE);
//        Item item6 = new Item("마법의 빗자루",20000,"King", Condition.SELL);
//        Item item7 = new Item("커피머신",440000,"Leviathan", Condition.RESERVE);
//
//        itemRepository.save(item1);
//        itemRepository.save(item2);
//        itemRepository.save(item3);
//        itemRepository.save(item4);
//        itemRepository.save(item5);
//        itemRepository.save(item6);
//        itemRepository.save(item7);
//
//
//
//    }


    //@Bean
    public void searchTest() {
        List<Item> items = new ArrayList<>(itemRepository.findBySearch("보조배터리"));
        for (Item item : items) {
            System.out.println(item.getItemName());
        }
    }


    //@Transactional
    //@Bean
    public void updateTest(){
        Item updateItem = itemRepository.findById(5L);
        log.info("상품명 = {}",updateItem.getItemName());
        log.info("업데이트 전 가격 = {}",updateItem.getPrice());
        log.info("업데이트 전 수량 = {}",updateItem.getQuantity());
        log.info("업데이트 전 판매 상태 = {}",updateItem.getCondition());

        UpdateItemParam updateItemParam = new UpdateItemParam("사용감 있는 M1 맥북 16인치", 2000000,1,Condition.RESERVE);
        itemRepository.update(5L,updateItemParam);
        log.info("상품명 = {}",updateItem.getItemName());
        log.info("업데이트 후 가격 = {}",updateItem.getPrice());
        log.info("업데이트 후 수량 = {}",updateItem.getQuantity());
        log.info("업데이트 전 판매 상태 = {}",updateItem.getCondition());
   }

    //@Transactional
    //@Bean
    public void searchTestV2() {
        List<Item> items = new ArrayList<>(itemRepository.findBySearch(null));
        for (Item item : items) {
            System.out.println(item.getItemName());
        }
    }// null일 경우 출력이 되지 않음


    @Bean
    public void searchTestV3(){
        List<Item> items = new ArrayList<>(itemRepository.findBySearchV2(null));
        for (Item item: items){
            System.out.println(item.getItemName());
        }
    }//결과는 성공적 -> null이어도 정상동작
}
