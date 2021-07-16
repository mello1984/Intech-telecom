package ru.butakov.intechtelecomsub.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

@Entity
@Table(name = "subscription")
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    long id;

    @Column(name = "message_id")
    long messageId;

    @Column(name = "msisdn")
    long msisdn;

    @Column(name = "timestamp")
    long timestamp;

    public Subscription(long messageId, long msisdn, long timestamp) {
        this.messageId = messageId;
        this.msisdn = msisdn;
        this.timestamp = timestamp;
    }
}
