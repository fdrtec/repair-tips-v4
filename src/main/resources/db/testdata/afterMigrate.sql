-- INSERT IGNORE INTO tb_type (type_id,created_date,last_modified_date,type_name) VALUES (0xD46F202DD4A84F129564C22EEFB2C843,'2023-05-10 23:23:34.984684000','2023-05-10 23:23:34.984684000','Impressora');

-- auto increment
INSERT INTO tb_type (type_id, type_name) VALUES (1,'Impressora');
INSERT INTO tb_type (type_id, type_name) VALUES (2,'Notebook');
INSERT INTO tb_type (type_id, type_name) VALUES (3,'Telefone');

INSERT INTO tb_category (category_name, category_type_fk, category_active) VALUES ('Laser', 1, true);
INSERT INTO tb_category (category_name, category_type_fk, category_active) VALUES ('Jato de tinta', 1, true);
INSERT INTO tb_category (category_name, category_type_fk, category_active) VALUES ('Matricial', 1, true);



