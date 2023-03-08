CREATE TABLE movie (
    id BIGINT IDENTITY (1,1),
    producers varchar(150),
    studios varchar(150),
    title varchar(150),
    winner varchar(150),
    year INTEGER,
    PRIMARY KEY (id);
);
