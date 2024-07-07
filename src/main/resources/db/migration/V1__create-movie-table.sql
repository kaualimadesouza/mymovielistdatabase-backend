CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE movies (
    id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    description VARCHAR(255) NOT NULL,
    imgURL VARCHAR(255) NOT NULL,
    genre VARCHAR(100) NOT NULL,
    rating INT NOT NULL,
    movieYear INT NOT NULL,
    imdbId VARCHAR(100) NOT NULL
)