package com.PaulDanielT.cardShield.dao.customer;

import com.PaulDanielT.cardShield.model.Customer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CustomerDao implements ICustomerDao{

    private final JdbcTemplate jdbcTemplate;
    private final CustomerRowMapper customerRowMapper;

    public CustomerDao(JdbcTemplate jdbcTemplate, CustomerRowMapper customerRowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.customerRowMapper = customerRowMapper;
    }

    @Override
    public List<Customer> selectAllCustomers() {
        var sql = """
                SELECT * FROM customer;
                """;

        return jdbcTemplate.query(sql, customerRowMapper);
    }

    @Override
    public Optional<Customer> selectCustomerById(Integer id) {
        var sql = """
                SELECT * FROM customer
                WHERE customer_id = ?;
                """;

        return jdbcTemplate.query(sql, customerRowMapper, id)
                .stream()
                .findFirst();
    }

    @Override
    public void insertCustomer(Customer customer) {
        var sql = """
                    INSERT INTO customer(firstname, lastname, email, phone, country, password, fund_source_id)
                    VALUES (?,?,?,?,?,?,?)
                """;

        jdbcTemplate.update(sql,
                customer.getFirstname(),
                customer.getLastname(),
                customer.getEmail(),
                customer.getPhone(),
                customer.getCountry(),
                customer.getPassword(),
                customer.getFundSourceId()
                );
    }

    @Override
    public void deleteCustomerById(Integer id) {
        var sql = """
                    DELETE FROM customer
                    WHERE customer_id = ?;
                """;

        jdbcTemplate.update(sql, id);
    }

    @Override
    public void updateCustomerInfos(Customer customer, Integer customerId) {
        var sql = """
                    UPDATE customer
                    SET email = ?
                    AND password = ?
                    AND phone = ?
                    WHERE customer_id = ?;
                """;

        jdbcTemplate.update(sql,
                customer.getEmail(),
                customer.getPassword(),
                customer.getPhone(),
                customerId);
    }

    @Override
    public boolean existsCustomerWithId(Integer id) {
        var sql = """
                SELECT * FROM customer
                WHERE customer_id = ?;
                """;

        return jdbcTemplate.query(sql, customerRowMapper, id)
                .stream()
                .anyMatch(
                c -> c.getCustomerId().equals(id)
                );
    }

    @Override
    public boolean existsPersonWithEmail(String email) {
        var sql = """
                SELECT * FROM customer
                WHERE email = ?;
                """;

        return jdbcTemplate.query(sql, customerRowMapper, email)
                .stream()
                .anyMatch(
                        c -> c.getEmail().equals(email)
                );
    }
}
