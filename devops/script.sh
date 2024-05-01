#monta container do postgres
docker run -d -p 5432:5432 -v "postgres_volume:/var/lib/postgresql/data" -e POSTGRES_PASSWORD=postgres -e PRIMARY_USER=postgres postgres

#monta container do mysql
