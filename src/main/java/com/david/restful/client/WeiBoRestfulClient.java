package com.david.restful.client;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * 假设的WeiBo RESTful请求客户端
 */
public class WeiBoRestfulClient {

    public static String getWeibosForUsername(String username){

        ResponseEntity<String> responseEntity = new RestTemplate().getForEntity("http://localhost:8080/weibo/{username}",String.class,username);

        System.out.println(responseEntity.getStatusCode().toString());

        return new RestTemplate().getForObject("http://localhost:8080/weibo/{username}",String.class,username);

    }

    public static void main(String[] args) {

        System.out.println(getWeibosForUsername("1"));

    }

}
