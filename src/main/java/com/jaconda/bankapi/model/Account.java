package com.jaconda.bankapi.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
//создается составной уникальный индекс, ключ например 1-USD становится уникальным, дубль прерывется
@Table(name = "accounts", uniqueConstraints = @UniqueConstraint(columnNames = {"owner_id", "currency"}))
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Account extends BaseEntity{

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