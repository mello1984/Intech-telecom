package ru.butakov.intechtelecompub.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
public class ChatMessage {
    long id;
    long msisdn;
    String action;
    long timestamp;
}
