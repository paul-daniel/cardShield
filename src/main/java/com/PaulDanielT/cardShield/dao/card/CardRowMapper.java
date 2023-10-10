package com.PaulDanielT.cardShield.dao.card;

import com.PaulDanielT.cardShield.model.Card;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CardRowMapper implements RowMapper<Card> {
    @Override
    public Card mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Card(
                rs.getInt("card_id"),
                rs.getInt("customer_id"),
                rs.getBigDecimal("spending_limit"),
                rs.getTimestamp("created_at"),
                rs.getTimestamp("updated_at"),
                rs.getString("card_number"),
                rs.getDate("expiration_date"),
                rs.getString("cvv"),
                rs.getInt("category_id")
        );
    }
}
