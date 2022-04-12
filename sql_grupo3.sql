CREATE DATABASE `grupo3`;
create USER 'grupo2022'@'localhost' IDENTIFIED WITH mysql_native_password BY 'pa$$word';
GRANT ALL PRIVILEGES on grupo3.* TO 'grupo2022'@'localhost';
FLUSH PRIVILEGES;