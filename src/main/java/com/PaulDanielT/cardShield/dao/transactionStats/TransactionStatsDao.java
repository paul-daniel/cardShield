package com.PaulDanielT.cardShield.dao.transactionStats;

import com.PaulDanielT.cardShield.model.TransactionStats;

import java.util.List;

public class TransactionStatsDao implements ITransactionStatsDao{
    @Override
    public void save(TransactionStats stats) {

    }

    @Override
    public TransactionStats findByCustomerId(Integer customerId) {
        return null;
    }

    @Override
    public List<TransactionStats> findTopSpendingCustomers(int limit) {
        return null;
    }

    @Override
    public void update(TransactionStats stats) {

    }

    @Override
    public void deleteByCustomerId(Integer customerId) {

    }
}
