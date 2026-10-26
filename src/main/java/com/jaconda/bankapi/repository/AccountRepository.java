package com.jaconda.bankapi.repository;

import com.jaconda.bankapi.model.Account;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {

    boolean existsByOwnerIdAndCurrency(Long id, String currency);

    Optional<Account> findById(Long id);

    @Modifying
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("UPDATE Account a SET a.balance = a.balance + :amount WHERE a.id = :id")
    void updateBalance(@Param("id") Long id, @Param("amount") BigDecimal amount);

}