package ru.butakov.intechtelecomsub.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ChatMessageDtoTest {

    @Test
    @DisplayName(value = "ChatMessageDto.toPurchase() return correct Purchase")
    void toPurchase_whenCorrect_thenSuccessful() {
        long id = 1;
        long msisdn = 12345;
        long timestamp = 123456789;
        var dto = new ChatMessageDto(id, msisdn, "PURCHASE", timestamp);
        var expected = new Purchase(id, msisdn, timestamp);
        var actual = ChatMessageDto.toPurchase(dto);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName(value = "ChatMessageDto.toPurchase() throws exception when invalid")
    void toPurchase_whenWrong_thanThrowsException() {
        long id = 1;
        long msisdn = 12345;
        long timestamp = 123456789;
        var dto = new ChatMessageDto(id, msisdn, "SUBSCRIPTION", timestamp);

        assertThatThrownBy(() -> ChatMessageDto.toPurchase(dto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("DTO is not purchase, dto=" + dto);
    }

    @Test
    @DisplayName(value = "ChatMessageDto.toSubscription() return correct Subscription")
    void toSubscription_whenCorrect_thenSuccessful() {
        long id = 1;
        long msisdn = 12345;
        long timestamp = 123456789;
        var dto = new ChatMessageDto(id, msisdn, "SUBSCRIPTION", timestamp);
        var expected = new Subscription(id, msisdn, timestamp);
        var actual = ChatMessageDto.toSubscription(dto);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName(value = "ChatMessageDto.toSubscription() throws exception when invalid")
    void toSubscription_whenWrong_thanThrowsException() {
        long id = 1;
        long msisdn = 12345;
        long timestamp = 123456789;
        var dto = new ChatMessageDto(id, msisdn, "PURCHASE", timestamp);

        assertThatThrownBy(() -> ChatMessageDto.toSubscription(dto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("DTO is not subscription, dto=" + dto);
    }
}