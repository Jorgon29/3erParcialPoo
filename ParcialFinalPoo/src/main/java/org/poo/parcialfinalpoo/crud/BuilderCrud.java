package org.poo.parcialfinalpoo.crud;

public interface BuilderCrud<T> {// 00016823 Interfaz para los builder concretos, de cualquier elemento
    public void reiniciar(); // 00016823 se espera se reinicie el proceso de construcción de la app
    public void ponerBotonEliminar(); // 00016823 Se pone el botón eliminar si fuese necesario
    public void ponerBotonActualizar(); // 00016823 Se pone el botón actualizar si fuese necesario
    public void ponerTextFields(); // 00016823 Se ponen los text fields (campos editables)
    public void ponerLabels(); // 00016823 Se ponen los labels para mostrar información (campos no editables)
    public void ponerBuscador(); // 00016823 Se pone el buscador (combo box con ids pertinentes y botón buscar)
    public void ponerBotonInsertar(); // 00016823 Se pone el botó insertar si fuese necesario
    public T getResultado(); // 00016823 Se obtiene el resultado del builder
}
