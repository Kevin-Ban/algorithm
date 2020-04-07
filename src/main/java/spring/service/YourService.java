package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class YourService {

    @Autowired
    private MyService myService;

    private String field = "yourService";
}
