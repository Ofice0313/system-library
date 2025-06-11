INSERT INTO tb_publisher(name, contact, site) VALUES ('Editora Moderna', '+559874593', 'www.moderna.com.br');

INSERT INTO tb_book(title, ISBN, CDU, language_, caption, matter, country_published, year_of_edition, publisher_id) VALUES ('Programming', '2134587564', '11111', 'English', 'wwww', 'OOP', 'EUA', '2016', 1);

INSERT INTO tb_author(name, nationality, date_of_birth) VALUES ('Paul Deitel', 'American', TIMESTAMP WITH TIME ZONE '2025-06-10T00:55:53Z');

INSERT INTO tb_book_author(book_id, author_id) VALUES (1, 1);

INSERT INTO tb_category(type_category, book_id) VALUES (1, 1);

INSERT INTO tb_person(name, phone, email) VALUES ('Marcelo Ofice', '877312374', 'marcelocalebjulioo@gmail.com');
INSERT INTO tb_person(name, phone, email) VALUES ('Ednilson Dava', '864362423', 'ednilsondava@gmail.com');

INSERT INTO tb_loan(person_id, book_id, date_loan, return_date, date_returned, renew, observations) VALUES (1, 1, TIMESTAMP WITH TIME ZONE '2025-06-10T08:10:53Z', TIMESTAMP WITH TIME ZONE '2025-06-17T10:30:00Z', TIMESTAMP WITH TIME ZONE '2025-06-23T09:00:53Z', TIMESTAMP WITH TIME ZONE '2025-06-23T09:15:53Z', 'Inadiplete');

INSERT INTO tb_department(name) VALUES ('TICs');

INSERT INTO tb_employee(department_id, person_id, name, type_employee) VALUES (1, 2, 'TICs', 2);

INSERT INTO tb_course(name) VALUES ('Programação');

INSERT INTO tb_student(course_id, person_id, year_of_study) VALUES (1, 1, 4);

