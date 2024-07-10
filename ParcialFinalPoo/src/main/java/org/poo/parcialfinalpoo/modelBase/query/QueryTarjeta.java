package org.poo.parcialfinalpoo.modelBase.query;

import org.poo.parcialfinalpoo.modelBase.tipos.Tarjeta;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class QueryTarjeta implements Queryable<Tarjeta>{ // 00016823 Clase que implementa Queryable para la tabla Tarjeta
    public Tarjeta select(int id) throws SQLException { // 00016823 Obtiene datos de la tabla en base a un id, construye un Tarjeta objeto y lo retorna
        Tarjeta resultado = null; // 00016823 Se declara e inicializa en nulo un objeto tarjeta (resultado)
        Connection connection = DriverManager.getConnection( "jdbc:sqlserver://localhost:1433;databaseName=BCN"
                ,"Final_Poo_2024" ,"FinalPoo2024_25%" ); // 00016823 Se establece la conexión dada la url, usuario y contraseña
        Statement statement = connection.createStatement();
        statement.execute(
                "SELECT t.id, t.numero, t.fecha_exp, t.tipo, t.id_cliente, t.id_facilitador, c.nombre AS nombre_cliente, f.nombre AS nombre_facilitador FROM Tarjeta t " +
                        "INNER JOIN Cliente c ON c.id = t.id_cliente " +
                        "INNER JOIN Facilitador f ON f.id = t.id_facilitador " +
                        "WHERE t.id = " + id
        ); // 00016823 Se ejecuta la query
        ResultSet rs = statement.getResultSet(); // 00016823 Guarda el resultado de la query en un result set
        if (rs.isBeforeFirst()){ // 00016823 Comprueba que la query haya resultado no vacía
            rs.next(); // 00016823 Coloca el cursor en el registro encontrado
           resultado = new Tarjeta(rs.getInt("id"), rs.getString("tipo"), rs.getString("numero"), rs.getDate("fecha_exp").toLocalDate(), rs.getString("nombre_cliente"), rs.getInt("id_cliente"), rs.getString("nombre_facilitador"), rs.getInt("id_facilitador")); // 00016823 Se construye un objeto Tarjeta con los datos en el registro actual del bucle y se agrega al resultado
        }
        connection.close(); // 00016823 Se cierra la conexión
        return resultado;  // 00016823 Se cierra la conexión
    }

    public ArrayList<Integer> getIds() throws SQLException{ // 00016823 Obtiene un arrayList de todos los ids en la tabla
        Connection connection = DriverManager.getConnection( "jdbc:sqlserver://localhost:1433;databaseName=BCN"
                ,"Final_Poo_2024" ,"FinalPoo2024_25%" ); // 00016823 Se establece la conexión dada la url, usuario y contraseña
        ArrayList<Integer> resultado = new ArrayList<>(); // 00016823 Se declara e inicializa el array de ids que será el resultado
        Statement statement = connection.createStatement(); // 00016823 Se crea un statement para la conexión
        statement.execute("SELECT id FROM Tarjeta"); // 00016823 Se seleccionan todos los ids de la tabla Cliente
        ResultSet rs = statement.getResultSet(); // 00016823 Se guarda el resultado de la query en un result set
        while (rs.next()){ // 00016823 Mientras haya siguiente registro, avanza a él
            resultado.add(rs.getInt("id")); // 00016823 Añade el id del registro de la iteración al array de resultado
        }
        connection.close(); // 00016823 Se cierra la conexión
        return resultado;  // 00016823 Retorna el array de ids encontrados
    }

    public void actualizar(Tarjeta tarjeta) throws SQLException{ // 00016823 Recibe un Cliente objeto y usa sus valores para actualizar un registro
        Connection connection = null; // 00016823 Declara e inicializa en nulo la conexión

            connection = DriverManager.getConnection( "jdbc:sqlserver://localhost:1433;databaseName=BCN"
                    ,"Final_Poo_2024" ,"FinalPoo2024_25%" ); // 00016823 Con la url, usuario y contraseña la conexión pasa a estar activa
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE Tarjeta SET numero = ?, fecha_exp = ?, tipo = ?, id_cliente = ?, id_facilitador = ? WHERE id = ?"
            ); // 00016823 Se prepara la query donde se actualizan todos los campos en el id dado
            statement.setString(1, tarjeta.getNumero()); // 00016823 Se pone el número de tarjeta en su lugar correspondiente
            statement.setDate(2, Date.valueOf(tarjeta.getFecha_exp())); // 00016823 Se pone la fecha de expiración en su lugar correspondiente
            statement.setString(3, tarjeta.getTipo()); // 00016823 Se pone el tipo de tarjeta en su lugar correspondiente
            statement.setInt(4, tarjeta.getId_cliente()); // 00016823 Se pone el id del cliente en su lugar correspondiente
            statement.setInt(5, tarjeta.getId_facilitador()); // 00016823 Se pone el id del facilitador en su lugar correspondiente
            statement.setInt(6, tarjeta.getId()); // 00016823 Se pone el id en su lugar correspondiente
            statement.execute(); // 00016823 Se ejecuta la query ya con todos los campos correctamente puestos
            connection.close(); // 00016823 Se cierra la conexión
    }

    public void eliminar(int id) throws SQLException{ // 00016823 Elimina un registro dado un id
        Connection connection = DriverManager.getConnection( "jdbc:sqlserver://localhost:1433;databaseName=BCN"
                ,"Final_Poo_2024" ,"FinalPoo2024_25%" ); // 00016823 Crea una conexión dada la url, usuario y contraseña
        Statement statement = connection.createStatement(); // 00016823 Crea un statement para la conexión
        statement.execute("DELETE FROM Tarjeta WHERE id = " + id); // 00016823 Se ejecuta la query de eliminación
        connection.close(); // 00016823 Se cierra la conexión
    }

    public void insertar(Tarjeta tarjeta) throws SQLException{ // 00016823 Recibe un Tarjeta objeto e introduce los valores de sus atributos en en nuevo registro en la tabla
        Connection connection = DriverManager.getConnection( "jdbc:sqlserver://localhost:1433;databaseName=BCN"
                ,"Final_Poo_2024" ,"FinalPoo2024_25%" ); // 00016823 Crea una conexión dada la url, usuario y contraseña
        PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO Tarjeta VALUES(?, ?, ?, ?, ?)"
        ); // 00016823 Se prepara la query donde se insertan todos los campos
        statement.setString(1, tarjeta.getNumero()); // 00016823 Se pone el número de tarjeta en su lugar correspondiente
        statement.setDate(2, Date.valueOf(tarjeta.getFecha_exp())); // 00016823 Se pone la fecha de expiración en su lugar correspondiente
        statement.setString(3, tarjeta.getTipo()); // 00016823 Se pone el tipo de tarjeta en su lugar correspondiente
        statement.setInt(4, tarjeta.getId_cliente()); // 00016823 Se pone el id del cliente en su lugar correspondiente
        statement.setInt(5, tarjeta.getId_facilitador());  // 00016823 Se pone el id del facilitador en su lugar correspondiente
        statement.execute(); // 00016823 Se ejecuta la query ya con todos los campos correctamente puestos
        connection.close(); // 00016823 Se cierra la conexión

    }

    @Override
    public ArrayList<Tarjeta> select() throws SQLException {return null;} // 00016823 Está el método porque es parte de la interfaz, pero no se necesitó, así que returna nulo

}
