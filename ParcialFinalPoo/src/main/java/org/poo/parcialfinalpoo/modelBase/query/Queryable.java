package org.poo.parcialfinalpoo.modelBase.query;

import java.sql.SQLException;
import java.util.ArrayList;

public interface Queryable<T> { // 00016823 Interfaz que declara los métodos básicos para comunicarse con la base de datos
    public T select(int id) throws SQLException; // 00016823 Obtiene datos de la tabla en base a un id, construye un T objeto y lo retorna
    public ArrayList<Integer> getIds() throws SQLException; // 00016823 Obtiene un arrayList de todos los ids en la tabla
    public void actualizar(T t)throws SQLException; // 00016823 Recibe un T objeto y usa sus valores para actualizar un registro
    public void eliminar(int id)throws SQLException; // 00016823 Elimina un registro dado un id
    public void insertar(T t)throws SQLException; // 00016823 Recibe un T objeto e introduce los valores de sus atributos en en nuevo registro en la tabla
    public ArrayList<T> select()throws SQLException; // 00016823 Selecciona todos los registros de la tabla, construye un objeto T de cada uno y retorna un ArrayList de todos
}
