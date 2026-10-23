package com.jaconda.bankapi.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "accounts", uniqueConstraints = @UniqueConstraint(columnNames = {"owner_id", "currency"}))
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    Long id;
    @Column(name = "owner_id", nullable = false)
    Long ownerId;
    @Column(name = "currency", nullable = false, length = 3)
    String currency;
    @Column(name = "balance", nullable = false, precision = 19, scale = 4)
    BigDecimal balance = BigDecimal.ZERO;
    @Column(name = "created_at", nullable = false)
    LocalDateTime createdAt;

    @PrePersist
    protected void date(){
        this.createdAt = LocalDateTime.now();
    }
}