-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2015-09-16 11:30:39.152



-- tables
-- Table: address
CREATE TABLE address (
    id integer  NOT NULL   PRIMARY KEY ,
    city_id integer  NOT NULL ,
    address varchar(255) ,
    FOREIGN KEY (city_id) REFERENCES city (id)
);

-- Table: city
CREATE TABLE city (
    id integer  NOT NULL   PRIMARY KEY ,
    country_id integer  NOT NULL ,
    name varchar(255)  NOT NULL ,
    FOREIGN KEY (country_id) REFERENCES country (id)
);

-- Table: country
CREATE TABLE country (
    id integer  NOT NULL   PRIMARY KEY ,
    name varchar(255)  NOT NULL ,
    CONSTRAINT name UNIQUE (name)
);

-- Table: place
CREATE TABLE place (
    id integer  NOT NULL   PRIMARY KEY ,
    name varchar(255)  NOT NULL ,
    address_id integer  NOT NULL ,
    rating integer  NOT NULL ,
    added datetime  NOT NULL ,
    comment text ,
    image blob ,
    FOREIGN KEY (address_id) REFERENCES address (id)
);

-- Table: place_tag
CREATE TABLE place_tag (
    place_id integer  NOT NULL ,
    tag_name varchar(255)  NOT NULL ,
    CONSTRAINT place_tag_pk PRIMARY KEY (place_id,tag_name),
    FOREIGN KEY (place_id) REFERENCES place (id),
    FOREIGN KEY (tag_name) REFERENCES tag (name)
);

-- Table: tag
CREATE TABLE tag (
    name varchar(255)  NOT NULL   PRIMARY KEY 
);


-- views
-- View: address_view

CREATE VIEW address_view AS
select 
 address.id as address_id,
    address.address as address,
    city.name as city_name,
    country.name as country_name
from
 country
    join city on (country.id=city.country_id)
    join address on (city.id=address.city_id);




-- End of file.
