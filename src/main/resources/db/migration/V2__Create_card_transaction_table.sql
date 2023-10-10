CREATE TABLE Card (
                      "card_id" SERIAL PRIMARY KEY ,
                      "customer_id" Integer,
                      "spending_limit" Decimal,
                      "created_at" TimeStamp,
                      "updated_at" TimeStamp,
                      "card_number" varchar,
                      "expiration_date" DATE,
                      "cvv" varchar,
                      "category_id" Integer
);

CREATE TABLE Transaction (
                             "transaction_id" SERIAL PRIMARY KEY,
                             "card_id" Integer,
                             "amount" Decimal,
                             "transaction_date" Date,
                             "vendor_id" Integer,
                             "transaction_month" Integer,
                             "transaction_year" Integer
);