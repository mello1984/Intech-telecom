package ru.butakov.intechtelecomsub.service;

import ru.butakov.intechtelecomsub.domain.ChatMessageDto;

public interface MainService {
    Object parseAndSave(ChatMessageDto dto);
}
