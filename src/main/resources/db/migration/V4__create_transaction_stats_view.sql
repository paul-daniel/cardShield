CREATE VIEW Transaction_stats AS
SELECT
    c.customer_id,
    SUM(CASE WHEN t.transaction_date = CURRENT_DATE THEN t.amount ELSE 0 END) AS daily_spending,
    SUM(CASE WHEN t.transaction_date BETWEEN CURRENT_DATE - INTERVAL '7 day' AND CURRENT_DATE THEN t.amount ELSE 0 END) AS weekly_spending,
    SUM(CASE WHEN EXTRACT(MONTH FROM t.transaction_date) = EXTRACT(MONTH FROM CURRENT_DATE) THEN t.amount ELSE 0 END) AS monthly_spending
FROM customer c
         LEFT JOIN card ca ON c.customer_id = ca.customer_id
         LEFT JOIN transaction t ON ca.card_id = t.card_id
GROUP BY c.customer_id;
