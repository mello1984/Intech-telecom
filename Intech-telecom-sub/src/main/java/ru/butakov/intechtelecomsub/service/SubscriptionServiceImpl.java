package ru.butakov.intechtelecomsub.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.butakov.intechtelecomsub.aop.Loggable;
import ru.butakov.intechtelecomsub.dao.SubscriptionRepository;
import ru.butakov.intechtelecomsub.domain.Subscription;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Loggable
public class SubscriptionServiceImpl implements SubscriptionService {
    SubscriptionRepository repository;

    @Override
    @Transactional
    public Subscription save(Subscription subscription) {
        return repository.save(subscription);
    }
}
