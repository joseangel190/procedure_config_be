DROP TABLE IF EXISTS institute;

CREATE TABLE institute(
    id SERIAL,
    name VARCHAR(50) NOT NULL,
    academic_area VARCHAR(50) NOT NULL,
    career VARCHAR(50) NOT NULL,
    active BOOLEAN NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO institute(name,academic_area,career,active) VALUES
('Valle Grande','data','Analisis de sistemas',true),
('Valle Grande','data','Analisis de sistemas',false ),
('Valle Grande','data','Produccion Agraria',true);