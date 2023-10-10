package com.PaulDanielT.cardShield.dao.vendor;

import com.PaulDanielT.cardShield.model.Vendor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class VendorRowMapper implements RowMapper<Vendor> {
    @Override
    public Vendor mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Vendor(
                rs.getInt("vendor_id"),
                rs.getString("vendor_name"),
                rs.getString("vendor_category")
        );
    }
}
