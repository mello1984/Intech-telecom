package ru.butakov.intechtelecomsub.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.butakov.intechtelecomsub.domain.Purchase;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
}
