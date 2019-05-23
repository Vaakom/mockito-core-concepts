package vaakom.mockito.adv.service;

import vaakom.mockito.adv.domain.Item;

import java.util.List;

public interface ItemService {

    public Item getHardcodedItem(Long id);

    public List<Item> getAllItems();
}
