package com.flashcards.classdemo.entity;

import javax.persistence.*;

/**
 * This is to represent the comedians that will be studying using their flashcards lol
 * @author Chuma,
 * @author Josh,
 * @author Mohammed,
 * @author Hernan
 *
 * @see com.flashcards.classdemo.entity.FlashCard;
 */

@Entity
@Table
public class Comedian {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "STAGE_NAME")
    private String name;
    private String cityOrigin;
    @Column(name = "Pop_Rating")
    private int fiveStarRating;

    Comedian(){}

    public Comedian(String name, String cityOrigin, int fiveStarRating) {
        this.name = name;
        this.cityOrigin = cityOrigin;
        this.fiveStarRating = fiveStarRating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCityOrigin() {
        return cityOrigin;
    }

    public void setCityOrigin(String cityOrigin) {
        this.cityOrigin = cityOrigin;
    }

    public int getFiveStarRating() {
        return fiveStarRating;
    }

    public void setFiveStarRating(int fiveStarRating) {
        this.fiveStarRating = fiveStarRating;
    }

    @Override
    public String toString() {
        return "Comedian{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cityOrigin='" + cityOrigin + '\'' +
                ", fiveStarRating=" + fiveStarRating +
                '}';
    }
}
