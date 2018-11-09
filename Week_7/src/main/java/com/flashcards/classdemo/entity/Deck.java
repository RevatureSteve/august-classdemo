package com.flashcards.classdemo.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Deck {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "CATEGORY")
    private String category;

    @OneToMany
    @JoinColumn(name = "FLASHCARD_ID")
    List<FlashCard> fc;


    public Deck () {}

    public Deck(String category) {
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<FlashCard> getFc() {
        return fc;
    }

    public void setFc(List<FlashCard> fc) {
        this.fc = fc;
    }

    @Override
    public String toString() {
        return "Deck{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", fc=" + fc +
                '}';
    }
}
