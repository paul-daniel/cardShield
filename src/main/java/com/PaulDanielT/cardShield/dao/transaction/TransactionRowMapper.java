package com.PaulDanielT.cardShield.dao.transaction;

import com.PaulDanielT.cardShield.model.Transaction;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TransactionRowMapper implements RowMapper<Transaction> {
    @Override
    public Transaction mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Transaction(
                rs.getInt("transaction_id"),
                rs.getInt("card_id"),
                rs.getBigDecimal("amount"),
                rs.getDate("transaction_date"),
                rs.getInt("vendor_id"),
                rs.getInt("transaction_month"),
                rs.getInt("transaction_year")
        );
    }
}
