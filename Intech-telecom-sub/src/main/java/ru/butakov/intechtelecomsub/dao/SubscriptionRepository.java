package ru.butakov.intechtelecomsub.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.butakov.intechtelecomsub.domain.Subscription;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
}
