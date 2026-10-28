package com.jaconda.bankapi.model;

import com.jaconda.bankapi.enums.TransactionStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "transactions")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transaction extends BaseEntity{

    @Column(name = "from_account_id", nullable = false)
    UUID fromAccountId;
    @Column(name = "to_account_id", nullable = false)
    UUID toAccountId;
    @Column(name = "amount", nullable = false, precision = 19, scale = 4)
    BigDecimal amount;
    @Column(name = "currency", nullable = false)
    String currency;
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    TransactionStatus status;
    @Column(name = "created_at", nullable = false, updatable = false)
    LocalDateTime createdAt;

    @PrePersist //перед первым insert, вызвать метод
    protected void onCreate(){
        this.createdAt = LocalDateTime.now();
        if(status == null){
            status = TransactionStatus.PENDING;
        }
    }
}