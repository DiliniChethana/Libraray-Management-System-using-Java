create database library_db;
use library_db;
CREATE TABLE books (
    book_id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    publisher VARCHAR(255),
    year_published INT
);
CREATE TABLE members (
    member_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    phone VARCHAR(20)
);
CREATE TABLE loans (
    loan_id INT PRIMARY KEY AUTO_INCREMENT,
    book_id INT,
    member_id INT,
    loan_date DATE,
    return_date DATE,
    FOREIGN KEY (book_id) REFERENCES books(book_id),
    FOREIGN KEY (member_id) REFERENCES members(member_id)
);
desc books;
select*from books;
desc loans;
INSERT INTO books VALUES
(1, "Pride and Prejudice", "Jane Austen","Basic  Books",2023),
(2, "Great Expectation", "Cherles Dicken","Basic Books",2020);

INSERT INTO members VALUES
(100, "C.Thilkarathjna","dilini@gmail.com","0771081252"),
(101, "chethana Dilini","chethi@gmail.com","0754283639");

INSERT INTO loans VALUES
(10, 1, 100, "2023-05-01","2024-05-26" ),
(11, 2, 101, "2023-07-25", "2024-06-19");




