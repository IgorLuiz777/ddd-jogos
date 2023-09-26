package br.com.ddd_jogos.entity;

public class Jogo {
    private String name;
    private String released;
    private String genero;
    private String developers;
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

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDevelopers() {
        return developers;
    }

    public void setDevelopers(String developers) {
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

    public void setNota(double nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Jogo{" +
                "Título='" + name + '\'' +
                ", date='" + released + '\'' +
                ", genero='" + genero + '\'' +
                ", desenvolvedora='" + developers + '\'' +
                ", id='" + id + '\'' +
                ", nota=" + nota +
                '}';
    }
}
