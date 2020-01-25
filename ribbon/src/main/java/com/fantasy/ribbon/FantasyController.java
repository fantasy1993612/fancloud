package com.fantasy.ribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FantasyController {

    @Autowired
    private FantasyRibbonService fantasyRibbonService;


    @GetMapping(value = "/hi")
    public String hi(@RequestParam String name){
        return fantasyRibbonService.hiService(name);
    }

}
