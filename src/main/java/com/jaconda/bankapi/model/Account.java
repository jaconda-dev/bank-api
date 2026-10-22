package com.jaconda.bankapi.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "accounts", uniqueConstraints = @UniqueConstraint(columnNames = {"ownerid", "currency"}))
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
    @Column(name = "ownerid", nullable = false)
    Long ownerId;
    @Column(name = "currency", nullable = false, length = 3)
    String currency;
    @Column(name = "balance", nullable = false, precision = 19, scale = 4)
    BigDecimal balance = BigDecimal.ZERO;
    @Column(name = "createdat", nullable = false)
    LocalDateTime createdAt;

    @PrePersist
    protected void date(){
        this.createdAt = LocalDateTime.now();
    }
}
