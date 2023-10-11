package com.PaulDanielT.cardShield.dao.category;

import com.PaulDanielT.cardShield.model.Category;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoryDao implements ICategoryDao {

    private final JdbcTemplate jdbcTemplate;
    private final CategoryRowMapper categoryRowMapper;

    public CategoryDao(JdbcTemplate jdbcTemplate, CategoryRowMapper categoryRowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.categoryRowMapper = categoryRowMapper;
    }

    @Override
    public List<Category> getAllCategories() {
        var sql = """
                SELECT * FROM category;
                """;

        return jdbcTemplate.query(sql, categoryRowMapper);
    }

    @Override
    public Optional<Category> getCategoryById(Integer categoryId) {
        var sql = """
                SELECT * FROM category
                WHERE category_id = ?;
                """;

        return jdbcTemplate.query(sql, categoryRowMapper, categoryId)
                .stream()
                .findFirst();
    }

    @Override
    public Optional<Category> getCategoryByName(String categoryName) {
        var sql = """
                SELECT * FROM category
                WHERE category_name = ?;
                """;

        return jdbcTemplate.query(sql, categoryRowMapper, categoryName)
                .stream()
                .findFirst();
    }
}
