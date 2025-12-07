CREATE TABLE IF NOT EXISTS restaurants."reservations" (
    reservation_id UUID NOT NULL,
    user_id UUID NOT NULL,
    restaurant_id UUID NOT NULL,
    diners INT NOT NULL CHECK (diners >= 1),
    active BOOLEAN NOT NULL DEFAULT TRUE,
    PRIMARY KEY (reservation_id),
    CONSTRAINT fk_user FOREIGN KEY(user_id) REFERENCES restaurants."users"(user_id),
    CONSTRAINT fk_restaurant FOREIGN KEY(restaurant_id) REFERENCES restaurants."restaurant"(res_id)
);