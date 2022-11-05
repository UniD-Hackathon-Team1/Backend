package UNID_1.FloatingLetter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping(value = "hello")
    public String hello(@RequestParam(name = "hello") String map){
        return map;
    }
}
