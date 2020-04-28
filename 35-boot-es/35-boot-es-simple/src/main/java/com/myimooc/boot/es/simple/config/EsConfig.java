package com.myimooc.boot.es.simple.config;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * ElasticSearch配置类
 *
 * @author zc 2017-09-15
 */
@Configuration
public class EsConfig {

    @Bean
    public TransportClient client() throws UnknownHostException {
        TransportAddress node = new TransportAddress(InetAddress.getByName("localhost"), 9300);

        Settings settings = Settings.builder()
                // es集群名称
                .put("cluster.name", "myes")
                .build();

        TransportClient client = new PreBuiltTransportClient(settings);
        client.addTransportAddress(node);

        return client;
    }

}
