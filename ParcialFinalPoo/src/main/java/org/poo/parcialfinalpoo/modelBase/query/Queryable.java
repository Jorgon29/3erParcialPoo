package org.poo.parcialfinalpoo.modelBase.query;

import java.sql.SQLException;
import java.util.ArrayList;

public interface Queryable<T> {
    public T select(int id) throws SQLException;
    public ArrayList<Integer> getIds() throws SQLException;
    public void actualizar(T t)throws SQLException;
    public void eliminar(int id)throws SQLException;
    public void insertar(T t)throws SQLException;
    public ArrayList<T> select()throws SQLException;
}
