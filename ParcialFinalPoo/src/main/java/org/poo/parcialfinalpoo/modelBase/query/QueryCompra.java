package org.poo.parcialfinalpoo.modelBase.query;

import org.poo.parcialfinalpoo.modelBase.tipos.Transaccion;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class QueryCompra implements Queryable<Transaccion>{

    public ArrayList<Integer> getIds() throws SQLException {
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

    public Transaccion select(int id) throws SQLException{
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

    public void eliminar(int id) throws SQLException{
        Connection connection = DriverManager.getConnection( "jdbc:sqlserver://localhost:1433;databaseName=BCN"
                ,"Final_Poo_2024" ,"FinalPoo2024_25%" );
        Statement statement = connection.createStatement();
        statement.execute("DELETE FROM Transaccion WHERE id = " + id);
        connection.close();
    }

    public void insertar(Transaccion transaccion)throws SQLException{
        Connection connection = DriverManager.getConnection( "jdbc:sqlserver://localhost:1433;databaseName=BCN"
                ,"Final_Poo_2024" ,"FinalPoo2024_25%" );
        PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO Transaccion VALUES(?,?,?,?)"
        );
        statement.setDouble(1, transaccion.getTotal());
        statement.setDate(2, Date.valueOf(transaccion.getFecha()));
        statement.setString(3, transaccion.getDescripcion());
        statement.setInt(4, transaccion.getId_tarjeta());
        statement.execute();
        connection.close();
    }
    public void actualizar(Transaccion transaccion) throws SQLException{
        Connection connection = DriverManager.getConnection( "jdbc:sqlserver://localhost:1433;databaseName=BCN"
                ,"Final_Poo_2024" ,"FinalPoo2024_25%" );
        PreparedStatement statement = connection.prepareStatement(
                "UPDATE Transaccion SET total = ?, fecha = ?, descripcion = ?, id_tarjeta = ? WHERE id = ?"
        );
        statement.setDouble(1, transaccion.getTotal());
        statement.setDate(2, Date.valueOf(transaccion.getFecha()));
        statement.setString(3, transaccion.getDescripcion());
        statement.setInt(4, transaccion.getId_tarjeta());
        statement.setInt(5, transaccion.getId());
        statement.execute();
        connection.close();
    }
    public ArrayList<Transaccion> select() throws SQLException{
        return null;
    }
}
