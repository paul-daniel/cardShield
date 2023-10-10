package com.PaulDanielT.cardShield.dao.transaction;

import com.PaulDanielT.cardShield.model.Transaction;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository("jdbc")
public class TransactionDao implements ITransactionDao{
    @Override
    public void save(Transaction transaction) {

    }

    @Override
    public Transaction findById(Integer transactionId) {
        return null;
    }

    @Override
    public List<Transaction> findAll() {
        return null;
    }

    @Override
    public List<Transaction> findByCardId(Integer cardId) {
        return null;
    }

    @Override
    public List<Transaction> findByVendorId(Integer vendorId) {
        return null;
    }

    @Override
    public List<Transaction> findByDateRange(Date startDate, Date endDate) {
        return null;
    }

    @Override
    public void update(Transaction transaction) {

    }

    @Override
    public void deleteById(Integer transactionId) {

    }
}
