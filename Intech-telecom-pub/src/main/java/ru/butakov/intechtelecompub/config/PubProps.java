package ru.butakov.intechtelecompub.config;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "pub")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class PubProps {
    long firstId;
    String url;
    int threadCount;
}
