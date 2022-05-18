DROP USER IF EXISTS '2022bd2grupo3'@'localhost';
CREATE USER '2022bd2grupo3'@'localhost' IDENTIFIED WITH mysql_native_password BY 'pa$$word';
CREATE DATABASE IF NOT EXISTS `grupo3`;
GRANT ALL PRIVILEGES on grupo3.* TO '2022bd2grupo3'@'localhost';
FLUSH PRIVILEGES;