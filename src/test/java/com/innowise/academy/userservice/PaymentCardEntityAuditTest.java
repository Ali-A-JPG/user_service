package com.innowise.academy.userservice;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.innowise.academy.userservice.model.PaymentCardEntity;
import com.innowise.academy.userservice.model.UserEntity;
import jakarta.persistence.EntityManager;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
@SpringBootTest
@Transactional
public class PaymentCardEntityAuditTest {
    @Autowired
    private EntityManager entityManager;

    @Test
    public void TimestampPaymentCreated(){
        UserEntity user = new UserEntity("Alexandros", "smith", LocalDate.of(2000,1,1), "alexandros.cardtest@example.invalid");
        entityManager.persist(user);
        PaymentCardEntity card = new PaymentCardEntity( user, "0000000000000000", "Alexandros Smith", LocalDate.of(2030, 12, 31));
        entityManager.persist(card);
        entityManager.flush();
        assertNotNull(card.getId());
        assertNotNull(card.getUser().getCreatedAt());
        assertNotNull(card.getUser().getUpdatedAt());
        assertEquals(user.getId(), card.getUser().getId());
    }
}
