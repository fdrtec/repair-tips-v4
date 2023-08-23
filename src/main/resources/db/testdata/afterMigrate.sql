-- INSERT IGNORE INTO tb_type (type_id,created_date,last_modified_date,type_name) VALUES (0xD46F202DD4A84F129564C22EEFB2C843,'2023-05-10 23:23:34.984684000','2023-05-10 23:23:34.984684000','Impressora');
INSERT IGNORE INTO tb_type (type_id,type_name) VALUES (0xD46F202DD4A84F129564C22EEFB2C843,'Impressora');
INSERT IGNORE INTO tb_type (type_id,type_name) VALUES (0xD46F202DD4A84F129564C22EEFB2C844,'Notebook');
INSERT IGNORE INTO tb_type (type_id,type_name) VALUES (0xD46F202DD4A84F129564C22EEFB2C845,'Telefone');

INSERT IGNORE INTO tb_category (category_id,category_name, category_type_fk, category_active) VALUES (0xD46F202DD4A84F129564C22EEFB2C846,'Laser', 0xD46F202DD4A84F129564C22EEFB2C843, true);
INSERT IGNORE INTO tb_category (category_id,category_name, category_type_fk, category_active) VALUES (0xD46F202DD4A84F129564C22EEFB2C847,'Jato de tinta', 0xD46F202DD4A84F129564C22EEFB2C843, true);
INSERT IGNORE INTO tb_category (category_id,category_name, category_type_fk, category_active) VALUES (0xD46F202DD4A84F129564C22EEFB2C848,'Matricial', 0xD46F202DD4A84F129564C22EEFB2C843, true);


