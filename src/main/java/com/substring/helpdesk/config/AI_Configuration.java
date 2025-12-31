package com.substring.helpdesk.config;

import org.slf4j.Logger;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.memory.MessageWindowChatMemory;
import org.springframework.ai.chat.memory.repository.jdbc.JdbcChatMemoryRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AI_Configuration {

    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(AI_Configuration.class);

    @Bean
    public ChatClient chatClient(ChatClient.Builder builder, JdbcChatMemoryRepository jdbcChatMemoryRepository) {

        var chatMemory=MessageWindowChatMemory.builder()
                        .chatMemoryRepository(jdbcChatMemoryRepository)
                                .maxMessages(15)
                                        .build();

        logger.info("ChatClient bean created.");
        logger.info("Chat memory bean created. {}", chatMemory.getClass().getName());

        return builder
                .defaultSystem("Summerize the response within 400 words.")
                .defaultAdvisors(new SimpleLoggerAdvisor(),
                        MessageChatMemoryAdvisor.builder(chatMemory).build())
                .build();
    }

}

