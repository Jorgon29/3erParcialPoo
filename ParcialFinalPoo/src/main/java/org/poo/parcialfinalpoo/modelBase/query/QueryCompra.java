package org.poo.parcialfinalpoo.modelBase.query;

import org.poo.parcialfinalpoo.modelBase.tipos.Transaccion;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class QueryCompra implements Queryable<Transaccion>{ // 00016823 Clase que implementa Queryable para la tabla Transaccion

    public ArrayList<Integer> getIds() throws SQLException { // 00016823 Obtiene un arrayList de todos los ids en la tabla
        ArrayList<Integer> resultado = new ArrayList<>(); // 00016823 Se declara e inicializa el array de ids que será el resultado
        Connection connection = DriverManager.getConnection( "jdbc:sqlserver://localhost:1433;databaseName=BCN"
                ,"Final_Poo_2024" ,"FinalPoo2024_25%" ); // 00016823 Se establece la conexión dada la url, usuario y contraseña
        Statement statement = connection.createStatement(); // 00016823 Declara e inicializa un statement para la conexión
        statement.execute("SELECT id FROM Transaccion"); // 00016823 Ejecuta la query
        ResultSet rs = statement.getResultSet(); // 00016823 Guarda el resultado de la query en un result set
        while (rs.next()){ // 00016823 Mientras haya siguiente registro, avanza a él
            resultado.add(rs.getInt("id")); // 00016823 Añade el id del registro de la iteración al array de resultado
        }
        connection.close(); // 00016823 Se cierra la conexión
        return resultado; // 00016823 Retorna el array de resultado
    }

    public Transaccion select(int id) throws SQLException{ // 00016823 Obtiene datos de la tabla en base a un id, construye un Transacción objeto y lo retorna
        Connection connection = DriverManager.getConnection( "jdbc:sqlserver://localhost:1433;databaseName=BCN"
                ,"Final_Poo_2024" ,"FinalPoo2024_25%" ); // 00016823 Se establece la conexión dada la url, usuario y contraseña
        Transaccion resultado = null; // 00016823 Declara e inicializa en nulo una transacción (Resultado)
        Statement statement = connection.createStatement(); // 00016823 Declara e inicializa un statement para la conexión
        statement.execute("SELECT * FROM Transaccion WHERE id = " + id); // 00016823 Ejecuta la query
        ResultSet rs = statement.getResultSet(); // 00016823 Guarda el resultado de la query en un result set
        if (rs.isBeforeFirst()){ // 00016823 Comprueba que la query haya resultado no vacía
            rs.next(); // 00016823 Coloca el cursor en el registro encontrado
            resultado = new Transaccion(rs.getInt("id"), rs.getDouble("total"), rs.getDate("fecha").toLocalDate(), rs.getString("descripcion"), rs.getInt("id_tarjeta")); // 00016823 Construye un objeto Transacción a partir de los datos encontrados en la bd
        }
        connection.close();  // 00016823 Cierra la conexión
        return resultado; // 00016823 Retorna el cliente construido
    }

    public void eliminar(int id) throws SQLException{ // 00016823 Elimina un registro dado un id
        Connection connection = DriverManager.getConnection( "jdbc:sqlserver://localhost:1433;databaseName=BCN"
                ,"Final_Poo_2024" ,"FinalPoo2024_25%" ); // 00016823 Se establece la conexión dada la url, usuario y contraseña
        Statement statement = connection.createStatement(); // 00016823 Declara e inicializa un statement para la conexión
        statement.execute("DELETE FROM Transaccion WHERE id = " + id); // 00016823 Se ejecuta la query de eliminación
        connection.close(); // 00016823 Cierra la conexión
    }

    public void insertar(Transaccion transaccion)throws SQLException{
        Connection connection = DriverManager.getConnection( "jdbc:sqlserver://localhost:1433;databaseName=BCN"
                ,"Final_Poo_2024" ,"FinalPoo2024_25%" ); // 00016823 Se establece la conexión dada la url, usuario y contraseña
        PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO Transaccion VALUES(?,?,?,?)"
        ); // 00016823 Se prepara la query donde se inserten los valores
        statement.setDouble(1, transaccion.getTotal()); // 00016823 Se pone el total en su lugar correspondiente
        statement.setDate(2, Date.valueOf(transaccion.getFecha())); // 00016823 Se pone la fecha en su lugar correspondiente
        statement.setString(3, transaccion.getDescripcion()); // 00016823 Se pone la descripción en su lugar correspondiente
        statement.setInt(4, transaccion.getId_tarjeta()); // 00016823 Se pone el id de tarjeta en su lugar correspondiente
        statement.execute(); // 00016823 Se ejecuta la query
        connection.close(); // 00016823 Se cierra la conexión
    }
    public void actualizar(Transaccion transaccion) throws SQLException{ // 00016823 Recibe un Transaccion objeto y usa sus valores para actualizar un registro
        Connection connection = DriverManager.getConnection( "jdbc:sqlserver://localhost:1433;databaseName=BCN"
                ,"Final_Poo_2024" ,"FinalPoo2024_25%" ); // 00016823 Se establece la conexión dada la url, usuario y contraseña
        PreparedStatement statement = connection.prepareStatement(
                "UPDATE Transaccion SET total = ?, fecha = ?, descripcion = ?, id_tarjeta = ? WHERE id = ?"
        ); // 00016823 Se prepara la query donde se actualicen los valores
        statement.setDouble(1, transaccion.getTotal()); // 00016823 Se pone el total en su lugar correspondiente
        statement.setDate(2, Date.valueOf(transaccion.getFecha())); // 00016823 Se pone la fecha en su lugar correspondiente
        statement.setString(3, transaccion.getDescripcion()); // 00016823 Se pone la descripción en su lugar correspondiente
        statement.setInt(4, transaccion.getId_tarjeta()); // 00016823 Se pone el id de tarjeta en su lugar correspondiente
        statement.setInt(5, transaccion.getId()); // 00016823 Se pone el id en su lugar correspondiente
        statement.execute(); // 00016823 Se ejecuta la query
        connection.close(); // 00016823 Se cierra la conexión
    }
    public ArrayList<Transaccion> select() throws SQLException{return null;} // 00016823 Es necesario que esté debido a la interfaz, pero no se ha necesitado, así que simplemente retorna nulo
}
