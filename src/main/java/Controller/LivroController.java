package Controller;

import Dao.LivroDao;
import Model.Biblioteca;
import Model.Genero;
import Model.Livro;

import java.util.List;

public class LivroController {

    LivroDao livroDao = new LivroDao();

    public void criaTabelaLivros() {
        livroDao.criaTabelaLivros();
    }

    public void cadastraLivros(Livro livro) {
        livroDao.cadastraLivros(livro);
    }

    public List<Livro> listarLivros() {
        return livroDao.listarLivros();
    }

    public List<Livro> getLivrosByIdGenero(Genero idGenero) {
        return livroDao.getLivrosByIdGenero(idGenero);
    }

    public List<Livro> getLivrosByIdBiblioteca(Biblioteca idBiblioteca) {
        return livroDao.getLivrosByIdBiblioteca(idBiblioteca);
    }
}
