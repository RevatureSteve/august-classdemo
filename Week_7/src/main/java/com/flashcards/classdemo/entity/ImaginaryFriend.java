package com.flashcards.classdemo.entity;

import javax.persistence.*;

/**
 * @author Jonathan
 * @author Felipe
 * @author Christina
 * this creates java bean
 */
@Entity
@Table
public class ImaginaryFriend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String color;

    private String species;

    private String description;

    private String size; //big small medium

    public ImaginaryFriend() {
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "ImaginaryFriend{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", species='" + species + '\'' +
                ", description='" + description + '\'' +
                ", size='" + size + '\'' +
                '}';
    }
}
