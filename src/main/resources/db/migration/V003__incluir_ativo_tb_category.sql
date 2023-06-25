ALTER Table rtdbv4.tb_category add active TINYINT(1) not null;
UPDATE rtdbv4.tb_category SET active = true;