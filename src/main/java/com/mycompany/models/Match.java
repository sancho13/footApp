package com.mycompany.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Marseillais on 31/05/2016.
 */
@Entity
public class Match  {

    private Long id;
    private Date date;
    private String score ;
    private List<Equipe> equipes;



    public Match() {
    }

    public Match(Long id, Date date, String score,List<Equipe> equipes) {
        this.id = id;
        this.date = date;
        this.score = score;
        this.equipes=equipes;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    @OneToMany
    public List<Equipe> getEquipes() {
        return equipes;
    }

    public void setEquipes(List<Equipe> equipes) {
        this.equipes = equipes;
    }
}
