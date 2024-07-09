package org.poo.parcialfinalpoo.model;

import java.sql.*;
import java.util.ArrayList;

public class QueryFacilitador {
    public static ArrayList<Facilitador> select() throws SQLException {
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
