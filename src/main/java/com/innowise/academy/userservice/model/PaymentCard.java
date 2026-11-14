package com.innowise.academy.userservice.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table( name = "payment_cards")
public class PaymentCard extends AuditableEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "number", nullable = false, length = 32)
    private String number;

    @Column(name = "holder", nullable = false, length = 255)
    private String holder;

    @Column(name =  "expiration_date", nullable = false)
    private LocalDate expirationDate;

    @Column(name = "active", nullable = false)
    private boolean active;

    protected PaymentCard() {
    }

    public PaymentCard(User user, String number, String holder, LocalDate expirationDate) {
        this.user = user;
        this.number = number;
        this.holder = holder;
        this.expirationDate = expirationDate;
    }
    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }
    public String getNumber() {
        return number;
    }

    public String getHolder() {
        return holder;
    }
    public LocalDate getExpirationDate() {
        return expirationDate;
    }
    public boolean isActive() {
        return active;
    }


}
