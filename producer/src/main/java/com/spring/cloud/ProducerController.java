package com.spring.cloud;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xuwei on 2018/3/26.
 */
@RestController
@RequestMapping("producer")
public class ProducerController {

    @Value("${my.name}")
    private String name;

    @GetMapping("get")
    public Map getProducerName(){
        Map result = new HashMap();
        result.put("name",name);

        return result;
    }
}
