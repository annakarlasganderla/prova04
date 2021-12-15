package Dao;

import Factory.ConectionFactory;
import Model.Genero;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GeneroDao {
    private Connection connection;

    public GeneroDao() {
        this.connection = new ConectionFactory().getConection();
    }

    public void criaTabelaGeneros() {
        String sql = "CREATE TABLE IF NOT EXISTS generos (" +
                "idGenero INT PRIMARY KEY AUTO_INCREMENT," +
                "nomeGenero VARCHAR(50) NOT NULL"+
                ")";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("ERRO AO CRIAR TABELA DE GENEROS");
        }
    }

    public void cadastraGeneros(Genero genero) {
        String sql = "INSERT INTO generos"+
                "(nomeGenero)" +
                "VALUES (?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1, genero.getNomeGenero());

            stmt.execute();

            ResultSet resultSet = stmt.getGeneratedKeys();

            while (resultSet.next()) {
                genero.setIdGenero(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            System.out.println("ERRO AO CADASTRAR NA TABELA DE GENEROS");
        }
    }

    public List<Genero> listarGeneros () {
        String sql = "SELECT * FROM generos";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultSet = stmt.executeQuery();

            List<Genero> listaDeGeneros = new ArrayList<>();

            while (resultSet.next()) {
                Genero genero = new Genero();

                genero.setIdGenero(resultSet.getInt("idGenero"));
                genero.setNomeGenero(resultSet.getString("nomeGenero"));

                listaDeGeneros.add(genero);
            }

            return listaDeGeneros;
        } catch (SQLException e) {
            System.out.println("ERRO AO LISTAR GENEROS");
        }
        return null;
    }

    public Genero getGeneroById(int idGenero) {
        String sql = "SELECT * FROM generos WHERE idGenero = ?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, idGenero);

            ResultSet resultSet = stmt.executeQuery();

            while(resultSet.next()) {
                Genero genero = new Genero();

                genero.setIdGenero(resultSet.getInt("idGenero"));
                genero.setNomeGenero(resultSet.getString("nomeGenero"));

                return genero;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void editaGenero(Genero genero) {
        String sql = "UPDATE generos SET nomeGenero = ? WHERE idGenero = ?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, genero.getNomeGenero());
            stmt.setInt(2, genero.getIdGenero());

            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
