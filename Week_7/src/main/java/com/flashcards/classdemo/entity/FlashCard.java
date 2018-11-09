package com.flashcards.classdemo.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table
public class FlashCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String question;

    private String answer;

    @Column(name = "DECK_ID")
    private int deckId;

    public FlashCard() {
    }

    public FlashCard(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getDeckId() {
        return deckId;
    }

    public void setDeckId(int deckId) {
        this.deckId = deckId;
    }

    @Override
    public String toString() {
        return "FlashCard{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        FlashCard flashCard = (FlashCard) o;
        return id == flashCard.id &&
                Objects.equals(question, flashCard.question) &&
                Objects.equals(answer, flashCard.answer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, question, answer);
    }
}
