CREATE DATABASE `grupo3` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
create USER 'grupo2022'@'localhost' IDENTIFIED WITH mysql_native_password BY 'pa$$word';
GRANT ALL PRIVILEGES on grupo3.* TO 'grupo2022'@'localhost';