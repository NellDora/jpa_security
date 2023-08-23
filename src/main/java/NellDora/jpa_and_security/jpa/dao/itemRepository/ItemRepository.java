package NellDora.jpa_and_security.jpa.dao.itemRepository;

import NellDora.jpa_and_security.jpa.dao.userRepository.UpdateItemParam;
import NellDora.jpa_and_security.jpa.dto.item.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
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

    public void update(Long itemId, UpdateItemParam updateParam){
        Item findItem = manager.find(Item.class,itemId);
        findItem.setItemName(updateParam.getItemName());
        findItem.setPrice(updateParam.getPrice());
        findItem.setQuantity(updateParam.getQuantity());
        findItem.setCondition(updateParam.getCondition());

        //이게 끝임 JPA는 추가로 다시 저장 할 필요 없다
        // ->그 이유는 자동 추적해서 파악하기 때문
    }

    public Item findById(Long itemId){
        return manager.find(Item.class,itemId);
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

    // 바로 위 메소드 findBySearch의 문제점. -> itemName이 Null이면? 출력에 문제가 생김


    public List<Item> findBySearchV2(String name){
        String jpql = "select t from Item t";
        if(name!=null){
            jpql += " where t.itemName like concat('%', :itemName,'%')";
        }
        TypedQuery<Item> query = manager.createQuery(jpql,Item.class);
        if(name!=null){
            query.setParameter("itemName" , name);
        }
        List<Item> items = query.getResultList();
        return items;
        // 위 코드로 정상동작
    }


    public void delete (Long itemId){
        Item findItem = manager.find(Item.class,itemId);
        //삭제기능 (remove)를 쓰기 위해서 먼저 find로 컨텍스트로 가져와야한다.
        
        manager.remove(findItem);
        //이후 commit과 동시에 삭제
    }
}
