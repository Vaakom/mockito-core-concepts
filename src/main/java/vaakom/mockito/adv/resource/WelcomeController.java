package vaakom.mockito.adv.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @GetMapping(path = "/welcome")
    public String getWelcome(){
        return "Hi there!";
    }
}
