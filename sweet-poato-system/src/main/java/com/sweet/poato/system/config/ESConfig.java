package com.sweet.poato.system.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;

/**
 * @author The Sunshine
 * @version 1.0
 * @date 2023/5/23 15:26
 */
public class ESConfig {

    @Bean
    public RestHighLevelClient getRestHighLevelClient(){
        HttpHost httpHost = new HttpHost("192.168.3.110", 9200, "http");
        RestClientBuilder restClientBuilder = RestClient.builder(httpHost);
        RestHighLevelClient restHighLevelClient = new
                RestHighLevelClient(restClientBuilder);
        return restHighLevelClient;
    }


}
