create table if not exists user
(
    id         int not null primary key auto_increment,
    user_name  varchar(50),
    user_phone varchar(50)
);