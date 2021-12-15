package Dao;

import Factory.ConectionFactory;
import Model.Biblioteca;
import Model.Genero;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BibliotecaDao {
    private Connection connection;

    public void bibliotecaDao() {
        this.connection = new ConectionFactory().getConection();
    }

    public void criaTabelaBiblioteca() {
        String sql = "CREATE TABLE IF NOT EXISTS bibliotecas (" +
                "idBiblioteca INT PRIMARY KEY AUTO_INCREMENT," +
                "nomeBiblioteca VARCHAR(50) NOT NULL," +
                ")";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("ERRO AO CRIAR TABELA DE BIBLIOTECAS");
        }
    }

    public void cadastraBiblioteca(Biblioteca biblioteca) {

        String sql = "INSERT INTO bibliotecas"+
                "(nomeBiblioteca)" +
                "VALUES (?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1, biblioteca.getNomeBiblioteca());

            stmt.execute();

            ResultSet resultSet = stmt.getGeneratedKeys();

            while (resultSet.next()) {
                biblioteca.setIdBiblioteca(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            System.out.println("ERRO AO CADASTRAR NA TABELA DE BIBLIOTECAS");
        }
    }

    public List<Biblioteca> listarBibliotecas() {
        String sql = "SELECT * FROM bibliotecas";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultSet = stmt.executeQuery();

            List<Biblioteca> listaDeBibliotecas = new ArrayList<>();

            while (resultSet.next()) {
                Biblioteca biblioteca = new Biblioteca();

                biblioteca.setIdBiblioteca(resultSet.getInt("idBiblioteca"));
                biblioteca.setNomeBiblioteca(resultSet.getString("nomeBiblioteca"));

                listaDeBibliotecas.add(biblioteca);
            }

            return listaDeBibliotecas;
        } catch (SQLException e) {
            System.out.println("ERRO AO LISTAR BIBLIOTECAS");
        }
        return null;
    }

    public Biblioteca getBibliotecaById(int idBiblioteca) {
        String sql = "SELECT * FROM bibliotecas WHERE idBiblioteca = ?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, idBiblioteca);

            ResultSet resultSet = stmt.executeQuery();

            while(resultSet.next()) {
                Biblioteca biblioteca = new Biblioteca();

                biblioteca.setIdBiblioteca(resultSet.getInt("idBiblioteca"));
                biblioteca.setNomeBiblioteca(resultSet.getString("nomeBiblioteca"));

                return biblioteca;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
