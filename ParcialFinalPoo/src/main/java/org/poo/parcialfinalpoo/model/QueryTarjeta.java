package org.poo.parcialfinalpoo.model;

import java.sql.*;
import java.util.ArrayList;

public class QueryTarjeta {
    public static Tarjeta select(int id) throws SQLException {
        Tarjeta resultado = null;
        Connection connection = DriverManager.getConnection( "jdbc:sqlserver://localhost:1433;databaseName=BCN"
                ,"Final_Poo_2024" ,"FinalPoo2024_25%" );
        Statement statement = connection.createStatement();
        statement.execute(
                "SELECT t.id, t.numero, t.fecha_exp, t.tipo, t.id_cliente, t.id_facilitador, c.nombre AS nombre_cliente, f.nombre AS nombre_facilitador FROM Tarjeta t " +
                        "INNER JOIN Cliente c ON c.id = t.id_cliente " +
                        "INNER JOIN Facilitador f ON f.id = t.id_facilitador " +
                        "WHERE t.id = " + id
        );
        ResultSet rs = statement.getResultSet();
        if (rs.isBeforeFirst()){
            rs.next();
           resultado = new Tarjeta(rs.getInt("id"), rs.getString("tipo"), rs.getString("numero"), rs.getDate("fecha_exp").toLocalDate(), rs.getString("nombre_cliente"), rs.getInt("id_cliente"), rs.getString("nombre_facilitador"), rs.getInt("id_facilitador"));
        }
        connection.close();
        return resultado;
    }

    public static ArrayList<Integer> getIds() throws SQLException{
        Connection connection = DriverManager.getConnection( "jdbc:sqlserver://localhost:1433;databaseName=BCN"
                ,"Final_Poo_2024" ,"FinalPoo2024_25%" );
        ArrayList<Integer> resultado = new ArrayList<>();
        Statement statement = connection.createStatement();
        statement.execute("SELECT id FROM Tarjeta");
        ResultSet rs = statement.getResultSet();
        while (rs.next()){
            resultado.add(rs.getInt("id"));
        }
        connection.close();
        return resultado;
    }
/*
    public static void actualizar(Tarjeta tarjeta){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection( "jdbc:sqlserver://localhost:1433;databaseName=BCN"
                    ,"Final_Poo_2024" ,"FinalPoo2024_25%" );
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE Tarjeta SET numero = ?, fecha_exp = ?, tipo = ?,  WHERE id = ?"
            );
            statement.setString(1, cliente.getNombre());
            statement.setString(2, cliente.getDireccion());
            statement.setString(3, cliente.getTelefono());
            statement.setInt(4, cliente.getId());
            statement.execute();
            connection.close();
        } catch (SQLException e){
            System.out.println(e.getMessage());
            System.out.println(e.getSQLState());
            if (connection != null){
                try {
                    connection.close();
                } catch (SQLException exception){
                    exception.printStackTrace();
                }
            }
        }
    }*/

    public static void eliminar(int id) throws SQLException{
        Connection connection = DriverManager.getConnection( "jdbc:sqlserver://localhost:1433;databaseName=BCN"
                ,"Final_Poo_2024" ,"FinalPoo2024_25%" );
        Statement statement = connection.createStatement();
        statement.execute("DELETE FROM Tarjeta WHERE id = " + id);
        connection.close();
    }

    
}
