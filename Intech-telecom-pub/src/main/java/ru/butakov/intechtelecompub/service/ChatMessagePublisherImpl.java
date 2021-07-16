package ru.butakov.intechtelecompub.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import ru.butakov.intechtelecompub.aop.Loggable;
import ru.butakov.intechtelecompub.config.PubProps;
import ru.butakov.intechtelecompub.exceptions.CustomException;

@Service
@Scope("prototype")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Loggable
public class ChatMessagePublisherImpl implements ChatMessagePublisher{
    ChatMessageGenerationService generator;
    RestTemplate restTemplate;
    PubProps pubProps;
    ObjectMapper mapper;

    @Scheduled(fixedDelayString = "${pub.period}")
    public ResponseEntity<String> sendMessage()  {
        var headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        var message = generator.getRandomChatMessage();
        try {
            var messageString = mapper.writeValueAsString(message);
            HttpEntity<String> request = new HttpEntity<>(messageString, headers);
            return restTemplate.postForEntity(pubProps.getUrl(), request, String.class);
        } catch (JsonProcessingException | RestClientException e) {
            throw new CustomException(e);
        }
    }
}
