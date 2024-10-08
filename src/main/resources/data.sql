insert into passport (id, number) values(20001, '12345');
insert into passport (id, number) values(20002, '12346');
insert into passport (id, number) values(20003, '12347');
insert into passport (id, number) values(20004, '12348');

insert into person (id, name, location, birth_date) values(10001, 'ozan', 'ankara', CURRENT_TIMESTAMP(3));
insert into person (id, name, location, birth_date) values(10002, 'ercan', 'ankara', CURRENT_TIMESTAMP(3));
insert into person (id, name, location, birth_date) values(10003, 'gamze', 'ankara', CURRENT_TIMESTAMP(3));
insert into person (id, name, location, birth_date) values(10004, 'zehra', 'ankara', CURRENT_TIMESTAMP(3));
insert into person (id, name, location, birth_date) values(10005, 'duygu', 'ankara', CURRENT_TIMESTAMP(3));


insert into student (id, name, passport_id) values(10001, 'ozan', 20001);
insert into student (id, name, passport_id) values(10002, 'ozan2', 20002);
insert into student (id, name, passport_id) values(10003, 'ozan3', 20003);
insert into student (id, name, passport_id) values(10004, 'ozan4', 20004);

insert into course (id, created_date, last_updated, name) values(10, CURRENT_TIMESTAMP(3), CURRENT_TIMESTAMP(3), 'course1');
insert into course (id, created_date, last_updated, name) values(11, CURRENT_TIMESTAMP(3), CURRENT_TIMESTAMP(3), 'course2');
insert into course (id, created_date, last_updated, name) values(12, CURRENT_TIMESTAMP(3), CURRENT_TIMESTAMP(3), 'course3');
insert into course (id, created_date, last_updated, name) values(13, CURRENT_TIMESTAMP(3), CURRENT_TIMESTAMP(3), 'course4');
insert into course (id, created_date, last_updated, name) values(14, CURRENT_TIMESTAMP(3), CURRENT_TIMESTAMP(3), 'course5');
insert into course (id, created_date, last_updated, name) values(15, CURRENT_TIMESTAMP(3), CURRENT_TIMESTAMP(3), 'course6');
insert into course (id, created_date, last_updated, name) values(16, CURRENT_TIMESTAMP(3), CURRENT_TIMESTAMP(3), 'course7');
insert into course (id, created_date, last_updated, name) values(17, CURRENT_TIMESTAMP(3), CURRENT_TIMESTAMP(3), 'course8');

update course set is_deleted = false;


insert into review (id, rating, description, course_id) values(30001, '5', 'great course', 10);
insert into review (id, rating, description, course_id) values(30002, '4', 'great course2', 10);
insert into review (id, rating, description, course_id) values(30003, '2', 'great course3', 12);
insert into review (id, rating, description, course_id) values(30004, '9', 'great course4', 13);


insert into student_course (student_id, course_id) values(10001, 10);
insert into student_course (student_id, course_id) values(10001, 12);
insert into student_course (student_id, course_id) values(10001, 13);
insert into student_course (student_id, course_id) values(10001, 14);
insert into student_course (student_id, course_id) values(10002, 10);
insert into student_course (student_id, course_id) values(10002, 12);
insert into student_course (student_id, course_id) values(10002, 13);
insert into student_course (student_id, course_id) values(10003, 14);
insert into student_course (student_id, course_id) values(10003, 16);
