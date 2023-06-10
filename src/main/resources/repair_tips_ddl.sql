
    create table tb_category (
       category_id binary(16) not null,
        category_name varchar(255) not null,
        type_fk binary(16) not null,
        primary key (category_id)
    ) engine=InnoDB;

    create table tb_type (
       type_id binary(16) not null,
        type_name varchar(255) not null,
        primary key (type_id)
    ) engine=InnoDB;

    alter table tb_category 
       add constraint UK_e07bosf57ulahhtqrdw4bila2 unique (category_name);

    alter table tb_type 
       add constraint UK_uy1ryicl81x9pdqrt5en0ejp unique (type_name);

    alter table tb_category 
       add constraint FK3kvs7wqd6e3sne1ttjsxol5el 
       foreign key (type_fk) 
       references tb_type (type_id);
INSERT INTO tb_type (type_id,type_name) VALUES (0xD46F202DD4A84F129564C22EEFB2C843,'Impressora');
INSERT INTO tb_type (type_id,type_name) VALUES (0xD46F202DD4A84F129564C22EEFB2C844,'Notebook');
INSERT INTO tb_type (type_id,type_name) VALUES (0xD46F202DD4A84F129564C22EEFB2C845,'Telefone');
INSERT INTO tb_category (category_id,category_name, type_fk) VALUES (0xD46F202DD4A84F129564C22EEFB2C846,'Laser', 0xD46F202DD4A84F129564C22EEFB2C843);
INSERT INTO tb_category (category_id,category_name, type_fk) VALUES (0xD46F202DD4A84F129564C22EEFB2C847,'Jato de tinta', 0xD46F202DD4A84F129564C22EEFB2C843);
INSERT INTO tb_category (category_id,category_name, type_fk) VALUES (0xD46F202DD4A84F129564C22EEFB2C848,'Matricial', 0xD46F202DD4A84F129564C22EEFB2C843);

    create table tb_category (
       category_id binary(16) not null,
        category_name varchar(255) not null,
        type_fk binary(16) not null,
        primary key (category_id)
    ) engine=InnoDB;

    create table tb_type (
       type_id binary(16) not null,
        type_name varchar(255) not null,
        primary key (type_id)
    ) engine=InnoDB;

    alter table tb_category 
       add constraint UK_e07bosf57ulahhtqrdw4bila2 unique (category_name);

    alter table tb_type 
       add constraint UK_uy1ryicl81x9pdqrt5en0ejp unique (type_name);

    alter table tb_category 
       add constraint FK3kvs7wqd6e3sne1ttjsxol5el 
       foreign key (type_fk) 
       references tb_type (type_id);
INSERT INTO tb_type (type_id,type_name) VALUES (0xD46F202DD4A84F129564C22EEFB2C843,'Impressora');
INSERT INTO tb_type (type_id,type_name) VALUES (0xD46F202DD4A84F129564C22EEFB2C844,'Notebook');
INSERT INTO tb_type (type_id,type_name) VALUES (0xD46F202DD4A84F129564C22EEFB2C845,'Telefone');
INSERT INTO tb_category (category_id,category_name, type_fk) VALUES (0xD46F202DD4A84F129564C22EEFB2C846,'Laser', 0xD46F202DD4A84F129564C22EEFB2C843);
INSERT INTO tb_category (category_id,category_name, type_fk) VALUES (0xD46F202DD4A84F129564C22EEFB2C847,'Jato de tinta', 0xD46F202DD4A84F129564C22EEFB2C843);
INSERT INTO tb_category (category_id,category_name, type_fk) VALUES (0xD46F202DD4A84F129564C22EEFB2C848,'Matricial', 0xD46F202DD4A84F129564C22EEFB2C843);

    create table tb_category (
       category_id binary(16) not null,
        category_name varchar(255) not null,
        type_fk binary(16) not null,
        primary key (category_id)
    ) engine=InnoDB;

    create table tb_type (
       type_id binary(16) not null,
        type_name varchar(255) not null,
        primary key (type_id)
    ) engine=InnoDB;

    alter table tb_category 
       add constraint UK_e07bosf57ulahhtqrdw4bila2 unique (category_name);

    alter table tb_type 
       add constraint UK_uy1ryicl81x9pdqrt5en0ejp unique (type_name);

    alter table tb_category 
       add constraint FK3kvs7wqd6e3sne1ttjsxol5el 
       foreign key (type_fk) 
       references tb_type (type_id);
