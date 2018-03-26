package com.spring.cloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * Created by xuwei on 2018/3/26.
 */
@RestController
@RequestMapping("consumer")
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("hello")
    public String hello(){
        ResponseEntity<Map> result = restTemplate.getForEntity("http://Producer-Service/producer/get",Map.class);
        Map user = result.getBody();
        return "hello " + user.get("name");
    }
}
