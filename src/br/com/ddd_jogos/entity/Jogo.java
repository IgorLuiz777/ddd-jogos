package br.com.ddd_jogos.entity;

import java.util.List;

public class Jogo {
    private String name;
    private String released;
    private List<Genre> genres;
    private List<Developer> developers;
    private String id;
    private double nota;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return released;
    }

    public void setDate(String date) {
        this.released = date;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public List<Developer> getDevelopers() {
        return developers;
    }

    public void setDevelopers(List<Developer> developers) {
        this.developers = developers;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getNota() {
        return nota;
    }

    public String getReleased() {
        return released;
    }

    public void setReleased(String released) {
        this.released = released;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Jogo{" +
                "Título='" + name + '\'' +
                ", date='" + released + '\'' +
                ", genero='" + genres + '\'' +
                ", desenvolvedora='" + developers + '\'' +
                ", id='" + id + '\'' +
                ", nota=" + nota +
                '}';
    }
}
