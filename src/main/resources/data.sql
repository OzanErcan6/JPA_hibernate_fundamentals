create table person
(
    id integer not null,
    name varchar(255) not null,
    location varchar(255),
    birth_date timestamp,
    primary key(id)
);

insert into person (id, name, location, birth_date) values(10001, 'ozan', 'ankara', CURRENT_TIMESTAMP(3));
insert into person (id, name, location, birth_date) values(10002, 'ercan', 'ankara', CURRENT_TIMESTAMP(3));
insert into person (id, name, location, birth_date) values(10003, 'gamze', 'ankara', CURRENT_TIMESTAMP(3));
insert into person (id, name, location, birth_date) values(10004, 'zehra', 'ankara', CURRENT_TIMESTAMP(3));
insert into person (id, name, location, birth_date) values(10005, 'duygu', 'ankara', CURRENT_TIMESTAMP(3));
