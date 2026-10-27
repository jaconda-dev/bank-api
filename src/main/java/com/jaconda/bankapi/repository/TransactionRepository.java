package com.jaconda.bankapi.repository;

import com.jaconda.bankapi.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TransactionRepository extends JpaRepository<Transaction, UUID> {
    // Получить все транзакции, где счёт участвовал как отправитель или получатель
    List<Transaction> findByFromAccountIdOrToAccountId(Long fromAccountId, Long toAccountId);

}
