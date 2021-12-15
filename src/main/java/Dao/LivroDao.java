package Dao;

import Factory.ConectionFactory;
import Model.Biblioteca;
import Model.Genero;
import Model.Livro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LivroDao {

    private Connection connection;

    public LivroDao() {
        this.connection = new ConectionFactory().getConection();
    }

    public void criaTabelaLivros() {
        String sql = "CREATE TABLE IF NOT EXISTS livros(" +
                "idLivro INT PRIMARY KEY AUTO_INCREMENT," +
                "nomeLivro VARCHAR(50) NOT NULL," +
                "idGenero INT," +
                "FOREIGN KEY (idGenero) " +
                "REFERENCES generos(idGenero),"+
                "idBiblioteca INT," +
                "FOREIGN KEY (idBiblioteca) " +
                "REFERENCES bibliotecas(idBiblioteca)"+
                ");";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("ERRO AO CRIAR TABELA DE LIVROS");
        }
    }

    public void cadastraLivros(Livro livro) {
        String sql = "INSERT INTO livros"+
                "(nomeLivro, idGenero,idBiblioteca)" +
                "VALUES (?,?,?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1, livro.getNomeLivro());
            stmt.setInt(2,livro.getIdGeneroLivro().getIdGenero());
            stmt.setInt(3,livro.getBiblioteca().getIdBiblioteca());

            stmt.execute();

            ResultSet resultSet = stmt.getGeneratedKeys();

            while (resultSet.next()) {
                livro.setIdLivro(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            System.out.println("ERRO AO CADASTRAR NA TABELA DE LIVROS");
        }
    }

    public List<Livro> listarLivros() {
        String sql = "SELECT * FROM livros";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultSet = stmt.executeQuery();

            List<Livro> listaDeLivros = new ArrayList<>();

            while (resultSet.next()) {
                Livro livro = new Livro();

                livro.setIdLivro(resultSet.getInt("idLivro"));
                livro.setNomeLivro(resultSet.getString("nomeLivro"));

                GeneroDao generoDao = new GeneroDao();
                Genero genero = generoDao.getGeneroById(resultSet.getInt("idGenero"));
                livro.setIdGeneroLivro(genero);

                BibliotecaDao bibliotecaDao = new BibliotecaDao();
                Biblioteca biblioteca = bibliotecaDao.getBibliotecaById(resultSet.getInt("idBiblioteca"));
                livro.setBiblioteca(biblioteca);

                listaDeLivros.add(livro);
            }

            return listaDeLivros;
        } catch (SQLException e) {
            System.out.println("ERRO AO LISTAR LIVROS");
        }
        return null;
    }

    public List<Livro> getLivrosByIdGenero(Genero generoSelecionado) {
        String sql = "SELECT * FROM livros WHERE idGenero = ?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, generoSelecionado.getIdGenero());

            ResultSet resultSet = stmt.executeQuery();
            List<Livro> listaDeLivros = new ArrayList<>();

            while(resultSet.next()) {
                Livro livro = new Livro();

                livro.setIdLivro(resultSet.getInt("idLivro"));
                livro.setNomeLivro(resultSet.getString("nomeLivro"));

                GeneroDao generoDao = new GeneroDao();
                Genero genero = generoDao.getGeneroById(resultSet.getInt("idGenero"));
                livro.setIdGeneroLivro(genero);

                BibliotecaDao bibliotecaDao = new BibliotecaDao();
                Biblioteca biblioteca = bibliotecaDao.getBibliotecaById(resultSet.getInt("idBiblioteca"));
                livro.setBiblioteca(biblioteca);

                listaDeLivros.add(livro);
            }
            return listaDeLivros;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Livro> getLivrosByIdBiblioteca(Biblioteca bibliotecaSelecionada) {
        String sql = "SELECT * FROM livros WHERE idBiblioteca = ?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, bibliotecaSelecionada.getIdBiblioteca());

            ResultSet resultSet = stmt.executeQuery();
            List<Livro> listaDeLivros = new ArrayList<>();

            while(resultSet.next()) {
                Livro livro = new Livro();

                livro.setIdLivro(resultSet.getInt("idLivro"));
                livro.setNomeLivro(resultSet.getString("nomeLivro"));

                GeneroDao generoDao = new GeneroDao();
                Genero genero = generoDao.getGeneroById(resultSet.getInt("idGenero"));
                livro.setIdGeneroLivro(genero);

                BibliotecaDao bibliotecaDao = new BibliotecaDao();
                Biblioteca biblioteca = bibliotecaDao.getBibliotecaById(resultSet.getInt("idBiblioteca"));
                livro.setBiblioteca(biblioteca);

                listaDeLivros.add(livro);
            }
            return listaDeLivros;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }



}