INSERT INTO tb_type (type_id,type_name) VALUES (0xD46F202DD4A84F129564C22EEFB2C843,'Impressora');
INSERT INTO tb_type (type_id,type_name) VALUES (0xD46F202DD4A84F129564C22EEFB2C844,'Notebook');
INSERT INTO tb_type (type_id,type_name) VALUES (0xD46F202DD4A84F129564C22EEFB2C845,'Telefone');
INSERT INTO tb_category (category_id,category_name, type_fk) VALUES (0xD46F202DD4A84F129564C22EEFB2C846,'Laser', 0xD46F202DD4A84F129564C22EEFB2C843);
INSERT INTO tb_category (category_id,category_name, type_fk) VALUES (0xD46F202DD4A84F129564C22EEFB2C847,'Jato de tinta', 0xD46F202DD4A84F129564C22EEFB2C843);
INSERT INTO tb_category (category_id,category_name, type_fk) VALUES (0xD46F202DD4A84F129564C22EEFB2C848,'Matricial', 0xD46F202DD4A84F129564C22EEFB2C843);

    create table tb_category (
       category_id binary(16) not null,
        category_name varchar(255) not null,
        type_fk binary(16) not null,
        primary key (category_id)
    ) engine=InnoDB;

    create table tb_type (
       type_id binary(16) not null,
        type_name varchar(255) not null,
        primary key (type_id)
    ) engine=InnoDB;

    alter table tb_category 
       add constraint UK_e07bosf57ulahhtqrdw4bila2 unique (category_name);

    alter table tb_type 
       add constraint UK_uy1ryicl81x9pdqrt5en0ejp unique (type_name);

    alter table tb_category 
       add constraint FK3kvs7wqd6e3sne1ttjsxol5el 
       foreign key (type_fk) 
       references tb_type (type_id);
INSERT INTO tb_type (type_id,type_name) VALUES (0xD46F202DD4A84F129564C22EEFB2C843,'Impressora');
INSERT INTO tb_type (type_id,type_name) VALUES (0xD46F202DD4A84F129564C22EEFB2C844,'Notebook');
INSERT INTO tb_type (type_id,type_name) VALUES (0xD46F202DD4A84F129564C22EEFB2C845,'Telefone');
INSERT INTO tb_category (category_id,category_name, type_fk) VALUES (0xD46F202DD4A84F129564C22EEFB2C846,'Laser', 0xD46F202DD4A84F129564C22EEFB2C843);
INSERT INTO tb_category (category_id,category_name, type_fk) VALUES (0xD46F202DD4A84F129564C22EEFB2C847,'Jato de tinta', 0xD46F202DD4A84F129564C22EEFB2C843);
INSERT INTO tb_category (category_id,category_name, type_fk) VALUES (0xD46F202DD4A84F129564C22EEFB2C848,'Matricial', 0xD46F202DD4A84F129564C22EEFB2C843);

    create table tb_category (
       category_id binary(16) not null,
        category_name varchar(255) not null,
        type_fk binary(16) not null,
        primary key (category_id)
    ) engine=InnoDB;

    create table tb_type (
       type_id binary(16) not null,
        type_name varchar(255) not null,
        primary key (type_id)
    ) engine=InnoDB;

    alter table tb_category 
       add constraint UK_e07bosf57ulahhtqrdw4bila2 unique (category_name);

    alter table tb_type 
       add constraint UK_uy1ryicl81x9pdqrt5en0ejp unique (type_name);

    alter table tb_category 
       add constraint FK3kvs7wqd6e3sne1ttjsxol5el 
       foreign key (type_fk) 
       references tb_type (type_id);
INSERT INTO tb_type (type_id,type_name) VALUES (0xD46F202DD4A84F129564C22EEFB2C843,'Impressora');
INSERT INTO tb_type (type_id,type_name) VALUES (0xD46F202DD4A84F129564C22EEFB2C844,'Notebook');
INSERT INTO tb_type (type_id,type_name) VALUES (0xD46F202DD4A84F129564C22EEFB2C845,'Telefone');
INSERT INTO tb_category (category_id,category_name, type_fk) VALUES (0xD46F202DD4A84F129564C22EEFB2C846,'Laser', 0xD46F202DD4A84F129564C22EEFB2C843);
INSERT INTO tb_category (category_id,category_name, type_fk) VALUES (0xD46F202DD4A84F129564C22EEFB2C847,'Jato de tinta', 0xD46F202DD4A84F129564C22EEFB2C843);
INSERT INTO tb_category (category_id,category_name, type_fk) VALUES (0xD46F202DD4A84F129564C22EEFB2C848,'Matricial', 0xD46F202DD4A84F129564C22EEFB2C843);

    create table tb_category (
       category_id binary(16) not null,
        category_name varchar(255) not null,
        type_fk binary(16) not null,
        primary key (category_id)
    ) engine=InnoDB;

    create table tb_type (
       type_id binary(16) not null,
        type_name varchar(255) not null,
        primary key (type_id)
    ) engine=InnoDB;

    alter table tb_category 
       add constraint UK_e07bosf57ulahhtqrdw4bila2 unique (category_name);

    alter table tb_type 
       add constraint UK_uy1ryicl81x9pdqrt5en0ejp unique (type_name);

    alter table tb_category 
       add constraint FK3kvs7wqd6e3sne1ttjsxol5el 
       foreign key (type_fk) 
       references tb_type (type_id);
