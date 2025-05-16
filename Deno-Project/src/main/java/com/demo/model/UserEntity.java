package com.demo.model;

import java.util.Map;

import jakarta.persistence.*;

@Entity
@Table(name = "user_details")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;

    private String name;

    @ElementCollection
    @CollectionTable(
        name = "user_plays",
        joinColumns = @JoinColumn(name = "user_id")
    )
    @MapKeyColumn(name = "sport")
    @Column(name = "score")
    private Map<String, Integer> plays;

    // Getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Integer> getPlays() {
        return plays;
    }

    public void setPlays(Map<String, Integer> plays) {
        this.plays = plays;
    }
}
