package org.poo.parcialfinalpoo.modelBase.query;

import org.poo.parcialfinalpoo.modelBase.tipos.Facilitador;

import java.sql.*;
import java.util.ArrayList;

public class QueryFacilitador implements Queryable<Facilitador>{ // 00016823 Clase que implementa Queryable para la tabla Facilitador
    @Override
    public Facilitador select(int id) throws SQLException { // 00016823 Obtiene datos de la tabla en base a un id, construye un Transacción objeto y lo retorna
        Facilitador resultado;
        Connection connection = DriverManager.getConnection( "jdbc:sqlserver://localhost:1433;databaseName=BCN"
                ,"Final_Poo_2024" ,"FinalPoo2024_25%" );  // 00016823 Se establece la conexión dada la url, usuario y contraseña
        Statement statement = connection.createStatement(); // 00016823 Declara e inicializa un statement para la conexión
        statement.execute("SELECT id, nombre FROM Facilitador WHERE id = " + id); // 00016823 Ejecuta la query
        ResultSet rs = statement.getResultSet(); // 00016823 Guarda el resultado de la query en un result set
        if (rs.isBeforeFirst()){ // 00016823 Comprueba que la query haya resultado no vacía
            rs.next(); // 00016823 Coloca el cursor en el registro encontrado
            resultado = new Facilitador(rs.getInt("id"), rs.getString("nombre")); // 00016823 Construye un objeto Facilitador a partir de los datos encontrados en la bd
        } else {
            resultado = null; // 00016823 Si el resultado es vacío, se le asigna nulo al resultado
        }
        connection.close(); // 00016823 Cierra la conexión
        return resultado; // 00016823 Retorna el facilitador construido
    }

    @Override
    public ArrayList<Integer> getIds() throws SQLException{ // 00016823 Obtiene un arrayList de todos los ids en la tabla
        ArrayList<Integer> resultado = new ArrayList<>(); // 00016823 Se declara e inicializa el array de ids que será el resultado
        Connection connection = DriverManager.getConnection( "jdbc:sqlserver://localhost:1433;databaseName=BCN"
                ,"Final_Poo_2024" ,"FinalPoo2024_25%" ); // 00016823 Se establece la conexión dada la url, usuario y contraseña
        Statement statement = connection.createStatement(); // 00016823 Declara e inicializa un statement para la conexión
        statement.execute("SELECT id FROM Facilitador"); // 00016823 Ejecuta la query
        ResultSet rs = statement.getResultSet(); // 00016823 Guarda el resultado de la query en un result set
        while (rs.next()){ // 00016823 Mientras haya siguiente registro, avanza a él
            resultado.add(rs.getInt("id")); // 00016823 Añade el id del registro de la iteración al array de resultado
        }
        connection.close(); // 00016823 Se cierra la conexión
        return resultado; // 00016823 Retorna el array de resultado
    }

    @Override
    public void actualizar(Facilitador facilitador) throws SQLException { // 00016823 Recibe un Facilitador objeto y usa sus valores para actualizar un registro
        Connection connection = DriverManager.getConnection( "jdbc:sqlserver://localhost:1433;databaseName=BCN"
                ,"Final_Poo_2024" ,"FinalPoo2024_25%" ); // 00016823 Se establece la conexión dada la url, usuario y contraseña
        PreparedStatement statement = connection.prepareStatement(
                "UPDATE Facilitador SET nombre = ? WHERE id = ?"
        ); // 00016823 Se prepara la query donde se actualicen los valores
        statement.setString(1, facilitador.getNombre()); // 00016823 Pone el nombre del facilitador en su lugar correspondiente
        statement.setInt(2, facilitador.getId());// 00016823 Pone el id del facilitador en su lugar correspondiente
        statement.execute(); // 00016823 Se ejecuta la query
        connection.close(); // 00016823 Se cierra la conexión
    }

    @Override
    public void eliminar(int id) throws SQLException {  // 00016823 Elimina un registro dado un id
        Connection connection = DriverManager.getConnection( "jdbc:sqlserver://localhost:1433;databaseName=BCN"
                ,"Final_Poo_2024" ,"FinalPoo2024_25%" ); // 00016823 Se establece la conexión dada la url, usuario y contraseña
        Statement statement = connection.createStatement(); // 00016823 Declara e inicializa un statement para la conexión
        statement.execute("DELETE FROM Facilitador WHERE id = " + id); // 00016823 Se ejecuta la query de eliminación
        connection.close(); // 00016823 Cierra la conexión
    }

    @Override
    public void insertar(Facilitador facilitador) throws SQLException { // 00016823 Recibe un Facilitador objeto e introduce los valores de sus atributos en en nuevo registro en la tabla
        Connection connection = DriverManager.getConnection( "jdbc:sqlserver://localhost:1433;databaseName=BCN"
                ,"Final_Poo_2024" ,"FinalPoo2024_25%" ); // 00016823 Se establece la conexión dada la url, usuario y contraseña
        PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO Facilitador VALUES(?)"
        ); // 00016823 Se prepara la query donde se inserten los valores
        statement.setString(1, facilitador.getNombre()); // 00016823 Pone el nombre del facilitador en su lugar correspondiente
        statement.execute(); // 00016823 Se ejecuta la query
        connection.close(); // 00016823 Se cierra la conexión
    }

    public ArrayList<Facilitador> select() throws SQLException { // 00016823 Selecciona todos los registros de la tabla, construye un objeto Facilitador de cada uno y retorna un ArrayList de todos
        ArrayList<Facilitador> resultado = new ArrayList<>(); // 00016823 Inicializa el ArrayList que será el resultado
        Connection connection = DriverManager.getConnection( "jdbc:sqlserver://localhost:1433;databaseName=BCN"
                ,"Final_Poo_2024" ,"FinalPoo2024_25%" ); // 00016823 Crea una conexión dada la url, usuario y contraseña
        Statement statement = connection.createStatement(); // 00016823 Crea un statement para la conexión
        statement.execute("SELECT id, nombre FROM Facilitador");
        ResultSet rs = statement.getResultSet();  // 00016823 Guarda el resultado de la query en un result set
        while (rs.next()){ // 00016823 Mientras haya un siguiente registro, avanza a ese registro
            resultado.add(new Facilitador(rs.getInt("id"), rs.getString("nombre"))); // 00016823 Se construye un objeto Facilitador con los datos en el registro actual del bucle y se agrega al resultado
        }
        connection.close(); // 00016823 Se cierra la conexión
        return resultado; // 00016823 Retorna el array resultado
    }
}
