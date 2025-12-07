CREATE TABLE IF NOT EXISTS restaurants."restaurant" (
    res_id uuid NOT NULL,
    name VARCHAR(100) NOT NULL,
    capacity INT NOT NULL,
    food_type VARCHAR(50),
    current_diner INTEGER NOT NULL DEFAULT 0,
    PRIMARY KEY (res_id)
);