package com.innowise.academy.userservice;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import com.innowise.academy.userservice.model.UserEntity;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.time.Instant;

@SpringBootTest
@Transactional
public class UserEntityAuditingTest {
    @Autowired
    private EntityManager entityManager;

    @Test
    void TimeStampUserCreation() {
        UserEntity user = new UserEntity( "Alex", "Smith", LocalDate.of(2000,1,1), "alexandros.test@example.invalid");
        entityManager.persist(user);
        entityManager.flush();
        assertNotNull(user.getCreatedAt());
        assertNotNull(user.getUpdatedAt());
    }

    @Test
    void TimeStampUserUpdate() {
        UserEntity user = new UserEntity(
                "Alex", "Smith", LocalDate.of(2000,1,1), "alexandros.test@example.invalid");
        entityManager.persist(user);
        entityManager.flush();
        Instant originalCreatedAt = user.getCreatedAt();
        Instant originalUpdatedAt = user.getUpdatedAt();
        user.setName("Alexandros");
        entityManager.flush();
        assertEquals(originalCreatedAt, user.getCreatedAt());
        assertTrue(user.getUpdatedAt().isAfter(originalUpdatedAt), " before " + originalUpdatedAt + "after " + user.getUpdatedAt());

    }

}
