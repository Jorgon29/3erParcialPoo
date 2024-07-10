package org.poo.parcialfinalpoo.modelBase.query;

import org.poo.parcialfinalpoo.modelBase.tipos.Cliente;

import java.sql.*;
import java.util.ArrayList;

public class QueryCliente implements Queryable<Cliente> { // 00016823 Clase que implementa Queryable para la tabla Cliente

    public Cliente select(int id) throws SQLException{ // 00016823 Obtiene datos de la tabla en base a un id, construye un Cliente objeto y lo retorna
        Connection connection = null; // 00016823 Declara e inicializa en nulo una conexión sql
        Cliente cliente = null; // 00016823 Declara e inicializa en nulo un cliente (Resultado)
        connection = DriverManager.getConnection( "jdbc:sqlserver://localhost:1433;databaseName=BCN"
                    ,"Final_Poo_2024" ,"FinalPoo2024_25%" ); // 00016823 Provee de la url, usuario y contraseña a la connection para establecer una conexión activa
        Statement statement = connection.createStatement(); // 00016823 Declara e inicializa un statement para la conexión
        statement.execute("SELECT * FROM Cliente WHERE id = " + id); // 00016823 Ejecuta la query
        ResultSet rs = statement.getResultSet(); // 00016823 Guarda el resultado de la query en un result set
        if (rs.isBeforeFirst()){ // 00016823 Comprueba que la query haya resultado no vacía
            rs.next(); // 00016823 Coloca el cursor en el registro encontrado
            cliente = new Cliente(rs.getInt("id"), rs.getString("nombre"), rs.getString("telefono"), rs.getString("direccion")); // 00016823 Construye un objeto Cliente a partir de los datos encontrados en la bd
            }
        connection.close(); // 00016823 Cierra la conexión
        return cliente; // 00016823 Retorna el cliente construido
    }

    public  ArrayList<Integer> getIds() throws SQLException{ // 00016823 Obtiene un arrayList de todos los ids en la tabla
        Connection connection = null; // 00016823 Se declara e inicializa en nulo la conexión
        ArrayList<Integer> ids = new ArrayList<>(); // 00016823 Se declara e inicializa el array de ids que será el resultado

        connection = DriverManager.getConnection( "jdbc:sqlserver://localhost:1433;databaseName=BCN"
                    ,"Final_Poo_2024" ,"FinalPoo2024_25%" );// 00016823 Se establece la conexión dada la url, usuario y contraseña
        Statement statement = connection.createStatement(); // 00016823 Se crea un statement para la conexión
        statement.execute("SELECT id FROM Cliente"); // 00016823 Se seleccionan todos los ids de la tabla Cliente
        ResultSet rs = statement.getResultSet(); // 00016823 Se guarda el resultado de la query en un result set
        while (rs.next()) { // 00016823 Mientras haya siguiente registro, avanza a él
            ids.add(rs.getInt("id")); // 00016823 Añade el id del registro de la iteración al array de resultado
        }
        connection.close(); // 00016823 Se cierra la conexión
        return ids; // 00016823 Retorna el array de ids encontrados
    }

    public void actualizar(Cliente cliente) throws SQLException{ // 00016823 Recibe un Cliente objeto y usa sus valores para actualizar un registro
        Connection connection = null; // 00016823 Declara e inicializa en nulo la conexión
            connection = DriverManager.getConnection( "jdbc:sqlserver://localhost:1433;databaseName=BCN"
                    ,"Final_Poo_2024" ,"FinalPoo2024_25%" ); // 00016823 Con la url, usuario y contraseña la conexión pasa a estar activa
            PreparedStatement statement = connection.prepareStatement(
              "UPDATE Cliente SET nombre = ?, direccion = ?, telefono = ? WHERE id = ?"
            ); // 00016823 Se prepara la query donde se actualizan todos los campos en el id dado
            statement.setString(1, cliente.getNombre()); // 00016823 Se asigna el nombre a su lugar correspondiente
            statement.setString(2, cliente.getDireccion()); // 00016823 Se asigna la dirección a su lugar correspondiente
            statement.setString(3, cliente.getTelefono()); // 00016823 Se asigna el teléfono a su lugar correspondiente
            statement.setInt(4, cliente.getId()); // 00016823 Se asigna el id a su lugar correspondiente
            statement.execute(); // 00016823 Se ejecuta la query ya con todos los campos correctamente puestos
            connection.close(); // 00016823 Se cierra la conexión
    }

    public void eliminar(int id) throws SQLException{ // 00016823 Elimina un registro dado un id
            Connection connection = DriverManager.getConnection( "jdbc:sqlserver://localhost:1433;databaseName=BCN"
                    ,"Final_Poo_2024" ,"FinalPoo2024_25%" ); // 00016823 Crea una conexión dada la url, usuario y contraseña
            Statement statement = connection.createStatement(); // 00016823 Crea un statement para la conexión
            statement.execute("DELETE FROM Cliente WHERE id = " + id); // 00016823 Se ejecuta la query de eliminación
            connection.close(); // 00016823 Se cierra la conexión
    }

    public void insertar(Cliente cliente) throws SQLException{ // 00016823 Recibe un Cliente objeto e introduce los valores de sus atributos en en nuevo registro en la tabla
        Connection connection = DriverManager.getConnection( "jdbc:sqlserver://localhost:1433;databaseName=BCN"
                ,"Final_Poo_2024" ,"FinalPoo2024_25%" ); // 00016823 Crea una conexión dada la url, usuario y contraseña
        PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO Cliente VALUES(?, ?, ?)"
        ); // 00016823 Se prepara la query donde se inserten los valores
        preparedStatement.setString(1, cliente.getNombre()); // 00016823 Se pone el nombre en su lugar correspondiente
        preparedStatement.setString(2, cliente.getDireccion()); // 00016823 Se pone el dirección en su lugar correspondiente
        preparedStatement.setString(3, cliente.getTelefono()); // 00016823 Se pone el teléfono en su lugar correspondiente
        preparedStatement.execute(); // 00016823 Se ejecuta la query
        connection.close(); // 00016823 Se cierra la conexión
    }

    public ArrayList<Cliente> select() throws SQLException{ // 00016823 Selecciona todos los registros de la tabla, construye un objeto Cliente de cada uno y retorna un ArrayList de todos
        ArrayList<Cliente> resultado = new ArrayList<>(); // 00016823 Inicializa el ArrayList que será el resultado
        Connection connection = DriverManager.getConnection( "jdbc:sqlserver://localhost:1433;databaseName=BCN"
                ,"Final_Poo_2024" ,"FinalPoo2024_25%" ); // 00016823 Crea una conexión dada la url, usuario y contraseña
        Statement statement = connection.createStatement(); // 00016823 Crea un statement para la conexión
        statement.execute("SELECT * FROM Cliente"); // 00016823 Se seleccionan todos los registros de la tabla
        ResultSet rs = statement.getResultSet(); // 00016823 Se almacena el resultado de la query en un ResultSet
        while (rs.next()){ // 00016823 Mientras haya un siguiente registro, avanza a ese registro
            resultado.add(new Cliente(rs.getInt("id"), rs.getString("nombre"), rs.getString("telefono"), rs.getString("direccion"))); // 00016823 Se construye un objeto Cliente con los datos en el registro actual del bucle y se agrega al resultado
        }
        connection.close();// 00016823 Se cierra la conexión
        return resultado; // 00016823 Retorna el array resultado
    }
}
