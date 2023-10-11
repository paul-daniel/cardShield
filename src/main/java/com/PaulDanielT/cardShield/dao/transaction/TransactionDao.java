package com.PaulDanielT.cardShield.dao.transaction;

import com.PaulDanielT.cardShield.model.Transaction;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class TransactionDao implements ITransactionDao{
    private final JdbcTemplate jdbcTemplate;
    private final TransactionRowMapper transactionRowMapper;

    public TransactionDao(JdbcTemplate jdbcTemplate, TransactionRowMapper transactionRowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.transactionRowMapper = transactionRowMapper;
    }

    @Override
    public void save(Transaction transaction) {
        var sql = "INSERT INTO transaction (card_id, amount, transaction_date, vendor_id, transaction_month, transaction_year) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, transaction.getCardId(), transaction.getAmount(), transaction.getTransactionDate(), transaction.getVendorId(), transaction.getTransactionMonth(), transaction.getTransactionYear());
    }

    @Override
    public Optional<Transaction> findById(Integer transactionId) {
        var sql = "SELECT * FROM transaction WHERE transaction_id = ?";
        return jdbcTemplate.query(sql, transactionRowMapper, transactionId)
                .stream()
                .findFirst();
    }

    @Override
    public List<Transaction> findAll() {
        var sql = "SELECT * FROM transaction";
        return jdbcTemplate.query(sql, transactionRowMapper);
    }

    @Override
    public List<Transaction> findByCardId(Integer cardId) {
        var sql = "SELECT * FROM transaction WHERE card_id = ?";
        return jdbcTemplate.query(sql, new Object[]{cardId}, transactionRowMapper);
    }

    @Override
    public List<Transaction> findByVendorId(Integer vendorId) {
        var sql = "SELECT * FROM transaction WHERE vendor_id = ?";
        return jdbcTemplate.query(sql, new Object[]{vendorId}, transactionRowMapper);
    }

    @Override
    public List<Transaction> findByDateRange(Date startDate, Date endDate) {
        var sql = "SELECT * FROM transaction WHERE transaction_date BETWEEN ? AND ?";
        return jdbcTemplate.query(sql, new Object[]{startDate, endDate}, transactionRowMapper);
    }

    @Override
    public void update(Transaction transaction) {
        var sql = "UPDATE transaction SET card_id = ?, amount = ?, transaction_date = ?, vendor_id = ?, transaction_month = ?, transaction_year = ? WHERE transaction_id = ?";
        jdbcTemplate.update(sql, transaction.getCardId(), transaction.getAmount(), transaction.getTransactionDate(), transaction.getVendorId(), transaction.getTransactionMonth(), transaction.getTransactionYear(), transaction.getTransactionId());
    }

    @Override
    public void deleteById(Integer transactionId) {
        var sql = "DELETE FROM transaction WHERE transaction_id = ?";
        jdbcTemplate.update(sql, transactionId);
    }
}
