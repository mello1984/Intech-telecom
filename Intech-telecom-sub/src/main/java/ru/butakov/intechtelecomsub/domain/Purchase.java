package ru.butakov.intechtelecomsub.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

@Entity
@Table(name = "purchase")
public class Purchase {
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

    public Purchase(long messageId, long msisdn, long timestamp) {
        this.messageId = messageId;
        this.msisdn = msisdn;
        this.timestamp = timestamp;
    }
}
