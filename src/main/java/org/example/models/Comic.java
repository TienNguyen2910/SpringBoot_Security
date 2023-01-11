package org.example.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Comic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int comicId;
    private String comicName;
    private String avatarComic;
    private String description;
    @ManyToOne
    @JoinColumn(name = "kindId")
    private KindOfComic kindOfComic;
    private Date datePosted;
    public Comic(){}
    public Comic(String comicName, String avatarComic, String description, KindOfComic kindOfComic, Date datePosted) {
        this.comicName = comicName;
        this.avatarComic = avatarComic;
        this.description = description;
        this.kindOfComic = kindOfComic;
        this.datePosted = datePosted;
    }

    public int getComicId() {
        return comicId;
    }

    public String getComicName() {
        return comicName;
    }

    public void setComicName(String comicName) {
        this.comicName = comicName;
    }

    public String getAvatarComic() {
        return avatarComic;
    }

    public void setAvatarComic(String avatarComic) {
        this.avatarComic = avatarComic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public KindOfComic getKindOfComic() {
        return kindOfComic;
    }

    public void setKindOfComic(KindOfComic kindOfComic) {
        this.kindOfComic = kindOfComic;
    }

    public Date getDatePosted() {
        return datePosted;
    }

    public void setDatePosted(Date datePosted) {
        this.datePosted = datePosted;
    }

    private enum status{DROP,PROCESS,FINISH};
}
