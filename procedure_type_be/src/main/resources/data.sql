DROP TABLE IF EXISTS procedure_type;

CREATE TABLE procedure_type(
    id SERIAL,
    name VARCHAR(50) NOT NULL,
    person_level VARCHAR(50) NOT NULL,
    abreviaton VARCHAR(50) NOT NULL,
    active BOOLEAN NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO procedure_type(name,person_level,abreviaton,active) VALUES
('Documents','Student','Documents',true);