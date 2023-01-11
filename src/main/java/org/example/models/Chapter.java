package org.example.models;

import jakarta.persistence.*;

@Entity
public class Chapter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int chapterId;
    private String chapterName;
    @ManyToOne
    @JoinColumn(name = "comicId")
    private Comic comic;
    public Chapter(){}
    public Chapter(String chapterName, Comic comic) {
        this.chapterName = chapterName;
        this.comic = comic;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public Comic getComic() {
        return comic;
    }

    public void setComic(Comic comic) {
        this.comic = comic;
    }
}
