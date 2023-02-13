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


insert into student (id, name, passport_id) values(10001, 'ozan', 20001);
insert into student (id, name, passport_id) values(10002, 'ozan2', 20002);
insert into student (id, name, passport_id) values(10003, 'ozan3', 20003);
insert into student (id, name, passport_id) values(10004, 'ozan4', 20004);


insert into passport (id, number) values(20001, '12345');
insert into passport (id, number) values(20002, '12346');
insert into passport (id, number) values(20003, '12347');
insert into passport (id, number) values(20004, '12348');


insert into review (id, rating, description) values(30001, '5', 'great course');
insert into review (id, rating, description) values(30002, '4', 'great course2');
insert into review (id, rating, description) values(30003, '2', 'great course3');
insert into review (id, rating, description) values(30004, '9', 'great course4');
