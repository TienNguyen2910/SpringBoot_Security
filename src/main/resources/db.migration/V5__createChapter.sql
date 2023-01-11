create table Chapter if not exists(
    chapterId int AUTO_INCREMENT primary key,
    chapterName varchar(40),
    comicId int
    foreign key(comicId) references Comic(comicId)
)