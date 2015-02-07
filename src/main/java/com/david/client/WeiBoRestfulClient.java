package com.david.client;


import com.david.model.Weibo;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by caiwei on 2015/2/7.
 */
public class WeiBoRestfulClient {

    public static String getWeibosForUsername(String username){
        return new RestTemplate().getForObject("http://localhost:8080/weibo/{username}",String.class,username);
    }

    public static void main(String[] args) {
        System.out.println(getWeibosForUsername("1"));
    }
}
