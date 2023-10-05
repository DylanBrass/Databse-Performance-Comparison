USE `test-db`;


create table if not exists tests (
                        id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                        test_string VARCHAR(255) NOT NULL,
                        test_int INT NOT NULL,
                        test_float FLOAT NOT NULL,
                        test_boolean BOOLEAN NOT NULL,
                        test_date DATE NOT NULL
);