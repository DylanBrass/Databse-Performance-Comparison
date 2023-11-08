USE `test-db`;


create table if not exists tests (
                        id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                        test_string VARCHAR(255) NOT NULL,
                        test_int INT NOT NULL,
                        test_float FLOAT NOT NULL,
                        test_boolean BOOLEAN NOT NULL,
                        test_date DATE NULL
);

create table if not exists sql_user(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL
);

create table if not exists sql_post(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    content VARCHAR(255) NOT NULL,
    user_id INT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES sql_user(id)
);