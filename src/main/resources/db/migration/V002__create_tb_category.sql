CREATE TABLE rtdbv4.tb_category (
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(255) NOT NULL,
	type_id BIGINT NOT NULL,
    active TINYINT(1) NOT NULL,
    
    CONSTRAINT category_type
    FOREIGN KEY (type_id) REFERENCES rtdbv4.tb_type(id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;