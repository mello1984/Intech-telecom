package ru.butakov.intechtelecompub.service;

import org.springframework.http.ResponseEntity;

public interface ChatMessagePublisher {
    ResponseEntity<String> sendMessage();
}
