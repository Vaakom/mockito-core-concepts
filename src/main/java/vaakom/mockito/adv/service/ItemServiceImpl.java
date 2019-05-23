package vaakom.mockito.adv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vaakom.mockito.adv.domain.Item;
import vaakom.mockito.adv.reposiory.ItemRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository repository;

    @Override
    public Item getHardcodedItem(Long id) {
        return new Item(1L, "Ball", new BigDecimal(10), 5L);
    }

    @Override
    public List<Item> getAllItems() {
        return repository.findAll().stream()
                .peek((item) -> item.setValue(item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity())))).collect(Collectors.toList());
    }
}
