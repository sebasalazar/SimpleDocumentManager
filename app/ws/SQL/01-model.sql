BEGIN TRANSACTION;


DROP TABLE IF EXISTS types CASCADE;
CREATE TABLE types (
    pk bigserial NOT NULL,
    name varchar(255) NOT NULL,
    description text,
    PRIMARY KEY (pk)
);
CREATE UNIQUE INDEX types_name_idx ON types (LOWER(name));

DROP TABLE IF EXISTS documents CASCADE;
CREATE TABLE documents (
    pk bigserial NOT NULL,
    type_fk bigint NOT NULL REFERENCES types(pk) ON UPDATE CASCADE ON DELETE CASCADE,
    code varchar(255) NOT NULL,
    name varchar(255) NOT NULL,
    mime varchar(255) NOT NULL,
    filesize bigint NOT NULL,
    file bytea NOT NULL,
    UNIQUE (code),
    PRIMARY KEY (pk)
);
CREATE INDEX documents_name_idx ON documents(name);

COMMIT;
