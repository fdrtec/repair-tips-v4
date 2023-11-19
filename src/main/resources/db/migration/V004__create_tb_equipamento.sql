CREATE TABLE rtdb.tb_equipment (
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(150) NOT NULL,
    model VARCHAR(150) NOT NULL,
    manufacturer_id BIGINT NOT NULL, 	
    category_id BIGINT NOT NULL,
    type_id  BIGINT NOT NULL,

    CONSTRAINT equipament_category_fk
    FOREIGN KEY (category_id) REFERENCES rtdb.tb_category(id),

    CONSTRAINT equipament_type_fk
    FOREIGN KEY (type_id) REFERENCES rtdb.tb_type(id)    
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;