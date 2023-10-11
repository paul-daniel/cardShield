package com.PaulDanielT.cardShield.dao.transaction;

import com.PaulDanielT.cardShield.model.Transaction;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ITransactionDao {
    // Create
    void save(Transaction transaction);

    // Read
    Optional<Transaction> findById(Integer transactionId);
    List<Transaction> findAll();
    List<Transaction> findByCardId(Integer cardId);
    List<Transaction> findByVendorId(Integer vendorId);
    List<Transaction> findByDateRange(Date startDate, Date endDate);

    // Update
    void update(Transaction transaction);

    // Delete
    void deleteById(Integer transactionId);
}