INSERT INTO tb_type (type_id,type_name) VALUES (0xD46F202DD4A84F129564C22EEFB2C843,'Impressora');
INSERT INTO tb_type (type_id,type_name) VALUES (0xD46F202DD4A84F129564C22EEFB2C844,'Notebook');
INSERT INTO tb_type (type_id,type_name) VALUES (0xD46F202DD4A84F129564C22EEFB2C845,'Telefone');
INSERT INTO tb_category (category_id,category_name, type_fk) VALUES (0xD46F202DD4A84F129564C22EEFB2C846,'Laser', 0xD46F202DD4A84F129564C22EEFB2C843);
INSERT INTO tb_category (category_id,category_name, type_fk) VALUES (0xD46F202DD4A84F129564C22EEFB2C847,'Jato de tinta', 0xD46F202DD4A84F129564C22EEFB2C843);
INSERT INTO tb_category (category_id,category_name, type_fk) VALUES (0xD46F202DD4A84F129564C22EEFB2C848,'Matricial', 0xD46F202DD4A84F129564C22EEFB2C843);

    create table tb_category (
       category_id binary(16) not null,
        category_name varchar(255) not null,
        type_fk binary(16) not null,
        primary key (category_id)
    ) engine=InnoDB;

    create table tb_type (
       type_id binary(16) not null,
        type_name varchar(255) not null,
        primary key (type_id)
    ) engine=InnoDB;

    alter table tb_category 
       add constraint UK_e07bosf57ulahhtqrdw4bila2 unique (category_name);

    alter table tb_type 
       add constraint UK_uy1ryicl81x9pdqrt5en0ejp unique (type_name);

    alter table tb_category 
       add constraint FK3kvs7wqd6e3sne1ttjsxol5el 
       foreign key (type_fk) 
       references tb_type (type_id);
INSERT INTO tb_type (type_id,type_name) VALUES (0xD46F202DD4A84F129564C22EEFB2C843,'Impressora');
INSERT INTO tb_type (type_id,type_name) VALUES (0xD46F202DD4A84F129564C22EEFB2C844,'Notebook');
INSERT INTO tb_type (type_id,type_name) VALUES (0xD46F202DD4A84F129564C22EEFB2C845,'Telefone');
INSERT INTO tb_category (category_id,category_name, type_fk) VALUES (0xD46F202DD4A84F129564C22EEFB2C846,'Laser', 0xD46F202DD4A84F129564C22EEFB2C843);
INSERT INTO tb_category (category_id,category_name, type_fk) VALUES (0xD46F202DD4A84F129564C22EEFB2C847,'Jato de tinta', 0xD46F202DD4A84F129564C22EEFB2C843);
INSERT INTO tb_category (category_id,category_name, type_fk) VALUES (0xD46F202DD4A84F129564C22EEFB2C848,'Matricial', 0xD46F202DD4A84F129564C22EEFB2C843);

    create table tb_category (
       category_id binary(16) not null,
        category_name varchar(255) not null,
        type_fk binary(16) not null,
        primary key (category_id)
    ) engine=InnoDB;

    create table tb_type (
       type_id binary(16) not null,
        type_name varchar(255) not null,
        primary key (type_id)
    ) engine=InnoDB;

    alter table tb_category 
       add constraint UK_e07bosf57ulahhtqrdw4bila2 unique (category_name);

    alter table tb_type 
       add constraint UK_uy1ryicl81x9pdqrt5en0ejp unique (type_name);

    alter table tb_category 
       add constraint FK3kvs7wqd6e3sne1ttjsxol5el 
       foreign key (type_fk) 
       references tb_type (type_id);
