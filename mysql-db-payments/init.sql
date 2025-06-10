SET NAMES utf8mb4;

DROP TABLE IF EXISTS payments;

ALTER DATABASE paymentsdb CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS payments (
    id INT AUTO_INCREMENT PRIMARY KEY,
    payment_id INT NOT NULL,
    user_id INT NOT NULL,
    book_id INT NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    quantity INT DEFAULT 1,
    payment_date DATETIME NOT NULL
) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

INSERT INTO payment_items (payment_id, user_id, book_id, price, quantity, payment_date)
VALUES
    (101, 1, 4, 30000.00, 1, '2025-06-09 14:30:00'),
    (101, 1, 7, 45000.00, 1, '2025-06-09 14:30:00'),
    (102, 2, 2, 25000.00, 2, '2025-06-10 10:15:00'),
    (102, 2, 1, 15000.00, 1, '2025-06-10 10:15:00'),
    (102, 2, 3, 20000.00, 1, '2025-06-10 10:15:00'),
    (102, 2, 5, 35000.00, 1, '2025-06-10 10:15:00');

