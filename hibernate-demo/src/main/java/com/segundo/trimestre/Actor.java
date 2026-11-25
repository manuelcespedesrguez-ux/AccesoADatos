package com.segundo.trimestre;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "actor")
public class Actor {
    @Id
    @Column(name = "actor_id")
    private Integer actor_id;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "last_update")
    private LocalDateTime last_update;

    // En film_actor: joinColumns ("actor_id") enlaza con Actor y inverseJoinColumns ("film_id") enlaza con Film
    @ManyToMany
    @JoinTable(name = "film_actor", joinColumns = @JoinColumn(name = "actor_id"), inverseJoinColumns = @JoinColumn(name = "film_id"))
    List<Film> films = new ArrayList<>();

    protected Actor() {
    }

    public Integer getActor_id() {
        return actor_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public LocalDateTime getLast_update() {
        return last_update;
    }

    public List<Film> getFilms() {
        return films;
    }

}
