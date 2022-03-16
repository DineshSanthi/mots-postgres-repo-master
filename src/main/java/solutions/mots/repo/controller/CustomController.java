package solutions.mots.repo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomController {

    @RequestMapping(value = "/custom")
    @GetMapping
    public String custom() {
        return "custom";
    }
}