package com.fantasy.feign;

import org.springframework.stereotype.Component;

@Component
public class FantasyFeignServiceImpl implements FantasyFeignService{

    @Override
    public String sayHi(String name) {
        return "sorry error page !";
    }
}
