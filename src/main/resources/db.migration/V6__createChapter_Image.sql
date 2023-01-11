create table Chapter_Image if not exists(
    chapterImageId int AUTO_INCREMENT primary key,
    pathImage varchar(100),
    chapterId int
    foreign key(chapterId) references Chapter(chapterId)
)