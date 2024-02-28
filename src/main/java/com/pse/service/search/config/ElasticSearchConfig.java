package com.pse.service.search.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchConfiguration;
import reactor.util.annotation.NonNull;

@Configuration
public class ElasticSearchConfig extends ElasticsearchConfiguration {

    @Override
    @NonNull
    public ClientConfiguration clientConfiguration() {
        return ClientConfiguration.builder()
                .connectedTo("localhost:9200")
                .usingSsl("8c2958798c21884d4a71e00971180740843719b9bd59455bda0fe102309592e6")
                .withBasicAuth("elastic", "OdVI3onB7g3qggl70yz2")
                .build();
    }
}
