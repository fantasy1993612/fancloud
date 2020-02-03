package com.fantasy.eurekaclient.controller;

import com.fantasy.eurekaclient.model.dto.ActivityDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/activity")
public class ActivityController {


    @GetMapping("/queryActivity")
    public ActivityDto queryActivityInfo(){
        return null;
    }
}
