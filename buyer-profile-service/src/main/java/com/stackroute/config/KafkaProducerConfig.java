package com.stackroute.config;

import com.stackroute.kafka.BuyerDto;
import com.stackroute.kafka.BuyerRecomDto;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerConfig {

    /*configuration for kafka producer for producing buyer Dto*/

    @Bean
    public ProducerFactory<String, BuyerDto> producerFactoryBuyerDto(){
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return new DefaultKafkaProducerFactory<>(configProps);
    }

    @Bean
    public KafkaTemplate<String, BuyerDto> kafkaTemplate(){
        return new KafkaTemplate<>(producerFactoryBuyerDto());
    }

    /*configuration for kafka producer for producing buyer Recommendation Dto*/

    @Bean
    public ProducerFactory<String, BuyerRecomDto> producerFactoryBuyerRecomDto(){
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return new DefaultKafkaProducerFactory<>(configProps);
    }

    @Bean
    public KafkaTemplate<String, BuyerRecomDto> kafkaTemplate1(){
        return new KafkaTemplate<>(producerFactoryBuyerRecomDto());
    }


}
