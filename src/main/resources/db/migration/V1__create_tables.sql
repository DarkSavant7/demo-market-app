CREATE TABLE users
(
    id BIGSERIAL PRIMARY KEY,
    login    TEXT NOT NULL,
    password TEXT NOT NULL,
    email    TEXT,
    created  TIMESTAMP DEFAULT NOW(),
    updated  TIMESTAMP DEFAULT NOW()
);

CREATE TABLE roles
(
    id      SERIAL PRIMARY KEY,
    name    TEXT NOT NULL,
    created TIMESTAMP DEFAULT NOW(),
    updated TIMESTAMP DEFAULT NOW()
);

CREATE TABLE users_roles
(
    user_id BIGINT REFERENCES users (id),
    role_id INTEGER REFERENCES roles (id),
    created TIMESTAMP DEFAULT NOW(),
    updated TIMESTAMP DEFAULT NOW()
);

CREATE TABLE products
(
    id BIGSERIAL PRIMARY KEY,
    title       TEXT NOT NULL,
    description TEXT NOT NULL,
    price       NUMERIC(8, 2),
    created     TIMESTAMP DEFAULT NOW(),
    updated     TIMESTAMP DEFAULT NOW()
);