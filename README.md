**Book-manager - restful CRUD service**

Spring Boot  
Spring WebMvc  
Spring Data JPA
PostgreSQL on Heroku               
Mapstruct               
Lombok              
Swagger                         
Liquibase

****API documentation:****                  
http://localhost:8080/swagger-ui.html

**Specification**:                      
"У нас есть сущности:               
книга - ид, код, название, описание, автор.             
отзывы по книге - ид, код, текст отзыва, оценка.

Обе сущности находятся в БД с доступом по jpa               
Требуется ведение историчности изменений.
1. Предложить структуры БД, с индексами, с возможными ссылками между сущностями
2. Создание  реста (spring boot) получающего данные по jpa для книг + отзывов"

by Reztsov Alexander

![db_schema](src/main/resources/image/db_schema.png)
![db_indexes](src/main/resources/image/db.png)
![swagger](src/main/resources/image/swagger.png)