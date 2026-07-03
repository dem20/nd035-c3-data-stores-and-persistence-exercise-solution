CREATE TABLE IF NOT EXISTS candy (
    id BIGINT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    price DECIMAL(10, 2) NOT NULL
);

CREATE TABLE IF NOT EXISTS candy_delivery (
    candy_id BIGINT NOT NULL,
    delivery_id BIGINT NOT NULL,
    FOREIGN KEY (candy_id) REFERENCES candy(id),
    FOREIGN KEY (delivery_id) REFERENCES delivery(id)
);