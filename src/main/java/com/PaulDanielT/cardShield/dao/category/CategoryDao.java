package com.PaulDanielT.cardShield.dao.category;

import com.PaulDanielT.cardShield.model.Category;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("jdbc")
public class CategoryDao implements ICategoryDao {
    @Override
    public List<Category> getAllCategories() {
        return null;
    }

    @Override
    public Optional<Category> getCategoryById(Integer categoryId) {
        return Optional.empty();
    }

    @Override
    public Optional<Category> getCategoryByName(String categoryName) {
        return Optional.empty();
    }
}
