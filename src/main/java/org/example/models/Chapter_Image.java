package org.example.models;

import jakarta.persistence.*;

@Entity
public class Chapter_Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int chapterImageId;
    private String pathImage;
    @ManyToOne
    @JoinColumn(name = "chapterId")
    private Chapter chapter;
    public Chapter_Image(){}
    public Chapter_Image(String pathImage, Chapter chapter) {
        this.pathImage = pathImage;
        this.chapter = chapter;
    }

    public int getChapterImageId() {
        return chapterImageId;
    }

    public String getPathImage() {
        return pathImage;
    }

    public void setPathImage(String pathImage) {
        this.pathImage = pathImage;
    }

    public Chapter getChapter() {
        return chapter;
    }

    public void setChapter(Chapter chapter) {
        this.chapter = chapter;
    }
}
