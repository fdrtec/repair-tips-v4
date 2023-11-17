CREATE TABLE rtdbv4.tb_category (
	category_id BIGINT PRIMARY KEY AUTO_INCREMENT,
	category_name VARCHAR(255) NOT NULL,
	type_fk BIGINT NOT NULL,
    
    CONSTRAINT category_type_fk   
    FOREIGN KEY (type_fk) REFERENCES rtdbv4.tb_type (type_id)    
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;