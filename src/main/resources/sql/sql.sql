CREATE DATABASE IF NOT EXISTS bilibili;
DROP DATABASE bilibili;
CREATE DATABASE bilibili;
USE bilibili;

CREATE TABLE comments (
bvid varchar(20),
appearancetime float,
commenttype int,
commentsize int,
commentcolor int,
sendtimestamp varchar(11),
pooltype int,
senderuid varchar(20),
commentdmid varchar(20) primary key,
commenttext varchar(500)
);

CREATE TABLE tasks (
bvid varchar(20) primary key
);
show tables;