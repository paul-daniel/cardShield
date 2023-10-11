package com.PaulDanielT.cardShield.dao.transactionStats;

import com.PaulDanielT.cardShield.model.TransactionStats;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TransactionStatsDao implements ITransactionStatsDao{

    private final JdbcTemplate jdbcTemplate;
    private final TransactionStatsRowMapper transactionStatsRowMapper;

    public TransactionStatsDao(JdbcTemplate jdbcTemplate, TransactionStatsRowMapper transactionStatsRowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.transactionStatsRowMapper = transactionStatsRowMapper;
    }

    @Override
    public List<TransactionStats> findByCustomerId(Integer customerId) {
        var sql = """
                    SELECT * FROM transaction_stats
                    WHERE customer_id = ?;
                """;

        return jdbcTemplate.query(sql, transactionStatsRowMapper, customerId);
    }
}
