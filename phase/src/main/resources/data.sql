DROP TABLE IF EXISTS phase;

CREATE TABLE phase(
    id SERIAL,
    name VARCHAR(50) NOT NULL,
    notification BOOLEAN NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO phase(name,notification) VALUES
    ('Requsitos',true),
    ('Documentos',false),
    ('Constancias',true);
