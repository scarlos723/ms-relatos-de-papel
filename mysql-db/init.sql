SET NAMES utf8mb4;

DROP TABLE IF EXISTS books;

ALTER DATABASE booksdb CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS books (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) UNIQUE,
    author VARCHAR(255),
    category VARCHAR(100),
    isbn VARCHAR(20),
    publication_date DATE,
    rating INT,
    price DECIMAL(10, 2),
    description VARCHAR(255),
    visible BOOLEAN
) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

INSERT INTO
    books (
        title,
        author,
        category,
        isbn,
        publication_date,
        rating,
        price,
        description,
        visible
    )
VALUES (
        'El Señor de los Anillos',
        'J.R.R. Tolkien',
        'Fantasía',
        '978-0618640157',
        '1954-07-29',
        5,
        29.99,
        'Una épica historia de fantasía de J.R.R. Tolkien',
        true
    ),
    (
        'Cien años de soledad',
        'Gabriel García Márquez',
        'Realismo mágico',
        '978-0307474728',
        '1967-05-30',
        5,
        24.99,
        'Obra maestra de Gabriel García Márquez',
        false
    ),
    (
        '1984',
        'George Orwell',
        'Distopía',
        '978-0451524935',
        '1949-06-08',
        4,
        19.99,
        'Novela distópica de George Orwell',
        true
    ),
    (
        'Don Quijote de la Mancha',
        'Miguel de Cervantes',
        'Clásico',
        '978-8491050297',
        '1605-01-16',
        5,
        34.99,
        'La obra más importante de la literatura española',
        false
    ),
    (
        'Harry Potter y la Piedra Filosofal',
        'J.K. Rowling',
        'Fantasía',
        '978-8478884452',
        '1997-06-26',
        4,
        22.99,
        'El primer libro de la saga de J.K. Rowling',
        false
    );