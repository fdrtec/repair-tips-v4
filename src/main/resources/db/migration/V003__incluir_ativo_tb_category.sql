ALTER Table rtdbv4.tb_category add ativo TINYINT(1) not null;
UPDATE rtdbv4.tb_category SET ativo = true;