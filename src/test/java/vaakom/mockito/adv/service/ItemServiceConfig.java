package vaakom.mockito.adv.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ItemServiceConfig {

    @Bean
    public ItemService itemService(){
        return new ItemServiceImpl();
    }
}
