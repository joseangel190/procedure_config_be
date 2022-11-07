DROP TABLE IF EXISTS procedure_config;

CREATE TABLE procedure_config(
    id SERIAL,
    procedure_type_id INT NOT NULL,
    institute_id INT NOT NULL,
    phase_id INT NOT NULL,
    active BOOLEAN NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO procedure_config(procedure_type_id, institute_id, phase_id, active) VALUES
    (1,1,1,false),
    (1,1,2,true);