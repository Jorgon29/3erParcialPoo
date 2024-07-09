package org.poo.parcialfinalpoo.modelBase.query;

import org.poo.parcialfinalpoo.modelBase.tipos.Facilitador;

import java.sql.*;
import java.util.ArrayList;

public class QueryFacilitador implements Queryable<Facilitador>{
    @Override
    public Facilitador select(int id) throws SQLException {
        Facilitador resultado;
        Connection connection = DriverManager.getConnection( "jdbc:sqlserver://localhost:1433;databaseName=BCN"
                ,"Final_Poo_2024" ,"FinalPoo2024_25%" );
        Statement statement = connection.createStatement();
        statement.execute("SELECT id, nombre FROM Facilitador WHERE id = " + id);
        ResultSet rs = statement.getResultSet();
        if (rs.isBeforeFirst()){
            rs.next();
            resultado = new Facilitador(rs.getInt("id"), rs.getString("nombre"));
        } else {
            resultado = null;
        }
        connection.close();
        return resultado;
    }

    @Override
    public ArrayList<Integer> getIds() throws SQLException{
        ArrayList<Integer> resultado = new ArrayList<>();
        Connection connection = DriverManager.getConnection( "jdbc:sqlserver://localhost:1433;databaseName=BCN"
                ,"Final_Poo_2024" ,"FinalPoo2024_25%" );
        Statement statement = connection.createStatement();
        statement.execute("SELECT id FROM Facilitador");
        ResultSet rs = statement.getResultSet();
        while (rs.next()){
            resultado.add(rs.getInt("id"));
        }
        connection.close();
        return resultado;
    }

    @Override
    public void actualizar(Facilitador facilitador) throws SQLException {
        Connection connection = DriverManager.getConnection( "jdbc:sqlserver://localhost:1433;databaseName=BCN"
                ,"Final_Poo_2024" ,"FinalPoo2024_25%" );
        PreparedStatement statement = connection.prepareStatement(
                "UPDATE Facilitador SET nombre = ? WHERE id = ?"
        );
        statement.setString(1, facilitador.getNombre());
        statement.setInt(2, facilitador.getId());
        statement.execute();
        connection.close();
    }

    @Override
    public void eliminar(int id) throws SQLException {
        Connection connection = DriverManager.getConnection( "jdbc:sqlserver://localhost:1433;databaseName=BCN"
                ,"Final_Poo_2024" ,"FinalPoo2024_25%" );
        Statement statement = connection.createStatement();
        statement.execute("DELETE FROM Facilitador WHERE id = " + id);
        connection.close();
    }

    @Override
    public void insertar(Facilitador facilitador) throws SQLException {
        Connection connection = DriverManager.getConnection( "jdbc:sqlserver://localhost:1433;databaseName=BCN"
                ,"Final_Poo_2024" ,"FinalPoo2024_25%" );
        PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO Facilitador VALUES(?)"
        );
        statement.setString(1, facilitador.getNombre());
        statement.execute();
        connection.close();
    }

    public ArrayList<Facilitador> select() throws SQLException {
        ArrayList<Facilitador> resultado = new ArrayList<>();
        Connection connection = DriverManager.getConnection( "jdbc:sqlserver://localhost:1433;databaseName=BCN"
                ,"Final_Poo_2024" ,"FinalPoo2024_25%" );
        Statement statement = connection.createStatement();
        statement.execute("SELECT id, nombre FROM Facilitador");
        ResultSet rs = statement.getResultSet();
        while (rs.next()){
            resultado.add(new Facilitador(rs.getInt("id"), rs.getString("nombre")));
        }
        connection.close();
        return resultado;
    }
}
