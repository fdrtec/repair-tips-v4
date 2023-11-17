CREATE TABLE nome_table(
    id INT
    nome VARCHAR(50) NOT NULL,
    entidade_id INT
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;

ALTER TABLE nome_table
MODIFY COLUMN id INT AUTO_INCREMENT,
ADD PRIMARY KEY (id);

CREATE TABLE tabela_uuid(
    id BINARY(16) PRIMARY KEY,
    atributo VARCHAR(150) NOT NULL UNIQUE,
    entidade_id BINARY(16)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;

# Criar tabelas sem ligações de FK, deixar para segundo momento para customizar o
# nome da ligação de forma mais amigável (evitar nome automatizados do banco)

