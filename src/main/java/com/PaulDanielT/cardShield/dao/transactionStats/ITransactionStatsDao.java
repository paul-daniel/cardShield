package com.PaulDanielT.cardShield.dao.transactionStats;

import com.PaulDanielT.cardShield.model.TransactionStats;

import java.util.List;

public interface ITransactionStatsDao {
    // Read
    List<TransactionStats> findByCustomerId(Integer customerId);
}
