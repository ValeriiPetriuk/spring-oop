CREATE TABLE inspections (
            id SERIAL PRIMARY KEY,
            name_attraction VARCHAR(100) NOT NULL,
            number_inspection INT NOT NULL CHECK (number_inspection BETWEEN 1 AND 5),
            date_inspection DATE NOT NULL,
            type_inspection VARCHAR(50) NOT NULL,
            location_attraction VARCHAR(100) NOT NULL
);
