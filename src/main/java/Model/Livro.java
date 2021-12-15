package Model;

public class Livro {
    private int idLivro;
    private String nomeLivro;
    private Genero idGeneroLivro;
    private Biblioteca biblioteca;

    public int getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(int idLivro) {
        this.idLivro = idLivro;
    }

    public String getNomeLivro() {
        return nomeLivro;
    }

    public void setNomeLivro(String nomeLivro) {
        this.nomeLivro = nomeLivro;
    }

    public Genero getIdGeneroLivro() {
        return idGeneroLivro;
    }

    public void setIdGeneroLivro(Genero idGeneroLivro) {
        this.idGeneroLivro = idGeneroLivro;
    }

    public Biblioteca getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "idLivro=" + idLivro +
                ", nomeLivro='" + nomeLivro + '\'' +
                ", idGeneroLivro=" + idGeneroLivro +
                ", biblioteca=" + biblioteca +
                '}';
    }
}
