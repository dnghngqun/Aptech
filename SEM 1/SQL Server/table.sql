CREATE TABLE orders(
    id INT PRIMARY KEY IDENTITY(1, 1),
    CustomerID INT NOT NULL,
    CreateAt DATETIME

)
SELECT * from orders