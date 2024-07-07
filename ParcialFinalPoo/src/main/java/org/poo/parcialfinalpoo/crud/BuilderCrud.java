package org.poo.parcialfinalpoo.crud;

public interface BuilderCrud<T> {
    public void reiniciar();
    public void ponerBotonEliminar();
    public void ponerBotonActualizar();
    public void ponerTextFields();
    public void ponerLabels();
    public void ponerBuscador();
    public void ponerBotonInsertar();
    public T getResultado();
}
