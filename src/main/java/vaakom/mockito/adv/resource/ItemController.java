package vaakom.mockito.adv.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import vaakom.mockito.adv.domain.Item;
import vaakom.mockito.adv.service.ItemService;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping(path = "/items/{id}")
    public Item getItem(@PathVariable Long id){

        Item item = itemService.getHardcodedItem(id);

        return item;
    }

    @GetMapping(path = "/items")
    public List<Item> getAllItems(){
        return itemService.getAllItems();
    }
}
