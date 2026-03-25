CREATE TABLE articles (
    id UUID PRIMARY KEY,
    code varchar(10) UNIQUE NOT NULL,
    reagent_id UUID REFERENCES reagents (id),
    pureness numeric(4,2) NOT NULL,
    manufacturer varchar(100) NOT NULL,
    created_date timestamp,
    updated_date timestamp
);