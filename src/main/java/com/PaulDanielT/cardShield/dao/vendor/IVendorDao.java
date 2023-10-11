package com.PaulDanielT.cardShield.dao.vendor;

import com.PaulDanielT.cardShield.model.Vendor;

import java.util.List;
import java.util.Optional;

public interface IVendorDao {
    // Create
    void save(Vendor vendor);

    // Read
    Optional<Vendor> findById(Integer vendorId);
    List<Vendor> findAll();
    List<Vendor> findByCategory(String category);

    // Update
    void update(Vendor vendor);

    // Delete
    void deleteById(Integer vendorId);
}
