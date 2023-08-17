package NellDora.jpa_and_security.jpa.service;

import NellDora.jpa_and_security.jpa.dao.itemRepository.ItemRepository;
import NellDora.jpa_and_security.jpa.dto.item.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    //물품 등록
    public Item save(Item item){
        return itemRepository.save(item);
    }

    public Item find(Long id){
        return itemRepository.find(id);
    }

    public List<Item> findBySearchName(String name){
        return itemRepository.findBySearch(name);
    }

    // 구매 예약하기

}
