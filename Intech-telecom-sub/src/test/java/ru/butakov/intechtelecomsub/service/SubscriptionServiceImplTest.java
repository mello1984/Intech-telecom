package ru.butakov.intechtelecomsub.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.butakov.intechtelecomsub.dao.SubscriptionRepository;
import ru.butakov.intechtelecomsub.domain.Purchase;
import ru.butakov.intechtelecomsub.domain.Subscription;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class SubscriptionServiceImplTest {
    @Mock
    SubscriptionRepository repository;

    @Test
    @DisplayName("SubscriptionServiceImpl save Subscription correctly")
    void save() {
        var subscription = new Subscription(1, 2, 3);
        var expected = new Subscription(10, 20, 30);
        Mockito.when(repository.save(subscription)).thenReturn(expected);
        var service = new SubscriptionServiceImpl(repository);
        var actual = service.save(subscription);
        assertThat(actual).isEqualTo(expected);
    }
}