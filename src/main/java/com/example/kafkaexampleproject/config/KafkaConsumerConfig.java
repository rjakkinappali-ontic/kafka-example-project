package com.example.kafkaexampleproject.config;

import com.example.kafkaexampleproject.constants.ConstantValues;
import com.example.kafkaexampleproject.model.User;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

public class KafkaConsumerConfig{
    private String bootstrapServers = ConstantValues.bootstrapServers;

    public Map<String, Object> consumerConfig(){
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        return props;
    }

    @Bean
    public ConsumerFactory<String, String> consumerFactoryString(){
        return new DefaultKafkaConsumerFactory<>(consumerConfig(), new StringDeserializer(),
                new StringDeserializer());
    }

    @Bean
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, String>> stringKafkaListenerFactory(){
        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactoryString());
        return factory;
    }

    @Bean
    public ConsumerFactory<String, User> consumerFactoryUserObject(){
        return new DefaultKafkaConsumerFactory<>(consumerConfig(), new StringDeserializer(), new JsonDeserializer<>(User.class));
    }

    @Bean
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String,User>> userKafkaListenerFactory(){
        ConcurrentKafkaListenerContainerFactory<String,User> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactoryUserObject());
        return factory;
    }
}
