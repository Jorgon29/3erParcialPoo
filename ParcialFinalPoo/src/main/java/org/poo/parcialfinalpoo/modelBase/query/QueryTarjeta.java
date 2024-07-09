package org.poo.parcialfinalpoo.modelBase.query;

import org.poo.parcialfinalpoo.modelBase.tipos.Tarjeta;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class QueryTarjeta implements Queryable<Tarjeta>{
    public Tarjeta select(int id) throws SQLException {
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

    public ArrayList<Integer> getIds() throws SQLException{
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

    public void actualizar(Tarjeta tarjeta) throws SQLException{
        Connection connection = null;

            connection = DriverManager.getConnection( "jdbc:sqlserver://localhost:1433;databaseName=BCN"
                    ,"Final_Poo_2024" ,"FinalPoo2024_25%" );
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE Tarjeta SET numero = ?, fecha_exp = ?, tipo = ?, id_cliente = ?, id_facilitador = ? WHERE id = ?"
            );
            statement.setString(1, tarjeta.getNumero());
            statement.setDate(2, Date.valueOf(tarjeta.getFecha_exp()));
            statement.setString(3, tarjeta.getTipo());
            statement.setInt(4, tarjeta.getId_cliente());
            statement.setInt(5, tarjeta.getId_facilitador());
            statement.setInt(6, tarjeta.getId());
            statement.execute();
            connection.close();
    }

    public void eliminar(int id) throws SQLException{
        Connection connection = DriverManager.getConnection( "jdbc:sqlserver://localhost:1433;databaseName=BCN"
                ,"Final_Poo_2024" ,"FinalPoo2024_25%" );
        Statement statement = connection.createStatement();
        statement.execute("DELETE FROM Tarjeta WHERE id = " + id);
        connection.close();
    }

    public void insertar(Tarjeta tarjeta) throws SQLException{
        Connection connection = DriverManager.getConnection( "jdbc:sqlserver://localhost:1433;databaseName=BCN"
                ,"Final_Poo_2024" ,"FinalPoo2024_25%" );
        PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO Tarjeta VALUES(?, ?, ?, ?, ?)"
        );
        statement.setString(1, tarjeta.getNumero());
        statement.setDate(2, Date.valueOf(tarjeta.getFecha_exp()));
        statement.setString(3, tarjeta.getTipo());
        statement.setInt(4, tarjeta.getId_cliente());
        statement.setInt(5, tarjeta.getId_facilitador());
        statement.execute();
        connection.close();

    }

    @Override
    public ArrayList<Tarjeta> select() throws SQLException {
        return null;
    }

}
