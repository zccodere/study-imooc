package com.myimooc.boot.es.simple.config;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @title ElasticSearch配置类
 * @describe ElasticSearch配置
 * @author zc
 * @version 1.0 2017-09-15
 */
@Configuration
public class EsConfig {
	
	@Bean
	public TransportClient client() throws UnknownHostException{
		InetSocketTransportAddress node = new InetSocketTransportAddress(InetAddress.getByName("localhost"),9300);
		
		Settings settings = Settings.builder()
				// es集群名称
				.put("cluster.name", "myes")
				.build();
		
		TransportClient client = new PreBuiltTransportClient(settings);
		client.addTransportAddress(node);
		
		return client;
	}
	
}
