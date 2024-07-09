package org.poo.parcialfinalpoo.model;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class QueryCompra {
    public static ArrayList<Integer> getIds() throws SQLException {
        ArrayList<Integer> resultado = new ArrayList<>();
        Connection connection = DriverManager.getConnection( "jdbc:sqlserver://localhost:1433;databaseName=BCN"
                ,"Final_Poo_2024" ,"FinalPoo2024_25%" );
        Statement statement = connection.createStatement();
        statement.execute("SELECT id FROM Transaccion");
        ResultSet rs = statement.getResultSet();
        while (rs.next()){
            resultado.add(rs.getInt("id"));
        }
        connection.close();
        return resultado;
    }

    public static Transaccion select(int id) throws SQLException{
        Connection connection = DriverManager.getConnection( "jdbc:sqlserver://localhost:1433;databaseName=BCN"
                ,"Final_Poo_2024" ,"FinalPoo2024_25%" );
        Transaccion resultado = null;
        Statement statement = connection.createStatement();
        statement.execute("SELECT * FROM Transaccion WHERE id = " + id);
        ResultSet rs = statement.getResultSet();
        if (rs.isBeforeFirst()){
            rs.next();
            resultado = new Transaccion(rs.getInt("id"), rs.getDouble("total"), rs.getDate("fecha").toLocalDate(), rs.getString("descripcion"), rs.getInt("id_tarjeta"));
        }
        connection.close();
        return resultado;
    }

    public static void eliminar(int id) throws SQLException{
        Connection connection = DriverManager.getConnection( "jdbc:sqlserver://localhost:1433;databaseName=BCN"
                ,"Final_Poo_2024" ,"FinalPoo2024_25%" );
        Statement statement = connection.createStatement();
        statement.execute("DELETE FROM Transaccion WHERE id = " + id);
        connection.close();
    }

    public static void insertar(double total, LocalDate fecha, String descripcion, int id_tarjeta)throws SQLException{
        Connection connection = DriverManager.getConnection( "jdbc:sqlserver://localhost:1433;databaseName=BCN"
                ,"Final_Poo_2024" ,"FinalPoo2024_25%" );
        PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO Transaccion VALUES(?,?,?,?)"
        );
        statement.setDouble(1, total);
        statement.setDate(2, Date.valueOf(fecha));
        statement.setString(3, descripcion);
        statement.setInt(4, id_tarjeta);
        statement.execute();
        connection.close();
    }
    public static void actualizar(double total, LocalDate fecha, String descripcion, int id_tarjeta) throws SQLException{
        Connection connection = DriverManager.getConnection( "jdbc:sqlserver://localhost:1433;databaseName=BCN"
                ,"Final_Poo_2024" ,"FinalPoo2024_25%" );
        PreparedStatement statement = connection.prepareStatement(
                "UPDATE Transaccion SET total = ?, fecha = ?, descripcion = ?, id_tarjeta = ?"
        );
        statement.setDouble(1, total);
        statement.setDate(2, Date.valueOf(fecha));
        statement.setString(3, descripcion);
        statement.setInt(4, id_tarjeta);
        statement.execute();
        connection.close();
    }
}
