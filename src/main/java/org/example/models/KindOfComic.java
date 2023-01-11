package org.example.models;

import jakarta.persistence.*;


@Entity
public class KindOfComic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int kindId;
    private String kindName;
    public KindOfComic(){}
    public KindOfComic(String typeName) {
        this.kindName = typeName;
    }

    public int getTypeId() {
        return kindId;
    }

    public String getTypeName() {
        return kindName;
    }

    public void setTypeName(String typeName) {
        this.kindName = typeName;
    }
}
