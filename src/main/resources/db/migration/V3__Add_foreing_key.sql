ALTER TABLE transaction
    ADD CONSTRAINT "FK_Transaction.vendor_id"
        FOREIGN KEY ("vendor_id")
            REFERENCES vendor("vendor_id");

ALTER TABLE transaction
    ADD CONSTRAINT "FK_Transaction.card_id"
        FOREIGN KEY ("card_id")
            REFERENCES card("card_id");

ALTER TABLE card
    ADD CONSTRAINT "FK_Card.customer_id"
        FOREIGN KEY ("customer_id")
            REFERENCES customer("customer_id");

ALTER TABLE card
    ADD CONSTRAINT "FK_Card.category_id"
        FOREIGN KEY ("category_id")
            REFERENCES category("category_id");
