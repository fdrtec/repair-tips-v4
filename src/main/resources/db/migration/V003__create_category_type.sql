CREATE TABLE rtdbv4.tb_category_type (
	category_id BIGINT NOT NULL,
	type_id BIGINT NOT NULL,    
    
    CONSTRAINT category_type_fk
    FOREIGN KEY (category_id) REFERENCES rtdbv4.tb_category(id),

    CONSTRAINT type_category_fk
    FOREIGN KEY (type_id) REFERENCES rtdbv4.tb_type(id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;