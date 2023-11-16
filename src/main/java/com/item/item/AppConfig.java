package com.item.item;

import org.springframework.web.client.RestTemplate;

public class AppConfig {
    public RestTemplate registrRestTemplate(){
        return new RestTemplate();
    }
}
