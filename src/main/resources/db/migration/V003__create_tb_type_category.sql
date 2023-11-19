CREATE TABLE rtdb.tb_type_category (
	type_id BIGINT NOT NULL,    
	category_id BIGINT NOT NULL,

    PRIMARY KEY(type_id, category_id),
    
    CONSTRAINT category_type_fk
    FOREIGN KEY (category_id) REFERENCES rtdb.tb_category(id),

    CONSTRAINT type_category_fk
    FOREIGN KEY (type_id) REFERENCES rtdb.tb_type(id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;