INSERT INTO tb_type (type_id,type_name) VALUES (0xD46F202DD4A84F129564C22EEFB2C843,'Impressora');
INSERT INTO tb_type (type_id,type_name) VALUES (0xD46F202DD4A84F129564C22EEFB2C844,'Notebook');
INSERT INTO tb_type (type_id,type_name) VALUES (0xD46F202DD4A84F129564C22EEFB2C845,'Telefone');
INSERT INTO tb_category (category_id,category_name, type_fk) VALUES (0xD46F202DD4A84F129564C22EEFB2C846,'Laser', 0xD46F202DD4A84F129564C22EEFB2C843);
INSERT INTO tb_category (category_id,category_name, type_fk) VALUES (0xD46F202DD4A84F129564C22EEFB2C847,'Jato de tinta', 0xD46F202DD4A84F129564C22EEFB2C843);
INSERT INTO tb_category (category_id,category_name, type_fk) VALUES (0xD46F202DD4A84F129564C22EEFB2C848,'Matricial', 0xD46F202DD4A84F129564C22EEFB2C843);

    create table tb_category (
       category_id binary(16) not null,
        category_name varchar(255) not null,
        type_fk binary(16) not null,
        primary key (category_id)
    ) engine=InnoDB;

    create table tb_type (
       type_id binary(16) not null,
        type_name varchar(255) not null,
        primary key (type_id)
    ) engine=InnoDB;

    alter table tb_category 
       add constraint UK_e07bosf57ulahhtqrdw4bila2 unique (category_name);

    alter table tb_type 
       add constraint UK_uy1ryicl81x9pdqrt5en0ejp unique (type_name);

    alter table tb_category 
       add constraint FK3kvs7wqd6e3sne1ttjsxol5el 
       foreign key (type_fk) 
       references tb_type (type_id);
INSERT INTO tb_type (type_id,type_name) VALUES (0xD46F202DD4A84F129564C22EEFB2C843,'Impressora');
INSERT INTO tb_type (type_id,type_name) VALUES (0xD46F202DD4A84F129564C22EEFB2C844,'Notebook');
INSERT INTO tb_type (type_id,type_name) VALUES (0xD46F202DD4A84F129564C22EEFB2C845,'Telefone');
INSERT INTO tb_category (category_id,category_name, type_fk) VALUES (0xD46F202DD4A84F129564C22EEFB2C846,'Laser', 0xD46F202DD4A84F129564C22EEFB2C843);
INSERT INTO tb_category (category_id,category_name, type_fk) VALUES (0xD46F202DD4A84F129564C22EEFB2C847,'Jato de tinta', 0xD46F202DD4A84F129564C22EEFB2C843);
INSERT INTO tb_category (category_id,category_name, type_fk) VALUES (0xD46F202DD4A84F129564C22EEFB2C848,'Matricial', 0xD46F202DD4A84F129564C22EEFB2C843);

    create table tb_category (
       category_id binary(16) not null,
        category_name varchar(255) not null,
        type_fk binary(16) not null,
        primary key (category_id)
    ) engine=InnoDB;

    create table tb_type (
       type_id binary(16) not null,
        type_name varchar(255) not null,
        primary key (type_id)
    ) engine=InnoDB;

    alter table tb_category 
       add constraint UK_e07bosf57ulahhtqrdw4bila2 unique (category_name);

    alter table tb_type 
       add constraint UK_uy1ryicl81x9pdqrt5en0ejp unique (type_name);

    alter table tb_category 
       add constraint FK3kvs7wqd6e3sne1ttjsxol5el 
       foreign key (type_fk) 
       references tb_type (type_id);
INSERT INTO tb_type (type_id,type_name) VALUES (0xD46F202DD4A84F129564C22EEFB2C843,'Impressora');
INSERT INTO tb_type (type_id,type_name) VALUES (0xD46F202DD4A84F129564C22EEFB2C844,'Notebook');
INSERT INTO tb_type (type_id,type_name) VALUES (0xD46F202DD4A84F129564C22EEFB2C845,'Telefone');
INSERT INTO tb_category (category_id,category_name, type_fk) VALUES (0xD46F202DD4A84F129564C22EEFB2C846,'Laser', 0xD46F202DD4A84F129564C22EEFB2C843);
INSERT INTO tb_category (category_id,category_name, type_fk) VALUES (0xD46F202DD4A84F129564C22EEFB2C847,'Jato de tinta', 0xD46F202DD4A84F129564C22EEFB2C843);
INSERT INTO tb_category (category_id,category_name, type_fk) VALUES (0xD46F202DD4A84F129564C22EEFB2C848,'Matricial', 0xD46F202DD4A84F129564C22EEFB2C843);
