package com.PaulDanielT.cardShield.dao.fundSource;

import com.PaulDanielT.cardShield.model.FundSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class FundSourceDao implements IFundSourceDao{

    private final JdbcTemplate jdbcTemplate;
    private final FundSourceRowMapper fundSourceRowMapper;

    public FundSourceDao(JdbcTemplate jdbcTemplate, FundSourceRowMapper fundSourceRowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.fundSourceRowMapper = fundSourceRowMapper;
    }

    @Override
    public Optional<FundSource> getFundSource(Integer fundSourceId) {
        var sql = """
                    SELECT * FROM fundsource
                    WHERE fund_source_id = ?;
                """;

        return jdbcTemplate.query(sql, fundSourceRowMapper, fundSourceId)
                .stream()
                .findFirst();
    }

    @Override
    public void addFundSource(FundSource fundSource) {
        var sql = """
                    INSERT INTO fundsource(card_number, expiry_date, card_type, card_holder_name, cvv)
                    VALUES(?,?,?,?,?);
                """;

        jdbcTemplate.update(sql,
                fundSource.getCardNumber(),
                fundSource.getExpiryDate(),
                fundSource.getCardType(),
                fundSource.getCardHolderName(),
                fundSource.getCardHolderName(),
                fundSource.getCvv());
    }

    @Override
    public void updateFundSource(FundSource fundSource, Integer fundSourceId) {
        var sql = """
                    UPDATE fundsource
                    SET card_number = ?
                    AND expiry_date = ?
                    AND card_type  = ?
                    AND card_holder_name = ?
                    AND cvv = ?
                    WHERE fund_source_id = ?;
                """;

        jdbcTemplate.update(sql,
                fundSource.getCardNumber(),
                fundSource.getExpiryDate(),
                fundSource.getCardType(),
                fundSource.getCardType(),
                fundSource.getCvv(),
                fundSourceId);
    }

    @Override
    public void deleteFundSource(Integer fundSourceId) {
        var sql = """
                    DELETE FROM fundsource
                    WHERE fund_source_id = ?
                """;
        jdbcTemplate.update(sql, fundSourceId);
    }
}