CREATE TABLE IF NOT EXISTS books (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) UNIQUE,
    price DECIMAL(10, 2),
    description VARCHAR(255),
    visible BOOLEAN
);

INSERT INTO
    books (
        name,
        price,
        description,
        visible
    )
VALUES (
        'El Señor de los Anillos',
        29.99,
        'Una épica historia de fantasía de J.R.R. Tolkien',
        true
    ),
    (
        'Cien años de soledad',
        24.99,
        'Obra maestra de Gabriel García Márquez',
        true
    ),
    (
        '1984',
        19.99,
        'Novela distópica de George Orwell',
        true
    ),
    (
        'Don Quijote de la Mancha',
        34.99,
        'La obra más importante de la literatura española',
        true
    ),
    (
        'Harry Potter y la Piedra Filosofal',
        22.99,
        'El primer libro de la saga de J.K. Rowling',
        true
    );