package org.poo.parcialfinalpoo.modelBase.query;

import org.poo.parcialfinalpoo.modelBase.tipos.Cliente;

import java.sql.*;
import java.util.ArrayList;

public class QueryCliente implements Queryable<Cliente> {

    public Cliente select(int id) throws SQLException{
        Connection connection = null;
        Cliente cliente = null;
        connection = DriverManager.getConnection( "jdbc:sqlserver://localhost:1433;databaseName=BCN"
                    ,"Final_Poo_2024" ,"FinalPoo2024_25%" );
        Statement statement = connection.createStatement();
        statement.execute("SELECT * FROM Cliente WHERE id = " + id);
        ResultSet rs = statement.getResultSet();
        if (rs.isBeforeFirst()){
            rs.next();
            cliente = new Cliente(rs.getInt("id"), rs.getString("nombre"), rs.getString("telefono"), rs.getString("direccion"));
            }
        connection.close();
        return cliente;
    }

    public  ArrayList<Integer> getIds() throws SQLException{
        Connection connection = null;
        ArrayList<Integer> ids = new ArrayList<>();

        connection = DriverManager.getConnection( "jdbc:sqlserver://localhost:1433;databaseName=BCN"
                    ,"Final_Poo_2024" ,"FinalPoo2024_25%" );
        Statement statement = connection.createStatement();
        statement.execute("SELECT id FROM Cliente");
        ResultSet rs = statement.getResultSet();
        while (rs.next()) {
            ids.add(rs.getInt("id"));
        }
        return ids;
    }

    public void actualizar(Cliente cliente) throws SQLException{
        Connection connection = null;
            connection = DriverManager.getConnection( "jdbc:sqlserver://localhost:1433;databaseName=BCN"
                    ,"Final_Poo_2024" ,"FinalPoo2024_25%" );
            PreparedStatement statement = connection.prepareStatement(
              "UPDATE Cliente SET nombre = ?, direccion = ?, telefono = ? WHERE id = ?"
            );
            statement.setString(1, cliente.getNombre());
            statement.setString(2, cliente.getDireccion());
            statement.setString(3, cliente.getTelefono());
            statement.setInt(4, cliente.getId());
            statement.execute();
            connection.close();

    }

    public void eliminar(int id) throws SQLException{
            Connection connection = DriverManager.getConnection( "jdbc:sqlserver://localhost:1433;databaseName=BCN"
                    ,"Final_Poo_2024" ,"FinalPoo2024_25%" );
            Statement statement = connection.createStatement();
            statement.execute("DELETE FROM Cliente WHERE id = " + id);
            connection.close();
    }

    public void insertar(Cliente cliente) throws SQLException{
        Connection connection = DriverManager.getConnection( "jdbc:sqlserver://localhost:1433;databaseName=BCN"
                ,"Final_Poo_2024" ,"FinalPoo2024_25%" );
        PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO Cliente VALUES(?, ?, ?)"
        );
        preparedStatement.setString(1, cliente.getNombre());
        preparedStatement.setString(2, cliente.getDireccion());
        preparedStatement.setString(3, cliente.getTelefono());
        preparedStatement.execute();
        connection.close();
    }

    public ArrayList<Cliente> select() throws SQLException{
        ArrayList<Cliente> resultado = new ArrayList<>();
        Connection connection = DriverManager.getConnection( "jdbc:sqlserver://localhost:1433;databaseName=BCN"
                ,"Final_Poo_2024" ,"FinalPoo2024_25%" );
        Statement statement = connection.createStatement();
        statement.execute("SELECT * FROM Cliente");
        ResultSet rs = statement.getResultSet();
        while (rs.next()){
            resultado.add(new Cliente(rs.getInt("id"), rs.getString("nombre"), rs.getString("telefono"), rs.getString("direccion")));
        }
        connection.close();
        return resultado;
    }
}
