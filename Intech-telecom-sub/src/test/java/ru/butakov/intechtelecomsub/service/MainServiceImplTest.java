package ru.butakov.intechtelecomsub.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.butakov.intechtelecomsub.domain.ChatMessageDto;
import ru.butakov.intechtelecomsub.domain.Purchase;
import ru.butakov.intechtelecomsub.domain.Subscription;
import ru.butakov.intechtelecomsub.exceptions.RequestException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class MainServiceImplTest {
    @Mock
    PurchaseService purchaseService;
    @Mock
    SubscriptionService subscriptionService;

    @Test
    @DisplayName("MainServiceImpl return correct Purchase")
    void parseAndSave_thenReturnPurchase() {
        long id = 1;
        long msisdn = 12345;
        long timestamp = 123456789;
        var dto = new ChatMessageDto(id, msisdn, "PURCHASE", timestamp);
        var expected = new Purchase(id, msisdn, timestamp);

        var service = new MainServiceImpl(purchaseService, subscriptionService);
        Mockito.when(purchaseService.save(Mockito.any())).thenReturn(expected);

        var actual = service.parseAndSave(dto);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("MainServiceImpl return correct Subscription")
    void parseAndSave_thenReturnSubscription() {
        long id = 1;
        long msisdn = 12345;
        long timestamp = 123456789;
        var dto = new ChatMessageDto(id, msisdn, "SUBSCRIPTION", timestamp);
        var expected = new Subscription(id, msisdn, timestamp);

        var service = new MainServiceImpl(purchaseService, subscriptionService);
        Mockito.when(subscriptionService.save(Mockito.any())).thenReturn(expected);

        var actual = service.parseAndSave(dto);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("MainServiceImpl throws Exception when dto is not correct")
    void parseAndSave_thenExceptionThrows() {
        long id = 1;
        long msisdn = 12345;
        long timestamp = 123456789;
        String action = "La-la-la";
        var dto = new ChatMessageDto(id, msisdn, action, timestamp);
        var service = new MainServiceImpl(purchaseService, subscriptionService);

        assertThatThrownBy(() -> service.parseAndSave(dto))
                .isInstanceOf(RequestException.class)
                .hasMessageContaining("400 BAD_REQUEST")
                .hasMessageContaining("Type '" + action + "' not exists");
    }
}