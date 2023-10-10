package com.PaulDanielT.cardShield.dao.transactionStats;

import com.PaulDanielT.cardShield.model.TransactionStats;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TransactionStatsRowMapper implements RowMapper<TransactionStats> {
    @Override
    public TransactionStats mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new TransactionStats(
                rs.getInt("customer_id"),
                rs.getBigDecimal("daily_spending"),
                rs.getBigDecimal("weekly_spending"),
                rs.getBigDecimal("monthly_spending")
        );
    }
}
