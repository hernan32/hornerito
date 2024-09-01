CREATE TABLE if NOT EXISTS users (
    id SERIAL PRIMARY KEY,
    username VARCHAR(255) NOT NULL
);

CREATE TABLE if NOT EXISTS follow (
    id SERIAL PRIMARY KEY,
    user_id int NOT NULL,
    following_id int NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (following_id) REFERENCES users(id)
);

CREATE TABLE if NOT EXISTS tweet (
    id SERIAL PRIMARY KEY,
    user_id int NOT NULL,
    content VARCHAR(280) NOT NULL,
    create_date TIMESTAMP DEFAULT NOW(),
    FOREIGN KEY (user_id) REFERENCES users (id)
);
