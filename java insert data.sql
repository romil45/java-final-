-- Insert Customers
INSERT INTO customers (name, email, phone, address) VALUES
('Alice Smith', 'alice@example.com', '123-456-7890', '123 Maple St, Toronto'),
('Bob Johnson', 'bob@example.com', '234-567-8901', '456 Oak St, Ottawa'),
('Carol Lee', 'carol@example.com', '345-678-9012', '789 Pine St, Vancouver'),
('David Brown', 'david@example.com', '456-789-0123', '321 Birch St, Calgary'),
('Emma Davis', 'emma@example.com', '567-890-1234', '654 Spruce St, Halifax');

-- Insert Products
INSERT INTO products (name, description, price, stock) VALUES
('Laptop', '15-inch gaming laptop', 999.99, 10),
('Smartphone', 'Android phone with 5G', 699.99, 20),
('Headphones', 'Noise-cancelling wireless headphones', 199.99, 15),
('Backpack', 'Laptop backpack', 49.99, 25),
('Mouse', 'Wireless mouse', 24.99, 30);

-- Insert Orders
INSERT INTO orders (customer_id, total_amount, status) VALUES
(1, 1024.98, 'Shipped'),
(2, 724.98, 'Processing'),
(3, 49.99, 'Delivered');

-- Insert Order Items
INSERT INTO order_items (order_id, product_id, quantity, price) VALUES
(1, 1, 1, 999.99),
(1, 5, 1, 24.99),
(2, 2, 1, 699.99),
(2, 5, 1, 24.99),
(3, 4, 1, 49.99);

-- Insert Payments
INSERT INTO payments (order_id, payment_method, amount_paid) VALUES
(1, 'Credit Card', 1024.98),
(2, 'PayPal', 724.98),
(3, 'Credit Card', 49.99);

SELECT * FROM customers;
SELECT * FROM products;
SELECT * FROM order_items;
SELECT * FROM orders;
SELECT * FROM payments;

