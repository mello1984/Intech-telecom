package ru.butakov.intechtelecomsub.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.butakov.intechtelecomsub.aop.Loggable;
import ru.butakov.intechtelecomsub.domain.ChatMessageDto;
import ru.butakov.intechtelecomsub.exceptions.RequestException;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Loggable
public class MainServiceImpl implements MainService {
    PurchaseService purchaseService;
    SubscriptionService subscriptionService;

    @Override
    public Object parseAndSave(ChatMessageDto dto) {
        switch (dto.getAction()) {
            case "PURCHASE":
                return purchaseService.save(ChatMessageDto.toPurchase(dto));
            case "SUBSCRIPTION":
                return subscriptionService.save(ChatMessageDto.toSubscription(dto));
            default:
                throw new RequestException(HttpStatus.BAD_REQUEST, String.format("Type '%s' not exists", dto.getAction()));
        }
    }
}
