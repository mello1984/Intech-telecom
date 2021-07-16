package ru.butakov.intechtelecompub.service;

import ru.butakov.intechtelecompub.domain.ChatMessage;

public interface ChatMessageGenerationService {
    ChatMessage getRandomChatMessage();
}
