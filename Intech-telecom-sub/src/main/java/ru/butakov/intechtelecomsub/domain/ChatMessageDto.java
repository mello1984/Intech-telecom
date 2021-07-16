package ru.butakov.intechtelecomsub.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
public class ChatMessageDto {
    long id;
    long msisdn;
    String action;
    long timestamp;

    public static Purchase toPurchase(ChatMessageDto dto) {
        if (!dto.getAction().equals("PURCHASE"))
            throw new IllegalArgumentException("DTO is not purchase, dto=" + dto);

        return new Purchase(dto.id, dto.msisdn, dto.timestamp);
    }

    public static Subscription toSubscription(ChatMessageDto dto) {
        if (!dto.getAction().equals("SUBSCRIPTION"))
            throw new IllegalArgumentException("DTO is not subscription, dto=" + dto);

        return new Subscription(dto.id, dto.msisdn, dto.timestamp);
    }
}
