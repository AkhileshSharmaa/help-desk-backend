package com.substring.helpdesk.controller;

import com.substring.helpdesk.dto.ChatRequest;
import com.substring.helpdesk.service.AI_Service;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/v1/helpdesk")
@RequiredArgsConstructor
@CrossOrigin(
        origins = "http://localhost:5173",
        allowedHeaders = "*",
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS}
)
public class AI_Controller {

    private final AI_Service service;

    @PostMapping
    public ResponseEntity<String> getResponse(@RequestBody String query , @RequestHeader("ConversationId")String conversationId) {
        return ResponseEntity.ok(
                service.getResponseFromAssistant(query, conversationId)
        );
    }
    @PostMapping(value = "/stream")
    public Flux<String> streamResponse(@RequestBody  String query, @RequestHeader("ConversationId") String conversationId){
        return this.service.streamResponseFromAssistant(query,conversationId) ;
    }
}
