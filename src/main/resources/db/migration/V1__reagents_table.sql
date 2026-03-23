CREATE TABLE reagents (
    id UUID PRIMARY KEY,
    cas_number varchar(10) UNIQUE NOT NULL,
    name varchar(100) NOT NULL,
    formula varchar(50),
    molecular_weight numeric(4,2),
    reagent_type char(1) NOT NULL,
    flammability int,
    health int,
    instability int,
    specials varchar(10),
    create_date timestamp,
    update_date timestamp
)