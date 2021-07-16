package ru.butakov.intechtelecomsub.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.butakov.intechtelecomsub.aop.Loggable;
import ru.butakov.intechtelecomsub.dao.PurchaseRepository;
import ru.butakov.intechtelecomsub.domain.Purchase;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Loggable
public class PurchaseServiceImpl implements PurchaseService {
    PurchaseRepository repository;

    @Override
    @Transactional
    public Purchase save(Purchase purchase) {
        return repository.save(purchase);
    }
}
