-- INSERT IGNORE INTO tb_type (type_id,created_date,last_modified_date,type_name) VALUES (0xD46F202DD4A84F129564C22EEFB2C843,'2023-05-10 23:23:34.984684000','2023-05-10 23:23:34.984684000','Impressora');

-- auto increment
INSERT IGNORE INTO tb_type (id, name) VALUES (1,'Impressora');
INSERT IGNORE INTO tb_type (id, name) VALUES (2,'Notebook');
INSERT IGNORE INTO tb_type (id, name) VALUES (3,'Telefone');

INSERT IGNORE INTO tb_category (id, name, active) VALUES (101, 'Laser', true);
INSERT  IGNORE INTO tb_category (id, name, active) VALUES (102, 'Jato de tinta', true);
INSERT IGNORE INTO tb_category (id, name, active) VALUES (103, 'Matricial', true);

INSERT  IGNORE INTO tb_type_category(type_id, category_id) values (1, 101);
INSERT  IGNORE INTO tb_type_category(type_id, category_id) values (1, 102);
INSERT IGNORE INTO tb_type_category(type_id, category_id) values (1, 103);




