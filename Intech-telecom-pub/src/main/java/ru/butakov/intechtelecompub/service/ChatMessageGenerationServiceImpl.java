package ru.butakov.intechtelecompub.service;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import ru.butakov.intechtelecompub.aop.Loggable;
import ru.butakov.intechtelecompub.config.PubProps;
import ru.butakov.intechtelecompub.domain.ChatMessage;
import ru.butakov.intechtelecompub.domain.MessageType;

import java.time.Instant;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicLong;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Loggable
public class ChatMessageGenerationServiceImpl implements ChatMessageGenerationService {
    AtomicLong id;

    public ChatMessageGenerationServiceImpl(PubProps pubProps) {
        id = new AtomicLong(pubProps.getFirstId());
    }

    @Override
    public ChatMessage getRandomChatMessage() {
        long localId = id.getAndIncrement();
        long msisdn = ThreadLocalRandom.current().nextLong(10_000_000_000L);
        String action = ThreadLocalRandom.current().nextBoolean() ? MessageType.PURCHASE.name() : MessageType.SUBSCRIPTION.name();
        long timestamp = Instant.now().getEpochSecond();
        return new ChatMessage(localId, msisdn, action, timestamp);
    }
}
