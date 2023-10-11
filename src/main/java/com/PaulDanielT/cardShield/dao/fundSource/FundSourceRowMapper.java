package com.PaulDanielT.cardShield.dao.fundSource;

import com.PaulDanielT.cardShield.model.FundSource;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class FundSourceRowMapper implements RowMapper<FundSource> {
    @Override
    public FundSource mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new FundSource(
                rs.getInt("fund_source_id"),
                rs.getString("card_number"),
                rs.getDate("expiry_date"),
                rs.getString("card_type"),
                rs.getString("card_holder_name"),
                rs.getString("cvv")
        );
    }
}
