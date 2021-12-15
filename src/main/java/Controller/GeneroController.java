package Controller;

import Dao.GeneroDao;
import Model.Genero;

import java.util.List;

public class GeneroController {
    GeneroDao generoDao = new GeneroDao();

    public void criaTabelaGeneros() {
        generoDao.criaTabelaGeneros();
    }

    public void cadastraGeneros(Genero genero) {
        generoDao.cadastraGeneros(genero);
    }

    public List<Genero> listarGeneros() {
        return generoDao.listarGeneros();
    }

    public Genero getGeneroById(int idGenero) {
        return generoDao.getGeneroById(idGenero);
    }

    public void editaGenero(Genero genero) {
        generoDao.editaGenero(genero);
    }
}
