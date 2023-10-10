CREATE TABLE "Vendor" (
                          "vendor_id" SERIAL PRIMARY KEY,
                          "vendor_name" Varchar,
                          "vendor_category" Varchar
);

CREATE TABLE "Customer" (
                            "customer_id" SERIAL PRIMARY KEY ,
                            "firstname" varchar(50),
                            "lastname" varchar(50),
                            "email" varchar,
                            "phone" varchar(12),
                            "country" varchar(50),
                            "password" varchar,
                            "fund_source_id" Integer
);

CREATE TABLE "Category" (
                            "category_id" SERIAL PRIMARY KEY,
                            "category_name" varchar
);

CREATE TABLE "Card" (
                        "card_id" SERIAL PRIMARY KEY ,
                        "customer_id" Integer,
                        "spending_limit" Decimal,
                        "created_at" TimeStamp,
                        "updated_at" TimeStamp,
                        "card_number" varchar,
                        "expiration_date" DATE,
                        "cvv" varchar,
                        "category_id" Integer,
                        CONSTRAINT "FK_Card.customer_id"
                            FOREIGN KEY ("customer_id")
                                REFERENCES "Customer"("customer_id"),
                        CONSTRAINT "FK_Card.category_id"
                            FOREIGN KEY ("category_id")
                                REFERENCES "Category"("category_id")
);

CREATE TABLE "Transaction" (
                               "transaction_id" SERIAL PRIMARY KEY,
                               "card_id" Integer,
                               "amount" Decimal,
                               "transaction_date" Date,
                               "vendor_id" Integer,
                               "transaction_month" Integer,
                               "transaction_year" Integer,
                               CONSTRAINT "FK_Transaction.vendor_id"
                                   FOREIGN KEY ("vendor_id")
                                       REFERENCES "Vendor"("vendor_id"),
                               CONSTRAINT "FK_Transaction.card_id"
                                   FOREIGN KEY ("card_id")
                                       REFERENCES "Card"("card_id")
);

CREATE TABLE "FundSource" (
                              "fund_source_id" SERIAL PRIMARY KEY,
                              "card_number" varchar,
                              "expiry_date" Date,
                              "card_type" varchar,
                              "card_holder_name" varchar
);

