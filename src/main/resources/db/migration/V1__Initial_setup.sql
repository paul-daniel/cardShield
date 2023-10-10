CREATE TABLE Vendor (
                        "vendor_id" SERIAL PRIMARY KEY,
                        "vendor_name" Varchar,
                        "vendor_category" Varchar
);

CREATE TABLE Customer (
                          "customer_id" SERIAL PRIMARY KEY ,
                          "firstname" varchar(50),
                          "lastname" varchar(50),
                          "email" varchar,
                          "phone" varchar(12),
                          "country" varchar(50),
                          "password" varchar,
                          "fund_source_id" Integer
);

CREATE TABLE Category (
                          "category_id" SERIAL PRIMARY KEY,
                          "category_name" varchar
);

CREATE TABLE FundSource (
                            "fund_source_id" SERIAL PRIMARY KEY,
                            "card_number" varchar,
                            "expiry_date" Date,
                            "card_type" varchar,
                            "card_holder_name" varchar
);

