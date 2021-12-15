package Controller;

import Dao.BibliotecaDao;
import Model.Biblioteca;

import java.util.List;

public class BibliotecaController {

    BibliotecaDao bibliotecaDao = new BibliotecaDao();

    public void criaTabelaBiblioteca() {
        bibliotecaDao.criaTabelaBiblioteca();
    }

    public void cadastraBibliotecas(Biblioteca biblioteca) {
        bibliotecaDao.cadastraBiblioteca(biblioteca);
    }

    public List<Biblioteca> listarBibliotecas() {
        return bibliotecaDao.listarBibliotecas();
    }

    public Biblioteca getBibliotecasById(int idBiblioteca) {
        return bibliotecaDao.getBibliotecaById(idBiblioteca);
    }

}
