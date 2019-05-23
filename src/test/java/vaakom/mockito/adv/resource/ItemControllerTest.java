package vaakom.mockito.adv.resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import vaakom.mockito.adv.domain.Item;
import vaakom.mockito.adv.service.ItemService;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ItemController.class)
public class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemService itemService;

    @Test
    public void getItemTest() throws Exception {
        when(itemService.getHardcodedItem(anyLong())).thenReturn(new Item(1L, "Ball", new BigDecimal(10), 5L));

        RequestBuilder request = MockMvcRequestBuilders.get("/items/1").accept(MediaType.APPLICATION_JSON);

        MvcResult mvcResult = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{" +
                        "    \"id\": 1," +
                        "    \"name\": \"Ball\"," +
                        "    \"price\": 10," +
                        "    \"quantity\": 5" +
                        "}"))
                .andReturn();
    }

    @Test
    public void getAllItemsTest() throws Exception {
        when(itemService.getAllItems()).thenReturn(Arrays.asList(new Item(1L, "Ball", new BigDecimal(10), 5L)));

        RequestBuilder request = MockMvcRequestBuilders.get("/items").accept(MediaType.APPLICATION_JSON);

        MvcResult mvcResult = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("[{id: 1, name: \"Ball\", price: 10, quantity: 5}]"))
                .andReturn();
    }
}