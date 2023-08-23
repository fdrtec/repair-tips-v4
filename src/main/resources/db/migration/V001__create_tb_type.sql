CREATE TABLE rtdbv4.tb_type (
	type_id BINARY(16) NOT NULL,
	type_name VARCHAR(255) NOT NULL,

    PRIMARY KEY(type_id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;
