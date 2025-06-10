-- Establecer codificación
SET NAMES utf8mb4;

ALTER DATABASE paymentsdb CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

DROP TABLE IF EXISTS payment_books;
DROP TABLE IF EXISTS payments;

CREATE TABLE IF NOT EXISTS payments (
    id INT AUTO_INCREMENT PRIMARY KEY,
    payment_id INT NOT NULL UNIQUE,
    user_id INT NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    payment_date DATETIME NOT NULL
    ) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS payment_books (
     payment_id INT NOT NULL,
     book_id INT NOT NULL,
     quantity INT DEFAULT 1,
     PRIMARY KEY (payment_id, book_id),
    FOREIGN KEY (payment_id) REFERENCES payments(id) ON DELETE CASCADE
    ) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;



