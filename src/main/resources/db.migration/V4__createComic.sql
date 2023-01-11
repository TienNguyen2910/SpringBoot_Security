create table Comic if not exists(
    comicId int AUTO_INCREMENT primary key,
    comicName varchar(60),
    avatarComic varchar(100),
    description mediumtext,
    datePosted date,
    status enum('DROP','PROCESS','FINISH'),
    kindId int
    foreign key (kindId) references KindOfComic(kindId)
)