INSERT INTO tb_publisher(name, contact, site) VALUES ('Editora Moderna', '+559874593', 'www.moderna.com.br');
INSERT INTO tb_publisher(name, contact, site) VALUES ('Editora Saraiva', '+551134567890', 'www.saraiva.com.br');
INSERT INTO tb_publisher(name, contact, site) VALUES ('Pearson Education', '+441632960960', 'www.pearson.com');
INSERT INTO tb_publisher(name, contact, site) VALUES ('Campus Elsevier', '+551133224455', 'www.elsevier.com.br');

INSERT INTO tb_book(title, ISBN, CDU, language_, caption, matter, country_published, year_of_edition, status) VALUES ('Programming', '2134587564', '11111', 'English', 'wwww', 'OOP', 'EUA', '2016', 0);
INSERT INTO tb_book(title, ISBN, CDU, language_, caption, matter, country_published, year_of_edition, status) VALUES ('Java para Iniciantes', '9788534605080', '005.13', 'Portuguese', 'Introdução ao Java', 'Programação', 'Brasil', '2020', 1);
INSERT INTO tb_book(title, ISBN, CDU, language_, caption, matter, country_published, year_of_edition, status) VALUES ('Estruturas de Dados', '9780132576277', '005.73', 'English', 'Fundamentos de estruturas de dados', 'Algoritmos', 'EUA', '2018', 3);
INSERT INTO tb_book(title, ISBN, CDU, language_, caption, matter, country_published, year_of_edition, status) VALUES ('Redes de Computadores', '9788582602961', '004.6', 'Portuguese', 'Conceitos de redes', 'Redes', 'Brasil', '2019', 2);

INSERT INTO tb_author(name, nationality, date_of_birth) VALUES ('Paul Deitel', 'American', TIMESTAMP WITH TIME ZONE '2025-06-10T00:55:53Z');
INSERT INTO tb_author(name, nationality, date_of_birth) VALUES ('Harvey Deitel', 'American', TIMESTAMP WITH TIME ZONE '1960-04-01T00:00:00Z');
INSERT INTO tb_author(name, nationality, date_of_birth) VALUES ('Andrew S. Tanenbaum', 'Dutch', TIMESTAMP WITH TIME ZONE '1944-03-16T00:00:00Z');
INSERT INTO tb_author(name, nationality, date_of_birth) VALUES ('José Carlos Cavalcanti', 'Brazilian', TIMESTAMP WITH TIME ZONE '1975-09-12T00:00:00Z');

INSERT INTO tb_book_author(book_id, author_id) VALUES (1, 1);
INSERT INTO tb_book_author(book_id, author_id) VALUES (2, 1);
INSERT INTO tb_book_author(book_id, author_id) VALUES (3, 2);
INSERT INTO tb_book_author(book_id, author_id) VALUES (4, 3);

INSERT INTO tb_category(type_category, book_id) VALUES (1, 1);
INSERT INTO tb_category(type_category, book_id) VALUES (2, 2);
INSERT INTO tb_category(type_category, book_id) VALUES (3, 3);
INSERT INTO tb_category(type_category, book_id) VALUES (1, 4);

INSERT INTO tb_person(name, phone, email) VALUES ('Marcelo Ofice', '877312374', 'marcelocalebjulioo@gmail.com');
INSERT INTO tb_person(name, phone, email) VALUES ('Ednilson Dava', '864362423', 'ednilsondava@gmail.com');
INSERT INTO tb_person(name, phone, email) VALUES ('Ana Paula Silva', '8798856241', 'ana.silva@example.com');
INSERT INTO tb_person(name, phone, email) VALUES ('Carlos Domingos', '8732154796', 'carlos.domingos@example.com');
INSERT INTO tb_person(name, phone, email) VALUES ('Luísa Nhantumbo', '8712547890', 'luisa.nhantumbo@example.com');
INSERT INTO tb_person(name, phone, email) VALUES ('Renato Muiambo', '8712547890', 'renatomuiambo@example.com');

INSERT INTO tb_loan(person_id, book_id, date_loan, return_date, date_returned, renew, observations, status) VALUES (1, 1, TIMESTAMP WITH TIME ZONE '2025-06-10T08:10:53Z', TIMESTAMP WITH TIME ZONE '2025-06-17T10:30:00Z', TIMESTAMP WITH TIME ZONE '2025-06-23T09:00:53Z', TIMESTAMP WITH TIME ZONE '2025-06-23T09:15:53Z', 'Inadiplete', 0);
INSERT INTO tb_loan(person_id, book_id, date_loan, return_date, date_returned, renew, observations, status) VALUES (2, 2, TIMESTAMP WITH TIME ZONE '2025-06-05T09:15:00Z', TIMESTAMP WITH TIME ZONE '2025-06-12T10:00:00Z', TIMESTAMP WITH TIME ZONE '2025-06-12T09:45:00Z', NULL, 'Entregue a tempo', 1);
INSERT INTO tb_loan(person_id, book_id, date_loan, return_date, date_returned, renew, observations, status) VALUES (3, 3, TIMESTAMP WITH TIME ZONE '2025-06-01T14:20:00Z', TIMESTAMP WITH TIME ZONE '2025-06-08T14:00:00Z', TIMESTAMP WITH TIME ZONE '2025-06-09T08:00:00Z', NULL, 'Devolvido com 1 dia de atraso', 1);
INSERT INTO tb_loan(person_id, book_id, date_loan, return_date, date_returned, renew, observations, status) VALUES (1, 4, TIMESTAMP WITH TIME ZONE '2025-06-02T10:00:00Z', TIMESTAMP WITH TIME ZONE '2025-06-09T10:00:00Z', NULL, NULL, 'Em atraso', 0);

INSERT INTO tb_department(name) VALUES ('TICs');
INSERT INTO tb_department(name) VALUES ('Administração');
INSERT INTO tb_department(name) VALUES ('Biblioteca');
INSERT INTO tb_department(name) VALUES ('RH');

INSERT INTO tb_employee(department_id, person_id, name, type_employee) VALUES (1, 2, 'TICs', 1);
INSERT INTO tb_employee(department_id, person_id, name, type_employee) VALUES (2, 3, 'Bibliotecária', 1);
INSERT INTO tb_employee(department_id, person_id, name, type_employee) VALUES (3, 1, 'Recursos Humanos', 2);
INSERT INTO tb_employee(department_id, person_id, name, type_employee) VALUES (1, 6, 'TICs', 1);

INSERT INTO tb_course(name) VALUES ('Programação');
INSERT INTO tb_course(name) VALUES ('Engenharia de Software');
INSERT INTO tb_course(name) VALUES ('Redes de Computadores');
INSERT INTO tb_course(name) VALUES ('Ciência de Dados');

INSERT INTO tb_student(course_id, person_id, year_of_study) VALUES (1, 1, 4);
INSERT INTO tb_student(course_id, person_id, year_of_study) VALUES (2, 4, 3);
INSERT INTO tb_student(course_id, person_id, year_of_study) VALUES (3, 5, 2);

