package org.poo.parcialfinalpoo.model;

import java.sql.*;
import java.util.ArrayList;

public class QueryCliente {
    public static Cliente select(int id){
        Connection connection = null;
        Cliente cliente;
        try {
            connection = DriverManager.getConnection( "jdbc:sqlserver://localhost:1433;databaseName=BCN"
                    ,"Final_Poo_2024" ,"FinalPoo2024_25%" );
            Statement statement = connection.createStatement();
            statement.execute("SELECT * FROM Cliente WHERE id = " + id);
            ResultSet rs = statement.getResultSet();
            if (rs.isBeforeFirst()){
                rs.next();
                cliente = new Cliente(rs.getInt("id"), rs.getString("nombre"), rs.getString("telefono"), rs.getString("direccion"));
            } else {
                cliente = null;
            }
            connection.close();
            return cliente;
        } catch (SQLException e){
            System.out.println(e.getMessage());
            System.out.println(e.getSQLState());
            if (connection != null){
                try {
                    connection.close();
                    return null;
                } catch (SQLException exception){
                     exception.printStackTrace();
                }
            } else {
                return null;
            }
        }
        return null;
    }

    public static ArrayList<Integer> getIds(){
        Connection connection = null;
        ArrayList<Integer> ids = new ArrayList<>();
        try {
            connection = DriverManager.getConnection( "jdbc:sqlserver://localhost:1433;databaseName=BCN"
                    ,"Final_Poo_2024" ,"FinalPoo2024_25%" );
            Statement statement = connection.createStatement();
            statement.execute("SELECT id FROM Cliente");
            ResultSet rs = statement.getResultSet();
            while (rs.next()){
                ids.add(rs.getInt("id"));
            }
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
        return ids;
    }

    public static void actualizar(Cliente cliente){
        Connection connection = null;
        try {
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
    }

    public static void eliminar(int id) throws SQLException{
            Connection connection = DriverManager.getConnection( "jdbc:sqlserver://localhost:1433;databaseName=BCN"
                    ,"Final_Poo_2024" ,"FinalPoo2024_25%" );
            Statement statement = connection.createStatement();
            statement.execute("DELETE FROM Cliente WHERE id = " + id);
            connection.close();
    }

    public static void insertar(String nombre, String direccion, String telefono) throws SQLException{
        Connection connection = DriverManager.getConnection( "jdbc:sqlserver://localhost:1433;databaseName=BCN"
                ,"Final_Poo_2024" ,"FinalPoo2024_25%" );
        PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO Cliente VALUES(?, ?, ?)"
        );
        preparedStatement.setString(1, nombre);
        preparedStatement.setString(2, direccion);
        preparedStatement.setString(3, telefono);
        preparedStatement.execute();
        connection.close();
    }

    public static ArrayList<Cliente> select() throws SQLException{
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
