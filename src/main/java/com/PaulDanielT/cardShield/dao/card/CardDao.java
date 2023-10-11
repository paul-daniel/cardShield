package com.PaulDanielT.cardShield.dao.card;

import com.PaulDanielT.cardShield.exception.ResourceNotFoundException;
import com.PaulDanielT.cardShield.model.Card;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CardDao implements ICardDao{

    private final JdbcTemplate jdbcTemplate;
    private final CardRowMapper cardRowMapper;

    public CardDao(JdbcTemplate jdbcTemplate, CardRowMapper cardRowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.cardRowMapper = cardRowMapper;
    }

    @Override
    public List<Card> selectAllCards() {
        var sql = """
                    SELECT * FROM card;
                """;
        return jdbcTemplate.query(sql, cardRowMapper);
    }

    @Override
    public Optional<Card> selectCardById(Integer id) {
        var sql = """
                    SELECT * FROM card
                    WHERE card_id = ?;
                """;

        return jdbcTemplate.query(sql, cardRowMapper,id).stream().findFirst();
    }

    @Override
    public List<Card> selectCardByCategory(String categoryName) {
        var sql = """
                    SELECT * FROM card c
                    INNER JOIN category cat ON c.category_id = cat.category_id
                    WHERE cat.name = ?;
                """;

        return jdbcTemplate.query(sql, cardRowMapper, categoryName);
    }

    @Override
    public void createCard(Card card) {
        var sql = """
                    INSERT INTO card(customer_id, spending_limit, created_at, updated_at, card_number, expiration_date, cvv, category_id)
                    VALUES(?,?,?,?,?,?,?,?);
                """;

        jdbcTemplate.update(sql,
                card.getCustomerId(),
                card.getSpendingLimit(),
                card.getCreatedAt(),
                card.getUpdatedAt(),
                card.getCardNumber(),
                card.getExpirationDate(),
                card.getCvv(),
                card.getCategoryId());
    }

    @Override
    public void deleteCard(Integer cardId) {
        var sql = """
                    DELETE FROM card
                    WHERE card_id = ?;
                """;

        jdbcTemplate.update(sql, cardId);
    }

    @Override
    public void updateCard(Integer cardId, String categoryName) {
        // First, retrieve the category_id for the given category_name
        var fetchCategoryIdSql = "SELECT category_id FROM Category WHERE category_name = ?";

        Integer categoryId = jdbcTemplate.queryForObject(fetchCategoryIdSql, new Object[]{categoryName.toLowerCase()}, Integer.class);

        if (categoryId != null) {
            // Then, update the card with the fetched category_id
            var updateCardSql = """
                             UPDATE card
                             SET category_id = ?
                             WHERE card_id = ?;
                             """;

            jdbcTemplate.update(updateCardSql, categoryId, cardId);
        } else {
            throw new ResourceNotFoundException("No categories found with name : [%s]".formatted(categoryName));
        }
    }

    @Override
    public boolean existCardWithNumber(String cardNumber) {
        var sql = """
                SELECT * FROM card
                WHERE card_number = ?;
                """;
        return jdbcTemplate.query(sql,cardRowMapper, cardNumber)
                .stream()
                .anyMatch(c->c.getCardNumber().equals(cardNumber));
    }
}
