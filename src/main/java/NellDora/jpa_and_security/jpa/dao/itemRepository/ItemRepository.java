package NellDora.jpa_and_security.jpa.dao.itemRepository;

import NellDora.jpa_and_security.jpa.dto.item.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@RequiredArgsConstructor
@Transactional
public class ItemRepository {

    private final EntityManager manager;

    public Item save(Item item){
        manager.persist(item);
        return item;
    }

    public void update(Item item){

    }

    public Item find(Long id){
        Item item = manager.find(Item.class,id);
        return item;
    }
    public List<Item> findBySearch(String name){
        String searchQL ="select t from Item t where t.itemName like concat('%', :itemName,'%')";
        TypedQuery<Item> query = manager.createQuery(searchQL, Item.class);
        query.setParameter("itemName",name);

        //JPQL 사용시에 파라미터를 설정해야함.
        //concat(:itemName )에서 파라미터 :itemName을 서치할때 필요한입력받는 name으로 설정해주었음
        // 즉 ("파라미터", 파라미터에 대입시킬 값)

        List<Item> items = query.getResultList();

        return items;
    }
}
