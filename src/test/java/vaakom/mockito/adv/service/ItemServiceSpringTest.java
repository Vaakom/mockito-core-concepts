package vaakom.mockito.adv.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import vaakom.mockito.adv.config.ExcludeSpringBootConfig;
import vaakom.mockito.adv.domain.Item;
import vaakom.mockito.adv.reposiory.ItemRepository;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ItemServiceConfig.class)
public class ItemServiceSpringTest {

    @Autowired
    private ItemService service;

    @MockBean
    private ItemRepository repository;

    @Test
    public void valueCalcTest() {
        when(repository.findAll()).thenReturn(Arrays.asList(new Item(1L, "Ball", new BigDecimal(10), 5L)));

        List<Item> itemList = service.getAllItems();
        assertEquals(itemList.get(0).getValue(), BigDecimal.valueOf(50));
    }
}