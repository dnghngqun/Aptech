CREATE DATABASE TestDataBase;
USE TestDataBase;
CREATE TABLE tblStudent(
    studentID INT IDENTITY(1, 1),
    studentName NVARCHAR(100),
    age INT CHECK(age > 0)
);
SELECT * FROM tblStudent;
INSERT INTO tblStudent(studentName, age)
VALUES('Đặng Hồng Quân', 18);

sp_help Employee

