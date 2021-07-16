package ru.butakov.intechtelecomsub.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.butakov.intechtelecomsub.dao.PurchaseRepository;
import ru.butakov.intechtelecomsub.domain.Purchase;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PurchaseServiceImplTest {
    @Mock
    PurchaseRepository repository;

    @Test
    @DisplayName("PurchaseServiceImpl save Purchase correctly")
    void save() {
        var purchase = new Purchase(1,2,3);
        var expected = new Purchase(10,20,30);
        Mockito.when(repository.save(purchase)).thenReturn(expected);
        var service = new PurchaseServiceImpl(repository);
        var actual = service.save(purchase);
        assertThat(actual).isEqualTo(expected);
    }
}