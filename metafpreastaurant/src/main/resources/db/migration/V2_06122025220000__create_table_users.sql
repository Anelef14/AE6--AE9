CREATE TABLE IF NOT EXISTS restaurants."users" (
    user_id UUID NOT NULL,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    PRIMARY KEY (user_id)
);