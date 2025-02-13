-- V1 - Create Orders Table
CREATE TABLE orders (
    id SERIAL PRIMARY KEY,
    supplier VARCHAR(64) NOT NULL,
    products TEXT[] CHECK (ARRAY_LENGTH(products, 1) > 0),
    status VARCHAR(20) NOT NULL CHECK (status IN ('PENDING', 'CONFIRMED', 'SHIPPED', 'PROGRESS', 'DELIVERED', 'CANCELLED', 'COMPLETED')),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
CREATE INDEX idx_orders_status ON orders (status);