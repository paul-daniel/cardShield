package com.PaulDanielT.cardShield.dao.fundSource;

import com.PaulDanielT.cardShield.model.FundSource;

import java.util.Optional;

public interface IFundSourceDao {
    Optional<FundSource> getFundSource(Integer fundSourceId);
    void addFundSource(FundSource fundSource);
    void updateFundSource(FundSource fundSource, Integer fundSourceId);
    void deleteFundSource(Integer fundSourceId);
}
