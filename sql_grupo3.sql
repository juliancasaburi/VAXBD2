CREATE DATABASE `grupo3`;
create USER '2022bd2grupo3'@'localhost' IDENTIFIED WITH mysql_native_password BY 'pa$$word';
GRANT ALL PRIVILEGES on grupo3.* TO '2022bd2grupo3'@'localhost';