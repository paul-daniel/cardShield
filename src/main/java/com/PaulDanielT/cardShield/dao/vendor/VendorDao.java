package com.PaulDanielT.cardShield.dao.vendor;

import com.PaulDanielT.cardShield.model.Vendor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class VendorDao implements IVendorDao {
    private final JdbcTemplate jdbcTemplate;
    private final VendorRowMapper vendorRowMapper;

    public VendorDao(JdbcTemplate jdbcTemplate, VendorRowMapper vendorRowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.vendorRowMapper = vendorRowMapper;
    }

    @Override
    public void save(Vendor vendor) {
        var sql = "INSERT INTO vendor (vendor_name, vendor_category) VALUES (?, ?)";
        jdbcTemplate.update(sql, vendor.getVendorName(), vendor.getVendorCategory());
    }

    @Override
    public Optional<Vendor> findById(Integer vendorId) {
        var sql = "SELECT * FROM vendor WHERE vendor_id = ?";
        return jdbcTemplate.query(sql, vendorRowMapper, vendorId)
                .stream()
                .findFirst();
    }

    @Override
    public List<Vendor> findAll() {
        var sql = "SELECT * FROM vendor";
        return jdbcTemplate.query(sql, vendorRowMapper);
    }

    @Override
    public List<Vendor> findByCategory(String category) {
        var sql = """
                    SELECT * FROM vendor WHERE vendor_category = ?;
                  """;

        return jdbcTemplate.query(sql, vendorRowMapper, category);
    }

    @Override
    public void update(Vendor vendor) {
        var sql = "UPDATE vendor SET vendor_name = ?, vendor_category = ? WHERE vendor_id = ?";
        jdbcTemplate.update(sql, vendor.getVendorName(), vendor.getVendorCategory(), vendor.getVendorId());
    }

    @Override
    public void deleteById(Integer vendorId) {
        var sql = "DELETE FROM vendor WHERE vendor_id = ?";
        jdbcTemplate.update(sql, vendorId);
    }
}
