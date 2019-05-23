package vaakom.mockito.adv.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import vaakom.mockito.adv.domain.Item;
import vaakom.mockito.adv.reposiory.ItemRepository;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ItemServiceNoSpringFastTest {

    @InjectMocks
    private ItemServiceImpl service;

    @Mock
    private ItemRepository repository;

    @Test
    public void valueCalcTest() {
        when(repository.findAll()).thenReturn(Arrays.asList(new Item(1L, "Ball", new BigDecimal(10), 5L)));

        List<Item> itemList = service.getAllItems();
        assertEquals(itemList.get(0).getValue(), BigDecimal.valueOf(50));
    }
}