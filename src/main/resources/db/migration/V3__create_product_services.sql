CREATE TABLE product_services
(
    id BIGSERIAL PRIMARY KEY,
    title    TEXT NOT NULL,
    description TEXT NOT NULL,
    price    decimal,
    product_id  BIGINT REFERENCES products (id),
    created  TIMESTAMP DEFAULT NOW(),
    updated  TIMESTAMP DEFAULT NOW()
);
