package ru.butakov.intechtelecomsub.controllers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import ru.butakov.intechtelecomsub.domain.ChatMessageDto;
import ru.butakov.intechtelecomsub.service.MainService;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class MainControllerTest {
    @Mock
    MainService service;

    @Test
    @DisplayName("MainController.handleChatMessage return HttpStatus.OK")
    void handleChatMessage() {
        var controller = new MainController(service);
        long id = 1;
        long msisdn = 12345;
        long timestamp = 123456789;
        var dto = new ChatMessageDto(id, msisdn, "SUBSCRIPTION", timestamp);
        var expected = new Object();

        Mockito.when(service.parseAndSave(dto)).thenReturn(expected);
        var actual = controller.handleChatMessage(dto);
        assertThat(actual.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(actual.getBody()).isEqualTo(expected);
    }
}