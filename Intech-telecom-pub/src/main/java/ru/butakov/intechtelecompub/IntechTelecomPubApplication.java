package ru.butakov.intechtelecompub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.butakov.intechtelecompub.service.ChatMessagePublisher;

@SpringBootApplication
public class IntechTelecomPubApplication {

    public static void main(String[] args) {
       ApplicationContext context= SpringApplication.run(IntechTelecomPubApplication.class, args);

        for (int i = 0; i < 5; i++) {
            context.getBean(ChatMessagePublisher.class);
        }
    }
}
